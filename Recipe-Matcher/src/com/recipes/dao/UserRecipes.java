package com.recipes.dao;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.recipes.bean.RecipeEvaluation;
import com.recipes.util.DBConnection;
import com.recipes.util.RecipeBean;

public class UserRecipes {
	
	private Connection conn=null;
	public ArrayList<String> available_ingredients=new ArrayList<String>();
	
	public UserRecipes()
	{
		conn = DBConnection.createConnection();
	}
	
	//-------------------Homepage community picks recipes-----------------------------------------------
	
	public ArrayList<RecipeBean> get_community_pick_recipes()
	{
		ArrayList<RecipeBean> recipe_picks=new ArrayList<>();
		try
		{
			String sql1 ="select a.recipe_id,a.recipe_title from essex_recipes_meta_tbl a, essex_recipes_reviews_tbl b " +
					"where b.recipe_reviews like '%Community Pick%' and a.recipe_id=b.recipe_id";
			
			Statement statement=conn.createStatement();
			ResultSet resultSet1 = statement.executeQuery(sql1);
			ResultSet resultSet2 = null;
			
			while(resultSet1.next()){
				RecipeBean recipe=new RecipeBean();
				recipe.setRecipe_id(resultSet1.getInt("recipe_id"));
				recipe.setRecipe_title(resultSet1.getString("recipe_title"));	
				recipe_picks.add(recipe);
			}
			for(RecipeBean recipe:recipe_picks)
			{
				ArrayList<String> images=new ArrayList<>();
				int recipe_id=recipe.getRecipe_id();
				String query = "select recipe_images from essex_recipes_images_tbl where recipe_id="+recipe_id;
				resultSet2 = statement.executeQuery(query);
				if(resultSet2.next())		
					images.add(resultSet2.getString("recipe_images"));
				recipe.setRecipe_gallery(images);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return recipe_picks;
	}
	
	//--------------------------------------user dashboard community picks recipes---------------------------------------
	
	public ArrayList<RecipeBean> get_user_community_picks(String username)
	{
		ArrayList<RecipeBean> final_recipes=new ArrayList<>();
		ArrayList<RecipeBean> myrecipes=new ArrayList<>();
		final_recipes = get_my_recipes(username);
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			for(RecipeBean recipe:final_recipes)
			{
				String sql = "select * from essex_recipes_reviews_tbl where recipe_id="+recipe.getRecipe_id()+" and "
						+ " recipe_reviews like '%Community Pick%'";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if(rs.next())
					myrecipes.add(recipe);
				rs = null;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return myrecipes;
	}
	
	//-----------------------------------user recommended recipes based on ingredients-------------------------------
	
	public ArrayList<RecipeBean> get_my_recipes(String username)
	{
		ArrayList<RecipeBean> myrecipes=new ArrayList<>();
		ArrayList<String> user_ingredients=new ArrayList<>();		
		HashMap<Integer,String> recipes=new HashMap<>();
		HashMap<Integer,String> final_recipes=new HashMap<>();
		HashMap<String,Float> all_grocery_list=new HashMap<>();
		ArrayList<RecipeEvaluation> filter_recipes = new ArrayList<>();
		ArrayList<String> common_ingredients = new ArrayList<>();
			
		Statement statement = null;
		ResultSet rs1 = null;
			
		try 
		{
			String query1 = "select item_name from essex_farm_grocery_list_tbl where item_status='common'";
			statement=conn.createStatement();
			rs1 = statement.executeQuery(query1);
			while(rs1.next())
				common_ingredients.add(rs1.getString("item_name"));
			
			String query = "select item_name,item_score from essex_farm_grocery_list_tbl";
			statement = conn.createStatement();
			rs1 = statement.executeQuery(query);
			while(rs1.next())
				all_grocery_list.put(rs1.getString("item_name").toLowerCase(),rs1.getFloat("item_score"));
			rs1 = null;
			
			String sql1 ="select ingredients from user_ingredients where user_id in (select user_id from user_tbl where user_email='"+username+"')";	
			rs1 = statement.executeQuery(sql1);
			while(rs1.next())
			{
				user_ingredients.add(rs1.getString("ingredients").toLowerCase());
			}
			rs1 = null;
			
			for(String i:user_ingredients)
			{
			String sql3 = "select recipe_id, recipe_title from essex_recipes_meta_tbl where recipe_id in (select recipe_id from essex_recipes_ingredients_tbl "
					+ "where recipe_ingredients like '%"+i+"%')";
			rs1 = statement.executeQuery(sql3);
			
			while(rs1.next())
				recipes.put(rs1.getInt("recipe_id"), rs1.getString("recipe_title"));
			}
			rs1 = null;
			
			for(int recipe_id:recipes.keySet())
			{
				HashMap<String,Float> available = new HashMap<>();
				HashMap<String,Float> missing = new HashMap<>();
				HashSet<String> items = new HashSet<>();
				String sql2 = "select recipe_ingredients from essex_recipes_ingredients_tbl where recipe_id="+recipe_id;
				rs1 = statement.executeQuery(sql2);
				while(rs1.next())
				{
					for(String s:all_grocery_list.keySet())
						if(rs1.getString("recipe_ingredients").toLowerCase().contains(s))
							items.add(s);
				}
				for(String s:items)
				{
					if(user_ingredients.contains(s))
					{
						available.put(s.toLowerCase(),all_grocery_list.get(s));
					}
					if(!user_ingredients.contains(s))
					{
						if(!common_ingredients.contains(s))
							missing.put(s.toLowerCase(),all_grocery_list.get(s));
					}
				}
				float total_ingredients = items.size();
				float count = available.size();
				float availability = (count / total_ingredients)*100;
				RecipeEvaluation recipeeve = new RecipeEvaluation();
				if(availability > 50)
				{
					recipeeve.setRecipe_id(recipe_id);
					recipeeve.setRecipe_title(recipes.get(recipe_id));
					recipeeve.setAvailable(available);
					recipeeve.setMissing(missing);
					filter_recipes.add(recipeeve);
				}
			}
			rs1 = null;
			
			final_recipes = get_filtered_recipes(filter_recipes);
			
			ArrayList<Integer> completed = new ArrayList<>();
			String sql5="select recipe_id from user_completed_recipes_tbl where user_id in (select user_id from user_tbl where user_email='"+username+"')";
			rs1 = statement.executeQuery(sql5);
			while(rs1.next())
				completed.add(rs1.getInt("recipe_id"));
			rs1 =null;
			
			for(int recipe_id:final_recipes.keySet())
			{
				if(!completed.contains(recipe_id))
				{
					String sql = "select recipe_images from essex_recipes_images_tbl where recipe_id="+recipe_id;
					rs1 = statement.executeQuery(sql);
					ArrayList<String> images = new ArrayList<>();
					if(rs1.next())
						images.add(rs1.getString("recipe_images"));
				
					RecipeBean recipe=new RecipeBean();
					recipe.setRecipe_id(recipe_id);
					recipe.setRecipe_title(final_recipes.get(recipe_id));
					recipe.setRecipe_gallery(images);
					myrecipes.add(recipe);
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return myrecipes;
	}
//----------------------------------------------------------------------
	
	public HashMap<Integer,String> get_filtered_recipes(ArrayList<RecipeEvaluation> filter_recipes)
	{
		HashMap<Integer,String> final_recipes=new HashMap<>();
		for(RecipeEvaluation recipe:filter_recipes)
		{
			ArrayList<Integer> flags = new ArrayList<>();
			if(recipe.getMissing().size()>0)
			{
				for(String s:recipe.getMissing().keySet())
				{
					if(recipe.getMissing().get(s)>4.00 && recipe.getMissing().get(s)<80.00)
					{
						flags.add(1);
					}
					else
					{
						if(recipe.getRecipe_title().toLowerCase().contains(s))
							flags.add(1);
						else
							flags.add(0);
					}
				}
				if(!(flags.contains(1)))
					final_recipes.put(recipe.getRecipe_id(), recipe.getRecipe_title());
			}
			else
			{
				final_recipes.put(recipe.getRecipe_id(), recipe.getRecipe_title());
			}
		}
		return final_recipes;
	}
	
	//-------------------------------------------------------
	
	public ArrayList<String> get_available_items(RecipeBean recipe, String username)
	{
		ArrayList<String> ingredients = new ArrayList<>();
		HashSet<String> items = new HashSet<>();
		ResultSet rs1 = null;
		Statement  statement = null;
		ArrayList<String> user_ingredients=new ArrayList<>();
		HashSet<String> all_grocery_list=new HashSet<>();
		
		try
		{
		String query = "select item_name from essex_farm_grocery_list_tbl";
		statement = conn.createStatement();
		rs1 = statement.executeQuery(query);
		while(rs1.next())
			all_grocery_list.add(rs1.getString("item_name").toLowerCase());
		rs1 = null;
		
		String sql1 ="select ingredients from user_ingredients where user_id in (select user_id from user_tbl where user_email='"+username+"')";	
		rs1 = statement.executeQuery(sql1);
		while(rs1.next())
			user_ingredients.add(rs1.getString("ingredients").toLowerCase());
		rs1 = null;
		
		String sql2 = "select recipe_ingredients from essex_recipes_ingredients_tbl where recipe_id="+recipe.getRecipe_id();
		rs1 = statement.executeQuery(sql2);
		while(rs1.next())
		{
			for(String s:all_grocery_list)
			{
				if(rs1.getString("recipe_ingredients").toLowerCase().contains(s))
				{
					System.out.println(s);
					items.add(s);
				}
			}
		}
		for(String s:items)
		{
			if(user_ingredients.contains(s))
				ingredients.add(s);
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return ingredients;
	}
	//--------------------------------------------------------
	
	public ArrayList<String> get_missing_ingredients(RecipeBean recipe, String username)
	{
		ArrayList<String> ingredients = new ArrayList<>();
		HashSet<String> items = new HashSet<>();
		ResultSet rs1 = null;
		Statement  statement = null;
		ArrayList<String> user_ingredients=new ArrayList<>();
		HashSet<String> all_grocery_list=new HashSet<>();
		
		try
		{
		String query = "select item_name from essex_farm_grocery_list_tbl";
		statement = conn.createStatement();
		rs1 = statement.executeQuery(query);
		while(rs1.next())
			all_grocery_list.add(rs1.getString("item_name").toLowerCase());
		rs1 = null;
		
		String sql1 ="select ingredients from user_ingredients where user_id in (select user_id from user_tbl where user_email='"+username+"')";	
		rs1 = statement.executeQuery(sql1);
		while(rs1.next())
			user_ingredients.add(rs1.getString("ingredients").toLowerCase());
		rs1 = null;
		
		String sql2 = "select recipe_ingredients from essex_recipes_ingredients_tbl where recipe_id="+recipe.getRecipe_id();
		rs1 = statement.executeQuery(sql2);
		while(rs1.next())
		{
			for(String s:all_grocery_list)
			{
				if(rs1.getString("recipe_ingredients").toLowerCase().contains(s))
					items.add(s);
			}
		}
		for(String s:items)
		{
			if(!user_ingredients.contains(s))
				ingredients.add(s);
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return ingredients;
	}
	//--------------------------------------------------------------------------
	
	public RecipeBean get_single_recipe(int recipe_id)
	{
		RecipeBean recipe = new RecipeBean();
		
		ArrayList<String> recipe_ingredients = new ArrayList<>();
		ArrayList<String> recipe_images = new ArrayList<>();
		ArrayList<String> recipe_steps = new ArrayList<>();
		ArrayList<String> recipe_reviews = new ArrayList<>();
		
		recipe.setRecipe_id(recipe_id);
		
		Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet rs = statement.getResultSet();
			String sql = "select recipe_title,recipe_serves from essex_recipes_meta_tbl where recipe_id= "+recipe_id;
			statement.executeQuery(sql);
			rs = statement.getResultSet();
			while (rs.next()) {
				recipe.setRecipe_title((rs.getString("recipe_title")));
				recipe.setRecipe_serves(rs.getString("recipe_serves"));
				System.out.println("Inside try");
			}
			rs = null;
			
			statement.executeQuery("select recipe_ingredients from essex_recipes_ingredients_tbl where recipe_id="+recipe_id);
			rs = statement.getResultSet();
			while (rs.next()) {
				recipe_ingredients.add(rs.getString("recipe_ingredients"));
				System.out.println("Inside try");
			}
			rs = null;
			
			statement.executeQuery("select recipe_images from essex_recipes_images_tbl where recipe_id="+recipe_id);
			rs = statement.getResultSet();
			while (rs.next()) {
				System.out.println(rs.getString("recipe_images"));
				recipe_images.add(rs.getString("recipe_images"));
				System.out.println("Inside try");
			}
			rs = null;
			
			statement.executeQuery("select recipe_step from essex_recipes_steps_tbl where recipe_id="+recipe_id);
			rs = statement.getResultSet();
			while (rs.next()) {
				recipe_steps.add(rs.getString("recipe_step"));
				System.out.println("Inside try");
			}
			rs = null;
			
			statement.executeQuery("select recipe_reviews from essex_recipes_reviews_tbl where recipe_id="+recipe_id);
			rs = statement.getResultSet();
			while (rs.next()) {
				recipe_reviews.add(rs.getString("recipe_reviews"));
				System.out.println("Inside try");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		recipe.setRecipe_ingredients(recipe_ingredients);
		recipe.setRecipe_gallery(recipe_images);
		recipe.setRecipe_reviews(recipe_reviews);
		recipe.setRecipe_steps(recipe_steps);
		
		return recipe;
	}
	
	//-------------------------------------------------------save recipe
	
	public String saveRecipe(String username, int recipe_id)
	{
		String status = "";
		try 
		{
			PreparedStatement pstmt;
			int user_id=0;
			String query = "select user_id from user_tbl where user_email='"+username+"'";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
				user_id = rs.getInt("user_id");
			pstmt = null;
			rs = null;
			
			int check = 0;
			String query2 = "select user_id,recipe_id from user_saved_recipes_tbl where user_id="+user_id+" and recipe_id="+recipe_id;
			pstmt = conn.prepareStatement(query2);
			rs = pstmt.executeQuery();
			while(rs.next())
				check++;
			pstmt = null;
			if(check==0)
			{
			String sql = "insert into user_saved_recipes_tbl (user_id,recipe_id) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);	
			pstmt.setInt(2, recipe_id);	
			int temp = pstmt.executeUpdate();
			if(temp>0)
				status = "Recipe saved successfully";
			else
				status = "Something went wrong.";
			}
			else
				status = "You have the recipe saved already.";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	//--------------------------------------------------------------------
	
	public String markascompleted(String username, int recipe_id)
	{
		String status = "";
		try 
		{
			PreparedStatement pstmt;
			int user_id=0;
			String query = "select user_id from user_tbl where user_email='"+username+"'";
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
				user_id = rs.getInt("user_id");
			pstmt = null;
			rs = null;
			
			String sql = "insert into user_completed_recipes_tbl (user_id,recipe_id) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);	
			pstmt.setInt(2, recipe_id);	
			int temp = pstmt.executeUpdate();
			if(temp>0)
				status = "Recipe completed successfully";
			else
				status = "Something went wrong.";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	//---------------------------------------------------------------------
	
	
	public ArrayList<RecipeBean> get_my_saved_recipes(String username)
	{
		ArrayList<RecipeBean> saved_recipes = new ArrayList<>();
		Statement statement = null;
		ResultSet rs1 = null;
	
		try 
		{
			String sql = "select recipe_id from user_saved_recipes_tbl where user_id in (select user_id from user_tbl where user_email='"+username+"')";
			statement = conn.createStatement();
			rs1 = statement.executeQuery(sql);
			while(rs1.next())
			{
				RecipeBean recipe=new RecipeBean();
				recipe.setRecipe_id(rs1.getInt("recipe_id"));
				saved_recipes.add(recipe);
			}
			rs1=null;
			
			for(RecipeBean recipe:saved_recipes)
			{
				String sql2 = "select recipe_title from essex_recipes_meta_tbl where recipe_id="+recipe.getRecipe_id();
				statement = conn.createStatement();
				rs1 = statement.executeQuery(sql2);
				while(rs1.next())
				{
					recipe.setRecipe_title(rs1.getString("recipe_title"));
				}
				rs1=null;
				String sql3 = "select recipe_images from essex_recipes_images_tbl where recipe_id="+recipe.getRecipe_id();
				statement = conn.createStatement();
				rs1 = statement.executeQuery(sql3);
				ArrayList<String> images = new ArrayList<>();
				if(rs1.next())
					images.add(rs1.getString("recipe_images"));
						
			    recipe.setRecipe_gallery(images);
			    rs1=null;
				}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saved_recipes;
	}
}

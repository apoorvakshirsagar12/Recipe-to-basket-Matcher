package com.recipes.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class RecipeProcessDao {
	private Connection conn=null;
	
	public RecipeProcessDao()
	{
		conn = DBConnection.createConnection();
	}

	public String showRecipes(ArrayList<RecipeBean> all_recipes)
	{
		if(addRecipes(all_recipes)=="Recipe added successfully")
			return "Recipe added successfully";
		else
			return "Recipe is already present.";
	}
	
	public String addRecipes(ArrayList<RecipeBean> all_recipes)
	{
		String result = "Recipe is already present.";
		try
		{
			for(RecipeBean recipe:all_recipes)
			{
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs = null;

			//String sql="select recipe_id from essex_recipes_meta_tbl where recipe_id="+recipe.getRecipe_id();
			//stmt = conn.createStatement();
			//rs = stmt.executeQuery(sql);
			//if(rs.next()==false)
			//{
				
				/*String sql2 = "insert into essex_recipes_meta_tbl(recipe_id,recipe_title, recipe_serves) values (?,?,?)";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, recipe.getRecipe_id());
				pstmt.setString(2, recipe.getRecipe_title());
				pstmt.setString(3, recipe.getRecipe_serves());
				pstmt.executeUpdate();
				
				pstmt = null;*/
				for(String i:recipe.getRecipe_ingredients())
				{
				String sql3 = "insert into essex_recipes_ingredients_tbl(recipe_id,recipe_ingredients) values (?,?)";
				pstmt = conn.prepareStatement(sql3);
				pstmt.setInt(1, recipe.getRecipe_id());
				pstmt.setString(2, i);
				pstmt.executeUpdate();
				}
				
				pstmt = null;
				for(String i:recipe.getRecipe_steps())
				{
				String sql3 = "insert into essex_recipes_steps_tbl(recipe_id,recipe_step) values (?,?)";
				pstmt = conn.prepareStatement(sql3);
				pstmt.setInt(1, recipe.getRecipe_id());
				pstmt.setString(2, i);
				pstmt.executeUpdate();
				}
				
				pstmt = null;
				if(!recipe.getRecipe_gallery().isEmpty())
				{
				for(String i:recipe.getRecipe_gallery())
				{
				String sql3 = "insert into essex_recipes_images_tbl(recipe_id,recipe_images) values (?,?)";
				pstmt = conn.prepareStatement(sql3);
				pstmt.setInt(1, recipe.getRecipe_id());
				pstmt.setString(2, i);
				pstmt.executeUpdate();
				}
				}
				pstmt = null;
				
				/*for(String i:recipe.getRecipe_reviews())
				{
				String sql3 = "insert into essex_recipes_reviews_tbl(recipe_id,recipe_reviews) values (?,?)";
				pstmt = conn.prepareStatement(sql3);
				pstmt.setInt(1, recipe.getRecipe_id());
				pstmt.setString(2, i);
				pstmt.executeUpdate();
				}*/
				
				result = "Recipe added successfully";
			}
			//}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	}
	public void calculateScore()
	{
		ArrayList<String> all_grocery_list=new ArrayList<>();
		Statement statement = null;
		ResultSet rs1 = null;
		try 
		{
			String query = "select item_name from essex_farm_grocery_list_tbl";
			statement = conn.createStatement();
			rs1 = statement.executeQuery(query);
			while(rs1.next())
			{
				all_grocery_list.add(rs1.getString("item_name"));
			}
			rs1 = null;
			
			float total_recipes = 0;
			String query1 = "select * from essex_recipes_meta_tbl";
			statement = conn.createStatement();
			rs1 = statement.executeQuery(query1);
			while(rs1.next())
				total_recipes++;
			System.out.println(total_recipes);
			rs1 = null;
			
			for(String item_name:all_grocery_list)
			{
				float count = 0;
				float item_score = 0;
				String query2 = "select distinct recipe_id from essex_recipes_ingredients_tbl where recipe_ingredients like '%"+item_name+"%'";
				statement = conn.createStatement();
				rs1 = statement.executeQuery(query2);
				while(rs1.next())
					count++;
				item_score = (count/total_recipes)*100;
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(2);

				String query3 = "update essex_farm_grocery_list_tbl set item_score = "+ df.format(item_score) +" where item_name = '"+item_name+"'";
				statement = conn.createStatement();
				statement.executeUpdate(query3);
				
				System.out.println(item_name+":"+df.format(item_score));
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException 
	{	
		ArrayList<RecipeBean> all_recipes=new ArrayList<>();
		RecipeProcessDao obj = new RecipeProcessDao();
		//all_recipes=WebScrap2.get_recipe_details();
		//System.out.println(obj.showRecipes(all_recipes));
		obj.calculateScore();
	}

}

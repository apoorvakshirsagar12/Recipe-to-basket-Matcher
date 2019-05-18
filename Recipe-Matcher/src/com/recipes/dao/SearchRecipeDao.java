package com.recipes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.recipes.bean.RecipesBean;
import com.recipes.util.DBConnection;

public class SearchRecipeDao {

	Connection conn = DBConnection.createConnection();
	public void searchRecipe(String with, String without)
	{
		if(!with.isEmpty())
		{	
		String[] cwith=with.split(":");
		with = cwith[1];
		}
		if(!without.isEmpty())
		{
			String[] cwithout=without.split(":");
			without = cwithout[1];
		}
		
		List <RecipesBean> recipes=new ArrayList<RecipesBean>();
		HashMap <Integer, ArrayList> ingredients = new HashMap<>();
		HashMap <Integer, ArrayList> steps = new HashMap<>();
		HashMap <Integer, ArrayList> images = new HashMap<>();
		HashMap <Integer, ArrayList> reviews = new HashMap<>();
		
		try
		{
			String sql="select a.recipe_id,a.recipe_title from essex_recipes_meta_tbl a, essex_recipes_ingredients_tbl b where " +
					 "recipe_ingredients like '%"+with+"%' and recipe_ingredients not like '%"+without+"%' and b.recipe_id=a.recipe_id";
			
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				RecipesBean recipe=new RecipesBean();
				int recipe_id=rs.getInt("recipe_id");
				String recipe_title=rs.getString("recipe_title");
				recipe.setRecipe_id(recipe_id);	
				recipe.setRecipe_title(recipe_title);
				recipes.add(recipe);
			}
			for(RecipesBean recipe:recipes){
				int recipe_id=recipe.getRecipe_id();
				ArrayList <String> ingredient=new ArrayList<>();
				ArrayList <String> step=new ArrayList<>();
				stmt=conn.createStatement();
				ResultSet rs2=stmt.executeQuery("select recipe_ingredients from essex_recipes_ingredients_tbl where recipe_id="+recipe_id);
				
				while(rs2.next())
				{
					ingredient.add(rs2.getString("recipe_ingredients"));
				}
				rs2.close();
				stmt=conn.createStatement();
				ResultSet rs3=stmt.executeQuery("select recipe_step from essex_recipes_steps_tbl where recipe_id="+recipe_id);
				while(rs3.next())
				{
					step.add(rs3.getString("recipe_step"));
				}
				ingredients.put(recipe_id, ingredient);
				recipe.setRecipe_ingredients(ingredients.get(recipe_id));
				steps.put(recipe_id, step);
				recipe.setRecipe_steps(steps.get(recipe_id));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		for(RecipesBean recipe:recipes) {
			System.out.println(recipe.getRecipe_id());
			System.out.println(recipe.getRecipe_title());
			System.out.println("Ingredients:");
			for(String s:recipe.getRecipe_ingredients())
				System.out.println(s);
			System.out.println("Directions:");
			for(String s:recipe.getRecipe_steps())
				System.out.println(s);
		}
	}
	
}

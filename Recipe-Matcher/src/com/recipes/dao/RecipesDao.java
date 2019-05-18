package com.recipes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.recipes.bean.MyBasketBean;
import com.recipes.bean.RecipesBean;
import com.recipes.util.DBConnection;

public class RecipesDao {

	private Connection conn;
	
	public RecipesDao()
	{
		conn=DBConnection.createConnection();
	}
	
	
	public List<RecipesBean> getAllRecipes() {
		System.out.println("In getAllUsers");
		List <RecipesBean> recipes=new ArrayList<RecipesBean>();
		try
		{
			String query="select recipe_id,recipe_title from essex_recipes_meta_tbl";
			System.out.println(query);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.println("In while of resultset");
				RecipesBean recipe=new RecipesBean();
				recipe.setRecipe_id(rs.getInt("recipe_id"));
				System.out.println(rs.getString("recipe_title"));
				recipe.setRecipe_title(rs.getString("recipe_title"));
				recipes.add(recipe);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return recipes;
	}

	public void deleteRecipe(int parseInt) {
		// TODO Auto-generated method stub
		
	}

}

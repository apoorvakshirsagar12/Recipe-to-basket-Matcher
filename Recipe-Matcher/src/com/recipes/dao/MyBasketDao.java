package com.recipes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.recipes.util.DBConnection;
import com.recipes.bean.MyBasketBean;

public class MyBasketDao {
	
	private Connection conn;
	
	public MyBasketDao()
	{
		conn=DBConnection.createConnection();
	}
	
	public int findUserId(String username)
	{
		int userid=0;
		try
		{
			String query="select user_id from user_tbl where user_email='" + username + "'";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
		
			while(rs.next())
				userid=rs.getInt("user_id");	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return userid;
	}

	public List<MyBasketBean> getAllIngredients(String username, int startPageIndex, int numRecordsPerPage) {
		System.out.println("In getAllUsers");
		String startIndex = Integer.toString(startPageIndex);
		String pageSize = Integer.toString(numRecordsPerPage);
		
		List <MyBasketBean> ingredients=new ArrayList<MyBasketBean>();
		try
		{
			int userid=findUserId(username);
			String query="select id,ingredients from user_ingredients where user_id= " + userid + " limit "+startIndex+","+pageSize;
			System.out.println(query);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.println("In while of resultset");
				MyBasketBean ingredient=new MyBasketBean();
				ingredient.setIngredient_id(rs.getInt("id"));
				ingredient.setIngredient_name(rs.getString("ingredients"));
				ingredients.add(ingredient);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ingredients;
	}

	public int getIngredientCount(String username)
	{
		int count=0;
		try
		{
			int userid=findUserId(username);
			String query="select count(*) as count from user_ingredients where user_id= " + userid;
			System.out.println(query);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				count = rs.getInt("count");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	public String addIngredient(MyBasketBean ingredient, String username) {
		
		String status = "";
		try
		{
			int userid = findUserId(username);
			System.out.println(userid);
			ArrayList<String> user_ingredients = new ArrayList<>();
			String sql = "select ingredients from user_ingredients where user_id="+userid;
			Statement stmt= conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
				user_ingredients.add(rs.getString("ingredients"));
			rs = null;
			if(user_ingredients.contains(ingredient.getIngredient_name()))
			{
				status = "Ingredient is already present";
			}
			else
			{
			String query="insert into user_ingredients (user_id, ingredients) values(?, ?)";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, userid);
			pstmt.setString(2, ingredient.getIngredient_name());
			pstmt.executeUpdate();
			status = "Ingredient added successfully.";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	public void updateIngredient(MyBasketBean ingredient, String username) {
		try
		{
			int userid = findUserId(username);
			String query="update user_ingredients set ingredients=? where id=? and userid=? ";
			
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1, ingredient.getIngredient_name());
			pstmt.setInt(2, ingredient.getIngredient_id());
			pstmt.setInt(3, userid);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	public void deleteIngredient(int ingredient_id, String username)
	{
		try
		{
			
			String query="delete from user_ingredients where id=?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, ingredient_id);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}

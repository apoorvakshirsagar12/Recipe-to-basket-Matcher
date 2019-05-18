package com.recipes.dao;

import java.sql.*;

public class NewRecipesDao {

	public void importData(Connection conn,String filename)
    {
        Statement stmt;
        String query;
 
        try
        {
            stmt = conn.createStatement(
            		ResultSet.TYPE_SCROLL_SENSITIVE,
            		ResultSet.CONCUR_UPDATABLE);
            	
            query = "LOAD DATA INFILE '"+filename+
            		"' INTO TABLE temp_recipes FIELDS TERMINATED BY ','"
            		+ "LINES TERMINATED BY '\n' (recipe_id,recipe_title,recipe_serves,recipe_reviews,recipe_steps,recipe_images);";
            System.out.println(query);
 
            stmt.executeUpdate(query);
                
        }
        catch(Exception e)
        {
            e.printStackTrace();
            stmt = null;
        }
    }
	
	
}

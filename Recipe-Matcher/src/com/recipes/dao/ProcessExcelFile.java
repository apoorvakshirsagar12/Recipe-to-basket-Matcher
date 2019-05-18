package com.recipes.dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.recipes.bean.UserIngredients;
import com.recipes.util.DBConnection;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ProcessExcelFile {

	Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    public UserIngredients getIngredientsListFromExcel(String username) throws SQLException
    {
    	UserIngredients basket = new UserIngredients();
        ArrayList<String> ingredients = new ArrayList<>();
        int id = 0;
        
        FileInputStream fis = null;
        try {
        	conn = DBConnection.createConnection();
        	String sql = "select user_id from user_tbl where user_email='"+username+"'";        	
        	stmt = conn.createStatement();
        	rs = stmt.executeQuery(sql);
        	while(rs.next())
        		id = rs.getInt("user_id");
        		
        	String FILE_PATH = "C:/Users/ApoorvaK/Documents/uploads/user_" + Integer.toString(id) + ".xlsx"  ;
        	System.out.println(FILE_PATH);
            fis = new FileInputStream(FILE_PATH);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = datatypeSheet.iterator();
                //iterating over each row
                while (rowIterator.hasNext()) 
                {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.iterator();
                    while (cellIterator.hasNext()) 
                    {
                        Cell cell = cellIterator.next();
                        ingredients.add(cell.getStringCellValue());
                    }
                }
                basket.setUser_id(id);
                basket.setIngredients(ingredients);
            fis.close();
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return basket;
    }
    
    public String processIngredients(UserIngredients basket)
    {
    	String status= "";
    	int user_id = basket.getUser_id();
    	ArrayList<String> user_ingredients = new ArrayList<>();
		basket.getIngredients().remove("Ingredient Name");
		try 
		{
			String sql = "select ingredients from user_ingredients where user_id="+user_id;
			Statement stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
				user_ingredients.add(rs.getString("ingredients"));
			rs=null;
			for(String i:basket.getIngredients())
			{
				if(user_ingredients.contains(i))
				{
					status = "Ingredient is already present";
				}
				else
				{
					String query="insert into user_ingredients (user_id, ingredients) values(?, ?)";
					PreparedStatement pstmt=conn.prepareStatement(query);
					pstmt.setInt(1, user_id);
					pstmt.setString(2, i);
					pstmt.executeUpdate();
					status = "Ingredient added successfully.";
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
    	return status;
    }
    
   /* public void downloadFile(String urlStr) throws IOException
    {
    	 URL url = new URL(urlStr);
         BufferedInputStream bis = new BufferedInputStream(url.openStream());
         FileOutputStream fis = new FileOutputStream(file);
         byte[] buffer = new byte[1024];
         int count=0;
         while((count = bis.read(buffer,0,1024)) != -1)
         {
             fis.write(buffer, 0, count);
         }
         fis.close();
         bis.close();
    }*/
    
}

package com.recipes.dao;
import java.sql.*;
import com.recipes.bean.Register;
import com.recipes.util.DBConnection;

public class RegisterDao {

	public void addUser(Register user)
	{
		String fname= user.getFname();
		String lname= user.getLname();
		String email=user.getEmail();
		String password=user.getPassword();
		
		try
		{
			Connection conn=DBConnection.createConnection();
			System.out.println(conn);
			Statement stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery("select user_id from user_tbl where user_email='"+user.getEmail()+"'");
			if(!rs.next())
			{
			String sql="insert into user_tbl (user_fname, user_lname, user_email, user_passwd) values (?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.executeUpdate();
			System.out.println("inserted successfully");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	

}

package com.recipes.controller;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipes.util.DBConnection;
import com.recipes.util.EncryptPassword;
import com.recipes.bean.Register;
import com.recipes.dao.RegisterDao;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	
	private RegisterDao dao;

    public UserRegister() {
        dao = new RegisterDao();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("username");
		String password = EncryptPassword.encryption(request.getParameter("passwd"));
		System.out.println("Encrypt Admin: "+password);
		
		Register user = new Register();
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(uname);
		user.setPassword(password);
		
		dao.addUser(user);
		request.getRequestDispatcher("/index.jsp").forward(request,response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int user_id = Integer.parseInt(request.getParameter("user_id"));
		String username = request.getParameter("user_email");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		Connection conn = DBConnection.createConnection();
		PreparedStatement pstmt = null;
		try
		{
			Statement stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery("select user_id from user_tbl where user_email='"+username+"'");
			if(!rs.next())
			{
			String sql = "update user_tbl set user_email=?,user_fname=?,user_lname=? where user_email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, fname);
			pstmt.setString(3, lname);
			pstmt.setString(4, username);
			pstmt.executeUpdate();
			System.out.println("updated successfully");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		request.getRequestDispatcher("/accountDetails.jsp").forward(request,response);
	}
	
}

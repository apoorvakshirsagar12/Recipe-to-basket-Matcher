package com.recipes.controller;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipes.dao.NewRecipesDao;
import com.recipes.util.DBConnection;

@WebServlet("/NewRecipesServlet")
public class NewRecipesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewRecipesDao dao = new NewRecipesDao();
		Connection conn=DBConnection.createConnection();
		String filename = "Recipes.csv";
		dao.importData(conn, filename);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package com.recipes.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipes.dao.SearchRecipeDao;

@WebServlet("/SearchRecipeServlet")
public class SearchRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SearchRecipeDao dao;
    public SearchRecipeServlet() {
        dao = new SearchRecipeDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String with = request.getParameter("cwith");
		String without = request.getParameter("cwithout");
		
		dao.searchRecipe(with, without);
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}

}

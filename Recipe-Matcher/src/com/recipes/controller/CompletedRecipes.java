package com.recipes.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recipes.dao.UserRecipes;

@WebServlet("/CompletedRecipes")
public class CompletedRecipes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompletedRecipes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserRecipes obj = new UserRecipes();
		int recipe_id = Integer.parseInt(request.getParameter("recipe_id"));
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String status = obj.markascompleted(username, recipe_id);
		if(status.equalsIgnoreCase("Recipe completed successfully"))
		{
			System.out.println("Recipe completed successfully");
			request.getRequestDispatcher("/myRecipes.jsp").forward(request, response);
		}
		else
		{
			System.out.println(status);
			request.setAttribute("msg",status);
			request.getRequestDispatcher("/myRecipes.jsp").forward(request, response);
		}
	}

}

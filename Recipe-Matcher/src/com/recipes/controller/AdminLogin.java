package com.recipes.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("psw");
		
		if (username.equals("admin") && password.equals("admin"))
		{
			System.out.println("success");
			request.setAttribute("admin_username",username);
			request.getSession().setAttribute("admin_username",username);
			request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);;
		}
		else
		{
			//request.setAttribute("errMessage",validateUser);
			request.getRequestDispatcher("/recipe-matcher-admin-login.jsp").forward(request,response);
		}
		HttpSession session = request.getSession();
		session.setAttribute("admin_username", username);
	}

}

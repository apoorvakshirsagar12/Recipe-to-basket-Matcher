package com.recipes.controller;

import com.recipes.bean.LoginBean;
import com.recipes.dao.LoginDao;
import com.recipes.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = EncryptPassword.encryption(request.getParameter("psw"));
		System.out.println("Encrypt Admin: "+password);
		
		LoginBean loginbean=new LoginBean();
		loginbean.setEmail(username);
		loginbean.setPassword(password);
		
		LoginDao logindao=new LoginDao();
		String validateUser=logindao.authenticateUser(loginbean);
		if (validateUser.equals("SUCCESS"))
		{
			System.out.println("success");
			request.setAttribute("username",username);
			request.getSession().setAttribute("username",username);
			request.getRequestDispatcher("/userDashboard.jsp").forward(request, response);
		}
		else
		{
			//request.setAttribute("errMessage",validateUser);
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}

		HttpSession session = request.getSession();
		session.setAttribute("username", username);

	}

}

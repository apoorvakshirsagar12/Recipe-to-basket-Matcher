package com.recipes.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recipes.util.RecipeBean;
import com.recipes.util.RecipeProcessDao;
import com.recipes.util.WebScrap;

@WebServlet("/RecipeProcessServlet")
public class RecipeProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RecipeProcessServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String status = "";
		ArrayList<RecipeBean> all_recipes=new ArrayList<>();
		all_recipes = WebScrap.get_recipe_details();
		RecipeProcessDao dao = new RecipeProcessDao();
		status = dao.showRecipes(all_recipes);
		session.setAttribute("get-recipe", status);
	}

}

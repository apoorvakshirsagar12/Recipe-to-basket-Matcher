package com.recipes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.recipes.bean.MyBasketBean;
import com.recipes.bean.RecipesBean;
import com.recipes.dao.RecipesDao;

@WebServlet("/RecipesController")
public class RecipesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public RecipesDao dao;
	
    public RecipesController() {
       dao = new RecipesDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		System.out.println("In doPost");
		
		String username = (String) request.getSession().getAttribute("username");
		System.out.println(username);
		
		if(request.getParameter("action")!=null)
		{
			List<RecipesBean> lstRecipes=new ArrayList<RecipesBean>();
			String action=(String)request.getParameter("action");
			Gson gson=new Gson();
			response.setContentType("application/json");
			if(action.equals("list"))
			{
				try
				{
					lstRecipes=dao.getAllRecipes();
					JsonElement element=gson.toJsonTree(lstRecipes,new TypeToken<List<MyBasketBean>>() {}.getType());
					JsonArray jsonArray = element.getAsJsonArray();
					String listData=jsonArray.toString();
					System.out.println(listData);
					//Return Json in the format required by jTable plugin
					listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";
					response.getWriter().print(listData);
				}
				catch(Exception ex)
				{
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}
			}
			else if(action.equals("delete"))
			{
				//Delete record
				try
				{
					if(request.getParameter("recipe_id")!=null)
					{
						String recipe_id=(String)request.getParameter("recipe_id");
						dao.deleteRecipe(Integer.parseInt(recipe_id));
						String listData="{\"Result\":\"OK\"}";
						response.getWriter().print(listData);
					}
				}
				catch(Exception ex)
				{
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
					response.getWriter().print(error);
				} 
			}
		}
	}

}

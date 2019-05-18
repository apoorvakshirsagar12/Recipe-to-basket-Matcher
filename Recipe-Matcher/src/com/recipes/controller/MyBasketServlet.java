package com.recipes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recipes.dao.MyBasketDao;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.recipes.bean.MyBasketBean;

@WebServlet("/MyBasketServlet")
public class MyBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyBasketDao dao;
	
    public MyBasketServlet() {
        dao = new MyBasketDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doPost");
		
		String username = (String) request.getSession().getAttribute("username");
		System.out.println(username);
		
		if(request.getParameter("action")!=null)
		{
			List<MyBasketBean> lstBasket=new ArrayList<MyBasketBean>();
			String action=(String)request.getParameter("action");
			Gson gson=new Gson();
			response.setContentType("application/json");
			if(action.equals("list"))
			{
				try
				{
					int startPageIndex = Integer.parseInt(request.getParameter("jtStartIndex"));
					int numRecordsPerPage = Integer.parseInt(request.getParameter("jtPageSize"));
					
					lstBasket=dao.getAllIngredients(username, startPageIndex, numRecordsPerPage);
					int ingredientsCount = dao.getIngredientCount(username);
					JsonElement element=gson.toJsonTree(lstBasket,new TypeToken<List<MyBasketBean>>() {}.getType());
					JsonArray jsonArray = element.getAsJsonArray();
					String listData=jsonArray.toString();
					//Return Json in the format required by jTable plugin
					listData="{\"Result\":\"OK\",\"Records\":"+listData+",\"TotalRecordCount\":"+ingredientsCount+"}";
					response.getWriter().print(listData);
				}
				catch(Exception ex)
				{
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}
			}
			else if(action.equals("create") || action.equals("update"))
			{
				MyBasketBean ingredient=new MyBasketBean();
				if(request.getParameter("ingredient_id")!=null)
				{ 
					int ingredient_id=Integer.parseInt(request.getParameter("ingredient_id"));
					ingredient.setIngredient_id(ingredient_id);;
				}
				if(request.getParameter("ingredient_name")!=null)
				{
					String ingredient_name=(String)request.getParameter("ingredient_name");
					ingredient.setIngredient_name(ingredient_name);;
				}
				
				try
				{
					if(action.equals("create"))
					{
						//Create new record
						String status = dao.addIngredient(ingredient,username);
						if(status.equalsIgnoreCase("Ingredient added successfully."))
							lstBasket.add(ingredient);
						//Convert Java Object to Json��� 
						String json=gson.toJson(ingredient);
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}"; 
						response.getWriter().print(listData);
					}
					else if(action.equals("update"))
					{
						//Update existing record
						dao.updateIngredient(ingredient,username);
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
			else if(action.equals("delete"))
			{
				//Delete record
				try
				{
					if(request.getParameter("ingredient_id")!=null)
					{
						String ingredient_id=(String)request.getParameter("ingredient_id");
						dao.deleteIngredient(Integer.parseInt(ingredient_id),username);
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

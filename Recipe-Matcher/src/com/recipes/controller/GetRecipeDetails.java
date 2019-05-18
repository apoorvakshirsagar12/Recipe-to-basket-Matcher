package com.recipes.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.recipes.dao.UserRecipes;
import com.recipes.util.RecipeBean;


@WebServlet("/GetRecipeDetails")
public class GetRecipeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public GetRecipeDetails() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try 
		{
			String output = "";
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			RecipeBean recipe = new RecipeBean();
			UserRecipes obj = new UserRecipes();
			
			recipe = obj.get_single_recipe(Integer.parseInt(request.getParameter("recipe_id")));
			
			output = output + "<h3 style='font-size:xx-large; font-family:sans serif; text-align:center;'>" + recipe.getRecipe_title().replaceAll("[^a-zA-Z0-9\\s]", " ") + "</h3></br>";
					
			output = output + "<div class='slideshow-container'>";
			for(String image:recipe.getRecipe_gallery())
			{
				output = output + "<div class='mySlides'><img src='"+image+"'style='width:100%'></div>";
			}
		    output = output + "<a class='prev' onclick='plusSlides(-1)'>&#10094;</a>";
			output = output + "<a class='next' onclick='plusSlides(1)'>&#10095;</a>";
			output = output + "</div></br><h4>&nbsp;</h4>";
				
			output = output + "<h4 style='font-family:sans serif;'>"+recipe.getRecipe_serves()+"</h4>";
			
			output = output + "<h4 style='font-family:sans serif;'>Ingredients</h4>";
			for(String ingredient:recipe.getRecipe_ingredients())
			{
				output = output + "<h5 style='font-family:sans serif; font-size:large;'>" + ingredient + "</h5>";
			}
			
			output = output + "</br><div><u> You have: </u></br>";
			String youhave = "";
			boolean first = true;
			for(String i: obj.get_available_items(recipe, username))
			{
				String temp = i.substring(0,1).toUpperCase()+i.substring(1);
				if(first) 
				{
			        youhave+=temp;
			        first=false;
			    } 
				else
			        youhave+=","+temp;
			}
			output = output + youhave ;
			int size = obj.get_missing_ingredients(recipe, username).size();
			if(size!=0)
			{
			output = output + "</br> <u> You don't have: </u></br>";
			String youdonthave = "";
			boolean f = true;
			
			
			for(String i: obj.get_missing_ingredients(recipe, username))
			{
				String temp = i.substring(0,1).toUpperCase()+i.substring(1);
				if(f) 
				{
			        youdonthave+=temp;
			        f=false;
			    } 
				else
			        youdonthave+=","+temp;
			}
			
			output = output + youdonthave ;
			output = output + "</br><div><u> Get Ingredients: </u>";
			output = output + "<a href='https://essexfarmcsa.com/' style='margin-left:2%;' target='_blank'>Essex Farm |</a>";
			output = output + "<a href='https://www.walmart.com/' style='margin-left:1%;' target='_blank'>Walmart |</a>";
			output = output + "<a href='https://shop.shoprite.com/' style='margin-left:1%;' target='_blank'>ShopRite</a>";
			}
			output = output + "</div>";
			
						
			output = output + "<br><h4 style='font-family:sans serif;'>Directions</h4>";	
			for(String step:recipe.getRecipe_steps())
			{
				output = output + "<h5 style='font-family:sans serif; font-size:large;'>" + step + "</h5></br>";
			}
			
			if(!recipe.getRecipe_reviews().isEmpty())
			{
				output = output + "<h4 style='font-family:sans serif;'>Reviews</h4>";
				for(String review:recipe.getRecipe_reviews())
				{
					output = output + "<h5 style='font-family:sans serif; font-size:large;'>" + review + "</h5></br>";
				}
			}
			
			
			String parent = (String) session.getAttribute("parent_page");
			if(parent.equals("savedRecipes"))
			{
				output = output + "<div align='center'><a class='button button-hero button-shadow' style='margin-left:50%;' href='savedRecipes.jsp'>Back</a>"
						+ "<button class='button button-hero button-shadow' onclick='save("+recipe.getRecipe_id()+")'>Remove Recipe</button></div>";
			}
			if(parent.equals("myRecipes"))
			{
				output = output + "<div align='center'><a class='button button-hero button-shadow' style='margin-left:25%;' href='myRecipes.jsp'>Back</a>"
						+ "<button class='button button-hero button-shadow' onclick='complete("+recipe.getRecipe_id()+")'>Mark as Complete</button>"
						+ "<button class='button button-hero button-shadow' onclick='save("+recipe.getRecipe_id()+")'>Save Recipe</button></div>";
			}
			if(parent.equals("meal_plan"))
			{
				output = output + "<div align='center'><a class='button button-hero button-shadow' style='margin-left:50%;' href='myMealPlan.jsp'>Back</a>";
			}
			out.println(output);

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}

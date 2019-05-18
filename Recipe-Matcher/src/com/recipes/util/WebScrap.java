package com.recipes.util;

import java.util.*;


import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements;



public class WebScrap {
	static String url = "https://food52.com";
	
	public static ArrayList<String> get_page_urls() throws IOException
	{
		ArrayList <String> page_urls = new ArrayList<>();
		String main_page = url + "/collections/2165046-essex-farm-csa";
		Document doc = Jsoup.connect(main_page).get();
		Elements links = doc.getElementsByClass("pagination").select("a[href]"); 
		System.out.println(links.size());
		for(int i=1;i<=links.size();i++)
		{
			if(!page_urls.contains(main_page+"?page="+Integer.toString(i)))
				page_urls.add(main_page+"?page="+Integer.toString(i));
		}
		return page_urls;
	}
	
	public static ArrayList<RecipeBean> get_recipe_details() throws IOException
	{
		ArrayList <String> page_urls = get_page_urls();
		ArrayList <RecipeBean> all_recipes = new ArrayList<>();
		
		for(String page_url: page_urls)
		{
			Document doc = Jsoup.connect(page_url).get();
			System.out.println(page_url);  
			Elements links = doc.getElementsByClass("photo photo-block__link");  
			for (Element link : links) 
			{  
				if(link.toString().contains("/recipes/"))
				{
					String recipe_url = url + link.attr("href");
					int recipe_id =  Integer.parseInt(recipe_url.substring(recipe_url.indexOf("/recipes/") + 9, recipe_url.indexOf("-")));
					all_recipes.add(process_recipe_details(recipe_id,recipe_url));
				}
			}
		}
		return all_recipes;
	}

	public static RecipeBean process_recipe_details(int recipe_id,String recipe_url) throws IOException
	{
		RecipeBean bean = new RecipeBean();
		String recipe_title =  get_recipe_title(recipe_id, recipe_url);
		String recipe_serves = get_recipe_serves(recipe_id, recipe_url);
		ArrayList <String> recipe_ingredients = get_recipe_ingredients(recipe_id, recipe_url);
		ArrayList<String> recipe_steps = get_recipe_steps(recipe_id, recipe_url);
		ArrayList<String> recipe_images = get_recipe_images(recipe_id, recipe_url);
		ArrayList<String> recipe_reviews = get_recipe_reviews(recipe_id, recipe_url);
		bean.setRecipe_id(recipe_id);
		bean.setRecipe_title(recipe_title);
		bean.setRecipe_serves(recipe_serves);
		bean.setRecipe_ingredients(recipe_ingredients);
		bean.setRecipe_steps(recipe_steps);
		bean.setRecipe_gallery(recipe_images);
		bean.setRecipe_reviews(recipe_reviews);
		get_recipe_author_notes(recipe_id, recipe_url);
		
		return bean;
	}
	
	public static String get_recipe_title(int recipe_id,String recipe_url) throws IOException
	{
		Document doc = Jsoup.connect(recipe_url).get();
		Elements title = doc.getElementsByClass("recipe__header-title");
		return title.text();
	}
	
	public static String get_recipe_serves(int recipe_id, String recipe_url) throws IOException
	{
		String serves = "";
		Document doc = Jsoup.connect(recipe_url).get();
		Elements recipe_makes = doc.getElementsByClass("recipe__text");
		String recipe_serves = recipe_makes.text();
		if(recipe_serves.contains("Prep time:"))
		{
			if(recipe_serves.contains("Makes:"))
				serves = recipe_serves.substring(recipe_serves.indexOf("Makes:") + 0, recipe_serves.indexOf("Prep time:"));
			else if(recipe_serves.contains("Serves:"))
				serves = recipe_serves.substring(recipe_serves.indexOf("Serves:") + 0, recipe_serves.indexOf("Prep time:"));
		}
		else
		{
			if(recipe_serves.contains("Makes:"))
				serves = recipe_serves.substring(recipe_serves.indexOf("Makes:") + 0, recipe_serves.indexOf("Ingredients"));
			else if(recipe_serves.contains("Serves:"))
				serves = recipe_serves.substring(recipe_serves.indexOf("Serves:") + 0, recipe_serves.indexOf("Ingredients"));
		}
		return serves;
	}
	
	public static String get_recipe_author_notes(int recipe_id, String recipe_url) throws IOException
	{
		String author_notes = "";
		Document doc = Jsoup.connect(recipe_url).get();
		Elements recipe_notes = doc.getElementsByClass("recipe-note");
		author_notes = recipe_notes.text();
		System.out.println(author_notes);
		return author_notes;
	}
	
	public static ArrayList<String> get_recipe_ingredients(int recipe_d, String recipe_url) throws IOException
	{
		Document doc = Jsoup.connect(recipe_url).get();
		Elements quantities = doc.getElementsByClass("recipe-list-quantity");
		Elements items = doc.getElementsByClass("recipe-list-item-name");
		String[] item_quantity = new String[quantities.size()];
		String[] item_name = new String[items.size()];
		ArrayList<String> recipe_ingredients = new ArrayList<>();
		int i=0;
		for(Element q:quantities)
		{
			item_quantity[i]=q.text();
			i++;
		}
		i = 0;
		for(Element q: items)
		{
			item_name[i]=q.text();
			i++;
		}
		
		for(i=0;i<item_name.length;i++)
			recipe_ingredients.add(item_quantity[i] + " " + item_name[i]);
		
		return recipe_ingredients;
	}
	
	public static ArrayList<String> get_recipe_steps(int recipe_id, String recipe_url) throws IOException
	{
		ArrayList<String> recipe_steps = new ArrayList<>();
		Document doc = Jsoup.connect(recipe_url).get();
		Elements steps_data = doc.getElementsByTag("ol");
		String steps = steps_data.toString();
		steps = steps.substring(steps.indexOf("<ol>")+4, steps.indexOf("</ol>")).trim();
		String[] slist = steps.split("</li>");
		for(int i=0;i<slist.length;i++)
		{
			String step = slist[i].replaceAll("<li>","");
			recipe_steps.add((i+1) +"."+step.trim());
		}
		return recipe_steps;
	}
	
	public static ArrayList<String> get_recipe_reviews(int recipe_id, String recipe_url) throws IOException
	{
		ArrayList<String> recipe_reviews = new ArrayList<>();
		Document doc = Jsoup.connect(recipe_url).get();
		Elements review1 = doc.getElementsByClass("recipe-accolades recipe__text ");
		Elements review2 = doc.getElementsByClass("recipe-accolades recipe__text  trophy");
		
		if(review1.size()!=0)
		{
			String[] reviews = review1.text().split("This");
			for(String review: reviews)
			{
				if(!review.isEmpty())
					recipe_reviews.add("This"+review);
			}
		}
		if(review2.size()!=0)
		{
			String[] reviews = review2.text().split("This");
			for(String review: reviews)
			{
				if(!review.isEmpty())
					recipe_reviews.add("This"+review);
			}
		}

		return recipe_reviews;
	}
	
	public static ArrayList<String> get_recipe_images(int recipe_id, String recipe_url) throws IOException
	{
		ArrayList<String> recipe_images = new ArrayList<>();
		Document doc = Jsoup.connect(recipe_url).get();
		Element img_id = doc.getElementById("recipe-gallery-frame");
		if(img_id!=null)
		{
			Elements imgs = img_id.getElementsByTag("img");
			for(Element i:imgs)
				recipe_images.add(i.attr("data-srcset"));
		}
		else
		{
			Elements video_id = doc.getElementsByTag("iframe");
			for(Element i:video_id)
			{
				if(i.parent().attr("class").equals("recipe__video-aspect"))
					recipe_images.add(i.attr("src"));
			}
				
		}
		return recipe_images;
	}
	  
	public static void main(String[]args) throws IOException
	{
		get_recipe_details();
	}
}

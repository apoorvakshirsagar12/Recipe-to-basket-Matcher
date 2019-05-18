package com.recipes.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScrap2 {

static String url = "https://www.foodandwine.com";
	
	public static HashSet<String> get_urls() throws IOException
	{
		HashSet<String> urls = new HashSet<>();
		Document doc = Jsoup.connect(url+"/articles/recipes-for-a-crowd").get();
		Element content = doc.getElementById("article-body");
		Elements titles = content.getElementsByTag("a");
		for(Element title:titles)
		{
			if(title.attr("href").toString().contains("/recipes/"))
				urls.add(url+title.attr("href"));
			if(title.attr("href").toString().contains("/slideshows/"))
			{
				Document doc2 = Jsoup.connect(url+title.attr("href")).get();
				Elements titles2 = doc2.getElementsByClass("headline-link").select("a");
				for(Element t:titles2)
				{
					if(t.attr("href").toString().contains("/recipes/"))
						urls.add(t.attr("href").toString());
				}
			}
		}
		return urls;
	}

	public static ArrayList<RecipeBean> get_recipe_details() throws IOException
	{
		ArrayList <RecipeBean> all_recipes = new ArrayList<>();
		HashSet<String> urls = new HashSet<>();
		urls = get_urls();
		int recipe_id = 72502;
		for(String url:urls)
		{
			all_recipes.add(process_recipe_details(recipe_id, url));	
			recipe_id++;
		}		
		return all_recipes;
	}
	
	public static RecipeBean process_recipe_details(int recipe_id,String recipe_url) throws IOException
	{
		RecipeBean recipe = new RecipeBean();
		recipe.setRecipe_id(recipe_id);
		recipe.setRecipe_title(get_recipe_title(recipe_url));
		recipe.setRecipe_serves(get_recipe_serves(recipe_url));
		recipe.setRecipe_ingredients(get_recipe_ingredients(recipe_id, recipe_url));
		recipe.setRecipe_steps(get_recipe_steps(recipe_id, recipe_url));
		recipe.setRecipe_gallery(get_recipe_images(recipe_id, recipe_url));
		return recipe;
	}
	
	public static String get_recipe_title(String recipe_url) throws IOException
	{
		Document doc = Jsoup.connect(recipe_url).get();
		Elements title = doc.getElementsByClass("headline heading-content margin-8-top margin-16-bottom");
		System.out.println(title.text());
		return title.text();
	}
	
	public static String get_recipe_serves(String recipe_url) throws IOException
	{
		String serves = "";
		Document doc = Jsoup.connect(recipe_url).get();
		Elements title = doc.getElementsByClass("recipe-meta-container clearfix");
		String temp = title.text();
		serves = temp.substring(temp.indexOf("Serves :") + 0);
		return serves;
	}
	
	public static ArrayList<String> get_recipe_ingredients(int recipe_d, String recipe_url) throws IOException
	{
		ArrayList<String> recipe_ingredients = new ArrayList<>();
		Document doc = Jsoup.connect(recipe_url).get();
		Elements title = doc.getElementsByClass("ingredients").select("li");
		for(Element i:title)
			recipe_ingredients.add(i.text());
		return recipe_ingredients;
	}
	
	public static ArrayList<String> get_recipe_steps(int recipe_id, String recipe_url) throws IOException
	{
		ArrayList<String> recipe_steps = new ArrayList<>();
		Document doc = Jsoup.connect(recipe_url).get();
		Elements title = doc.getElementsByClass("step");
		for(Element i:title)
			if(i.text().toString().contains("Step"))
				recipe_steps.add(i.text());
		return recipe_steps;
	}
	
	public static ArrayList<String> get_recipe_images(int recipe_id, String recipe_url) throws IOException
	{
		ArrayList<String> recipe_images = new ArrayList<>();
		Document doc = Jsoup.connect(recipe_url).get();
		Elements imgs = doc.getElementsByTag("noscript").select("img");
		for(Element i:imgs)
			{
				if(i.attr("src").toString().contains("cdn-image"))
					recipe_images.add(i.attr("src"));
			}
		
		return recipe_images;
	}
	
	public static void main(String[] args) throws IOException {
		get_recipe_details();
	}

}

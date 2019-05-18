package com.recipes.util;
import java.util.*;

public class RecipeBean {
	
	int recipe_id;
	String recipe_title;
	String recipe_serves;
	ArrayList <String> recipe_gallery;
	ArrayList <String> recipe_ingredients;
	ArrayList <String> recipe_steps;
	ArrayList <String> recipe_reviews;
	
	
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getRecipe_title() {
		return recipe_title;
	}
	public void setRecipe_title(String recipe_title) {
		this.recipe_title = recipe_title;
	}
	public String getRecipe_serves() {
		return recipe_serves;
	}
	public void setRecipe_serves(String recipe_serves) {
		this.recipe_serves = recipe_serves;
	}
	public ArrayList<String> getRecipe_gallery() {
		return recipe_gallery;
	}
	public void setRecipe_gallery(ArrayList<String> recipe_gallery) {
		this.recipe_gallery = recipe_gallery;
	}
	public ArrayList<String> getRecipe_ingredients() {
		return recipe_ingredients;
	}
	public void setRecipe_ingredients(ArrayList<String> recipe_ingredients) {
		this.recipe_ingredients = recipe_ingredients;
	}
	public ArrayList<String> getRecipe_steps() {
		return recipe_steps;
	}
	public void setRecipe_steps(ArrayList<String> recipe_steps) {
		this.recipe_steps = recipe_steps;
	}
	public ArrayList<String> getRecipe_reviews() {
		return recipe_reviews;
	}
	public void setRecipe_reviews(ArrayList<String> recipe_reviews) {
		this.recipe_reviews = recipe_reviews;
	}

	
}

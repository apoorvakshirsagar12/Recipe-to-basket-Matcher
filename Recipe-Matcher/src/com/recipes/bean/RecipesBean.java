package com.recipes.bean;

import java.util.ArrayList;

public class RecipesBean {

	private int recipe_id;
	private String recipe_title;
	private String recipe_serves;
	private ArrayList <String> recipe_ingredients;
	private ArrayList <String> recipe_steps;
	private ArrayList <String> recipe_reviews;
	ArrayList <String> recipe_images;
	
	
	
	
	
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

	public ArrayList<String> getRecipe_images() {
		return recipe_images;
	}

	public void setRecipe_images(ArrayList<String> recipe_images) {
		this.recipe_images = recipe_images;
	}


	@Override
	public String toString() {
		return "RecipesBean [recipe_id=" + recipe_id + ", recipe_title=" + recipe_title + "]";
	}
	
	
	
}

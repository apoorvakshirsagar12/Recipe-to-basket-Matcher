package com.recipes.bean;

import java.util.HashMap;

public class RecipeEvaluation {
	
	int recipe_id;
	String recipe_title;
	HashMap<String,Float> available = new HashMap<>();
	HashMap<String,Float> missing = new HashMap<>();
	
	
	
	
	public String getRecipe_title() {
		return recipe_title;
	}
	public void setRecipe_title(String recipe_title) {
		this.recipe_title = recipe_title;
	}
	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public HashMap<String, Float> getAvailable() {
		return available;
	}
	public void setAvailable(HashMap<String, Float> available) {
		this.available = available;
	}
	public HashMap<String, Float> getMissing() {
		return missing;
	}
	public void setMissing(HashMap<String, Float> missing) {
		this.missing = missing;
	}

	
}

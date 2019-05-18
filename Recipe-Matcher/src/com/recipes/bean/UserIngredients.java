package com.recipes.bean;

import java.util.ArrayList;

public class UserIngredients {

	private int user_id;
	private ArrayList<String> ingredients=new ArrayList<>();
	
	public UserIngredients()
	{
		
	}
	public UserIngredients(int user_id, ArrayList<String> ingredients) {
		super();
		this.user_id = user_id;
		this.ingredients = ingredients;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public ArrayList<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}

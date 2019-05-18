package com.recipes.bean;

public class MyBasketBean {
	
	private String username;
	private int ingredient_id;
	private String ingredient_name;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getIngredient_id() {
		return ingredient_id;
	}
	public void setIngredient_id(int ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	public String getIngredient_name() {
		return ingredient_name;
	}
	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}
	
	@Override
	public String toString() {
		return "MyBasket [ingredient_id=" + ingredient_id + ", ingredient_name=" + ingredient_name + "]";
	}
	
}

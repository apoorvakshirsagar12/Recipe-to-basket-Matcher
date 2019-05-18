package com.recipes.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IngredientsSampleFile")
public class IngredientsSampleFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IngredientsSampleFile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "https://drive.google.com/open?id=1ZPQ6jBKr2NG6IJtLtTDYg10BBnhTOHus";
        
	}

	

}

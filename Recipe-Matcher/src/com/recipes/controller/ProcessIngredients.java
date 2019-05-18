package com.recipes.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.recipes.bean.UserIngredients;
import com.recipes.dao.ProcessExcelFile;

@WebServlet("/ProcessIngredients")
public class ProcessIngredients extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:/Users/ApoorvaK/Documents/uploads";
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    	HttpSession session = request.getSession();
 		String username = (String) session.getAttribute("username");
 		
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
               
        		ProcessExcelFile obj = new ProcessExcelFile();
        		UserIngredients basket = new UserIngredients();
        		try {
        			basket = obj.getIngredientsListFromExcel(username);
        		} catch (SQLException e) {
        			e.printStackTrace();
        		}
        		String status = obj.processIngredients(basket);
                if(status.equalsIgnoreCase("success"))
                	request.setAttribute("message", "Ingredients proccessed Successfully");
                else
                	request.setAttribute("message", status);
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
    
        request.getRequestDispatcher("/myBasket.jsp").forward(request, response);
     
    }
  
}
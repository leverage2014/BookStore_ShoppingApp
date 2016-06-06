package com.bookStoreApp.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStoreApp.domain.Books;
import com.bookStoreApp.service.ShoppingCart;

/**
 * Servlet implementation class ShoppingClServlet
 */
public class ShoppingClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String oper = request.getParameter("oper");
		
		ShoppingCart sc = ((ShoppingCart)request.getSession().getAttribute("cart"));
		
        if("buy".equals(oper)){
        	
		   if(id==""||id==null||title==""||title==null||price==""||price==null){
					request.getRequestDispatcher("/GoHallUI").forward(request, response);
					return;
			} else {
					int bookId = Integer.parseInt(id);
					double bookPrice = Double.parseDouble(price);
					
					Books newBook = new Books(bookId, title, bookPrice);			
			
	            	sc.addBooks(newBook);
	            	request.getRequestDispatcher("/WEB-INF/showCart.jsp").forward(request, response);
			}     	
      
		     
        } else if ("show".equals(oper)){
        	// 
        	request.getRequestDispatcher("/WEB-INF/showCart.jsp").forward(request, response);
        	
        } else if ("delete".equals(oper)){
       
             LinkedHashMap<Books, String> info = sc.cartInfo();
             
             for (Books tmp:info.keySet()){
            	 if(String.valueOf(tmp.getId()).equals(id)){
            		 sc.deleteBooks(tmp);
            	 }
             }
             
             request.getRequestDispatcher("/WEB-INF/showCart.jsp").forward(request, response);
        	
        } else if ("update".equals(oper)){
              
        	
        	LinkedHashMap<Books, String> info = sc.cartInfo();
        	String[] ids = request.getParameterValues("ids");
        	String[] num2buy = request.getParameterValues("booknum");
        	
        	for(int i=0; i<ids.length; i++){
                
                for (Books tmp:info.keySet()){
               	 if(String.valueOf(tmp.getId()).equals(ids[i])){
               		 sc.updateBooks(Integer.parseInt(num2buy[i]), tmp);
               	 }
                }
                
          //      request.getRequestDispatcher("/WEB-INF/showCart.jsp").forward(request, response);
           	
        	}
        	
        	request.getRequestDispatcher("/WEB-INF/showCart.jsp").forward(request, response);
        
        	System.out.println(Arrays.toString(ids));
        	System.out.println(Arrays.toString(num2buy));
        }
		
		
		
				
		System.out.println("shopping cart:==>"+sc);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

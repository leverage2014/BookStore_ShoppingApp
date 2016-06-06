package com.bookStoreApp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStoreApp.domain.Books;
import com.bookStoreApp.domain.Users;
import com.bookStoreApp.service.BookService;
import com.bookStoreApp.service.UserService;

/**
 * Servlet implementation class GoHallUI
 */
public class GoHallUI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoHallUI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		Users userInSession = (Users) request.getSession().getAttribute("curUser");
		if (userInSession == null){
			  String username = request.getParameter("username");
		      String password = request.getParameter("password");
		      
		      if(username==null||password==null||username==""||password==""){
		    	  request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
		    	  return;
		      }
		      
				UserService us = new UserService();
				Users user = new Users(username, password);
				
				Users loginUser = us.checkUser(user);
				
				if(loginUser == null){
					request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
					return;
				} else {
					request.getSession().setAttribute("curUser", loginUser);	
				}
		}
		
		ArrayList<Books> allBooks = new BookService().getAllBook();
		System.out.println(String.valueOf(allBooks));
		
		request.setAttribute("books", allBooks);
	    
		request.getRequestDispatcher("/WEB-INF/hall.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

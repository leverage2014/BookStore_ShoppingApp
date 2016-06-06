package com.bookStoreApp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookStoreApp.domain.Users;

/**
 * Servlet implementation class LogoutServ
 */
public class LogoutServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    //    System.out.println("logout=====>before: "+request.getSession().getAttribute("cart"));
	//	request.getSession().removeAttribute("cart");
	//	request.getSession().removeAttribute("curUser");
        
        
		System.out.println("enter LogoutServ");
        request.getRequestDispatcher("LoginServ").forward(request, response);

		
	//	System.out.println("logout=====>after: "+request.getSession().getAttribute("cart"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

package com.bookStoreApp.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServ
 */
public class LoginServ extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("==== enter LoginServ ===");
		
		HttpSession session = request.getSession(false);
        
		if(session != null){
		   Enumeration attrs = session.getAttributeNames();  
	        while(attrs.hasMoreElements()){
	        	String name = (String) attrs.nextElement();
	     	   System.out.println(name);
	     	   session.setAttribute(name, null);
	        }
		    System.out.print("=== leave loginserv ==="); 
		//	session.invalidate();
		}
		
//		 Enumeration attrs = session.getAttributeNames();  
//	        while(attrs.hasMoreElements()){
//	     	   System.out.println(attrs.nextElement());
//	        }
         
        request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response); 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
		
	}

//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res,
//			FilterChain chain) throws IOException, ServletException {
//		// TODO Auto-generated method stub
//       
//		HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        HttpSession session = request.getSession(false);
//        if (session != null && session.isNew()) {
//            response.setHeader("Pragma", "no-cache");
//            response.setHeader("Cache-Control", "no-cache");
//            response.setDateHeader("Expires", 0);
//           // session.invalidate();
//            chain.doFilter(request, response);
//        } else {
//        	request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response); 
//        }
//        
//
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//		// TODO Auto-generated method stub
//		
//	}

}

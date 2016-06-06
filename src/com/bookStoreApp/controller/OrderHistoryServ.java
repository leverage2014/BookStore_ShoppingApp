package com.bookStoreApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStoreApp.domain.OrderGeneral;
import com.bookStoreApp.domain.Users;
import com.bookStoreApp.service.OrderService;

/**
 * Servlet implementation class OrderHistoryServ
 */
public class OrderHistoryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderHistoryServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String orderId = request.getParameter("orderId");
		Users curUser = ((Users)request.getSession().getAttribute("curUser"));
		OrderService os = new OrderService();
		
		if (orderId == null){
			
			ArrayList<OrderGeneral> history = os.getOrderGeneral(curUser);
			
			request.setAttribute("history", history);
			
			request.getRequestDispatcher("/WEB-INF/generalHistory.jsp").forward(request, response);
			
		} else {
			
			LinkedHashMap<String, Integer> details = os.getOrderDetails(orderId);
			request.setAttribute("details", details);
			request.setAttribute("orderId", orderId);
			request.getRequestDispatcher("/WEB-INF/detailOrder.jsp").forward(request, response);
		}
		

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}

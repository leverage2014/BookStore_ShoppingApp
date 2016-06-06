package com.bookStoreApp.controller;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookStoreApp.domain.Books;
import com.bookStoreApp.domain.Users;
import com.bookStoreApp.emailService.EmailSent;
import com.bookStoreApp.service.OrderService;
import com.bookStoreApp.service.ShoppingCart;

/**
 * Servlet implementation class GoMyOrderServ
 */
public class GoMyOrderServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoMyOrderServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String oper = (String) request.getParameter("oper");
		
		if("show".equals(oper)){
			request.getRequestDispatcher("/WEB-INF/showOrder.jsp").forward(request, response);
		} else if ("confirm".equals(oper)){
			
			// send an email
			
			Users curUser = (Users) request.getSession().getAttribute("curUser");
		    ShoppingCart sc = (ShoppingCart) request.getSession().getAttribute("cart");
		    
			// write order to db
			// 1) generate order number ?
			// 2) write order infor to databases?
			OrderService os = new OrderService();
			String orderId = os.recOrderInfo(sc, curUser);
			
			
			String email = curUser.getEmail();
		    LinkedHashMap<Books, String> info = sc.cartInfo();
			
			EmailSent es = new EmailSent();
			String sub = "Your order "+orderId+" is confirmation!";
			
			StringBuilder contents = new StringBuilder();
			contents.append("<html><body>");
			contents.append("<h1>Your Order "+orderId+" is Confirmed!</h1>");
			contents.append("<table border='1'>");
			contents.append("<tr><td>Book Title</td><td>Book Price</td><td>Book Qt.</td></tr>");
			for(Books tmp:info.keySet()){
				contents.append("<tr>");
				contents.append("<td>"+tmp.getTitle()+"</td>");
				contents.append("<td>"+tmp.getPrice()+"</td>");
				contents.append("<td>"+info.get(tmp)+"</td>");
				contents.append("<tr>");
			}
			contents.append("<tr><td colspan='3'>Total Price: $"+sc.getCost()+"</td></tr>");
			contents.append("</table>");
			contents.append("</body></html>");
			
			es.sendEmailTo(email, sub, contents.toString());
			
			System.out.println("GoMyOrderServ: email-->"+email);
			

			request.getSession().removeAttribute("cart");
			request.getRequestDispatcher("/WEB-INF/confirm.jsp").forward(request, response);
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

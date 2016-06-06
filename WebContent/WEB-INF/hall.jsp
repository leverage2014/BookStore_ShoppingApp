<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mvcCart.domain.Users, java.util.*, com.mvcCart.domain.Books, com.mvcCart.service.ShoppingCart" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome  to shopping mall, <%= ((Users)request.getSession().getAttribute("curUser")).getUsername()%> !</h1>
<a href="/MVCshoppingCart/LogoutServ">Logout</a><br/>
<a href="/MVCshoppingCart/OrderHistoryServ">Order History</a><br/>

<table border="1">
<tr><td>Book Name</td><td>Price</td><td>Press</td><td>Click to buy</td></tr>

<% 
   ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
   if (cart == null){
	   System.out.println("First cart created!");
	   cart = new ShoppingCart();
	   request.getSession().setAttribute("cart", cart);
   }

   ArrayList<Books> list = (ArrayList<Books>) request.getAttribute("books");
   for (Books tmp:list){
	   %>
	   <tr><td><%=tmp.getTitle() %></td><td><%=tmp.getPrice() %></td><td><%=tmp.getPress() %></td><td><a href="/MVCshoppingCart/ShoppingClServlet?oper=buy&id=<%=tmp.getId() %>&title=<%=tmp.getTitle()%>&price=<%=tmp.getPrice() %>">Buy</a></td></tr>
	   <%
   }

%>
<tr><td colspan="4"><a href="/MVCshoppingCart/ShoppingClServlet?oper=show">Goto My Shopping Cart</a></td></tr>
</table><br/>

</body>
</html>
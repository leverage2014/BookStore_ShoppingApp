<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mvcCart.domain.Users, java.util.*, com.mvcCart.domain.Books, com.mvcCart.service.ShoppingCart"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
      Users curUser = (Users) request.getSession().getAttribute("curUser");
      ShoppingCart sc = (ShoppingCart) request.getSession().getAttribute("cart");
      
      LinkedHashMap<Books, String> info = sc.cartInfo();
%>

<h1>Your order</h1>
<h2>Personal Info</h2>
<table border="1">
<tr><td>User Name: </td><td><%=curUser.getUsername() %></td></tr>
<tr><td>Email: </td><td><%=curUser.getEmail() %></td></tr>
<tr><td>Grade: </td><td><%=curUser.getGrade() %></td></tr>
</table>
<br/><br/>

<h2>Order details</h2>
<table border="1">
<tr><td>Book ID</td><td>Book Title</td><td>Book Price</td><td>Qt.</td></tr>
<%
    for (Books tmp:info.keySet()){
	  %>
	  <tr><td><%=tmp.getId() %></td><td><%=tmp.getTitle() %></td><td><%=tmp.getPrice() %></td><td><%=info.get(tmp) %></td></tr>
	  <%
}
%>
<tr><td colspan="6">Total price: <%=sc.getCost() %> </td></tr>
<tr><td colspan="4"><a href="/MVCshoppingCart/GoMyOrderServ?oper=confirm">Confirm and Checkout</a></td></tr>
</table>


</body>
</html>
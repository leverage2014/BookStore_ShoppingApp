<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mvcCart.domain.Users, java.util.*, com.mvcCart.domain.Books, com.mvcCart.service.ShoppingCart, com.mvcCart.domain.OrderGeneral"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
         Users curUser = ((Users)request.getSession().getAttribute("curUser"));
         ArrayList<OrderGeneral> history = (ArrayList<OrderGeneral>) request.getAttribute("history");
%>

<h1><%=curUser.getUsername()%>'s Order History</h1>
<br/>
<table border="1">
<tr><td>Date</td><td>Order Number</td><td>Total</td></tr>
<% for (OrderGeneral og:history){
    %>
    <tr><td><%=og.getOrderDate() %></td><td><a href="/MVCshoppingCart/OrderHistoryServ?orderId=<%=og.getOrderId() %>"><%=og.getOrderId() %></td><td><%=og.getTotalPrice() %></td></tr>
    <%	
}
%>

<tr><td colspan="3"><a href="/MVCshoppingCart/GoHallUI">Back to Shopping</a></td></tr>
</table>





</body>
</html>
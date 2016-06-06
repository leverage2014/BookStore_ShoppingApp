<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mvcCart.domain.Users, java.util.*, com.mvcCart.domain.Books, com.mvcCart.service.ShoppingCart"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/comm.css"/>
</head>
<body>

<h1>My Shopping Cart</h1>
<form action="/MVCshoppingCart/ShoppingClServlet" method="get">
<table border="1">
<tr><td>Book ID</td><td>Book Name</td><td>Price</td><td>Qt.</td><td>Delete</td></tr>

<%
      ShoppingCart sc = (ShoppingCart) request.getSession().getAttribute("cart");

      LinkedHashMap<Books, String> info = sc.cartInfo();
      
      for (Books tmp:info.keySet()){
    	  %>
    	  <tr><td><%=tmp.getId() %></td><td><%=tmp.getTitle() %></td><td><%=tmp.getPrice() %></td>
    	  <td><input type="text" name="booknum" value=<%=info.get(tmp) %>>
    	       <input type="hidden" name="ids" value="<%=tmp.getId() %>"/>
    	  </td>
          <td><a href="/MVCshoppingCart/ShoppingClServlet?oper=delete&id=<%=tmp.getId()%>">Delete</a></td></tr>
    	  <%
      }
%>

<tr><td colspan="3"><a href="/MVCshoppingCart/GoHallUI">Goto Shopping Hall</a></td><td colspan="3"><input type="submit" value="Update Qt."><input type="hidden" name="oper" value="update"/></td></tr>
<tr><td colspan="6">Total price: <%=sc.getCost() %> </td></tr>
<tr><td colspan="6"><a href="/MVCshoppingCart/GoMyOrderServ?oper=show">Goto Checkout </a></td></tr>
</table>

</form>


</body>
</html>
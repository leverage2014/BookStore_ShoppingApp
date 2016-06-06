<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mvcCart.domain.Users, java.util.*, com.mvcCart.domain.Books, com.mvcCart.service.ShoppingCart, com.mvcCart.domain.OrderGeneral"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Details for order <%=(String)request.getAttribute("orderId") %></h1>
<table border="1">
<tr><td>Book Name</td><td>Qt.</td></tr>
<% 
      LinkedHashMap<String, Integer> details = (LinkedHashMap<String, Integer>)request.getAttribute("details");
	  for(String tmp:details.keySet()){
		  %>
		    <tr><td><%=tmp %></td><td><%=details.get(tmp) %></td></tr>
		  <%
	  }	
		
%>
<tr><td colspan="2"><a href="/MVCshoppingCart/GoHallUI">Back to Shopping</a></td></tr>
</body>
</html>
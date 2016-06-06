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

%>

<h1> Thank your for your order!</h1>
<h2> An order confirmation has sent to your email: <%=curUser.getEmail() %></h2>
<a href="/MVCshoppingCart/LogoutServ">Back to Shopping</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Customer.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		CustomerBean cb=(CustomerBean)session.getAttribute("cbean");
		out.println("Logged by Customer : "+cb.getfName()+"<br/>");
	%>
	<a href="view">ViewAllProducts</a>
	<a href="clogout">Logout</a>
</body>
</html>
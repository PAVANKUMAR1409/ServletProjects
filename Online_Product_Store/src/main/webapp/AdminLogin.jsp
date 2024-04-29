<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Admin.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		AdminBean ab=(AdminBean)session.getAttribute("abean");
		out.println("Page Belongs to Admin : "+ab.getfName()+"<br>");
	%>
	<a href="AddProduct.html">AddProducts</a><br/>
	<a href="Viewproducts">ViewAllProducts</a><br/>
	<a href="alogout">Logout</a>
</body>
</html>
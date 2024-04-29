<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Admin.*,Customer.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	CustomerBean cb=(CustomerBean)session.getAttribute("cbean");
	out.println("Welcome customer : "+cb.getfName()+"<br>");
	int qty=(Integer)request.getAttribute("qty");
	ProductBean pb=(ProductBean)request.getAttribute("pbean2");
	float cost=pb.getPrice()*qty;
	out.println("Product Name:"+pb.getName()+"<br>"+
				"Product Price :"+pb.getPrice()+"<br>"+"Selected qty:"+qty+
					"<br>"+"Total Cost:"+cost+"<br>");
%>
<a href="view">ViewAllProducts</a><br>
<a href="clogout">Logout</a>
</body>
</html>
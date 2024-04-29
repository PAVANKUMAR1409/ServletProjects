<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Admin.*,Customer.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	CustomerBean cb=(CustomerBean)session.getAttribute("cbean");
	out.println("Welcome  Customer : "+cb.getfName()+"<br>");
	ProductBean pb=(ProductBean)request.getAttribute("pbean2");
%>
<span>Product Code:<%=pb.getCode() %></span><br>
<span>Product Name:<%=pb.getName() %></span><br>
<span>Product Price:<%=pb.getPrice() %></span><br>
<form action="pay" method="post">
	<input type="hidden" name="code" value=<%=pb.getCode() %>>
	<input type="hidden" name="quantity" value=<%=pb.getQty() %>>
	Required Product Qty:<input type="text" name="qty" value=<%=pb.getQty() %>><br>
	<input type="submit" value="Payment">
</form>
<a href="view">ViewAllProducts</a>
<a href="clogout">Logout</a>
</body>
</html>
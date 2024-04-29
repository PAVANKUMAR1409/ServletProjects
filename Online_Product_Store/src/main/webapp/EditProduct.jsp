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
	out.println("Page Belongs to Admin : "+ab.getfName()+"<br/>");
	ProductBean pb=(ProductBean)request.getAttribute("pbean");
%>
<form action="update" method="post">
	<input type="hidden" name="code" value=<%=pb.getCode()%>>
	Price:<input type="number" name="price" value=<%=pb.getPrice()%>><br>
	Qty:<input type="number" name="qty" value=<%=pb.getQty()%>><br>
	<input type="submit" value="UpdateProduct">
</form>
</body>
</html>
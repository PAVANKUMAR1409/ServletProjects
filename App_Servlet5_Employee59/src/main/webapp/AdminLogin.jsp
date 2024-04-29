<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		AdminBean ab=(AdminBean)session.getAttribute("abean");
		out.println("The Admin is : "+ab.getfName()+"<br/>");
	%>
	<a href="AddEmployee.html">AddEmployee</a>
	<a href="viewAll">ViewAllEmployees</a>
	<a href="logout">Logout</a>
</body>
</html>
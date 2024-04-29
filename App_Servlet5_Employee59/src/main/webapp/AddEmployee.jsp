<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test.*"%>
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
	String msg=(String)request.getAttribute("msg");
	out.println(msg);
%>
<a href="AddEmployee.html">AddEmployee</a>
<a href="viewAll">ViewAllEmployees</a>
<a href="logout">Logout</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String uName = request.getParameter("uname");
	Integer p = (Integer)application.getAttribute("p");
	out.println("Welcome User : "+uName+"<br>");
	out.println("********SERVLET CONTEXT*************");
	out.println("Server info"+application.getServerInfo()+"<br>");
	out.println("Context Attribute : "+p+"<br>");
	out.println("Context init-parameter : "+application.getInitParameter("a")+"<br>");
	out.println("****ServletProgram ServletConfig******<hr>");
	String serN=(String)request.getAttribute("serN");
	out.println("ServletName : "+serN+"<br>");
	Integer b=(Integer)request.getAttribute("b");
	out.println("Config initparam:"+b+"<br>");
	out.println("******JSP Config********<br>");
	out.println("ServletName:"+config.getServletName()+"<br>");	
	%>
</body>
</html>
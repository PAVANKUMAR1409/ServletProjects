<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String fName=(String)request.getAttribute("fname");
		UserBean ub= (UserBean)application.getAttribute("ubean");
		out.println("Page Belongs to User : "+fName+"<br/>");
		out.println(ub.getfName()+"&nbsp&nbsp"+ub.getlName()+"&nbsp&nbsp"+ub.getAddress()+"&nbsp&nbsp"
				+ub.getmId()+"&nbsp&nbsp"+ub.getPhno()+"&nbsp&nbsp"+"<a href='edit.html'>Edit</a><br/>");		
	%>
	<a href="logout">Logout</a>
</body>
</html>
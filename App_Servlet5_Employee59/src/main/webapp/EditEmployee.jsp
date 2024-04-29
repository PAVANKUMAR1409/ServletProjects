<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
<%
	AdminBean ab=(AdminBean)session.getAttribute("abean");
	out.println("Page Belongs to Admin : "+ab.getfName()+"<br/>");
	EmployeeBean eb= (EmployeeBean)request.getAttribute("ebean");	
%>
<form action="update" method="post">
	<input type="hidden" name="eid" value=<%=eb.getId()%>/>
	BasicSalary:<input type="text" name="bsal" value=<%=eb.getBsal()%>/><br/>
	Hra(1-100):<input type="text" name="hra" value=<%=eb.getHra()%>/><br/>
	Da(1-100):<input type="text" name="da" value=<%=eb.getDa()%>/><br/>
	<input type="submit" value="UpdateEmployee"/>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	AdminBean ab=(AdminBean)session.getAttribute("abean");
	out.println("page belons to Admin : "+ab.getfName()+"<br/>");
	ArrayList<EmployeeBean> al= (ArrayList<EmployeeBean>)session.getAttribute("alist"); 
	if(al.size()==0)
	{
		out.println("No Employee Details are Available.....<br>");
	}
	else{
		Iterator<EmployeeBean> i= al.iterator();
		while(i.hasNext())
		{
			EmployeeBean eb = (EmployeeBean)i.next();
			
			out.println(eb.getId()+"&nbsp&nbsp"+eb.getName()+"&nbsp&nbsp"+eb.getDsg()
							+"&nbsp&nbsp"+eb.getBsal()+"&nbsp&nbsp"+eb.getHra()+
							"&nbsp&nbsp"+eb.getDa()+"&nbsp&nbsp"+eb.getTa()
							+"&nbsp&nbsp<a href='edit?eid="+eb.getId()+"'>Edit</a>"+
							"&nbsp&nbsp<a href='delete?eid="+eb.getId()+"'>Delete</a><br/>");
		}
	}
	%>
	<a href="AddEmployee.html">AddEmployee</a>
	<a href="logout">Logout</a>
</body>
</html>
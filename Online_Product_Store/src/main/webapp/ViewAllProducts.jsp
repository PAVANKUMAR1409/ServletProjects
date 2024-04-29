<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Admin.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	AdminBean ab=(AdminBean)session.getAttribute("abean");
	out.println("Page belongs to Admin : "+ab.getfName()+"<br>");
	ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("alist");
	Iterator<ProductBean> it=al.iterator();
	while(it.hasNext()){
		ProductBean pb=(ProductBean)it.next();
		out.println(pb.getCode()+"&nbsp&nbsp"+pb.getName()+"&nbsp&nbsp"+
				pb.getPrice()+"&nbsp&nbsp"+pb.getQty()+"&nbsp&nbsp&nbsp&nbsp"+
				"<a href='edit?code="+pb.getCode()+"'>Edit</a>"+
				"&nbsp&nbsp"+"<a href='delete?code="+pb.getCode()+"'>Delete</a><br>");
	}
%>
<a href="alogout">Logout</a>
</body>
</html>
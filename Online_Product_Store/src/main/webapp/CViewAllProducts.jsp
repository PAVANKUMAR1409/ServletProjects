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
		out.println("Page belongs to Customer :"+cb.getfName()+"<br>");
		ArrayList<ProductBean> al2=(ArrayList<ProductBean>)session.getAttribute("alist2");
		Iterator<ProductBean> it=al2.iterator();
		while(it.hasNext()){
			ProductBean pb=(ProductBean)it.next();
			out.println(pb.getCode()+"&nbsp&nbsp"+pb.getName()+"&nbsp&nbsp"+
					pb.getPrice()+"&nbsp&nbsp"+pb.getQty()+"&nbsp&nbsp&nbsp&nbsp"+
					"&nbsp&nbsp"+"<a href='buy?code="+pb.getCode()+"'>Buy</a><br>");
		}
	%>
	<a href="clogout">Logout</a>
</body>
</html>
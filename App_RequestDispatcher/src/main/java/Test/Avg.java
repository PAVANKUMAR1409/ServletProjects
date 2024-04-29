package Test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/av")
public class Avg extends GenericServlet
{
	@Override
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		int v1=Integer.parseInt(req.getParameter("v1"));
		int v2=Integer.parseInt(req.getParameter("v2"));
		float avg=(float)(v1+v2)/2;
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Average : "+avg);
		RequestDispatcher rd=req.getRequestDispatcher("choice.html");
		rd.include(req, res);
	}
}

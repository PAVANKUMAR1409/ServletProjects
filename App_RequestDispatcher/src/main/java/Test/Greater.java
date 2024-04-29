package Test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/grt")
public class Greater extends GenericServlet
{
	@Override
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		int v1=Integer.parseInt(req.getParameter("v1"));
		int v2=Integer.parseInt(req.getParameter("v2"));
		int max=0;
		if(v1>v2)
		{
			max=v1;
		}
		else
		{
			max=v2;
		}
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Greater : "+max);
		RequestDispatcher rd=req.getRequestDispatcher("choice.html");
		rd.include(req, res);
	}
}

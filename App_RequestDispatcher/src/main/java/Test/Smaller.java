package Test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/small")
public class Smaller extends GenericServlet
{
	@Override
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		int v1=Integer.parseInt(req.getParameter("v1"));
		int v2=Integer.parseInt(req.getParameter("v2"));
		int min=0;
		if(v1<v2)
		{
			min=v1;
		}
		else
		{
			min=v2;
		}
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Smaller : "+min);
		RequestDispatcher rd=req.getRequestDispatcher("choice.html");
		rd.include(req, res);
	}
}

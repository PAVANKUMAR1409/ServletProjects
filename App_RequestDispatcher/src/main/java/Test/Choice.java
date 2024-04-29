package Test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/choice")
@SuppressWarnings("serial")
public class Choice extends GenericServlet
{
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException, IOException 
	{
		String s1=req.getParameter("s1");
		if(s1.equals("add"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("ad");
			rd.forward(req, res);
		}
		else if(s1.equals("sub"))
		{
			RequestDispatcher rd= req.getRequestDispatcher("sub");
			rd.forward(req, res);
		}
		else if(s1.equals("mul"))
		{
			RequestDispatcher rd= req.getRequestDispatcher("mul");
			rd.forward(req, res);
		}
		else if(s1.equals("div"))
		{
			RequestDispatcher rd= req.getRequestDispatcher("div");
			rd.forward(req, res);
		}
		else if(s1.equals("mod"))
		{
			RequestDispatcher rd= req.getRequestDispatcher("mod");
			rd.forward(req, res);
		}
		else if(s1.equals("greater"))
		{
			RequestDispatcher rd= req.getRequestDispatcher("grt");
			rd.forward(req, res);
		}
		else if(s1.equals("smaller"))
		{
			RequestDispatcher rd= req.getRequestDispatcher("small");
			rd.forward(req, res);
		}
		else
		{
			RequestDispatcher rd= req.getRequestDispatcher("av");
			rd.forward(req, res);
		}
		
	}
}

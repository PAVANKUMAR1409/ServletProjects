package Test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		String un=req.getParameter("uname");
		String pw=req.getParameter("pword");
		
		UserBean ub= new LoginDAO().login(un, pw);
		if(ub==null)
		{
			req.setAttribute("msg", "Invalid UserName or Password");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else {
			ServletContext sc= req.getServletContext();
			sc.setAttribute("ubean", ub);
			Cookie c= new Cookie("fname",ub.getfName());
			res.addCookie(c);
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}
}

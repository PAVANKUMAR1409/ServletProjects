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
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			req.setAttribute("msg", "SessionExpired...<br/>");
		}
		else {
			ServletContext sct=req.getServletContext();
			sct.removeAttribute("ubean");
			c[0].setMaxAge(0);
			res.addCookie(c[0]);
			req.setAttribute("msg", "Logged Out Successfully......!!!!!<br/>");
		}
		req.getRequestDispatcher("msg.jsp").forward(req, res);
	}


}

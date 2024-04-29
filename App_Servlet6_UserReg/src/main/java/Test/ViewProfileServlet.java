package Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		Cookie c[]=req.getCookies();
		if(c==null) {
			req.setAttribute("msg", "SessionExpired....!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}else {
			String fName=c[0].getValue();
			req.setAttribute("fname", fName);
			req.getRequestDispatcher("viewprofile.jsp").forward(req, res);
		}

	}
}

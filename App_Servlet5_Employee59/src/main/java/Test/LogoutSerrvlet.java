package Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutSerrvlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs= req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "session expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			hs.removeAttribute("alist");
			hs.removeAttribute("abean");
			hs.invalidate(); // session destroyed
			req.setAttribute("msg", "Logout successfull......!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		
	}
}

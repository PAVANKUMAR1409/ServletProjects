package Customer;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/clogout")
public class CustomerLogoutServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired.....!!!!!");
		}else {
			hs.removeAttribute("cbean");
			hs.invalidate();
			req.setAttribute("msg", "LoggedOut Successfully.......!!!");
		}
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
	}
}

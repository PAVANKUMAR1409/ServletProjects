package Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String uN=req.getParameter("uname");
		String pW=req.getParameter("pword");
		
		AdminBean ab= new AdminLoginDAO().login(uN, pW);
		if(ab==null) {
			req.setAttribute("msg", "Invalid Login Details");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			HttpSession hs= req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
		}
	}
}

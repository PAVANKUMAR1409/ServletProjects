package Admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/alogin")
public class AdminLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String uName=req.getParameter("uname");
		String pWord=req.getParameter("pword");
		
		AdminBean ab=new AdminLoginDAO().login(uName, pWord);
		if(ab==null) {
			req.setAttribute("msg", "Invalid Username or Password....!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);		
		}else {
			HttpSession hs=req.getSession();
			hs.setAttribute("abean", ab);
			req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
		}
	}
	
}

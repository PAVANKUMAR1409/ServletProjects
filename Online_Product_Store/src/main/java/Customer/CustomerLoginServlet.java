package Customer;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/clogin")
public class CustomerLoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String uName=req.getParameter("uname");
		String pWord=req.getParameter("pword");
		
		CustomerBean cb=new CustomerLoginDAO().loggin(uName, pWord);
		if(cb==null) {
			req.setAttribute("msg", "Invalid Login Details......!!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			HttpSession hs=req.getSession();
			hs.setAttribute("cbean", cb);
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}
	}
}

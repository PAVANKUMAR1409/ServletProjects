package Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		UserBean ub= new UserBean();
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAddress(req.getParameter("address"));
		ub.setmId(req.getParameter("mid"));
		ub.setPhno(Long.parseLong(req.getParameter("phno")));
		
		int k=new RegisterDAO().register(ub);
		if(k>0)
		{
			req.setAttribute("msg", "User Registerd Successfully.....!!!!<br>");
			req.getRequestDispatcher("register.jsp").forward(req, res);
		}
	}
}

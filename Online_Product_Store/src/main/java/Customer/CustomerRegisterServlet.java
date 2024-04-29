package Customer;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class CustomerRegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		CustomerBean cb=new CustomerBean();
		cb.setuName(req.getParameter("uname"));
		cb.setpWord(req.getParameter("pword"));
		cb.setfName(req.getParameter("fname"));
		cb.setlName(req.getParameter("lname"));
		cb.setAddress(req.getParameter("address"));
		cb.setmId(req.getParameter("mid"));
		cb.setPhno(Long.parseLong(req.getParameter("phno")));
		
		int k=new CustomerRegisterDAO().insert(cb);
		if(k>0) {
			req.setAttribute("msg", "Inserted Successfully.......!!!");
			req.getRequestDispatcher("CustomerRegister.jsp").forward(req, res);
		}
	}
}

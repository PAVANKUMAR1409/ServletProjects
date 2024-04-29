package Test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		ServletContext sct= req.getServletContext();
		UserBean ub1=(UserBean)sct.getAttribute("ubean");
		String uN=ub1.getuName();
		String pW=ub1.getpWord();
		
		UserBean ub= new UserBean();
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAddress(req.getParameter("address"));
		ub.setmId(req.getParameter("mid"));
		ub.setPhno(Long.parseLong(req.getParameter("phno")));
		
		int k=new EditDAO().update(ub,uN,pW);
		if(k>0)
		{
			ServletContext sc=req.getServletContext();
			sc.setAttribute("ubean", ub);
			req.setAttribute("msg", "Updated Successfully....!!!<br>");
			req.getRequestDispatcher("edit.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg", "updation Failed...!!!");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		
	}
}

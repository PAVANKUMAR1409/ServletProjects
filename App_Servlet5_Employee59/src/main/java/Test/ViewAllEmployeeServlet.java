package Test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/viewAll")
public class ViewAllEmployeeServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null){
			req.setAttribute("msg", "Session Expired...!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			ViewAllEmployeeDAO obj= new ViewAllEmployeeDAO();
			ArrayList<EmployeeBean> al=obj.retrieve();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("ViewAllEmployee.jsp").forward(req, res);
		}
	}
	
}

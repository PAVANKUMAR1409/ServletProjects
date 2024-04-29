package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/edit")
@SuppressWarnings("serial")
public class EditEmployeeServlet extends HttpServlet
{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		HttpSession hs= req.getSession(false);
		if(hs==null){
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String eId=req.getParameter("eid");
			ArrayList<EmployeeBean> al= (ArrayList<EmployeeBean>) hs.getAttribute("alist");
			Iterator<EmployeeBean> it=al.iterator();
			while(it.hasNext())
			{
				EmployeeBean eb=it.next();
				if(eId.equals(eb.getId()))
				{
					req.setAttribute("ebean", eb);
					break;
				}
			}// end of while
			req.getRequestDispatcher("EditEmployee.jsp").forward(req, res);
		}// end of else
	}
}

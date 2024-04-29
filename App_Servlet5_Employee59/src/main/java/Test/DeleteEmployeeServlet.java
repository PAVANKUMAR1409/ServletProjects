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

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteEmployeeServlet extends HttpServlet{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs= req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String eId= req.getParameter("eid");
			ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>)hs.getAttribute("alist");
			Iterator<EmployeeBean> it=al.iterator();
			while(it.hasNext())
			{
				EmployeeBean eb=(EmployeeBean)it.next();
				if(eId.equals(eb.getId()))
				{
					al.remove(eb);
					break;
				}
			}//end of while
			int k= new DeleteDAO().delete(eId);
			if(k>0)
			{
				req.setAttribute("msg", "Employee Deleted......!!!");
				req.getRequestDispatcher("DeleteEmployee.jsp").forward(req, res);
			}
		}// end of else
	}
}

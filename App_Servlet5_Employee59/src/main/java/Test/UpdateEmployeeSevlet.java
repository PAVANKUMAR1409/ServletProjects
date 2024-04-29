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
@WebServlet("/update")
public class UpdateEmployeeSevlet extends HttpServlet{
	@SuppressWarnings({ "unchecked" })
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs= req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String eId=req.getParameter("eid");
			float bsal=Float.parseFloat(req.getParameter("bsal"));
			float h=Float.parseFloat(req.getParameter("hra"));
			float d=Float.parseFloat(req.getParameter("da"));
			float hra=(bsal*h)/100;
			float da=(d*bsal)/100;
			float ta=bsal+hra+da;
			ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>)hs.getAttribute("alist");
			Iterator<EmployeeBean> it=al.iterator();
			while(it.hasNext())
			{
				EmployeeBean eb= (EmployeeBean)it.next();
				if(eId.equals(eb.getId()))
				{
					eb.setBsal(bsal);
					eb.setHra(hra);
					eb.setDa(da);
					eb.setTa(ta);
					int k=new UpdateDAO().update(eb);
					if(k>0) {
						req.setAttribute("msg", "Employee Details Updated Successfully.......!!!");
					}
					break;
				}//end of if
			}// end of while
			req.getRequestDispatcher("UpdateEmployee.jsp").forward(req, res);
		}// end of else
	}
}

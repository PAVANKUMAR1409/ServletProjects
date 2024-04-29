package Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddEmployeeServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null){
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			EmployeeBean eb=new EmployeeBean();
			eb.setId(req.getParameter("id"));
			eb.setName(req.getParameter("name"));
			eb.setDsg(req.getParameter("dsg"));
			float bSal=Float.parseFloat(req.getParameter("bsal"));
			float h=Float.parseFloat(req.getParameter("hra"));
			float d=Float.parseFloat(req.getParameter("da"));
			float hra=(bSal*h)/100;
			float da=(bSal*d)/100;
			float ta=bSal+hra+da;
			eb.setBsal(bSal);
			eb.setHra(hra);
			eb.setDa(da);
			eb.setTa(ta);
			
			int k=new AddEmployeeDAO().insert(eb);
			if(k>0)
			{
				req.setAttribute("msg", "Employee Details Added Successfully.......!!!<br/>");
				req.getRequestDispatcher("AddEmployee.jsp").forward(req, res);
			}
		}
		
	}
}

package Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProductServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired....!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String code=req.getParameter("code");
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("alist");
			Iterator<ProductBean> it=al.iterator();
			while(it.hasNext()) {
				ProductBean pb=(ProductBean)it.next();
				if(code.equals(pb.getCode())) {
					req.setAttribute("pbean", pb);
					break;
				}//end of if
			}//end of while
			req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
		}
	}
}

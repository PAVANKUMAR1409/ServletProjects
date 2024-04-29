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
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet
{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired.....!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String code1=req.getParameter("code");
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("alist");
			Iterator<ProductBean> it=al.iterator();
			while(it.hasNext()) {
				ProductBean pb= (ProductBean)it.next();
				if(code1.equals(pb.getCode())) {
					al.remove(pb);
					int k=new DeleteProductDAO().delete(code1);
					if(k>0) {
						req.setAttribute("msg", "Deleted the Product");
					}
					break;
				}// end of if
			}// end of while
			req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
		}
	}
}

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
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet 
{
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExpired");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String code=req.getParameter("code");
			float price=Float.parseFloat(req.getParameter("price"));
			int qty=Integer.parseInt(req.getParameter("qty"));
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("alist");
			Iterator<ProductBean> it=al.iterator();
			while(it.hasNext()) {
				ProductBean pb=(ProductBean)it.next();
				if(code.equals(pb.getCode())) {
					pb.setPrice(price);
					pb.setQty(pb.getQty()+qty);
					int k=new UpdateProductDAO().update(pb);
					if(k>0) {
						req.setAttribute("msg", "Product Details Updated Successfully........!!!");
					}
					break;
				}//end of if
			}//end of while
			req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
		}
	}
}
package Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Admin.ProductBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/pay")
public class PaymentProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs=req.getSession();
		if(hs==null) {
			req.setAttribute("msg", "Session Expired.......!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String code=req.getParameter("code");
			int quantity=Integer.parseInt(req.getParameter("quantity"));
			int qty=Integer.parseInt(req.getParameter("qty"));
			quantity-=qty;
			ArrayList<ProductBean> al2=(ArrayList<ProductBean>) hs.getAttribute("alist2");
			Iterator<ProductBean> it=al2.iterator();
			while(it.hasNext()) {
				ProductBean pb=(ProductBean)it.next();
				if(code.equals(pb.getCode())) {
					pb.setQty(quantity);
					int k=new PaymentProductDAO().payment(code, quantity);
					if(k>0) {
						req.setAttribute("pbean2", pb);
						req.setAttribute("qty", qty);
					}
				}// end of if
			}// end of while
			req.getRequestDispatcher("PaymentProduct.jsp").forward(req, res);
		}
	}
}

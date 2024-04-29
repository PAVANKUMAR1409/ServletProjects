package Customer;

import java.io.IOException;
import java.util.ArrayList;

import Admin.ProductBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view")
public class CViewAllProductsServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			ArrayList<ProductBean> al2=new CViewAllProductsDAO().retrieve();
			hs.setAttribute("alist2", al2);
			req.getRequestDispatcher("CViewAllProducts.jsp").forward(req, res);
		}
	}
}

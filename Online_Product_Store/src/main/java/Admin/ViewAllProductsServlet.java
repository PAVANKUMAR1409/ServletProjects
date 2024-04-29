package Admin;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/Viewproducts")
public class ViewAllProductsServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "SessionExpired......!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			ArrayList<ProductBean> al=new ViewAllProductsDAO().viewAll();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("ViewAllProducts.jsp").forward(req, res);
		}
		
	}
}
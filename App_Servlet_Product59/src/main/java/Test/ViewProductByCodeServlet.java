package Test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/viewproduct")
public class ViewProductByCodeServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException,IOException
	{
		ProductBean pb= new ProductBean();
		pb.setCode(req.getParameter("code"));
		
		ViewProductByCodeDAO obj= new ViewProductByCodeDAO();
		ArrayList<ProductBean> al=obj.getProduct(pb);
		req.setAttribute("alist", al);
		RequestDispatcher rd= req.getRequestDispatcher("ViewProductByCode.jsp");
		rd.forward(req, res);
	}
}

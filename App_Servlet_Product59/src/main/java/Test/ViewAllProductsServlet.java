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
@WebServlet("/view")
public class ViewAllProductsServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		ViewAllProductsDAO obj= new ViewAllProductsDAO();
		ArrayList<ProductBean> al= obj.retrieve();
		req.setAttribute("alist", al);
		RequestDispatcher rd = req.getRequestDispatcher("ViewAllProducts.jsp");
		rd.forward(req, res);
	}
}





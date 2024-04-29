package Test;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;



@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		ProductBean pb= new ProductBean();
		pb.setCode(req.getParameter("code"));
		pb.setName(req.getParameter("name"));
		pb.setPrice(Float.parseFloat(req.getParameter("price")));
		pb.setQty(Integer.parseInt(req.getParameter("qty")));
		
		AddProductDAO ob= new AddProductDAO();
		int k=ob.Insert(pb);
		if(k>0)
		{
			req.setAttribute("msg", "Product Added Scuccessfully........!!!!!!!");
			RequestDispatcher rd= req.getRequestDispatcher("AddProduct.jsp");
			rd.forward(req, res);
		}
	}
}

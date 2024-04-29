package Admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends HttpServlet
{
	@Override	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			ProductBean pb=new ProductBean();
			pb.setCode(req.getParameter("code"));
			pb.setName(req.getParameter("name"));
			pb.setPrice(Float.parseFloat(req.getParameter("price")));
			pb.setQty(Integer.parseInt(req.getParameter("qty")));
			
			int k=new AddProductDAO().insert(pb);
			if(k>0) {
				req.setAttribute("add","Product Added Successfully........!!!");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}
		}
		
	}
}

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
@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet
{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired.....!!!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String code=req.getParameter("code");
			ArrayList<ProductBean> al2=(ArrayList<ProductBean>)hs.getAttribute("alist2");
			Iterator<ProductBean> it=al2.iterator();
			while(it.hasNext()) {
				ProductBean pb=(ProductBean)it.next();
				if(code.equals(pb.getCode())) {
					req.setAttribute("pbean2", pb);
					break;
				}//end of if
			}//end of while
			req.getRequestDispatcher("BuyProduct.jsp").forward(req, res);
		}
	}
}

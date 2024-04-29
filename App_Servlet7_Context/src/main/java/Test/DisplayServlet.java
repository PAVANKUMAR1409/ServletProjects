package Test;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class DisplayServlet extends HttpServlet
{
	@SuppressWarnings("removal")
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		ServletContext sct=req.getServletContext();
		sct.setAttribute("p", new Integer(2514));
		ServletConfig scf=this.getServletConfig();
		String serN=scf.getServletName();
		req.setAttribute("serN", serN);
		req.setAttribute("b", new Integer(Integer.parseInt(scf.getInitParameter("b"))));
		req.getRequestDispatcher("display.jsp").forward(req, res);
	}
}

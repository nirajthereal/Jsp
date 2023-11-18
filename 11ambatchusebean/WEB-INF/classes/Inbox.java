package pack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Inbox extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException	
	{
		PrintWriter out=res.getWriter();
		HttpSession session= req.getSession();
		String email=(String)session.getAttribute("email");
		String address=getServletConfig().getInitParameter("address");
		String phone=getServletConfig().getInitParameter("mobile");
		if(session.isNew())
		{
			res.sendRedirect("index.html");
		}
		out.print("<html><font color=blue><b>");
		out.print("Hi "+email+" this is ur inbox ");
		out.print("<br>Address : "+address+" Phone: "+phone);
		out.print("<br>"+session.getId());
		
		out.print("</b></font></html>");
	}
}
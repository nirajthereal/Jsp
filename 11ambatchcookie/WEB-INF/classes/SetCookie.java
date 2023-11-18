import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class SetCookie extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");	
		String pass=request.getParameter("pass");	
		 
		 
		if(username==null) username="";
		Cookie cookie = new Cookie ("uname",username);
		Cookie cookie1 = new Cookie ("pass",pass);
		 
		 
		cookie.setMaxAge(365*24*60*60);
		cookie1.setMaxAge(365*24*60*60);
		 
	 
		response.addCookie(cookie);
		response.addCookie(cookie1);
		 
		 
		out.print("<html><head><title>Cookie Saved</title></head>");
		out.print("<body><p><a href='showc'>Next Page to view the cookie value</a><p></body>");

	}
}	
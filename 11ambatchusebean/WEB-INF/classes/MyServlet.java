package pack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class MyServlet extends HttpServlet
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		PrintWriter out=res.getWriter();
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		boolean valid=false;
		String driver=getServletContext().getInitParameter("driver");
		String connect=getServletContext().getInitParameter("connect");
		String user=getServletContext().getInitParameter("user");
		String pwd=getServletContext().getInitParameter("pwd");
		try
		{
			
			Class.forName(driver);// register the driver
			con=DriverManager.getConnection(connect,user,pwd);
			ps=con.prepareStatement("select email,password  from userdetails");
			rs=ps.executeQuery();
			while(rs.next())
			{
				if(email.equals(rs.getString("email")) && pass.equals(rs.getString("password")))
				{
						valid=true;
						break;
				}
			}
				
			if(valid)
			{
				//res.sendRedirect("https://www.google.com");
				HttpSession session= req.getSession();
				//session.setmaxTimeInterval(1*60);
				session.setAttribute("email",email);
				RequestDispatcher rd= req.getRequestDispatcher("in");
				rd.forward(req,res);
			}
			else
			{
				out.print("<html><font color=red><b>");
				out.print("email or password invalid");
				out.print("</b></font></html>");
				RequestDispatcher rd= req.getRequestDispatcher("index.html");
				rd.include(req,res);
			}
		}
		catch(Exception e){}
	}
}
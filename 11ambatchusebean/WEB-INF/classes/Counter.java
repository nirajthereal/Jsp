package pack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import java.sql.*;
public class Counter extends HttpServlet implements Runnable
{
	static int count=0;
	PreparedStatement ps;
	String dd;
	public void run()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///11ambatch","root","root123");
			while(true)
			{
				Date d = new Date();
				dd=d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
				ps=con.prepareStatement("insert into counterdetails values(?, ?)");
				ps.setInt(1,count);
				ps.setString(2,dd);
				ps.executeUpdate();
				Thread.sleep(1000*60);
			}
		}
		catch(Exception e)
		{}
	}
	public void init()
	{
		Counter c = new Counter();
		Thread t = new Thread(c);
		t.start();
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException	
	{
		PrintWriter out=res.getWriter();
		getServletContext().setAttribute("count",++count);
		out.print("<html><font color=blue><b>");
		out.print("Visitor : "+getServletContext().getAttribute("count"));
		out.print("</b></font></html>");
		
	
	}
}
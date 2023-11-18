package pack;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Formjdbc extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
		
        

        MyBean bean = new MyBean();
		bean.setEmail("email");
		bean.setPass("pass");

			if(bean.getLogin())
			{ 
		     
			RequestDispatcher rd= req.getRequestDispatcher("kk");
			rd.include(req,res);
			}
			else{
            out.print("<html><font color=red><b>");
			out.print("email or password invalid");
			out.print("</b></font></html>");
			RequestDispatcher rd= req.getRequestDispatcher("index.html");
			rd.include(req,res);
            //res.sendRedirect("newuser.html");
			}
        } 
	}

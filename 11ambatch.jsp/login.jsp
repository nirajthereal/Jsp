<%@page import="java.sql.*"%>

<%!
Connection con  ;
 PreparedStatement ps;
 ResultSet rs;
			%>
   
       <%
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
		String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        boolean valid =false;
        
        try {
             Class.forName("com.mysql.jdbc.Driver");
		     con = DriverManager.getConnection("jdbc:mysql:///11ambatch","root","abcd");
		     ps =con.prepareStatement("select email,pass from userdetails");
		     rs =ps.executeQuery();
		   while(rs.next())
		   {
			if(email.equals(rs.getString("email"))&& pass.equals(rs.getString("pass")))
			{
			    valid=true;
				break;
			}
			
		   }	
			if(valid)
			{ 
		    session.setAttribute("email",email);
		%>
		    
			<jsp:forward page="inbox.jsp"/>
			<%
			}
			else{
				%>
			<html><font color=red><b>email or password invalid</b></font></html>
			
			<jsp:include page="index.html"/>
			<%
        } 
		}catch (Exception ae) {
		}
	 %>
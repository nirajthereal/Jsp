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
		     ps=con.prepareStatement("select email from userdetails");
		     rs =ps.executeQuery();
		   while(rs.next())
		   {
			if(email.equals(rs.getString("email")))
			{
			    valid=true;
				break;
			}
			
		   }	
			if(valid)
			{
				%>
			<font color=red><b>already exist</b></font>
			<jsp:include page="index.html"/>
			<%
			}
			else{
            ps = con.prepareStatement("insert into userdetails values (?, ?, ?, ?)");
            ps.setString(1, email);
            ps.setString(2, pass);
		    ps.setString(3,address);
			ps.setInt(4,Integer.parseInt(phone));
            ps.executeUpdate();
            response.sendRedirect("index.html");
			}
        } catch (Exception e) {
           
		}
	 %>
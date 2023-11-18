<%@ page import="java.sql.*" %>
<%!
	Connection con;
%>
<%

	try
		{
			
			Class.forName("com.mysql.jdbc.Driver");// register the driver
			con=DriverManager.getConnection("jdbc:mysql:///11ambatch","root","abcd");
		}
		catch(Exception e){}
	%>
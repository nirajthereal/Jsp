<%@ page import="java.sql.*" %>
<%!
	
	PreparedStatement ps;
	ResultSet rs;
%>
<%	
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		boolean valid=false;
		try
		{
			
%>
	<%@ include file="connect.jsp" %>
<%
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
				
				
				session.setAttribute("email",email);
		%>
			<jsp:forward page="inbox.jsp" />
		<%	
			}
			else
			{
		%>
			<html><font color=red><b>email or password invalid</b></font></html>
			<jsp:include page="index.html" />
		<%
			}
		}
		catch(Exception e){}
%>	

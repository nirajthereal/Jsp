<%
		
		String email=(String)session.getAttribute("email");
		if(session.isNew())
		{
			response.sendRedirect("index.html");
		}
	%>
		<html><font color=blue><b>Hi <%=email %>
		<br><%=session.getId() %></b></font></html>
 <%
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
		String address = request.getParameter("address");
        String phone = request.getParameter("phone");
%>

<jsp:useBean id="mb" class="pack.MyBean">
<jsp:setProperty name="mb" property="email" value ="<%= email %>"/>
<jsp:setProperty name="mb" property="pass" value ="<%= pass %>" />
<jsp:setProperty name="mb" property="address" value ="<%= address %>" />
<jsp:setProperty name="mb" property="phone" value ="<%= phone %>" />
</jsp:useBean>
<% 
		
        if(mb.getUser())
		{
			
				%>
			<font color=red><b>already exist</b></font>
			<jsp:include page="newuser.html"/>
			<%
			
		}
		else{
			response.sendRedirect("index.html");
		}
			
	 %>
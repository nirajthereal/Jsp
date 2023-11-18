   <%
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

%>
 <jsp:useBean id="mb" class="pack.MyBean">
<jsp:setProperty name="mb" property="email" value="<%= email %>"/>
<jsp:setProperty name="mb" property="pass" value="<%= pass %>"/>
</jsp:useBean>

<%
		    if(mb.getLogin()){
				
				
				
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
		
	 %>
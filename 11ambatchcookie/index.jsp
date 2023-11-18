 
<html>
<head>
<title>Cookie Input Form</title>
</head>
<body>
<%!
	String uname,pass;
%>	
<%
	Cookie cookies [] = request.getCookies ();
	 
	
	out.print("<html><head><title>Show Saved Cookie</title>");
	if("username".equals(cookies[i].getName())
	{
		uname=cookies[1].getValue()+"";
	}
	if (cookies != null)
	{
			
			pass=cookies[2].getValue()+"";
	}
	if(uname != null && pass!=null)
	{
		response.sendRedirect("sc?username="+uname+"&pass="+pass);
	}
	else
	{
%>
<form method="get" action="sc">
<p><b>Enter Your Name: </b><input type="text" name="username"><p>
Enter Your Password: </b><input type="password" name="pass"><p>


<input type="submit" value="Submit">
</form>
<a href="http://www.google.com/search?q=india">Click</a>
</body>
<%
	}
%>	
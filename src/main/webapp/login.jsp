<%@include file="header.jsp"%>
<% 
String uid="",pass="";
Cookie ck[]=request.getCookies();
if(ck!=null)
{
	for(Cookie c:ck )
	{
		String name=c.getName();
		if(name.equalsIgnoreCase("uid"))
			uid=c.getValue();
		else if(name.equalsIgnoreCase("pass"))
			pass=c.getValue();
	}
}
%>
<h3>User Login Form</h3>
<form action="CheckUser" method="post">
<pre align="center">
      User id   :<input type="text" name="uid" value="<%=uid%>">
      password  :<input type="password" name="pass" value="<%=pass%>">
      save data :<input type="checkbox" name="chk" value="yes">
                 <input type="submit" value="login">
</pre>
</form>
<%@include file="footer.jsp"%>
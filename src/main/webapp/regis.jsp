<%@include file="header.jsp" %>

<h3>User Registration Form</h3>
<form action="RegisterUser" method="post">
<pre align ="center" >
     User ID   :<input type="text" name="uid">
     User Name :<input type="text" name="unm">
     Password  :<input type="password" name="pass">
     User Type :<select name="utype">
                <option>seller</option>
                <option>buyer</option>
          </select>
          <input type="submit" value="Register">
</pre>
</form>
<%@include file="footer.jsp"%>
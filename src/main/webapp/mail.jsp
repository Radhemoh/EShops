<%@include file="header.jsp"%>

<h3>Compose a Mail</h3>
<form action="SendMail" method="post">
<pre>
     Mail to  : <input type="text" name="to">
     Mail cc  : <input type="text" name="cc">
     Mail bcc : <input type="text" name="bcc">
     Mail by  : <input type="text" name="from">
     Password : <input type="text" name="pass">
     Subject  : <input type="text" name="sub">
     Content  : <textarea rows="10" cols="25" name="cnt"></textarea>
                <input type="submit" value="Send">
</pre>
</form>
<%@include file="footer.jsp"%>
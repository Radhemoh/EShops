<%@include file="header.jsp" %>
<%
String username=(String)session.getAttribute("username");
%>
<h1>Welcome <%=username%> the Buyer...</h1>
<pre>
<h4>
<a href="srcpro.jsp">Search</a>
<a href="showcart.jsp">View Card</a>
<a href="">Payment</a>
<a href="">Track Order</a>
<a href="Logout">Logout</a>
</h4></pre>
<%@include file="footer.jsp" %>
<%@include file="header.jsp" %>
<%String username=(String)session.getAttribute("username"); %>

<h1>Welcome<%=username %> , the Seller...</h1>
<pre>
<h4>
<a href="addpro.jsp">Manage New Product</a>
<a href="showpro.jsp">View Order</a>
<a href="">Deliver Order</a>
<a href="">Receive Payment</a>
<a href="Logout">Logout</a>
</h4>
</pre>
<%@include file="footer.jsp" %>
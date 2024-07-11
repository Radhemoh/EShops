<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ include file="header.jsp"%>
<h3>Product Category List</h3>
<%
Connection con=(Connection)this.getServletContext().getAttribute("mycon");
PreparedStatement ps=con.prepareStatement("select * from orders where userid=?");
ps.setString(1, (String)session.getAttribute("userid"));
ResultSet rs=ps.executeQuery();
%>
<table border="4" class="table table-dark table-hover table-stripped">
<thead>
	<tr>
		<th>Order ID</th>
		<th>Amount</th>
		<th>UserID</th>
	</tr>
</thead>
<tbody>
<% while(rs.next()){
	String oid=rs.getString(1);
	String amt=rs.getString(2);
	String uid=rs.getString(3);
	%>
	<tr>
		<td><%=oid%></td>
		<td><%=amt%></td>
		<td><%=uid%></td>
	</tr>
<% } %>
</tbody>
</table>
<a href="buyer.jsp">Home</a>
<%@ include file="footer.jsp"%>
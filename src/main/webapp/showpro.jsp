<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ include file="header.jsp"%>
<h3>Product Category List</h3>
<%
Connection con=(Connection)this.getServletContext().getAttribute("mycon");
ResultSet rs=con.createStatement().executeQuery("select * from products");
%>
<table border="4" class="table table-dark table-hover table-stripped">
<thead>
	<tr>
		<th>Product Name</th>
		<th>Description</th>
		<th>Price</th>
		<th>Discount(%)</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
</thead>
<tbody>
<% while(rs.next()){
	String pid=rs.getString(1);
	String pnm=rs.getString(2);
	String pdesc=rs.getString(3);
	String price=rs.getString(4);
	String disc=rs.getString(5);
	%>
	<tr>
		<td><%=pnm%></td>
		<td><%=pdesc%></td>
		<td><%=price%></td>
		<td><%=disc%></td>
		<td><a href="updpro.jsp?pid=<%=pid%>"><button class="btn-success">Modify</button></a></td>
		<td><a href="DeleteProduct?pid=<%=pid%>"><button class="btn-danger">Remove</button></a></td>
	</tr>
<% } %>
</tbody>
</table>
<%@ include file="footer.jsp"%>
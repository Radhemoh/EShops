<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ include file="header.jsp"%>
<h3>Product Category List</h3>
<%
Connection con=(Connection)this.getServletContext().getAttribute("mycon");
ResultSet rs=con.createStatement().executeQuery("select * from productcategory");
%>
<table border="4" class="table table-dark table-hover table-stripped">
<thead>
	<tr>
		<th>Category ID</th>
		<th>Category Name</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
</thead>
<tbody>
<% while(rs.next()){
	String pcid=rs.getString(1);
	String pcnm=rs.getString(2);
	%>
	<tr>
		<td><%=pcid%></td>
		<td><%=pcnm%></td>
		<td><a href="updPC.jsp?pcid=<%=pcid%>&pcnm=<%=pcnm%>"><button class="btn-success">Modify</button></a></td>
		<td><a href="DeletePC?pcid=<%=pcid%>"><button class="btn-danger">Remove</button></a></td>
	</tr>
<% } %>
</tbody>
</table>
<%@ include file="footer.jsp"%>
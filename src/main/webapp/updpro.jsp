<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ include file="header.jsp"%>
<h3>Product Category Modification Form</h3>
<%
Connection con=(Connection)this.getServletContext().getAttribute("mycon");
PreparedStatement ps=con.prepareStatement("select * from products where pid=?");
ps.setString(1, request.getParameter("pid"));
ResultSet rs=ps.executeQuery();
rs.next();
%>
<form action="UpdateProduct">
<pre>
	Product ID   : <input type="text" name="pid" value="<%=rs.getString(1)%>" readonly="true">
	Product Name : <input type="text" name="pnm" value="<%=rs.getString(2)%>">
	Description  : <input type="text" name="pdesc" value="<%=rs.getString(3)%>">
	Price	     : <input type="text" name="price" value="<%=rs.getString(4)%>">
	Discount(%)  : <input type="text" name="disc" value="<%=rs.getString(5)%>">
	               <input type="submit" class="btn-success" value="Modify">
</pre>
</form>

<%@ include file="footer.jsp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ include file="header.jsp"%>
<form action="AddProduct">
<pre>
	Product ID   : <input type="text" name="pid">
	Product Name : <input type="text" name="pnm">
	Description  : <input type="text" name="pdesc">
	Product Rate : <input type="text" name="price">
	Discount (%) : <input type="text" name="disc">
	Category ID  : <select name="pcid">
<%  
Connection con=(Connection)this.getServletContext().getAttribute("mycon");
ResultSet rs=con.createStatement().executeQuery("select * from productcategory");
while(rs.next()){
%>
		<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
<%}%>
	</select>
						    <input class="btn-lg btn-primary" type="submit" value="Add">
</pre>
</form>
<%@ include file="footer.jsp"%>

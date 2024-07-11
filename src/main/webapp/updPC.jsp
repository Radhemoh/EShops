<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ include file="header.jsp"%>
<h3>Product Category Modification Form</h3>
<form action="UpdatePC">
<pre>
	Product Cat ID   : <input type="text" name="pcid" value="<%=request.getParameter("pcid")%>" readonly="true">
	Product Cat Name : <input type="text" name="pcnm" value="<%=request.getParameter("pcnm")%>">
	                   <input type="submit" value="Modify">
</pre>
</form>

<%@ include file="footer.jsp"%>
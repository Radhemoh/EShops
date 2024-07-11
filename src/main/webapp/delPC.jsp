<%@ include file="header.jsp"%>
<h3>Product Category Removal Form</h3>
<h4>
<pre>
Do you really want to delete the Product Category : <%=request.getParameter("pcnm")%>
					             <a href="DeletePC?pcid=<%=request.getParameter("pcid")%>"><button class="btn-success">Yes</button></a><a href="showPC.jsp"><button class="btn-danger">No</button></a>
 </pre>
</h4>

<%@ include file="footer.jsp"%>
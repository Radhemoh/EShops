<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ include file="header.jsp"%>
<h3>Product Category List</h3>
<%
Connection con=(Connection)this.getServletContext().getAttribute("mycon");
PreparedStatement ps=con.prepareStatement("select * from products where pid=?");
ps.setString(1, request.getParameter("pid"));
ResultSet rs=ps.executeQuery();


rs.next();
%>
   <h4>The Details Of Product is :</h4>
   <pre>
          Product Name : <%=rs.getString(2)%>
          Description  : <%=rs.getString(3)%>
          Product Rate : <%=rs.getString(4)%>
          Discount(%)  : <%=rs.getString(5)%>
                             <a href="Add2Cart?pid=<%=rs.getString(1)%>"><button>Add To Cart</button></a>
                   
   </pre>
<%@ include file="footer.jsp"%>
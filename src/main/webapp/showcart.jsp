<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ include file="header.jsp"%>
<h3>Check Your Cart</h3>
<%
Connection con=(Connection)this.getServletContext().getAttribute("mycon");

ArrayList<String> list =(ArrayList) session.getAttribute("cart");
String qry="select * from products where pid in('";
if(list!=null)
{
for(int i=0;i<list.size();i++)
{
qry=qry+list.get(i)+"','";	
}
qry=qry.substring(0, qry.length()-2);
qry=qry+")";
//out.println("Query is: "+qry);
}

ResultSet rs=con.createStatement().executeQuery(qry);

%>
<form action="BookOrder">
<table class="table table-info table-hover table-stripped">
<thead>

       <tr>
       <th>Product Name</th>
       <th>Description</th>
       <th>Price</th>
       <th>Discount(%)</th>
       <th>Net Price</th>
       <th>Remove</th>
       <th>Delete</th>
       </tr>

</thead>
<tbody>
<%
int total=0,np=0;
while(rs.next()){
String pid=rs.getString(1);
int price=rs.getInt(4);
int disc=rs.getInt(5);
int net=price-(price*disc)/100;
total=total+price;
np=np+net;

%>
<tr> 
     <td><%=rs.getString(2) %></td>
     <td><%=rs.getString(3) %></td>
     <td><%=price %></td>
     <td><%=rs.getString(5) %></td>
     <td><%=net %></td>
     <td><a href="EditCart?pid=<%=pid%>">X</a></td>
     <td><input type="checkbox" name="chk" value="<%=pid%>"></td>

</tr>
<%} %>
</tbody>
<tfoot>
<tr style="font-size:large">
    <td align="center"  colspan=2><b>Total</b></td>
    <td><b><%=total %></b></td>
    <td></td>
    <td><b><%=np %></b></td>
    <td></td>
    <td><input type="submit" value="Book Order" ></td>
</tr>
</tfoot>
</table>
</form>
<%@ include file="footer.jsp"%>
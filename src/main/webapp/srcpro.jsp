<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ include file="header.jsp"%>
<script>
    var req;
    function getPro(pcat)
    {
    	//alert(pcat)
    	req=new XMLHttpRequest();
    	req.onreadystatechange=output;
    	req.open("get","GetProduct?pcid="+pcat,true);
    	req.send();
    	
    }
    function output()
    {
    	if(req.readyState==4 && req.status==200)
    		{
          	var ans=JSON.parse(req.responseText);
          	mydiv=document.getElementById("mydiv")
          	mydiv.innerHTML="";
            for(v of ans)
          		{
          		  str="<a href=prodetails.jsp?pid="+v[0]+">"+v[1]+"</a><br>"
          		  mydiv.innerHTML+=str
          		}
           }
    }

</script>

Select Product Category :<select id="pcat" onchange="getPro(this.value)">

<% 
Connection con=(Connection)this.getServletContext().getAttribute("mycon");
ResultSet rs=con.createStatement().executeQuery("select * from productcategory");
String pcid,pcnm;
while(rs.next())
{
pcid=rs.getString(1);
pcnm=rs.getString(2);
%>
<option value="<%=pcid%>"><%=pcnm%></option>
<%
}
%>
</select>
<h4>The List of Product : </h4>
<div id="mydiv"></div>
<%@ include file="footer.jsp"%>
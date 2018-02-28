<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
  	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
   	response.setHeader("Pragma", "no-cache");
   	response.setHeader("Expires","0");
  	if(session.getAttribute("user")==null){
		response.sendRedirect("Login.jsp");
	}
  %>
<title>HR HOME</title>
</head>
<body>
<h1 align="center">Welcome <%=session.getAttribute("user") %></h1>

<h3 align="right"><a href="Logout.jsp" ><b>Logout</b></a></h3>
<form action="HrHome" method="POST">
<table border = "1" cellpadding = "6" cellspacing = "2" align="center">
            <tr><td><b>Select an Employee to view Attendance</b></td></tr>
            <%Object object=session.getAttribute("employees");
            	if(object!=null){
            	String fullRecord=(String)object;
				String[] records=fullRecord.split(",");
				for(int i=0;i<=records.length-1;i++){
			%>
            <tr><td><input type = "radio" name = "name" value = <%=records[i]%> ><%=records[i]%></td></tr>
            <%} }%>
            <tr><td><input type="submit" value="Submit" onclick="submit" /></td></tr>
 </table>
 </form>
 <br><br>
 
 <%Object str=session.getAttribute("personRecord");
 if(str!=null){%>
 <h1 align="center">Attendance information of employee</h1>
 <table border="1" align="center">
 <tr>
<th>Date(MM/DD/YYYY)</th>
<th>Attendance</th>
</tr>
<%
String str1=str.toString();
String[] d=str1.split(",");
for(int i=0;i<=d.length-1;i++){
%>
<tr>
<td> <%=d[i].substring(0,10)%></td>
<td><%=d[i].substring(11)%> </td>
<tr>
<%}}%>

</table>
 
 
 
</body>
</html>
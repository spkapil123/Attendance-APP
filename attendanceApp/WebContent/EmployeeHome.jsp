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
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  
  </script>
 <title>EmployeeHome</title>
</head>
<body>

<h2 align="center" >Welcome <%= session.getAttribute("user") %> <%-- <%= session.getAttribute("person") %> --%> 
</h2>
<h3 align="right"><a href="Logout.jsp" ><b>Logout</b></a></h3>

<form action="home" method="POST">
<table border = "1" cellpadding = "6" cellspacing = "2" onclick="show();">
         <tr>
            <td><b>Mark Today's Attendence</b></td>
            <td><input type = "radio" name = "attendenceCall" value = "Present" >Present</td>
         	<td><input type = "radio" name = "attendenceCall" value = "Absent" >Absent</td>
         	<td><input type = "radio" name = "attendenceCall" value = "OfficialOut" >Official out</td>
         	<td><input type="submit" value="Submit" onclick="submit" onclick="show();" /></td></tr>
 </table>
 </form>
 <br>
 <%if(session.getAttribute("rollCall")!=null){ %>
 <h2 style="color:green">Your Attendence has been marked as <%=session.getAttribute("rollCall") %> successfully!</h2>
 <%} %>
 <br>
 
 
 <br>
 <form action="home" method="POST">
 <table border = "1" cellpadding = "2" cellspacing = "2">
         <tr>
            <td><b>See monthly view</b></td>
            <td>Table view<input type = "radio" name = "view" value = "intable" >
        	</td>
            <td>Calendar format<input type = "radio" name = "view" value = "calendar" > </td>
          	<td><input type="submit" value="Submit" onclick="submit" /></td>
          </tr>
         <!-- <tr>
            <td colspan = "2"><input type="submit" value="Submit" />
            <input type = "radio" name = "person" value = "employee"> Employee
         	<input type = "radio" name = "person" value = "HR"> HR
            </td>
         </tr> -->
         </table>

</form>
<%if(session.getAttribute("pass")!=null){%>
<form action="home" method="POST">
Select a month to view in table format <select name = "tableFormat">
            <option value="null" selected>choose</option>
            <option value = "1">January</option>
            <option value = "2">February</option>
            <option value = "3">March</option>
            <option value = "4">April</option>
            <option value = "5">May</option>
            <option value = "6">June</option>
            <option value = "7">July</option>
            <option value = "8">August</option>
            <option value = "9">September</option>
            <option value = "10">October</option>
            <option value = "11">November</option>
            <option value = "12">December</option>
         	</select>
         	<input type="submit" value="Submit" onclick="submit" />
         	</form>
         	<%}if(session.getAttribute("pass1")!=null){%>
         	<form action="home" method="POST">
			click to select from Calendar<input type="text" name = "calendarFormat" id="datepicker"  >
			<input type="submit" value="Submit" onclick="submit" />
			</form>
<%} %>
<br>
<br>
<%
String x="";
if(session.getAttribute("batchDate")!=null){
	x="batchDate";
	}
else if(session.getAttribute("singleDate")!=null){
		x="singleDate";
		}
		if(!x.toString().equals("")){%>
<table border = "1" cellpadding = "6" cellspacing = "1"  align="center">
<tr>
<th>Date(MM/DD/YYYY)</th>
<th>Attendace</th>
</tr>
<%String fullRecord=(String)session.getAttribute(x);
if(x.equals("batchDate")){
String[] records=fullRecord.split(",");
for(int i=0;i<=records.length-1;i++){
%>
<tr>
<td> <%=records[i].substring(0,10)%></td>
<td><%=records[i].substring(11)%> </td>
</tr><%}}if(x.equals("singleDate")){%>
<tr>
<td> <%=fullRecord.substring(0,10)%></td>
<td><%=fullRecord.substring(11)%> </td>
</tr> 

<%}}%>

</table>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendence App Login</title>
<script type="text/javascript">
function submitAction()
{
	 flag=o;
if(document.forms[0].name.value == "") {
alert("Please enter a valid name");
flag=1;
}
if(document.forms[0].password.value == "")
{
alert("Please enter a valid password");
flag=1;
}
if(document.forms[0].person.value == "")
{
alert("Please select HR or Employee");
flag=1;
}
if(flag=1){request.setParameter("errors","true");}
}
</script>

</head>
<body>
<h1 align="center">Attendence App</h1>
<h3>Login</h3>
 <form action="login" method="POST">
 	<table border = "1" cellpadding = "5" cellspacing = "5">
         <tr>
            <td> Name</td>
            <td><input type="text" name='name'><br></td>
         </tr>
         <tr>
            <td> Password</td>
            <td><input type="password" name='password'><br></td>
         </tr>
         <tr>
            <td colspan = "2"><input type="submit" value="Submit" onclick="submitAction();"/>
            <input type = "radio" name = "person" value = "employee"> Employee
         	<input type = "radio" name = "person" value = "hr"> HR
            </td>
         </tr>
      </table>
</form>
<%Object msg= session.getAttribute("error");
			if(msg!=null){%>
<h4 style="color:red">
<%=msg.toString() %>
</h4>
<%} %>
</body>
</html>
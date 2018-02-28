<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>LogOut Page</title>
</head>
<body>
<h2 align="center" style="color:red">Logging out..........</h2>
 

<% 
request.getSession().setAttribute("user", null);
request.getSession().invalidate();
response.sendRedirect("Login.jsp");
%>
</body>
</html>
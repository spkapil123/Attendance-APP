<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  
  </script>
 <title>Home</title>

<script>
function toggle() {
 if( document.getElementById("hidethis").style.display=='none' ){
   document.getElementById("hidethis").style.display = '';
 }else{
   document.getElementById("hidethis").style.display = 'none';
 }
}
</script>
</head>
<body>

<span onClick="toggle();">toggle</span><br /><br />

<table border="1" id="hidethis">
<tr>
<td>Always visible</td>
</tr>
<tr >
<td>Hide this</td>
</tr>
<tr>
<td>Always visible</td>
</tr>
</table>

</body>
</html>
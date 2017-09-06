<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to the sign up page</title>
<script>
function display(){
	
	var country= '<%= request.getParameter("country") %>';
	var gender= '<%= request.getParameter("gender") %>';
	var username= '<%= request.getParameter("uname") %>';
	document.getElementById("display").innerHTML='<center>'+"Username: "+username+'<br><br>'+"Gender: "+gender+'<br><br>'+"Country: "+country+'</center>';
}
</script>


</head>
<body>
<script type="text/javascript">alert('You are successfully Signed Up & Logged in');</script>
<!-- <h2><p align="middle"><a href="index.html">Home</a></p></h2> -->
<h1>Hello <%= request.getParameter("uname") %>!</h1>
<div id="display">
<br>
<h2><p align="middle"><a href="index.html">Login</a></p></h2>
<!--<center><button onclick="LoginJSP.jsp"><b>Show Details</b></button></center></div>  -->
</body>
</html>
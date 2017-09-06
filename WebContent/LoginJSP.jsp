<%@page import="com.d.Dbutil"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.lang.ClassNotFoundException" %>
<%@ page import="java.sql.ResultSet" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome to Bridgelabz</title>
<script>

</script>
</head>
<body>
<% 

	ResultSet rs = null;
	String query = "SELECT * FROM userdetails WHERE uname = ? AND password = ?";
	PreparedStatement pst = null;
	Connection conection = Dbutil.createConnection("Reg");
	
	pst = conection.prepareStatement(query);
	pst.setString(1, request.getParameter("uname"));
	pst.setString(2, request.getParameter("pass"));
	rs = pst.executeQuery();
	
%>


<div id="display">
<center>
<fieldset>
<h1>Welcome</h1>
<br>
<br>
<p align="middle"><a href="index.html">Go To Login page</a>

<% Dbutil.closeConection(conection); %>
</fieldset>
</center>
</div>
</body>
</html>
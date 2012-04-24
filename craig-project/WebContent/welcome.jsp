<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<center>
<h2 style="color: red;">Welcome!</h2>
<br>
<%!
int count = 0;
%>

This page has been visited <%= count %> times

 
<p>Hello <%= session.getAttribute("username") %></p>
<p> <%= response.getHeader("cke") %>

 <a href='./'>back</a>
</center>
</body>
</html>

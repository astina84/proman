<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projekt Management System</title>
</head>
<body>
<% 
out.println("Dieser Text wurde �bergeben !");
out.println(request.getParameter("text"));

%>
</body>
</html>
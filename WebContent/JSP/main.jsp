<%@page import="java.util.Date"%>
<%@page import="org.omg.CORBA.Current"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Projekt Managment System Radikon</title>
<!-- CSS Style hinzufügen -->
<link href="../CSS/main.css" rel="stylesheet" type="text/css">
<!-- JQuery hinzufügen -->
<script type="text/javascript" src="../SCRIPTS/jquery.js"></script>
</head>
<body>
<div class="overlay"></div>
<div class="container">
  <!-- start .header -->
  <div class="header">
  	<table class="headertab">
  	<tr>
  	<td class="headername">Radikon Managmentsystem</td>
  	<td class="headersearch"><form><input></input><button>OK</button></form></td>
  	<td class="headerdate">
  	<% Date date = new java.util.Date();%>
  	<% out.println(date);%></td>
  	</tr>
  	</table> 
  <!-- end .header -->
  </div>
  <!-- start .content -->
  <div class="content">
	<jsp:include page="../JSP/login.jsp"></jsp:include>
  <!-- end .content -->
  </div>
  <!-- start .footer --> 
  <div class="footer">
 	<table class="footertab">
  	<tr>
  	<td class="footer1">Bearbeiter</td>
  	<td class="footer2">Administrator</td>
  	<td class="footer3">Einstellungen</td>
 	</tr>
  	</table>
  <!-- end .footer --></div>
</div>
</body>
</html>
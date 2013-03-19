<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<script type="text/javascript" src="../SCRIPTS/jquery.js"></script>

<script type="text/javascript">

$(document).ready(function(){
	
	$(".footer1").html(<% out.println("'" + session.getAttribute("username") + "'" ); %>);
		
});
	

</script>

<% 
out.println("Dieser Text wurde im request Parameter username übergeben ! : ");
out.println(request.getParameter("username <br>"));

out.println("Dieser Text wurde mit sessions Attribute username übergeben ! : ");
out.println( session.getAttribute("username") );

%>

</html>
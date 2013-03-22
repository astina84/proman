<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- CSS Style hinzufügen -->
<link href="../CSS/maincontainer.css" rel="stylesheet" type="text/css">

<!-- JavaScript hinzufügen -->
<script type="text/javascript" src="../SCRIPTS/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	
	
	$(".footer1").html(<% out.println("'" + session.getAttribute("vorname") + " " + session.getAttribute("nachname") +  "'" ); %>);
		
});
</script>

<div class="menu"><jsp:include page="../JSP/menu.jsp"></jsp:include></div>
<div class="maincontent">maincontent</div>

</html>
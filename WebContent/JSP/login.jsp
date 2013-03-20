<%@page import="java.util.Date"%>
<%@page import="org.omg.CORBA.Current"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<!-- CSS Style hinzufügen -->
<link href="../CSS/login.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../SCRIPTS/jquery.js"></script>

<script type="text/javascript">

$(document).ready(function(){

	// overlay faden damit Fensterinhalte schwarz abgedunkelt sind
	$(".overlay").fadeIn("fast");	
	
	//Login Formular faden
	$(".loginformular").delay("slow").fadeIn("slow");
	
	//click event für den "anmelden" Button 
	$("#loginbutton").click(function(){
	
		// werte für die beiden Eingabefelder auslesen
		var username = $("#inputusername").val();
		var userpass = $("#inputpassword").val();
		
		// abfrage nach leeren feldern
		if(username == "" || username == null)
			{
			$("#Benutzerfeld").html("Benutzer: bitte ausfüllen").css("color","red");
			}
		if(userpass == "" || userpass == null)
			{
			$("#Passwordfeld").html("Password: bitte ausfüllen").css("color","red");
			}
		else
			{
			// ajax befehl Login Servlet ausführen username und userpass übergeben
			$.ajax({
			  type: "POST",
			  url: "http://localhost:8080/proman/Login",
			  data: { username: username , password: userpass }
			  }).done(function( msg ) {
			  $(".content").html(msg);
			  // nach erfolgreichen login wir der overlay div gefaded
			  $(".overlay").fadeOut("slow");
			  $(".loginformular").fadeOut("slow");
			}); 
			}
							
	});
	
	
});
	
</script>

<div class="loginformular">
		<table>
			<tr>
			<td id="Benutzerfeld">Benutzer:</td>
			</tr>
			<tr>
			<td><input id="inputusername" type="text" size="30" maxlength="50"></td>
			</tr>
			<tr>
			<td id="Passwordfeld">Password:</td>
			</tr>
			<tr>
			<td><input id="inputpassword" type="password" size="30" maxlength="50" ></td>
			</tr>
			<tr>
			<td><input id="loginbutton" type="submit" value="anmelden" onclick="javascript:void(0);"></td>
			</tr>
		</table>
</div>
</html>
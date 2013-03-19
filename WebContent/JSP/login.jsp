<%@page import="java.util.Date"%>
<%@page import="org.omg.CORBA.Current"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="../SCRIPTS/jquery.js"></script>

<script type="text/javascript">

$(document).ready(function(){

	//Login Formular Fade IN
	
	$(".loginformular").delay("slow").fadeIn("slow");

	//Abfrage Login Button danach Daten an Servlet verschicken über POST
	
	$("#loginbutton").click(function(){
		
		var username = $("#inputusername").val();
	//	alert(username);
		var userpass = $("#inputpassword").val();
	//	alert(userpass);
		
		//alert("Hallo");
 		$.ajax({
			  type: "POST",
			  url: "http://localhost:8080/proman/HelloWorldServlet",
			  data: { username: username , password: userpass }
			  }).done(function( msg ) {
			  $(".content").html(msg);
			  $(".overlay").fadeOut("slow");
			  $(".loginformular").fadeOut("slow");
			});
				
	});
	
	
});
	

</script>
<style type="text/css">
<!-- 


DIV.loginformular{
	position: absolute;
	height: 200px;
	width: 300px;
	top: 50%;
	left: 60%;
	background-color:#383838;
	display:none;
	z-index: 9999;
	
	-webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
		
}

DIV.loginformular table{
	position:absolute;
	top:20px;
	left:30px;
    text-align: left;
}

#einlogenbutton{
	
	margin-top:25px;
 	background: #FFFFFF;
	float: right;
}

DIV.overlay{

position: fixed;
width: 100%;
height: 100%;
left: 0px;
top: 0px;
z-index: 999;
background-color:#000;  
opacity:0.7;  

}

-->
</style>
<div class="loginformular">
		<table>
			<tr>
			<td>Benutzer:</td>
			</tr>
			<tr>
			<td><input id="inputusername" type="text" size="30" maxlength="50"></td>
			</tr>
			<tr>
			<td>Password:</td>
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
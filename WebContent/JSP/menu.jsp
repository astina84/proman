<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<ul class="accordion">
 
    <li id="one" class="mitarbeiter"><a href="#one">Mitarbeiter<span>18</span></a>
    
        <ul class="sub-menu">
 
        	<li><a href="#"><em>01</em>anlegen</a></li>
 
    	    <li><a href="#"><em>02</em>verwalten</a></li>
 
	        <li><a href="#"><em>03</em>löschen</a></li>
 
    	</ul>
    
    </li>
 
    <li id="two" class="projekte"><a href="#two">Projekte<span>1020</span></a>
    
        <ul class="sub-menu">
 
        	<li><a href="#"><em>01</em>anlegen</a></li>
 
    	    <li><a href="#"><em>02</em>verwalten</a></li>
 
	        <li><a href="#"><em>03</em>löschen</a></li>
 
    	</ul>
    
    </li>
 
    <li id="three" class="rechnungen"><a href="#three">Rechnungen<span>508</span></a>
    
        <ul class="sub-menu">
 
        	<li><a href="#"><em>01</em>anlegen</a></li>
 
    	    <li><a href="#"><em>02</em>verwalten</a></li>
 
	        <li><a href="#"><em>03</em>löschen</a></li>
 
    	</ul>
    
    </li>
 
    <li id="four" class="abmelden"><a href="javascript:void(0);">Abmelden</a></li>
 
</ul>

<style>

.accordion,
.accordion ul,
.accordion li,
.accordion a,
.accordion span {
    margin: 0;
    padding: 0;
    border: none;
    outline: none;
}
 
.accordion li {
    list-style: none;
}

.accordion li > a {
    display: block;
    position: relative;
    min-width: 200px;
    padding: 0px 10px 0 10px;
 
    color: #fdfdfd;
    font: bold 12px/32px Arial, sans-serif;
    text-align:left;
    text-decoration: none;
    text-shadow: 0px 1px 0px rgba(0,0,0, .35);
    
 
    background: #6c6e74;
    background: -moz-linear-gradient(top,  #6c6e74 0%, #4b4d51 100%);
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#6c6e74), color-stop(100%,#4b4d51));
    background: -webkit-linear-gradient(top,  #6c6e74 0%,#4b4d51 100%);
    background: -o-linear-gradient(top,  #6c6e74 0%,#4b4d51 100%);
    background: -ms-linear-gradient(top,  #6c6e74 0%,#4b4d51 100%);
    background: linear-gradient(top,  #6c6e74 0%,#4b4d51 100%);
 
    -webkit-box-shadow: inset 0px 1px 0px 0px rgba(255,255,255, .1), 0px 1px 0px 0px rgba(0,0,0, .1);
    -moz-box-shadow: inset 0px 1px 0px 0px rgba(255,255,255, .1), 0px 1px 0px 0px rgba(0,0,0, .1);
    box-shadow: inset 0px 1px 0px 0px rgba(255,255,255, .1), 0px 1px 0px 0px rgba(0,0,0, .1);
}

.accordion li > a span {
    display: block;
    position: absolute;
    top: 7px;
    right: 0;
    padding: 0 10px;
    margin-right: 10px;
 
    font: normal bold 12px/18px Arial, sans-serif;
    background: #404247;
 
    -webkit-border-radius: 15px;
    -moz-border-radius: 15px;
    border-radius: 15px;
 
    -webkit-box-shadow: inset 1px 1px 1px rgba(0,0,0, .2), 1px 1px 1px rgba(255,255,255, .1);
    -moz-box-shadow: inset 1px 1px 1px rgba(0,0,0, .2), 1px 1px 1px rgba(255,255,255, .1);
    box-shadow: inset 1px 1px 1px rgba(0,0,0, .2), 1px 1px 1px rgba(255,255,255, .1);
}

/* Hover Funktionen */
.accordion > li:hover > a,
.accordion > li:target > a {
    color: #3e5706;
    text-shadow: 1px 1px 1px rgba(255,255,255, .2);
 
    /*background: url(../img/active.png) repeat-x;*/
    background: #a5cd4e;
    background: -moz-linear-gradient(top,  #a5cd4e 0%, #6b8f1a 100%);
    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#a5cd4e), color-stop(100%,#6b8f1a));
    background: -webkit-linear-gradient(top,  #a5cd4e 0%,#6b8f1a 100%);
    background: -o-linear-gradient(top,  #a5cd4e 0%,#6b8f1a 100%);
    background: -ms-linear-gradient(top,  #a5cd4e 0%,#6b8f1a 100%);
    background: linear-gradient(top,  #a5cd4e 0%,#6b8f1a 100%);
}
 
.accordion > li:hover > a span,
.accordion > li:target > a span {
    color: #fdfdfd;
    text-shadow: 0px 1px 0px rgba(0,0,0, .35);
    background: #3e5706;
}
 

.sub-menu li:hover a { background: #efefef; }

.sub-menu li a {
    color: #797979;
    text-shadow: 1px 1px 0px rgba(255,255,255, .2);
 	text-align:center;
 	 
    background: #e5e5e5;
    border-bottom: 1px solid #c9c9c9;
 
    -webkit-box-shadow: inset 0px 1px 0px 0px rgba(255,255,255, .1), 0px 1px 0px 0px rgba(0,0,0, .1);
    -moz-box-shadow: inset 0px 1px 0px 0px rgba(255,255,255, .1), 0px 1px 0px 0px rgba(0,0,0, .1);
    box-shadow: inset 0px 1px 0px 0px rgba(255,255,255, .1), 0px 1px 0px 0px rgba(0,0,0, .1);
}
 
.sub-menu li:last-child a { border: none; }
 
.sub-menu li > a span {
    color: #797979;
    
    text-shadow: 1px 1px 0px rgba(255,255,255, .2);
    background: transparent;
    border: 1px solid #c9c9c9;
 
    -webkit-box-shadow: none;
    -moz-box-shadow: none;
    box-shadow: none;
}
 
.sub-menu em {
    position: absolute;
    top: 0;
    left: 0;
    margin-left: 14px;
    color: #a6a6a6;
    font: normal 10px/32px Arial, sans-serif;
}

/* Show and Hide Funktionen */
.accordion li > .sub-menu {
    height: 0;
    overflow: hidden;
 
    -webkit-transition: all .2s ease-in-out;
    -moz-transition: all .2s ease-in-out;
    -o-transition: all .2s ease-in-out;
    -ms-transition: all .2s ease-in-out;
    transition: all .2s ease-in-out;
}
 
.accordion li:target > .sub-menu {
    height: 98px;
}

</style>

<script type="text/javascript">

$(document).ready(function(){
	
	$(".abmelden").click(function(){
		
		$.ajax({
			  type: "POST",
			  url: "http://localhost:8080/proman/Logout",
			  data: {}
			  }).done(function( msg ) {
				  
				  $(".content").html(msg);
			  
			}); 
		
	});
	
});

</script>

</html>
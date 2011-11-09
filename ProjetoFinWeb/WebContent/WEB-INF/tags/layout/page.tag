<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ tag description="Page layout" %>
 
<%@ attribute name="title"       required="true" description="Page title" %>
<%@ attribute name="keywords"    required="true" description="Page keywords to improve SEO" %>
<%@ attribute name="description" required="true" description="Page description" %>
 
<%@ attribute name="extraHeader" fragment="true" description="Header" %>
<%@ attribute name="extraBottom" fragment="true" description="bottm" %>
<%@ attribute name="usuario"  required="true" description="Page Usuario" %>
 
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
 
        <!-- Displaying the attributes using EL -->
        <meta name="keywords"    content="${keywords}" />
        <meta name="description" content="${description}" />
		
        <title>${title}</title>
 
        <!-- Essential scripts -->
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
		<script type="text/javascript" src="js/menu.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>        
        <script type="text/javascript" src="js/jquery-imask-min.js"></script>
        <script type="text/javascript" src="js/formatdate.js"></script>
        
        <!-- Process the given input fragment -->
        <jsp:invoke fragment="extraHeader"/>
    </head>
    <body bgcolor="#e6EEEE" link="white" vlink="#BFEFFF" alink="#00FF7F" onload="horizontal();">
        <div id="geral">
        	<div id="geral2" align="center">
        	<!-- Main -->
        		<div id="wrapper">
            		<!-- Renders the page header -->
            		<layout:header usuario="${usuario}"/>
 
            		<!-- Renders the tag body inside a DIV -->
            		<div id="content"><jsp:doBody/>
						<div id="conteudo">
        				</div>
					</div>
 
            		<!-- Renders the page footer -->
            		<layout:footer/>
        		</div> <!-- Main -->
 			</div> 
    	</div>
        <!-- Process the given input fragment -->
        <jsp:invoke fragment="extraBottom"/>
    </body>
</html>
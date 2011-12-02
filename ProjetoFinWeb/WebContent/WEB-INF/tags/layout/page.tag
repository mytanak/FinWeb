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
        <link rel="stylesheet" type="text/css" href="css/screen.css"/>
        <link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" media="all"/>
        
		<script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery.maskedinput-1.3.min.js"></script>
        <script type="text/javascript" src="js/formatdate.js"></script>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/ddsmoothmenu.js"></script>
        <script type="text/javascript" src="js/menu.js"></script>
		<script type="text/javascript" src="js/jquery-ui.min.js"></script>
		<script type="text/javascript" src="js/tab.js"></script>
		<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="js/jquery.price_format.1.5.js"></script>		
		<script type="text/javascript" src="js/format.js"></script>		
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		
		<script type="text/javascript" src="js/validacao/validaConta.js"></script>
		<script type="text/javascript" src="js/validacao/validaLogin.js"></script>
		<script type="text/javascript" src="js/validacao/validaUsuario.js"></script>		
		<script type="text/javascript" src="js/validacao/validaLancamento.js"></script>
		<script type="text/javascript" src="js/validacao/validaOperacao.js"></script>
		<script type="text/javascript" src="js/validacao/validaGrupo.js"></script>
		<script type="text/javascript" src="js/validacao/validaFornecedor.js"></script>
		<script type="text/javascript" src="js/validacao/validaModalidade.js"></script>
		        
        <!-- Process the given input fragment -->
        <jsp:invoke fragment="extraHeader"/>
    </head>
    <body bgcolor="#e6EEEE" link="white" vlink="#BFEFFF" alink="#00FF7F" onload="horizontal();">
        <div id="geral">
        	<div id="geral2" align="center">
        	<!-- Main -->
           		<!-- Renders the page header -->
           		<layout:header usuario="${usuario}"/>

           		<!-- Renders the tag body inside a DIV -->
           		
				<jsp:doBody/>

           		<!-- Renders the page footer -->
           		<layout:footer/>
 			</div> 
        	<!-- Main -->
    	</div>
        <!-- Process the given input fragment -->
        <jsp:invoke fragment="extraBottom"/>
    </body>
</html>
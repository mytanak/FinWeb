<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Index page" description="This is the index page of my amazing app" keywords="amazing, app">
    <c:if test="${login != null}">
    <jsp:body>
    Home
	</jsp:body>  
    </c:if>    
</layout:page>
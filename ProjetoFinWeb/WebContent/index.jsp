<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="" title="Index page" description="This is the index page of my amazing app" keywords="amazing, app">
    <jsp:body>
    <table>
		<tr>
			<td width="60%">
			Conteudo
			</td>
			<td>
				<c:import url="login.jsp" />							
			</td>
		</tr>
	</table>
	
    </jsp:body>
</layout:page>
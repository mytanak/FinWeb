<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Detalhes do Grupo" description="Detalhes do Grupo" keywords="grupo">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
	<c:forEach var="Grupo" items="${listGrupo}">
    <form name="grupo" action="#" method="post">
		<FIELDSET>
		<LEGEND>Detalhes do Grupo</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=descricao>Descrição:</LABEL>
    				</td>
    				<td align="left"> 
    					<input readonly="readonly" type="text" name="descricao" size="50" value="${Grupo.descricao}"/>
    				</td>
    			</tr>			
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<A class=botao href="listarGrupo.jsp">Voltar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
	</c:forEach>
	</div>	
    </jsp:body>
    </c:if>
</layout:page>
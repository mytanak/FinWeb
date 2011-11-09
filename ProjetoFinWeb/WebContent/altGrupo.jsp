<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Editar Grupo" description="Editar de Grupo" keywords="grupo">
    <c:if test="${login != null}">
    <jsp:body>
    <c:if test="${msg != null}">
    ${msg}
    </c:if>
    <form name="grupo" action="ConfirmarEditarGrupo" method="post">
		<FIELDSET>
		<LEGEND>Edição de Grupos</LEGEND>
			<table>
				<tr>
					<td>
    					<LABEL accessKey=1 for=descricao>Descrição:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="descricao" size="50" value="${Grupo.descricao}"/>
    				</td>
    			</tr>			
    		</table>
			<table align="right">
    			<tr>
					<td>
				    	<input type="hidden" name="codGrupo" value="${Grupo.codGrupo}" />
				    	<BUTTON class=botao name=gravar type=submit>Confirmar Edição</BUTTON>
				    	<BUTTON class=botao name=cancelar type=reset>Cancelar</BUTTON>
				    	<A class=botao href="home.jsp">Voltar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
		
    </jsp:body>
    </c:if>
</layout:page>
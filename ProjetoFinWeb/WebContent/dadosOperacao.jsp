<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Editar Despesa/Receita" description="Editar Despesa/Receita" keywords="despesas, receitas">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
    <c:forEach var="Operacao" items="${listOperacao}">
    <form id="formOperacao" name="operacao" action="ConfirmarEditarOperacao" method="post">
		<FIELDSET>
		<LEGEND>Editar Despesa/Receita</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=descricao>Descrição:</LABEL>
    				</td>
    				<td align="left"> 
    					<input readonly="readonly" type="text" name="descricao" size="50" value="${Operacao.descricao}">
    				</td>
    			</tr>			
				<tr>
					<td>
    					<LABEL accessKey=2 for=tipo>Tipo:</LABEL>
    				</td>
    				<td align="left"> 
    					<input readonly="readonly" type="text" name="tipo" size="20" value="${Operacao.tipoStr}">
    				</td>
    			</tr>			
				<tr>
					<td>
    					<LABEL accessKey=3 for=codGrupo>Grupo:</LABEL>
    				</td>
    				<td align="left"> 
    					<input readonly="readonly" type="text" name="codGrupo" size="50" value="${Operacao.descGrupo}">
    				</td>
    			</tr>			
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<A class=botao href="listarOperacao.jsp">Voltar</A>
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
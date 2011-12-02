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
    <jsp:useBean id="dao" class="br.com.etectupa.dao.GrupoDAO" />
    <form id="formOperacao" name="operacao" action="ConfirmarEditarOperacao" method="post">
		<FIELDSET>
		<LEGEND>Editar Despesa/Receita</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=descricao>Descrição:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="descricao" size="50" value="${Operacao.descricao}">
    				</td>
    			</tr>			
				<tr>
					<td>
    					<LABEL accessKey=2 for=tipo>Tipo:</LABEL>
    				</td>
    				<td align="left"> 
    					<select name="tipo">
    						<c:if test="${Operacao.tipo == 'D'}">
								<option value="${Operacao.tipo}" SELECTED>Débito</option>
								<option value="C">Crédito</option>
							</c:if>
							<c:if test="${Operacao.tipo == 'C'}">
								<option value="${Operacao.tipo}" SELECTED>Crédito</option>
								<option value="D">Débito</option>
							</c:if>
						</select>
    				</td>
    			</tr>			
				<tr>
					<td>
    					<LABEL accessKey=3 for=codGrupo>Grupo:</LABEL>
    				</td>
    				<td align="left"> 
    					<select name="codGrupo">
							<c:forEach var="grupos" items="${dao.lista}" varStatus="id">
								<c:if test="${Operacao.codGrupo == grupos.codGrupo}">
									<option value="${grupos.codGrupo}" SELECTED>${grupos.descricao}</option>
								</c:if>
								<c:if test="${Operacao.codGrupo != grupos.codGrupo}">
									<option value="${grupos.codGrupo}">${grupos.descricao}</option>
								</c:if>
							</c:forEach>
						</select>
    				</td>
    			</tr>			
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<input type="hidden" name="codOperacao" value="${Operacao.codOperacao}" />
				    	<BUTTON class=botao name=gravar type=submit>Confirmar Edição</BUTTON>
				    	<A class=botao href="listarOperacao.jsp">Cancelar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
	</div>	
    </jsp:body>
    </c:if>
</layout:page>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Cadastrar Despesa/Receita" description="Cadastrar Despesa/Receita" keywords="despesas, receitas">
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
    <form id="formOperacao" name="operacao" action="GravarOperacao" method="post">
		<FIELDSET>
		<LEGEND>Cadastrar Despesa/Receita</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=descricao>Descrição:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="descricao" size="50">
    				</td>
    			</tr>			
				<tr>
					<td>
    					<LABEL accessKey=2 for=tipo>Tipo:</LABEL>
    				</td>
    				<td align="left"> 
    					<select name="tipo">
							<option value="" SELECTED>Escolha</option>
							<option value="D">Débito</option>
							<option value="C">Crédito</option>
						</select>
    				</td>
    			</tr>			
				<tr>
					<td>
    					<LABEL accessKey=3 for=codGrupo>Grupo:</LABEL>
    				</td>
    				<td align="left"> 
    					<select name="codGrupo">
							<option value="" SELECTED>Escolha</option>
							<c:forEach var="grupos" items="${dao.lista}" varStatus="id">
								<option value="${grupos.codGrupo}">${grupos.descricao}</option>
							</c:forEach>
						</select>
    				</td>
    			</tr>			
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<BUTTON class=botao name=gravar type=submit>Gravar</BUTTON>
				    	<BUTTON class=botao name=limpar type=reset>Limpar</BUTTON>
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
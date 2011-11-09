<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Cadastro de Despesas e Receitas" description="Cadastro de Despesas e Receitas" keywords="despesas, receitas">
    <c:if test="${login != null}">
    <jsp:body>
    <c:if test="${msg != null}">
    ${msg}
    </c:if>
    <jsp:useBean id="dao" class="br.com.etectupa.dao.GrupoDAO" />
    <form name="operacao" action="GravarOperacao" method="post">
		<FIELDSET>
		<LEGEND>Cadastro de Despesas e Receitas</LEGEND>
			<table>
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
							<option value="0" SELECTED>Escolha</option>
							<c:forEach var="grupos" items="${dao.lista}" varStatus="id">
								<option value="${grupos.codGrupo}">${grupos.descricao}</option>
							</c:forEach>
						</select>
    				</td>
    			</tr>			
    		</table>
			<table align="right">
    			<tr>
					<td>
				    	<BUTTON class=botao name=gravar type=submit>Gravar</BUTTON>
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
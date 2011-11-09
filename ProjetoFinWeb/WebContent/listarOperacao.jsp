<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<layout:page usuario="${login}" title="Cadastro de Operacao" description="Cadastro de Operacao" keywords="operacao">
    <c:if test="${login != null}">
    <jsp:body>
	<jsp:useBean id="dao" class="br.com.etectupa.dao.OperacaoDAO" />
	<jsp:useBean id="grupodao" class="br.com.etectupa.dao.GrupoDAO" />
	<c:if test="${msg != null}">
	${msg}
	</c:if>
	<FIELDSET>
		<LEGEND>Cadastro de Despesas/Receitas</LEGEND>
	<table id="tablesordem" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
	        <thead>
	        <tr>
				<th>Código</th>
				<th>Descrição</th>
				<th>Tipo</th>
				<th>Grupo</th>
				<th align="center" >Editar</th>
				<th align="center" >Excluir</th>
			</tr>
			</thead>
			<tbody>
			
		<c:forEach var="operacoes" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'e6EEEE' : 'ffffff' }">
				<td>${operacoes.codOperacao}</td>
				<td>${operacoes.descricao}</td>
				<c:if test="${operacoes.tipo == 'D'}">
				<td>Débito</td>
				</c:if>
				<c:if test="${operacoes.tipo == 'C'}">
				<td>Crédito</td>
				</c:if>	
				<c:forEach var="grupos" items="${grupodao.lista}">
					<c:if test="${operacoes.codGrupo == grupos.codGrupo}">
						<td>${grupos.descricao}</td>
					</c:if>				
				</c:forEach>			
				<td align="center" ><a class="botao1" href="EditarOperacao?codOperacao=${operacoes.codOperacao}">Editar</a></td>
				<td align="center" ><a class="botao1" href="ExcluirOperacao?codOperacao=${operacoes.codOperacao}">Excluir</a></td>
			</tr>
			</tbody>
			
		</c:forEach>
	</table>	
	</FIELDSET>
</jsp:body>
</c:if>
</layout:page>
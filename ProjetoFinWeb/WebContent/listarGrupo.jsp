<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<layout:page usuario="${login}" title="Cadastro de Grupo" description="Cadastro de Grupo" keywords="grupo">
    <c:if test="${login != null}">
    <jsp:body>
	<jsp:useBean id="dao" class="br.com.etectupa.dao.GrupoDAO" />
	<c:if test="${msg != null}">
	${msg}
	</c:if>
	<FIELDSET>
		<LEGEND>Cadastro de Grupos</LEGEND>
	<table id="tablesordem" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
	        <thead>
	        <tr>
				<th>Código</th>
				<th>Descrição</th>
				<th align="center" >Editar</th>
				<th align="center" >Excluir</th>
			</tr>
			</thead>
			<tbody>
			
		<c:forEach var="grupos" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'e6EEEE' : 'ffffff' }">
				<td>${grupos.codGrupo}</td>
				<td>${grupos.descricao}</td>
				<td align="center" ><a class="botao1" href="EditarGrupo?codGrupo=${grupos.codGrupo}">Editar</a></td>
				<td align="center" ><a class="botao1" href="ExcluirGrupo?codGrupo=${grupos.codGrupo}">Excluir</a></td>
			</tr>
			</tbody>
			
		</c:forEach>
	</table>	
	</FIELDSET>
</jsp:body>
</c:if>
</layout:page>
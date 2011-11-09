<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<layout:page usuario="${login}" title="Cadastro de Usuario" description="Cadastro de Conta" keywords="conta">
    <c:if test="${login != null}">
    <jsp:body>
	<jsp:useBean id="dao" class="br.com.etectupa.dao.UsuarioDAO" />
	<c:if test="${msg != null}">
	${msg}
	</c:if>
	<FIELDSET>
		<LEGEND>Cadastro de Usuarios</LEGEND>
	<table id="tablesordem" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
	        <thead>
	        <tr>
				<th>Código</th>
				<th>Identificação</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th align="center" >Data Nascimento</th>
				<th align="center" >Editar</th>
				<th align="center" >Excluir</th>
			</tr>
			</thead>
			<tbody>
			
		<c:forEach var="usuarios" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'e6EEEE' : 'ffffff' }">
				<td>${usuarios.codUsuario}</td>
				<td>${usuarios.idUsuario}</td>
				<td>${usuarios.nome}</td>
				<td>${usuarios.email}</td>
				<td align="center" >${usuarios.dataNascimento}</td>
				<td align="center" ><a class="botao1" href="EditarUsuario?codUsuario=${usuarios.codUsuario}">Editar</a></td>
				<td align="center" ><a class="botao1" href="ExcluirUsuario?codUsuario=${usuarios.codUsuario}">Excluir</a></td>
			</tr>
			</tbody>
			
		</c:forEach>
	</table>	
	</FIELDSET>
</jsp:body>
</c:if>
</layout:page>
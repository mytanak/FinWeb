<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<layout:page usuario="${login}" title="Cadastro de Conta" description="Cadastro de Conta" keywords="conta">
    <c:if test="${login != null}">
    <jsp:body>
	<jsp:useBean id="dao" class="br.com.etectupa.dao.ContaDAO" />
	<c:if test="${msg != null}">
	${msg}
	</c:if>
	<jsp:useBean id="usuarioDao" class="br.com.etectupa.dao.UsuarioDAO" />
    
	<c:forEach var="usuarios" items="${usuarioDao.lista}" varStatus="id">
	    <c:if test="${usuarios.idUsuario == login}">
	        <c:set var="codigoUsuario" value="${usuarios.codUsuario}"/>
		</c:if>	
	</c:forEach> 
	<FIELDSET>
		<LEGEND>Cadastro de Contas</LEGEND>
		<table id="tablesordem" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
	        <thead>
	        <tr>
				<th>Código Conta</th>
				<th>Descrição</th>
				<th align="right">Saldo Inicial</th>			
				<th align="center">Editar</th>
				<th align="center">Excluir</th>
			</tr>
			</thead>
			<tbody>
			
				<c:forEach var="contas" items="${dao.lista}" varStatus="id">
					<c:if test="${contas.codUsuario == codigoUsuario}">
						<tr bgcolor="#${id.count % 2 == 0 ? 'e6EEEE' : 'ffffff' }">
							<td>${contas.codConta}</td>
							<td>${contas.descricao}</td>
							<td align="right">${contas.saldoInicial}</td>
							
							<td align="center" ><a class="botao1" href="EditarConta?codConta=${contas.codConta}">Editar</a></td>
							<td align="center" ><a class="botao1" href="ExcluirConta?codConta=${contas.codConta}">Excluir</a></td>
						</tr>
					</c:if>	
				</c:forEach>			
			</tbody>
	</table>	
	</FIELDSET>
</jsp:body>
</c:if>
</layout:page>
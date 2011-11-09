<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Listar Fornecedor" description="Cadastro de Fornecedor" keywords="fornecedor">
    <c:if test="${login != null}">
    <jsp:body>
	<jsp:useBean id="dao" class="br.com.etectupa.dao.FornecedorDAO" />
	<c:if test="${msg != null}">
	${msg}
	</c:if>
	<FIELDSET>
		<LEGEND>Cadastro de Fornecedor</LEGEND>
	<table id="tablesordem" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
	        <thead>
	        <tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Editar</th>
				<th>Excluir</th>
			</tr>
			</thead>
			<tbody>
			
		<c:forEach var="fornecedor" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'e6EEEE' : 'ffffff' }">
				<td>${fornecedor.codFornecedor}</td>
				<td>${fornecedor.nome}</td>
				<td align="center" ><a class="botao1" href="EditarFornecedor?codFornecedor=${fornecedor.codFornecedor}">Editar</a></td>
				<td align="center" ><a class="botao1" href="ExcluirFornecedor?codFornecedor=${fornecedor.codFornecedor}">Excluir</a></td>
			</tr>
			</tbody>
			
		</c:forEach>
	</table>	
	</FIELDSET>
</jsp:body>
</c:if>
</layout:page>
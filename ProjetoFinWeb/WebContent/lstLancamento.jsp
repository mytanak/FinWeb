<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<layout:page usuario="${login}" title="Lançamentos" description="Lançamentos" keywords="lançamento">
    <c:if test="${login != null}">
    <jsp:body>
	<jsp:useBean id="contaDao" class="br.com.etectupa.dao.ContaDAO" />
    <jsp:useBean id="operacaoDao" class="br.com.etectupa.dao.OperacaoDAO" />
    <jsp:useBean id="modalidadeDao" class="br.com.etectupa.dao.ModalidadeDAO" />
    <jsp:useBean id="fornecedorDao" class="br.com.etectupa.dao.FornecedorDAO" />
	
	<c:if test="${msg != null}">
	${msg}
	</c:if>
	<FIELDSET>
		<LEGEND>Lançamentos</LEGEND>
	<table id="tablesordem" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
	        <thead>
	        <tr>
				<th>Conta</th>
				<th>Número</th>				
				<th>Vencimento</th>
				<th>Realização</th>
				<th>Descrição</th>
				<th>Modalidade</th>
				<th>Fornecedor</th>
				<th>Valor</th>
				<th>Observação</th>
				<th align="center" >Editar</th>
				<th align="center" >Excluir</th>
			</tr>
			</thead>
			<tbody>
			
		<c:forEach var="lancamentos" items="${lctosConta}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'e6EEEE' : 'ffffff' }">
				<c:forEach var="contas" items="${contaDao.lista}">
					<c:if test="${lancamentos.codConta == contas.codConta}">
						<td>${contas.descricao}</td>
					</c:if>				
				</c:forEach>
				<td>${lancamentos.nroLancamento}</td>
				<td>${lancamentos.dataVencimento}</td>
				<td>${lancamentos.dataRealizada}</td>
				<c:forEach var="operacoes" items="${operacaoDao.lista}">
					<c:if test="${lancamentos.codOperacao == operacoes.codOperacao}">
						<td>${operacoes.descricao}</td>
					</c:if>				
				</c:forEach>
				<c:forEach var="modalidades" items="${modalidadeDao.lista}">
					<c:if test="${lancamentos.codModalidade == modalidades.codModalidade}">
						<td>${modalidades.descricao}</td>
					</c:if>				
				</c:forEach>
				<c:forEach var="fornecedores" items="${fornecedorDao.lista}">
					<c:if test="${lancamentos.codFornecedor == fornecedores.codFornecedor}">
						<td>${fornecedores.nome}</td>
					</c:if>				
				</c:forEach>
				<td>${lancamentos.valor}</td>
				<td>${lancamentos.observacao}</td>
				<td align="center" ><a class="botao1" href="EditarLancamento?nroLancamento=${lancamentos.nroLancamento}">Editar</a></td>
				<td align="center" ><a class="botao1" href="ExcluirLancamento?nroLancamento=${lancamentos.nroLancamento}">Excluir</a></td>
			</tr>
			</tbody>
			
		</c:forEach>
	</table>	
	</FIELDSET>
</jsp:body>
</c:if>
</layout:page>
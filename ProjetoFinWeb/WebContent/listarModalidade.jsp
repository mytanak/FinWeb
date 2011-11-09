<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<layout:page usuario="${login}" title="Cadastro de Modalidade" description="Cadastro de Modalidade" keywords="modalidade">
    <c:if test="${login != null}">
    <jsp:body>
	<jsp:useBean id="dao" class="br.com.etectupa.dao.ModalidadeDAO" />
	<c:if test="${msg != null}">
	${msg}
	</c:if>
	<FIELDSET>
		<LEGEND>Cadastro de Modalidades</LEGEND>
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
			
		<c:forEach var="modalidades" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'e6EEEE' : 'ffffff' }">
				<td>${modalidades.codModalidade}</td>
				<td>${modalidades.descricao}</td>
				<td align="center" ><a class="botao1" href="EditarModalidade?codModalidade=${modalidades.codModalidade}">Editar</a></td>
				<td align="center" ><a class="botao1" href="ExcluirModalidade?codModalidade=${modalidades.codModalidade}">Excluir</a></td>
			</tr>
			</tbody>
			
		</c:forEach>
	</table>	
	</FIELDSET>
</jsp:body>
</c:if>
</layout:page>
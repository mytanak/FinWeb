<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="br.com.etectupa.displaytag.collection.ListFornecedor" %>

<%
request.setAttribute( "listFornecedor", new ListFornecedor());
%>
<layout:page usuario="${login}" title="Fornecedores" description="Fornecedores" keywords="fornecedor">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
		<FIELDSET>
		<LEGEND>Fornecedores</LEGEND>
		<br/>
		<div align="right">
		<A class=botao href="cadFornecedor.jsp">Novo</A>
		</div>		
		<display:table name="listFornecedor" export="false" sort="list" pagesize="8">
		    <display:column property="codFornecedor" title="Código" group="1" sortable="true" headerClass="sortable" href="ConsultaDadosFornecedor" paramId="codFornecedor" paramProperty="codFornecedor"/>
		    <display:column property="nome" title="Nome" group="2" sortable="true" headerClass="sortable"  href="ConsultaDadosFornecedor" paramId="codFornecedor" paramProperty="codFornecedor"/>
		    <display:column title="Editar" href="EditarFornecedor" paramId="codFornecedor" paramProperty="codFornecedor" >Editar</display:column>
		    <display:column title="Excluir" href="ExcluirFornecedor" paramId="codFornecedor" paramProperty="codFornecedor" >Excluir</display:column>
		    
		  </display:table>
		  </FIELDSET>	
	</div>
</jsp:body>
</c:if>
</layout:page>
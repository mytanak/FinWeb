<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="br.com.etectupa.displaytag.collection.ListOperacao" %>

<%
request.setAttribute( "listOperacao", new ListOperacao() );
%>

<layout:page usuario="${login}" title="Despesas/Receitas" description="Despesas/Receitas" keywords="operações">
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
		<LEGEND>Despesas/Receitas</LEGEND>
		<br/>
		<div align="right">
		<A class=botao href="cadOperacao.jsp">Novo</A>
		</div>
		
		<display:table name="listOperacao" export="false" sort="list" pagesize="8">
		    <display:column property="codOperacao" title="Código" group="1" sortable="true" headerClass="sortable" href="ConsultaDadosOperacao" paramId="codOperacao" paramProperty="codOperacao"/>
		    <display:column property="descricao" title="Descrição" group="2" sortable="true" headerClass="sortable" href="ConsultaDadosOperacao" paramId="codOperacao" paramProperty="codOperacao"/>
		    
		    <display:column title="Editar" href="EditarOperacao" paramId="codOperacao" paramProperty="codOperacao" >Editar</display:column>
		    <display:column title="Excluir" href="ExcluirOperacao" paramId="codOperacao" paramProperty="codOperacao" >Excluir</display:column>
		    
		  </display:table>
		  </FIELDSET>
		  </div>
	</jsp:body>		
	</c:if>
</layout:page>
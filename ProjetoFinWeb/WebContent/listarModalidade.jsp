<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="br.com.etectupa.displaytag.collection.ListModalidade" %>

<%
request.setAttribute( "listModalidade", new ListModalidade() );
%>

<layout:page usuario="${login}" title="Modalidades de Pagamento/Recebimento" description="Modalidades de Pagamento/Recebimento" keywords="modalidade, pagamento, recebimento">
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
		<LEGEND>Modalidades de Pagamento/Recebimento</LEGEND>
		<br/>
		<div align="right">
		<A class=botao href="cadModalidade.jsp">Novo</A>
		</div>
		
		<display:table name="listModalidade" export="false" sort="list" pagesize="8">
		    <display:column property="codModalidade" title="Código" group="1" sortable="true" headerClass="sortable" href="ConsultaDadosModalidade" paramId="codModalidade" paramProperty="codModalidade"/>
		    <display:column property="descricao" title="Descricao" group="2" sortable="true" headerClass="sortable" href="ConsultaDadosModalidade" paramId="codModalidade" paramProperty="codModalidade"/>
		    <display:column title="Editar" href="EditarModalidade" paramId="codModalidade" paramProperty="codModalidade" >Editar</display:column>
		    <display:column title="Excluir" href="ExcluirModalidade" paramId="codModalidade" paramProperty="codModalidade" >Excluir</display:column>
		    
		  </display:table>
		  </FIELDSET>
</div>
</jsp:body>
</c:if>
</layout:page>
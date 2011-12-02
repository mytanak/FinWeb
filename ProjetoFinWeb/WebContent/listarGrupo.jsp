<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="br.com.etectupa.displaytag.collection.ListGrupo" %>
<%
request.setAttribute( "listGrupo", new ListGrupo() );
%>
<layout:page usuario="${login}" title="Grupos de Despesas/Receitas" description="Grupos de Despesas/Receitas" keywords="grupo">
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
		<LEGEND>Grupos de Despesas/Receitas</LEGEND>
		<br/>
		<div align="right">
		<A class=botao href="cadGrupo.jsp">Novo</A>
		</div>
		
		<display:table name="listGrupo" export="false" sort="list" pagesize="8">
		    <display:column property="codGrupo" title="Código" group="1" sortable="true" headerClass="sortable"  href="ConsultaDadosGrupo" paramId="codGrupo" paramProperty="codGrupo"/>
		    <display:column property="descricao" title="Descrição" group="2" sortable="true" headerClass="sortable"  href="ConsultaDadosGrupo" paramId="codGrupo" paramProperty="codGrupo"/>
		    <display:column title="Editar" href="EditarGrupo" paramId="codGrupo" paramProperty="codGrupo" >Editar</display:column>
		    <display:column title="Excluir" href="ExcluirGrupo" paramId="codGrupo" paramProperty="codGrupo" >Excluir</display:column>
		    
		  </display:table>
		 </FIELDSET>
		 </div>
</jsp:body>
</c:if>
</layout:page>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="br.com.etectupa.displaytag.collection.ListUsuario" %>

<%
request.setAttribute( "listUsuario", new ListUsuario() );
%>

<layout:page usuario="${login}" title="Usuários" description="Usuários" keywords="usuário">
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
		<LEGEND>Usuários</LEGEND>
		<br/>
		<div align="right">
		<A class=botao href="cadUsuario.jsp">Novo</A>
		</div>
		
		<display:table name="listUsuario" export="false" sort="list" pagesize="8">
		    <display:column property="codUsuario" title="Código" group="1" sortable="true" headerClass="sortable" />
		    <display:column property="idUsuario" title="Identificação" group="2" sortable="true" headerClass="sortable" />
		    <display:column property="nome" title="Nome" group="2" sortable="true" headerClass="sortable" />
		    <display:column property="email" title="E-mail" autolink="true"/>
		    <display:column property="dataNascimento" title="Data Nascimento" format="{0,date,dd/MM/yyyy}" />  	  
		    <display:column title="Editar" href="EditarUsuario" paramId="codUsuario" paramProperty="codUsuario" >Editar</display:column>
		    <display:column title="Excluir" href="ExcluirUsuario" paramId="codUsuario" paramProperty="codUsuario" >Excluir</display:column>
		    
		  </display:table>
		  </FIELDSET>
		  </div>
	</jsp:body>		
	</c:if>
</layout:page>
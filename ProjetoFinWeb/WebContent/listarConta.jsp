<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="br.com.etectupa.displaytag.collection.ListConta" %>
<%@ page import="br.com.etectupa.collection.ResumoConta" %>

<c:set var="idUsuario" value="${login}"/>
<%
String idUsuario = (String) pageContext.getAttribute("idUsuario");
request.setAttribute( "listConta", new ListConta(idUsuario));
request.setAttribute( "resumoConta", new ResumoConta(idUsuario));

%>

<layout:page usuario="${login}" title="Contas" description="Contas" keywords="conta">
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
		<LEGEND>Contas</LEGEND>
		<br/>
		<div align="right">
		<A class=botao href="cadConta.jsp">Novo</A>
		</div>
		<display:table name="listConta" export="false" sort="list" pagesize="8">
		    <display:column property="codConta" title="Código" sortable="true" headerClass="sortable" href="ConsultaDadosConta" paramId="codConta" paramProperty="codConta"/>
		    <display:column property="descricao" title="Descrição das Contas" sortable="true" headerClass="sortable" href="ConsultaDadosConta" paramId="codConta" paramProperty="codConta"/>
		    <display:column property="saldoInicial" title="Saldo Inicial" format="{0,number,#,##0.00}" headerClass="r" class="r"/>
		    <display:column property="saldoAtual" title="Saldo Atual" format="{0,number,#,##0.00}" headerClass="r" class="r"/>
		   
		    <display:column title="Editar" href="EditarConta" paramId="codConta" paramProperty="codConta" >Editar</display:column>
		    <display:column title="Excluir" href="ExcluirConta" paramId="codConta" paramProperty="codConta" >Excluir</display:column>
		    
		</display:table>
	   
		<div>		
		<c:forEach var="resumo" items="${resumoConta }">
		<div class="divresumogeral">
		    <fieldset>
		    <legend>Resumo Geral das Contas</legend> 			
			<div class="divesquerda" >
				Saldo Inicial
			</div>
			<div class="divdireita">
				<fmt:formatNumber  pattern="#,##0.00">${resumo.saldoInicial }</fmt:formatNumber>								
			</div>
			<div class="divesquerda">
				Saldo Atual
			</div>
			<div class="divdireita">
				<fmt:formatNumber  pattern="#,##0.00">${resumo.saldo }</fmt:formatNumber>				
			</div>
			</fieldset>
		</div>
		</c:forEach>	
		</div>
		
		
		</FIELDSET>
		</div>
	</jsp:body>		
	</c:if>
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
	
</layout:page>

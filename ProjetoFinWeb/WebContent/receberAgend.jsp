<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/cewolf-1.1.tld" prefix="cewolf"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@ page import="br.com.etectupa.displaytag.collection.ListLancamento" %>
<%@ page import="br.com.etectupa.util.Biblioteca" %>
<%@ page import="br.com.etectupa.util.Convert" %>

<c:set var="idUsuario" value="${login}"/>
<%
String idUsuario = (String) pageContext.getAttribute("idUsuario");

ListLancamento proximos = new ListLancamento(idUsuario, 3, Biblioteca.Today());

request.setAttribute( "mesAtualStr", Biblioteca.retornaMesStr(Biblioteca.retornaMes(Biblioteca.Today())));
request.setAttribute( "anoAtualStr", Biblioteca.retornaAno(Biblioteca.Today()));

request.setAttribute( "proximos", proximos);

%>
<div class="conteudoSubTab">
	<div class="divgeral3">
	    <display:table name="proximos" defaultsort="1" defaultorder="descending" decorator="org.displaytag.decorator.TotalTableDecorator">
		    <display:column style="width: 100px;"  property="dataVencimentoStr" title="Vencimento" headerClass="sortable"/>
		    <display:column property="descOperacao" title="Descrição" headerClass="sortable"/>
		    <display:column style="width: 150px;" property="valor" title="Valor" format="{0,number,#,##0.00}" headerClass="r" class="r" total="true"/>
		</display:table>		
	</div>

</div>	
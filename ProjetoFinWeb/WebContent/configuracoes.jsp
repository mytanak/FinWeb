<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/cewolf-1.1.tld" prefix="cewolf"%>
<%@ page import="br.com.etectupa.collection.ResumoLancamento" %>

<c:set var="idUsuario" value="${login}"/>
<%
String idUsuario = (String) pageContext.getAttribute("idUsuario");
request.setAttribute( "resumoLancamento", new ResumoLancamento(idUsuario));
%>

<layout:page usuario="${login}" title="Index page" description="This is the index page of my amazing app" keywords="amazing, app">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
    <DIV class="tabs">
            <UL>
              <LI><A href="#tabs-1">Configurações da Conta</A></LI>
                           
            </UL>
            
            <DIV id="tabs-1" >
            <div class="conteudotab">
            	<c:if test="${param.origem == 'conf'}">
            		<c:import url="altSenha.jsp"></c:import>
            	</c:if>		
            	<c:if test="${param.origem != 'conf'}">
            		<c:import url="dadosUsuario.jsp"></c:import>
            	</c:if>		
				
			</div>
            </DIV>
            
            
            </DIV>
    </div>    
	</jsp:body>  
    </c:if>    
</layout:page>
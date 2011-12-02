<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<layout:page usuario="${login}" title="Index page" description="This is the index page of my amazing app" keywords="amazing, app">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
    	<DIV class="tabs">
            <UL>
              <LI><A href="#tabs-1">Principal</A></LI>
              <LI><A href="#tabs-2">Contas a Pagar</A></LI>
              <LI><A href="#tabs-3">Contas a Receber</A></LI>
              
            </UL>
            
            <DIV id="tabs-1" >
	            <div class="conteudotab">
		            <DIV class="tabs">
		            	<UL>
		              	<LI><A href="#tabs-4">Geral</A></LI>
		              	<LI><A href="#tabs-5">Despesas X Receitas</A></LI>
		              	<LI><A href="#tabs-10">Grupos de Despesas</A></LI>
		              	<LI><A href="#tabs-11">Grupos de Receitas</A></LI>
		            	</UL>
		            	<DIV id="tabs-4">
		            		<c:import url="geral.jsp"></c:import>
		            	</DIV>
		            	<DIV id="tabs-5">
		            		<c:import url="despesasreceitas.jsp"></c:import>
		            	</DIV>
		            	<DIV id="tabs-10">
		            		<c:import url="gruposdespesas.jsp"></c:import>
		            	</DIV>
		            	<DIV id="tabs-11">
		            		<c:import url="gruposreceitas.jsp"></c:import>
		            	</DIV>
		            </DIV>		        	
				</div>
            </DIV>
            
            <DIV id="tabs-2">
	            <div class="conteudotab">	            	            
		            <DIV class="tabs">
			            <UL>
			              <LI><A href="#tabs-6">Pagamentos Agendados</A></LI>
			              <LI><A href="#tabs-7">Pagamentos Atrasados</A></LI>
			            </UL>
			            <DIV id="tabs-6">
			            	<c:import url="pagarAgend.jsp"></c:import>
			            </DIV>
			            <DIV id="tabs-7">
			            	<c:import url="pagarAtraso.jsp"></c:import>
			            </DIV>
		            </DIV>
	            </div>
            </DIV>
            
            <DIV id="tabs-3">
	            <div class="conteudotab">	            	            
		            <DIV class="tabs">
			            <UL>
			              <LI><A href="#tabs-8">Pagamentos Agendados</A></LI>
			              <LI><A href="#tabs-9">Pagamentos Atrasados</A></LI>
			            </UL>
			            <DIV id="tabs-8">
			            	<c:import url="receberAgend.jsp"></c:import>
			            </DIV>
			            <DIV id="tabs-9">
			            	<c:import url="receberAtraso.jsp"></c:import>
			            </DIV>
		            </DIV>
	            </div>
            </DIV>
    	</DIV>
    </div>    
	</jsp:body>  
    </c:if>    
</layout:page>
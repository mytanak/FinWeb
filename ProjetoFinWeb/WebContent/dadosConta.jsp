<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<layout:page usuario="${login}" title="Detalhes da Conta" description="Detalhes da Conta" keywords="conta">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
    <c:forEach var="Conta" items="${listConta}">
    <form name="conta" action="#" method="post">
		<FIELDSET>
		<LEGEND>Detalhes da Conta</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=descricao>Descrição:</LABEL>
    				</td>
    				<td align="left"> 
    					<input readonly="readonly" type="text" name="descricao" size="50" value="${Conta.descricao}"/>
    				</td>
    			</tr>
    			<tr>    			
    				<td>
		    			<LABEL accessKey=2 for=saldoInicial>Saldo Inicial:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<fmt:formatNumber var="saldoInicial" pattern="#,##0.00">${Conta.saldoInicial}</fmt:formatNumber>
		    			<input id="mask-number" class="direita" readonly="readonly" id=numero type="text" name="saldoInicial" size="10" value="${saldoInicial}"/>
		    		</td>
		    	</tr>	    	
    			<tr>    			
    				<td>
		    			<LABEL accessKey=2 for=saldoAtual>Saldo Atual:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<fmt:formatNumber var="saldoAtual" pattern="#,##0.00">${Conta.saldoAtual}</fmt:formatNumber>
		    			<input id="mask-number1" class="direita" readonly="readonly" id=numero type="text" name="saldoAtual" size="10" value="${saldoAtual}"/>
		    		</td>
		    	</tr>	    	
				
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<A class=botao href="listarConta.jsp">Voltar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
	</c:forEach>
	</div>	
    </jsp:body>
    </c:if>
</layout:page>
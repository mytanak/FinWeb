<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<layout:page usuario="${login}" title="Editar Conta" description="Editar Conta" keywords="conta">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
    <form id="formConta" name="conta" action="ConfirmarEditarConta" method="post">
		<FIELDSET>
		<LEGEND>Editar Conta</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=descricao>Descrição:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="descricao" size="50" value="${Conta.descricao}"/>
    				</td>
    			</tr>
    			<tr>    			
    				<td>
		    			<LABEL accessKey=2 for=saldoInicial>Saldo Inicial:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<fmt:formatNumber var="saldoInicial" pattern="#,##0.00">${Conta.saldoInicial}</fmt:formatNumber>
		    			<input id="mask-number" class="direita" type="text" name="saldoInicial" size="10" value="${saldoInicial}"/>
		    		</td>
		    	</tr>	    	
				
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<input type="hidden" name="codConta" value="${Conta.codConta}" />
				    	<input type="hidden" name="codUsuario" value="${Conta.codUsuario}" />
				    	<BUTTON class=botao name=gravar type=submit>Confirmar Edição</BUTTON>
				    	<A class=botao href="listarConta.jsp">Cancelar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
	</div>	
    </jsp:body>
    </c:if>
</layout:page>
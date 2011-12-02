<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Cadastrar Conta" description="Cadastrar Conta" keywords="conta">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
    <form id="formConta" name="conta" action="GravarConta" method="post">
		<FIELDSET>
		<LEGEND>Cadastrar Conta</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=descricao>Descrição:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="descricao" size="50">
    				</td>
    			</tr>
    			<tr>    			
    				<td>
		    			<LABEL accessKey=2 for=saldoInicial>Saldo Inicial:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<input id="mask-number" class="direita" type="text" name="saldoInicial" size="10" value="0.00">
		    		</td>
		    	</tr>	    	
				
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<input type="hidden" name="idUsuario" value="${login}" />
				    	<BUTTON class=botao name=gravar type=submit>Gravar</BUTTON>
				    	<BUTTON class=botao name=limpar type=reset>Limpar</BUTTON>
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
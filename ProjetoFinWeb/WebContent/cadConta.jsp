<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Cadastro de Conta" description="Cadastro de Conta" keywords="conta">
    <c:if test="${login != null}">
    <jsp:body>
    <c:if test="${msg != null}">
    ${msg}
    </c:if>
    <form name="conta" action="GravarConta" method="post">
		<FIELDSET>
		<LEGEND>Cadastro de Contas</LEGEND>
			<table>
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
		    			<input id=numero type="text" name="saldoInicial" size="10">
		    		</td>
		    	</tr>	    	
				
    		</table>
			<table align="right">
    			<tr>
					<td>
				    	<input type="hidden" name="idUsuario" value="${login}" />
				    	<BUTTON class=botao name=gravar type=submit>Gravar</BUTTON>
				    	<BUTTON class=botao name=cancelar type=reset>Cancelar</BUTTON>
				    	<A class=botao href="home.jsp">Voltar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
		
    </jsp:body>
    </c:if>
</layout:page>
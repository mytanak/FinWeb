<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Cadastro de Fornecedor" description="Cadastro de Fornecedor" keywords="fornecedor">
    <c:if test="${login != null}">
    <jsp:body>
    <c:if test="${msg != null}">
    ${msg}
    </c:if>
    <form name="grupo" action="GravarFornecedor" method="post">
		<FIELDSET>
		<LEGEND>Cadastro de Fornecedores</LEGEND>
			<table>
				<tr>
					<td>
    					<LABEL accessKey=1 for=nome>Nome:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="nome" size="50">
    				</td>
    			</tr>			
    		</table>
			<table align="right">
    			<tr>
					<td>
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
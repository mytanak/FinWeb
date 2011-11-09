<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Editar Fornecedor" description="Editar de Fornecedor" keywords="fornecedor">
    <c:if test="${login != null}">
    <jsp:body>
    <c:if test="${msg != null}">
    ${msg}
    </c:if>
    <form name="fornecedor" action="ConfirmarEditarFornecedor" method="post">
		<FIELDSET>
		<LEGEND>Edição de Fornecedores</LEGEND>
			<table>
				<tr>
					<td>
    					<LABEL accessKey=1 for=nome>Nome:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="nome" size="50" value="${Fornecedor.nome}"/>
    				</td>
    			</tr>			
    		</table>
			<table align="right">
    			<tr>
					<td>
				    	<input type="hidden" name="codFornecedor" value="${Fornecedor.codFornecedor}" />
				    	<BUTTON class=botao name=gravar type=submit>Confirmar Edição</BUTTON>
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
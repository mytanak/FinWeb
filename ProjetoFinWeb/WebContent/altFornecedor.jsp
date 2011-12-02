<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Editar Fornecedor" description="Editar Fornecedor" keywords="fornecedor">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
    <form id="formFornecedor" name="fornecedor" action="ConfirmarEditarFornecedor" method="post">
		<FIELDSET>
		<LEGEND>Editar Fornecedor</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=nome>Nome:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="nome" size="50" value="${Fornecedor.nome}"/>
    				</td>
    			</tr>			
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<input type="hidden" name="codFornecedor" value="${Fornecedor.codFornecedor}" />
				    	<BUTTON class=botao name=gravar type=submit>Confirmar Edição</BUTTON>
				    	<A class=botao href="listarFornecedor.jsp">Cancelar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
	</div>	
    </jsp:body>
    </c:if>
</layout:page>
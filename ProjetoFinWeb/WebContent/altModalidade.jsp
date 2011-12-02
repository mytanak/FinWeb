<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Editar Modalidade de Pagamento/Recebimento" description="Editar Modalidade de Pagamento/Recebimento" keywords="modalidade, pagamento, recebimento">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
    <form id="formModalidade" name="modalidade" action="ConfirmarEditarModalidade" method="post">
		<FIELDSET>
		<LEGEND>Editar Modalidade de Pagamento/Recebimento</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=descricao>Descrição:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="descricao" size="50" value="${Modalidade.descricao}"/>
    				</td>
    			</tr>			
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<input type="hidden" name="codModalidade" value="${Modalidade.codModalidade}" />
				    	<BUTTON class=botao name=gravar type=submit>Confirmar Edição</BUTTON>
				    	<A class=botao href="listarModalidade.jsp">Cancelar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
	</div>	
    </jsp:body>
    </c:if>
</layout:page>
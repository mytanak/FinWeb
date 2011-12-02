<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ page import="br.com.etectupa.displaytag.collection.ListUsuario" %>

<c:set var="idUsuario" value="${login}"/>
<%
String idUsuario = (String) pageContext.getAttribute("idUsuario");
request.setAttribute("listUsuario", new ListUsuario(idUsuario));
%>

	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">

    <div>
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
	<c:forEach var="Usuario" items="${listUsuario}">
    <form id="formUsuario" name="usuario" action="AlterarSenhaUsuario" method="post">
		<FIELDSET>
		<LEGEND>Alterar Senha</LEGEND>
			<table class="normal">
		    	<tr>
		    		<td width="20%">
				    	<LABEL accessKey=3 for=senha>Informe a nova Senha:</LABEL>
				    </td>
				    <td align="left">				    	
				    	<input id="senha" type="password" name="senha" size="10" />
				    </td>
				</tr>
		    	<tr>
		    		<td>
				    	<LABEL accessKey=4 for=confirmeSenha>Confirme a nova Senha:</LABEL>
				    </td>
				    <td align="left">				    	
				    	<input type="password" name="confirmeSenha" size="10" />
				    </td>
				</tr>
				
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<input type="hidden" name="codUsuario" value="${Usuario.codUsuario}" />
				    	<BUTTON class=botao name=gravar type=submit>Confimar Alteração</BUTTON>
				    	<A class=botao href="configuracoes.jsp">Cancelar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
	</c:forEach>
	</div>	
    </c:if>


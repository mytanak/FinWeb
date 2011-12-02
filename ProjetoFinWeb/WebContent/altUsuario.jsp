<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<layout:page usuario="${login}" title="Editar Usuário" description="Editar Usuário" keywords="usuário">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
    <c:forEach var="Usuario" items="${listUsuario}">
    <form id="formUsuario" name="usuario" action="ConfirmarEditarUsuario" method="post">
		<FIELDSET>
		<LEGEND>Editar Usuário</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=idUsuario>Identificação:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" readonly="readonly" name="idUsuario" size="20" value="${Usuario.idUsuario}"/>
    				</td>
    			</tr>
    			<tr>    			
    				<td>
		    			<LABEL accessKey=2 for=nome>Nome:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<input type="text" name="nome" size="50" value="${Usuario.nome}"/>
		    		</td>
		    	</tr>
				<tr>
				    <td>				    	
				    	<LABEL accessKey=4 for=email>E-mail:</LABEL> 
				    </td>
				    <td align="left">
				    	<input type="text" name="email" size="50" value="${Usuario.email}"/>
				    </td>
				</tr>
				<tr>
					<td>				    
				    	<LABEL accessKey=5 for=dataNascimento>Data Nascimento:</LABEL>
				    </td>
				    <td align="left"> 
				    	<input class="mask-data" type="text" name="dataNascimento" size="10" value="${Usuario.dataNascimentoStr}"/>
				    </td>
				</tr>
				
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<input type="hidden" name="codUsuario" value="${Usuario.codUsuario}" />
				    	<input type="hidden" name="origem" value="${origem}" />
				    	<BUTTON class=botao name=gravar type=submit>Confimar Edição</BUTTON>
				    	<c:if test="${origem == null}">
				    		<A class=botao href="listarUsuario.jsp">Cancelar</A>
				    	</c:if>
				    	<c:if test="${origem != null}">
				    		<A class=botao href="configuracoes.jsp">Cancelar</A>
				    	</c:if>
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
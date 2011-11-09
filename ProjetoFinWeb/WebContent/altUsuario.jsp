<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Editar de Usu�rios" description="Editar de Usu�rios" keywords="usu�rio">
    <c:if test="${login != null}">
    <c:if test="${login == 'Admin'}">
    <jsp:body>
    <form name="usuario" action="ConfirmarEditarUsuario" method="post">
		<FIELDSET>
		<LEGEND>Editar de Usuarios - Alterar</LEGEND>
			<table>
				<tr>
					<td>
    					<LABEL accessKey=1 for=idUsuario>Identifica��o:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="idUsuario" size="20" value="${Usuario.idUsuario}"/>
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
				    	<input class="mask-data" type="text" name="dataNascimento" size="10" value="${Usuario.dataNascimento}"/>
				    	 
				    </td>
				</tr>
				
    		</table>
			<table align="right">
    			<tr>
					<td>
				    	<input type="hidden" name="codUsuario" value="${Usuario.codUsuario}" />
				    	<BUTTON class=botao name=gravar type=submit>Confimar Edi��o</BUTTON>
				    	<BUTTON class=botao name=cancelar type=reset>Cancelar</BUTTON>
				    	<A class=botao href="home.jsp">Voltar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
		
    </jsp:body>
    </c:if>
    </c:if>
</layout:page>
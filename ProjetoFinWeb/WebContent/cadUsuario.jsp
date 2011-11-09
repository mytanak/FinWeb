<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Cadastro de Usuários" description="Cadastro de Usuários" keywords="usuário">
    <c:if test="${login != null}">
    <c:if test="${login == 'Admin'}">
    <jsp:body>
    <form name="usuario" action="GravarUsuario" method="post">
		<FIELDSET>
		<LEGEND>Cadastro de Usuarios</LEGEND>
			<table>
				<tr>
					<td>
    					<LABEL accessKey=1 for=idUsuario>Identificação:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="idUsuario" size="20" />
    				</td>
    			</tr>
    			<tr>    			
    				<td>
		    			<LABEL accessKey=2 for=nome>Nome:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<input type="text" name="nome" size="50" />
		    		</td>
		    	</tr>
		    	<tr>
		    		<td>
				    	<LABEL accessKey=3 for=senha>Senha:</LABEL>
				    </td>
				    <td align="left">				    	
				    	<input type="password" name="senha" size="10" />
				    </td>
				</tr>
				<tr>
				    <td>				    	
				    	<LABEL accessKey=4 for=email>E-mail:</LABEL> 
				    </td>
				    <td align="left">
				    	<input type="text" name="email" size="50" />
				    </td>
				</tr>
				<tr>
					<td>				    
				    	<LABEL accessKey=5 for=dataNascimento>Data Nascimento:</LABEL>
				    </td>
				    <td align="left"> 
				    	<input class="mask-data" type="text" name="dataNascimento" size="10" />
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
    </c:if>
</layout:page>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<layout:page usuario="" title="Criar Conta" description="Criar Conta" keywords="conta">
    <jsp:body>
    <c:if test="${msg != null}">
    ${msg}
    </c:if>
	<form name="usuario" action="GravarLogin" method="post">
		<FIELDSET>
		<LEGEND>Criar Conta</LEGEND>
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
				    	<input id=date type="text" name="dataNascimento" size="10" />
				    </td>
				</tr>
				
    		</table>
    		<table align="right">
    			<tr>
					<td>
				    	<BUTTON class=botao name=gravar type=submit>Gravar</BUTTON>
				    	<BUTTON class=botao name=cancelar type=reset>Cancelar</BUTTON>
				    	<A class=botao href="index.jsp">Voltar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>	
    </jsp:body>  
    
</layout:page>
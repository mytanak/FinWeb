<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="post" action="AutenticarLogin">
<FIELDSET>
<LEGEND>Login de Usu�rios</LEGEND>
<table>
	<tr>
		<td>
			<LABEL accessKey=1 for=idUsuario>Usu�rio:</LABEL>
		</td>
		<td align="left">
			<input type="text" name="idUsuario" size="20" />
		</td>								
	</tr>
	<tr>
		<td>	
			<LABEL accessKey=2 for=senha>Senha:</LABEL>
		</td>
		<td align="left"> 
			<input type="password" name="senha" size="10" />
		</td>
	</tr>
</table>
<table width="100%">
	<tr>							
		<td align="left">
			<input type="hidden" name="acao" value="login" />
	    	<BUTTON class=botao name="entrar"  type=submit>Entrar</BUTTON>
	    </td>
	    <td align="right">
			<A class=botao href="cadLogin.jsp">Criar uma Conta</A>
			
	    </td>			    
	</tr>
</table>
<c:if test="${erro > 0}">
	Login inv�lido!
	</c:if>
	</FIELDSET>
</form>
				
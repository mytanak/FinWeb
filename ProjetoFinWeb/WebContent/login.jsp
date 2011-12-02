<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="post" action="AutenticarLogin">
<FIELDSET>
<LEGEND>Login de Usuários</LEGEND>
<table class="normal">
	<tr>
		<td>
			<LABEL accessKey=1 for=idUsuario>Usuário:</LABEL>
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
<table width="100%" class="normal">
	<tr>							
		<td valign="center" align="left">			
	    	<input type="hidden" name="acao" value="login" />
	    	<span align="left"><BUTTON class=botao name="entrar"  type=submit>Entrar</BUTTON></span>	    	
			<span align="right"><a class=botao  href="cadLogin.jsp">Criar uma Conta</a></span>			
			<span align="right"><a class=botao  href="recuperarSenha.jsp">Esqueceu sua senha?</a></span>
	    </td>			    
	</tr>
</table>
<c:if test="${erro > 0}">
    <center>
	<p class="msg">Login inválido!</p>
	</center>
	</c:if>
	</FIELDSET>
</form>
				
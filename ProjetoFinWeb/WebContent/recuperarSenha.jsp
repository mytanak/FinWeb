<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<layout:page usuario="" title="Recuperar Senha" description="Recuperar Senha" keywords="conta">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
	<c:if test="${listLogin == null}">
	<form id="formLogin" name="usuario" action="RecuperarSenha" method="post">
		<FIELDSET>
		<LEGEND>Recuperar Senha</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=idUsuario>Identificação:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="idUsuario" size="20"/>
    				</td>
    			</tr>
    			<tr>    			
    				<td>
		    			<LABEL accessKey=2 for=nome>Nome:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<input type="text" name="nome" size="50"/>
		    		</td>
		    	</tr>
				<tr>
				    <td>				    	
				    	<LABEL accessKey=5 for=email>E-mail:</LABEL> 
				    </td>
				    <td align="left">
				    	<input type="text" name="email" size="50"/>
				    </td>
				</tr>
				<tr>
					<td>				    
				    	<LABEL accessKey=6 for=dataNascimento>Data Nascimento:</LABEL>
				    </td>
				    <td align="left"> 
				    	<input class="mask-data" type="text" name="dataNascimento" size="10"/>
				    </td>
				</tr>
				
    		</table>
    		<table align="right" class="normal">
    			<tr>
					<td>
				    	<BUTTON class=botao name=enviar type=submit>Enviar</BUTTON>
				    	<BUTTON class=botao name=limpar type=reset>Limpar</BUTTON>
				    	<A class=botao href="index.jsp">Cancelar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>	
	</c:if>
	<c:forEach var="Login" items="${listLogin}">
	<form id="formLogin" name="usuario" action="RecuperarSenha" method="post">
		<FIELDSET>
		<LEGEND>Recuperar Senha</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=idUsuario>Identificação:</LABEL>
    				</td>
    				<td align="left"> 
    					<input type="text" name="idUsuario" size="20" value="${Login.idUsuario}"/>
    				</td>
    			</tr>
    			<tr>    			
    				<td>
		    			<LABEL accessKey=2 for=nome>Nome:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<input type="text" name="nome" size="50"  value="${Login.nome}"/>
		    		</td>
		    	</tr>
				<tr>
				    <td>				    	
				    	<LABEL accessKey=5 for=email>E-mail:</LABEL> 
				    </td>
				    <td align="left">
				    	<input type="text" name="email" size="50"  value="${Login.email}"/>
				    </td>
				</tr>
				<tr>
					<td>				    
				    	<LABEL accessKey=6 for=dataNascimento>Data Nascimento:</LABEL>
				    </td>
				    <td align="left"> 
				    	<input class="mask-data" type="text" name="dataNascimento" size="10" value="${Login.dataNascimentoStr}"/>
				    </td>
				</tr>
				
    		</table>
			<c:if test="${senhaGerada != null}">
			<p class="msg">Sua nova senha é: ${senhaGerada}</p>
			</c:if>
	    		
    		<table align="right" class="normal">
    			<tr>
					<td>
				    	<BUTTON class=botao name=enviar type=submit>Enviar</BUTTON>
				    	<BUTTON class=botao name=limpar type=reset>Limpar</BUTTON>
				    	<A class=botao href="index.jsp">Cancelar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>	
	</c:forEach>
	</div>
    </jsp:body>  
    
</layout:page>
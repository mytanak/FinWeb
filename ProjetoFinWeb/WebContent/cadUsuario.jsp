<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Cadastrar Usuário" description="Cadastrar Usuário" keywords="usuário">
	<c:if test="${login == null or login != 'Admin'}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
    <form id="formUsuario" name="usuario" action="GravarUsuario" method="post">
		<FIELDSET>
		<LEGEND>Cadastrar Usuario</LEGEND>
			<table class="normal">
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
				    	<input id="senha" type="password" name="senha" size="10" />
				    </td>
				</tr>
		    	<tr>
		    		<td>
				    	<LABEL accessKey=4 for=confirmeSenha>Confirme a Senha:</LABEL>
				    </td>
				    <td align="left">				    	
				    	<input type="password" name="confirmeSenha" size="10" />
				    </td>
				</tr>
				<tr>
				    <td>				    	
				    	<LABEL accessKey=5 for=email>E-mail:</LABEL> 
				    </td>
				    <td align="left">
				    	<input type="text" name="email" size="50" />
				    </td>
				</tr>
				<tr>
					<td>				    
				    	<LABEL accessKey=6 for=dataNascimento>Data Nascimento:</LABEL>
				    </td>
				    <td align="left"> 
				    	<input class="mask-data" type="text" name="dataNascimento" size="10" />
				    </td>
				</tr>
				
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<BUTTON class=botao name=gravar type=submit>Gravar</BUTTON>
				    	<BUTTON class=botao name=limpar type=reset>Limpar</BUTTON>
				    	<A class=botao href="listarUsuario.jsp">Cancelar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
	</div>	
    </jsp:body>
    </c:if>
</layout:page>
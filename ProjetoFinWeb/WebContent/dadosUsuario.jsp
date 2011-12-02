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
    <form id="formUsuario" name="usuario" action="#" method="post">
		<FIELDSET>
		<LEGEND>Informações Pessoais</LEGEND>
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
		    			<input type="text" readonly="readonly" name="nome" size="50" value="${Usuario.nome}"/>
		    		</td>
		    	</tr>
				<tr>
				    <td>				    	
				    	<LABEL accessKey=4 for=email>E-mail:</LABEL> 
				    </td>
				    <td align="left">
				    	<input type="text" readonly="readonly" name="email" size="50" value="${Usuario.email}"/>
				    </td>
				</tr>
				<tr>
					<td>				    
				    	<LABEL accessKey=5 for=dataNascimento>Data Nascimento:</LABEL>
				    </td>
				    <td align="left"> 
				    	<input class="mask-data" readonly="readonly" type="text" name="dataNascimento" size="10" value="${Usuario.dataNascimentoStr}"/>
				    </td>
				</tr>
				
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
					    <A class=botao href="EditarUsuario?codUsuario=${Usuario.codUsuario}&origem=conf">Alterar Dados</A>
					    <A class=botao href="configuracoes.jsp?origem=conf">Alterar Senha</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
	</c:forEach>
	</div>	
    </c:if>

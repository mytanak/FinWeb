<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<layout:page usuario="${login}" title="Index page" description="This is the index page of my amazing app" keywords="amazing, app">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	    <table class="normal">
			<tr>
				<td width="100%">
				<div style="text-align: center;"><p id="texto-inicial">FinWeb</p><br/>
				<p id="texto-inicial2">Sistema de Controle Financeiro Pessoal Versão 1.0</p><br/>
				<p id="texto-inicial3">
				ETEC Prof. Massuyuki Kawano - Centro Paula Souza<br/>
				Curso: Pós-Técnico em Java				
				</p><br/>
				<p id="texto-inicial2">Equipe:</p><br/>
				<p id="texto-inicial3">
				Halen Ribeiro Gusman <a class="email" href="mailto:halenconjak@hotmail.com">halenconjak@hotmail.com</a><br/>				
				Kely Oyamada <a class="email" href="mailto:kelynhajaponesa@hotmail.com">kelynhajaponesa@hotmail.com</a><br/>
				Marcelo Tanaka <a class="email" href="mailto:marcelotanaka@windowslive.com">marcelotanaka@windowslive.com</a><br/> 
				Vanessa de Almeida Santos <a class="email" href="mailto:nessatawa@bol.com.br">nessatawa@bol.com.br</a><br/>
				Vinicius Gustavo Castiliani <a class="email" href="mailto:viniciuscastiliani@hotmail.com">viniciuscastiliani@hotmail.com</a>			
				</p><br/>
				<p id="texto-inicial2">Tecnologias Utilizadas:</p><br/>
				<p id="texto-inicial3">
				<a  class="link" href="http://www.java.com">Java</a><br/>
				J2EE / Servlet / JSP / JSTL / JQuery / CSS / HTML / JavaScript<br/>
				Componentes: DisplayTag / Cewolf<br/>
				</p><br/>
				<p id="texto-inicial2">Ferramentas Utilizadas:</p><br/>
				<p id="texto-inicial3">
				<a class="link" href="http://www.eclipse.org">Eclipse versão Indigo</a><br/>
				<a class="link" href="http://www.apache.org/">Apache Tomcat versão 6</a><br/>
				<a class="link" href="http://www.microsoft.com/">Microsoft SQL Server e Management Studio 2005 Express Edition</a><br/>
				<a class="link" href="http://www.google.com/chrome">Google chrome</a>								
				</p>
				</div>
				
				</td>				
			</tr>
		</table>
    </div>    
	</jsp:body>  
    </c:if>    
</layout:page>
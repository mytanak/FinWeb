<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ tag body-content="empty" description="Header tag file" %>
<%@ attribute name="usuario"  required="true" description="Page Usuario" %>
<div id="header">
<!-- Header section here -->
	<div id="topo">
		<c:if test="${not empty usuario}">
    		<p id="welcome">Bem vindo(a) ${usuario}! <a href="AutenticarLogin?acao=logout">Sair</a></p>
    		
    	</c:if>
	</div>

	<c:if test="${not empty usuario}">
		<div id="menu-superior">
	        <ul id="menu_dropdown" class="menubar">
				<li class="submenu"><a href="home.jsp">Home</a></li>
	            <li class="submenu"><a href="">Cadastros</a>
	      			<ul class="menu">
	        			<li align="left"><a class="opcaomenu" href="cadConta.jsp">Conta</a></li>
	        			<li align="left"><a class="opcaomenu" href="cadGrupo.jsp">Grupo de Despesas e Receitas</a></li>
	        			<li align="left"><a class="opcaomenu" href="cadOperacao.jsp">Despesas \ Receitas</a></li>
	        			<li align="left"><a class="opcaomenu" href="cadModalidade.jsp">Modalidade</a></li>
	        			<li align="left"><a class="opcaomenu" href="cadFornecedor.jsp">Fornecedor</a></li>
	                    <c:if test="${usuario == 'Admin'}">
	                    	<li align="left"><a class="opcaomenu" href="cadUsuario.jsp">Usuário</a></li>
	                    </c:if>
	      			</ul>
	            </li>
	            <li class="submenu"><a href="cadLancamento.jsp">Lançamentos</a></li>
	            <li class="submenu"><a href="relatorio.html">Relatórios</a></li>
			</ul>        
	    </div>
    </c:if>
</div>
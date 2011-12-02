<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ tag body-content="empty" description="Header tag file" %>
<%@ attribute name="usuario"  required="true" description="Page Usuario" %>

<!-- Header section here -->
<div id="topo">
	<c:if test="${not empty usuario}">
   		<div id="welcome">Bem vindo(a) ${usuario}! <a id="sair" href="AutenticarLogin?acao=logout">Sair</a></div>
		<jsp:useBean id="agora" class="java.util.Date"/>
		<div id="welcome1"><fmt:formatDate value="${agora}" dateStyle="full"/></div>   		
   	</c:if>
</div>

<c:if test="${not empty usuario}">
	<div id="menu-superior" align="center">
		<div id="smoothmenu1" class="ddsmoothmenu">
		<ul>
		<li><a href="home.jsp">Home</a></li>
		<li><a href="#">Cadastros</a>
		  <ul>
		  	<li align="left"><a href="listarConta.jsp">Conta</a></li>
  			<li align="left"><a href="listarGrupo.jsp">Grupo de Despesas e Receitas</a></li>
  			<li align="left"><a href="listarOperacao.jsp">Despesas \ Receitas</a></li>
  			<li align="left"><a href="listarModalidade.jsp">Modalidade de Pagamento/Recebimento</a></li>
  			<li align="left"><a href="listarFornecedor.jsp">Fornecedor</a></li>
            <c:if test="${usuario == 'Admin'}">
              	<li align="left"><a href="listarUsuario.jsp">Usuário</a></li>
            </c:if>
		  </ul>
		</li>
		<li><a href="ListarLancamento?idUsuario=${usuario}">Lançamentos</a></li>
		<li><a href="relatorio.jsp">Relatórios</a></li>
		<li><a href="configuracoes.jsp">Configurações</a></li>		
		<li><a href="sobre.jsp">Sobre</a></li>
		</ul>
		<br style="clear: left" />
		</div>
    </div>
</c:if>
<c:if test="${empty usuario}">
	<div id="menu-superior">
    </div>
</c:if>

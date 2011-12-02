<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="" title="FinWeb" description="Sistema Financeiro Pessoal - FinWeb" keywords="Finanças, despesas, contas">
    <jsp:body>
    <div id="content">	    
	    <table class="normal">
			<tr>
				<td width="60%">
				<div><p id="texto-inicial">Controle, planeje e economize!</p></br>
				<p id="texto-inicial2">Fácil de usar.</p></br>
				<p id="texto-inicial3">Com o FinWeb, qualquer pessoa pode fazer seu controle financeiro sem complicações. 
				Você só vê na tela, os recursos que realmente precisa.</p></br>
				<p id="texto-inicial2">Tenha o controle de suas finanças.</p></br>
				<p id="texto-inicial3">Saiba onde o seu dinheiro está sendo gasto ou investido.
				Coloque suas contas em dia de forma simples e rápida.</p></br>
				<p id="texto-inicial2">Comece a usar agora.</p></br>
				<p id="texto-inicial3">O cadastro no sistema é simples e rápido. Informe os seus dados pessoais, e comece a usar.</p></br>
				<p id="texto-inicial2">Use em qualquer lugar.</p></br>
				<p id="texto-inicial3">O FinWeb é totalmente online. Você só precisa de um computador ou smartfone com acesso a internet.</p><br/>
				<p id="texto-inicial2">Acesse as nossas redes sociais:</p><br/>
				<a href="http://www.facebook.com" target="_blank"><img src="/ProjetoFinWeb/img/face.png"></a>
				<a href="http://www.twitter.com" target="_blank"><img src="/ProjetoFinWeb/img/twitter.png"></a>
				<a href="http://www.linkedin.com/" target="_blank"><img src="/ProjetoFinWeb/img/linkedin.png"></a>
				</div>
				
				</td>
				<td>
					<c:import url="login.jsp" /><br/>
					<div id="container1">
						<p id="texto-inicial4">Notícias</p><br/>
						<a id="texto-inicial5" href="http://not.economia.terra.com.br/noticias/noticia.aspx?idNoticia=201111291907_RTR_N1E7AS1D8" target="_blank">
						Dólar cai pelo 3º dia e fecha abaixo de R$ 1,85... Clique e leia.</a><br/><br/>
						<a id="texto-inicial5" href="http://www.estadao.com.br/noticias/impresso,mercado-financeiro-quer-restringir-iof-de-4,622680,0.htm" target="_blank">Mercado financeiro quer restringir IOF de 4%... Clique e leia.</a><br/><br/>
						<a id="texto-inicial5" href="http://economia.uol.com.br/ultimas-noticias/reuters/2011/11/29/petrobras-encontra-petroleo-no-pre-sal-de-santos.jhtm" target="_blank">Petrobras encontra petróleo no pré-sal de Santos... Clique e leia.</a><br/><br/>
						<a id="texto-inicial5" href="http://blogs.estadao.com.br/economia-tempo-real/2011/11/29/bovespa-recua-128-e-fecha-na-minima-com-pressao-da-vale/" target="_blank">Bovespa recua 1,28% e fecha na mínima... Clique e leia.</a><br/><br/>
						<a id="texto-inicial5" href="http://economia.uol.com.br/ultimas-noticias/efe/2011/11/28/facebook-planeja-entrar-na-bolsa-no-2-trimestre-de-2012-segundo-jornal.jhtm" target="_blank">Facebook planeja entrar na Bolsa no 2º trimestre... Clique e leia.</a><br/><br/>
						<a id="texto-inicial5" href="http://economia.uol.com.br/ultimas-noticias/redacao/2011/11/29/crescimento-da-economia-do-pais-cria-19-milionarios-por-dia-diz-forbes.jhtm" target="_blank">Crescimento da economia do país cria 19 mili... Clique e leia.</a>
					</div>							
				</td>
			</tr>
		</table>
	</div>
    </jsp:body>
</layout:page>
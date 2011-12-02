<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@ page import="br.com.etectupa.collection.ResumoLancamento" %>
<%@ page import="br.com.etectupa.displaytag.collection.ListLancamento" %>
<%@ page import="br.com.etectupa.util.Biblioteca" %>
<%@ page import="br.com.etectupa.util.Convert" %>
<%@ page import="org.joda.time.LocalDate" %>
<%@ page import="java.sql.Date" %>
<%@ page import="br.com.etectupa.displaytag.collection.ListConta" %>

<c:set var="idUsuario" value="${login}"/>
<%
String idUsuario = (String) pageContext.getAttribute("idUsuario");
request.setAttribute( "resumoLancamento", new ResumoLancamento(idUsuario));

Date dataInicial = Biblioteca.Today();
Date dataFinal = Convert.StrToDateSql(Biblioteca.ultimoDiaMes(Biblioteca.retornaAno(Biblioteca.Today()), Biblioteca.retornaMes(Biblioteca.Today())));

ListLancamento proximos = new ListLancamento(idUsuario, 4, dataInicial, dataFinal);

dataInicial = Convert.StrToDateSql(Biblioteca.primeiroDiaMes(Biblioteca.retornaAno(Biblioteca.Today()), Biblioteca.retornaMes(Biblioteca.Today())));
LocalDate dataFinalAux = new LocalDate(Biblioteca.Today()); 
dataFinal = Convert.StrToDateSql(dataFinalAux.minusDays(1).toString("dd/MM/yyyy"));

ListLancamento atrasadas = new ListLancamento(idUsuario, 4, dataInicial, dataFinal);

request.setAttribute( "mesAtualStr", Biblioteca.retornaMesStr(Biblioteca.retornaMes(Biblioteca.Today())));
request.setAttribute( "anoAtualStr", Biblioteca.retornaAno(Biblioteca.Today()));

request.setAttribute( "proximos", proximos);
request.setAttribute( "atrasadas", atrasadas);
request.setAttribute( "listConta", new ListConta(idUsuario));

%>

<div class="conteudoSubTab">	
	<c:forEach var="resumoGeral" items="${resumoLancamento }">
	<div class="divresumogeral1">
	    <fieldset>
	    <legend>Resumo Geral</legend>	
	    <div class="divgeral2">		
			<div class="divesquerda">
				Saldo Inicial
			</div>
			<div class="divdireita">
				<fmt:formatNumber  pattern="#,##0.00">${resumoGeral.saldoInicial }</fmt:formatNumber>
			</div>
			<div class="divesquerda" >
				Débito
			</div>
			<div class="divdireita">
				<fmt:formatNumber  pattern="#,##0.00">${resumoGeral.debitoGeral }</fmt:formatNumber>								
			</div>
			<div class="divesquerda">
				Crédito
			</div>
			<div class="divdireita">
				<fmt:formatNumber  pattern="#,##0.00">${resumoGeral.creditoGeral }</fmt:formatNumber>				
			</div>
			<div class="divesquerda"></div>
			<div class="divlinha"></div>
			<div class="divesquerda">
				<c:if test="${resumoGeral.saldo < 0}">
					<span class="negativoGeral">
						Saldo Atual
					</span>
				</c:if>
				<c:if test="${resumoGeral.saldo >= 0}">
					<span class="positivoGeral">
						Saldo Atual
					</span>
				</c:if>
			</div>
			<div class="divdireita">
				<c:if test="${resumoGeral.saldo < 0}">
					<span class="negativoGeral">
						<fmt:formatNumber  pattern="#,##0.00">${resumoGeral.saldo }</fmt:formatNumber>
					</span>
				</c:if>
				<c:if test="${resumoGeral.saldo >= 0}">
					<span class="positivoGeral">
						<fmt:formatNumber  pattern="#,##0.00">${resumoGeral.saldo }</fmt:formatNumber>
					</span>
				</c:if>
			</div>
			
			<display:table name="listConta" export="false" sort="list" decorator="org.displaytag.decorator.TotalTableDecorator">
			    <display:column style="width: 80px;" property="descricao" title="Contas" headerClass="sortable" href="ConsultaDadosConta" paramId="codConta" paramProperty="codConta"/>
			    <display:column  style="width: 80px;" property="saldoAtual" title="Saldo Atual" format="{0,number,#,##0.00}" headerClass="r" class="r" total="true"/>
			</display:table>
			
		</div>
		</fieldset>
	</div>
	</c:forEach>		
	
	<div class="divresumogeral2">
	<div class="divgeral">
	    <fieldset>
	    <legend>Próximos Lançamentos do mês (${mesAtualStr} - ${anoAtualStr })</legend>
	    <div class="divgeral1">	
	    <display:table class="normal" name="proximos" decorator="org.displaytag.decorator.TotalTableDecorator">
		    <display:column style="width: 80px;"  property="dataVencimentoStr" title="Vencimento" headerClass="sortable"/>
		    <display:column property="descOperacao" title="Descrição" headerClass="sortable"/>
		    <display:column style="width: 80px;" property="valor" title="Valor" format="{0,number,#,##0.00}" headerClass="r" class="r" total="true"/>
		</display:table>	
		</div>	
		</fieldset>
	</div>
	
	<div class="divgeral">
	    <fieldset>
	    <legend>Contas Atrasadas do mês (${mesAtualStr} - ${anoAtualStr })</legend>
	    <div class="divgeral1">	
	    <display:table class="normal" name="atrasadas" decorator="org.displaytag.decorator.TotalTableDecorator">
		    <display:column style="width: 80px;"  property="dataVencimentoStr" title="Vencimento" headerClass="sortable"/>
		    <display:column property="descOperacao" title="Descrição" headerClass="sortable"/>
		    <display:column style="width: 80px;" property="valor" title="Valor" format="{0,number,#,##0.00}" headerClass="r" class="r" total="true"/>
		</display:table>	
		</div>	
		</fieldset>
	</div>
	</div>

</div>
				
				
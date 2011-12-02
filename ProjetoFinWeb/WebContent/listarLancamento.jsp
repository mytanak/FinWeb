<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<c:set var="idUsuario" value="${login}"/>
<%
  if (request.getAttribute("origem") == null) {
	  int mesAtual = 0;
	  int anoAtual = 0;
	  int alteraMes = 0;
	  int pagina = 1;
	  int s = 0;
	  int o = 0;
	  
	  if (request.getParameter("mesAtual") != null){
	  	mesAtual = Integer.parseInt(request.getParameter("mesAtual"));
	  }
	  
	  if (request.getParameter("anoAtual") != null){
		anoAtual = Integer.parseInt(request.getParameter("anoAtual"));  
	  }
	  
	  if (request.getParameter("d-49653-p") != null){
		  pagina = Integer.parseInt(request.getParameter("d-49653-p"));  
	  }

	  if (request.getParameter("d-49653-s") != null){
		  s = Integer.parseInt(request.getParameter("d-49653-s"));  
	  }
	  
	  if (request.getParameter("d-49653-o") != null){
		  o = Integer.parseInt(request.getParameter("d-49653-o"));  
	  }
	  
	  if (request.getParameter("alteraMes") != null){
		  alteraMes = Integer.parseInt(request.getParameter("alteraMes"));  
	  }
	  
	  String idUsuario = request.getParameter("idUsuario");
	  response.sendRedirect("ListarLancamento?idUsuario=" + idUsuario + "&mesAtual="+ mesAtual + "&anoAtual=" + anoAtual + "&alteraMes=" + alteraMes + "&d-49653-p=" + pagina + "&d-49653-s=" + s + "&d-49653-o=" + o);
  }
%>

<layout:page usuario="${login}" title="Lançamentos" description="Lançamentos" keywords="lançamento">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
	<FIELDSET>
		<LEGEND>Lançamentos - ${mesStr} - ${primeiroDiaMes} - ${ultimoDiaMes}</LEGEND>
		<br/>
		<div align="left">
		<A class=botao href="ListarLancamento?idUsuario=${login}&alteraMes=-1&mesAtual=${mesAtual}&anoAtual=${anoAtual}">Mês Anterior</A>
		<A class=botao href="ListarLancamento?idUsuario=${login}&alteraMes=1&mesAtual=${mesAtual}&anoAtual=${anoAtual}">Próximo Mês</A>
		</div>		
		<div align="right">
		<A class=botao href="CadastroLancamento?mesAtual=${mesAtual}&anoAtual=${anoAtual}">Novo</A>
		</div>
		<display:table name="listLancamento" export="false" sort="list" pagesize="4">
		    <display:column property="nroLancamento" title="Num. Lcto." sortable="true" headerClass="sortable" href="ConsultaDadosLancamento?mesAtual=${mesAtual}&anoAtual=${anoAtual}" paramId="nroLancamento" paramProperty="nroLancamento" />
		    <display:column property="dataVencimento" title="Vencimento" sortable="true" headerClass="sortable" format="{0,date,dd/MM/yyyy}" />
		    <display:column property="dataRealizada" title="Pagamento" sortable="true" headerClass="sortable" format="{0,date,dd/MM/yyyy}" />
		    <display:column property="descOperacao" title="Descrição" sortable="true" headerClass="sortable" href="ConsultaDadosLancamento?mesAtual=${mesAtual}&anoAtual=${anoAtual}" paramId="nroLancamento" paramProperty="nroLancamento" />
		    <display:column property="debitos" title="Débito" format="{0,number,#,##0.00}" headerClass="r" class="r"/>
		    <display:column property="creditos" title="Crédito" format="{0,number,#,##0.00}" headerClass="r" class="r"/>
		    <display:column title="Editar" href="EditarLancamento?mesAtual=${mesAtual}&anoAtual=${anoAtual}" paramId="nroLancamento" paramProperty="nroLancamento" >Editar</display:column>
		    <display:column title="Excluir" href="ExcluirLancamento?idUsuario=${login}&mesAtual=${mesAtual}&anoAtual=${anoAtual}" paramId="nroLancamento" paramProperty="nroLancamento" >Excluir</display:column>
		</display:table>
		
		<div>		
		<c:forEach var="resumo" items="${resumoLancamento }">
		<div class="divresumoperiodo">
		    <fieldset>
		    <legend>Resumo da Movimentação do Período</legend> 			
			<div class="divesquerda" >
				Débito
			</div>
			<div class="divdireita">
				<fmt:formatNumber  pattern="#,##0.00">${resumo.debito }</fmt:formatNumber>								
			</div>
			<div class="divesquerda">
				Crédito
			</div>
			<div class="divdireita">
				<fmt:formatNumber  pattern="#,##0.00">${resumo.credito }</fmt:formatNumber>				
			</div>
			<div class="divesquerda"></div>
			<div class="divlinha"></div>
			<div class="divesquerda">
				<c:if test="${resumo.total < 0}">
					<span class="negativo">
						Total
					</span>
				</c:if>
				<c:if test="${resumo.total >= 0}">
					<span class="positivo">
						Total
					</span>
				</c:if>				
			</div>
			<div class="divdireita">
				<c:if test="${resumo.total < 0}">
					<span class="negativo">
						<fmt:formatNumber  pattern="#,##0.00">${resumo.total }</fmt:formatNumber>
					</span>
				</c:if>
				<c:if test="${resumo.total >= 0}">
					<span class="positivo">
						<fmt:formatNumber  pattern="#,##0.00">${resumo.total }</fmt:formatNumber>
					</span>
				</c:if>					
			</div>
			</fieldset>
		</div>
		</c:forEach>
		
		<c:forEach var="resumoGeral" items="${resumoLancamento }">
		<div class="divresumogeral">
		    <fieldset>
		    <legend>Resumo da Movimentação Geral</legend>			
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
					<span class="negativo">
						Saldo Atual
					</span>
				</c:if>
				<c:if test="${resumoGeral.saldo >= 0}">
					<span class="positivo">
						Saldo Atual
					</span>
				</c:if>
			</div>
			<div class="divdireita">
				<c:if test="${resumoGeral.saldo < 0}">
					<span class="negativo">
						<fmt:formatNumber  pattern="#,##0.00">${resumoGeral.saldo }</fmt:formatNumber>
					</span>
				</c:if>
				<c:if test="${resumoGeral.saldo >= 0}">
					<span class="positivo">
						<fmt:formatNumber  pattern="#,##0.00">${resumoGeral.saldo }</fmt:formatNumber>
					</span>
				</c:if>
			</div>
			</fieldset>
		</div>
		</c:forEach>		
		</div>
	</FIELDSET>
	</div>
	</jsp:body>
	</c:if>
</layout:page>
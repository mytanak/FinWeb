<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/cewolf-1.1.tld" prefix="cewolf"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="br.com.etectupa.dataset.DadosGraficoPizzaSetorialDataSet" %>

<c:set var="idUsuario" value="${login}"/>
<%
String idUsuario = (String) pageContext.getAttribute("idUsuario");
request.setAttribute( "grafDSGrupoDespesas", new DadosGraficoPizzaSetorialDataSet("GrupoDespesas",idUsuario));
%>
<div class="conteudoSubTab">
	<div class="divgeral4">			
		<!-- GRÁFICO SETORIAL/PIZZA EM 3D -->		
		<cewolf:chart id="grafico2" title="Grupos de Despesas" type="pie3d">
		    <cewolf:gradientpaint>
		        <cewolf:point x="0" y="0" color="#FBFBFB" />
		        <cewolf:point x="350" y="0" color="#F3F3F3" />
		    </cewolf:gradientpaint>
		    <cewolf:data>
		        <cewolf:producer id="grafDSGrupoDespesas" />
			</cewolf:data>
		</cewolf:chart>
		<cewolf:img chartid="grafico2" renderer="/cewolf" width="700" height="300"/>		
	</div>
</div>				
				
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/cewolf-1.1.tld" prefix="cewolf"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="br.com.etectupa.dataset.DadosGraficoDataSet" %>
<%@ page import="br.com.etectupa.dataset.RetornaDadosResumoGeralAnual" %>

<c:set var="idUsuario" value="${login}"/>
<%
String idUsuario = (String) pageContext.getAttribute("idUsuario");
request.setAttribute( "grafDSDespesasReceitas", new DadosGraficoDataSet("ResumoGeralAnual",idUsuario));

RetornaDadosResumoGeralAnual dadosResumoGeralAnual = new RetornaDadosResumoGeralAnual();
request.setAttribute( "resumoAnual", dadosResumoGeralAnual.retornaDadosResumo(idUsuario));
%>
<div class="conteudoSubTab">
	<div class="divesquerdaGeral">
	    <display:table class="fontemenor" name="resumoAnual" decorator="org.displaytag.decorator.TotalTableDecorator">
		    <display:column style="width: 20px;" property="mes" title="Mês"/>
		    <display:column style="width: 80px;" property="despesa" title="Despesas" format="{0,number,#,##0.00}" headerClass="r" class="r" total="true"/>
		    <display:column style="width: 80px;"property="receita" title="Receitas" format="{0,number,#,##0.00}" headerClass="r" class="r" total="true"/>
		</display:table>
	</div>
	<div class="divdireitaGeral">		
		<!-- GRÁFICO LINHAS E COLUNA -->
		<cewolf:chart id="grafico1" title="Despesas x Receitas no Ano" type="verticalbar3d" 
			xaxislabel="Meses" yaxislabel="Valor">
		   	<cewolf:gradientpaint>
		       	<cewolf:point x="0" y="0" color="#FBFBFB" />
		       	<cewolf:point x="350" y="0" color="#F3F3F3" />
		   	</cewolf:gradientpaint>
		   	<cewolf:data>
		       	<cewolf:producer id="grafDSDespesasReceitas" />
			</cewolf:data>
		</cewolf:chart>
		<cewolf:img chartid="grafico1" renderer="/cewolf" width="450" height="300"/>
	</div>
</div>				
				
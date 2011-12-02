<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<layout:page usuario="${login}" title="Detalhes do Lançamento" description="Detalhes do Lançamento" keywords="lançamento">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
    
    <c:forEach var="Lancamento" items="${listLancamento}">
    <form name="lancamento" action="#" method="post">
		<FIELDSET>
		<LEGEND>Detalhes do Lançamento</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=Conta>Conta:</LABEL>
    				</td>
    				<td align="left">	
						<input type="text" readonly="readonly" name="Conta" size="40" value="${Lancamento.descConta}"/>
    				</td>
    			</tr>
    			<tr>    			
    				<td>
		    			<LABEL accessKey=2 for=Operacao>Despesa \ Receita:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<input type="text" readonly="readonly" name="Operacao" size="50" value="${Lancamento.descOperacao}"/>
		    		</td>
		    	</tr>	    	
    			<tr>    			
    				<td>
		    			<LABEL accessKey=3 for=Modalidade>Modalidade:</LABEL>
		    		</td>
		    		<td align="left"> 
						<input type="text" readonly="readonly" name="Modalidade" size="30" value="${Lancamento.descModalidade}"/>
		    		</td>
		    	</tr>	    	
    			<tr>    			
    				<td>
		    			<LABEL accessKey=4 for=Fornecedor>Fornecedor:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<input type="text" readonly="readonly" name="Fornecedor" size="50" value="${Lancamento.nomeFornecedor}"/>
		    		</td>
		    	</tr>	    	
				<tr>
					<td>				    
				    	<LABEL accessKey=5 for=dataVencimento>Data Vencimento:</LABEL>
				    </td>
				    <td align="left"> 
				    	<input class="mask-data" readonly="readonly" type="text" name="dataVencimento" size="10" value="${Lancamento.dataVencimentoStr}"/>
				    </td>
				</tr>
				<tr>
					<td>				    
				    	<LABEL accessKey=6 for=dataRealizada>Data Pagamento:</LABEL>
				    </td>
				    <td align="left"> 
				    	<input class="mask-data" readonly="readonly" type="text" name="dataRealizada" size="10" value="${Lancamento.dataRealizadaStr}"/>
				    </td>
				</tr>
				<tr>    			
    				<td>
		    			<LABEL accessKey=7 for=valor>Valor:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<fmt:formatNumber var="valor" pattern="#,##0.00">${Lancamento.valor}</fmt:formatNumber>
		    			<input id="mask-number" class="direita" type="text" readonly="readonly" name="valor" size="10" value="${valor}"/>
		    		</td>
		    	</tr>	 
		    	<tr>    			
    				<td>
		    			<LABEL accessKey=8 for=observacao>Observação:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<textarea name="observacao" readonly="readonly" rows="5" cols="50">${Lancamento.observacao}</textarea>		    			
		    		</td>
		    	</tr>	   	
				
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<A class=botao href="ListarLancamento?idUsuario=${login}&&mesAtual=${mesAtual}&&anoAtual=${anoAtual}">Voltar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
	</c:forEach>
	</div>	
    </jsp:body>
    </c:if>
</layout:page>
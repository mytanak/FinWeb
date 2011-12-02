<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<layout:page usuario="${login}" title="Editar Lançamento" description="Editar Lançamento" keywords="lançamento">
	<c:if test="${login == null}">
		<c:redirect url="index.jsp"/>
	</c:if>
    <c:if test="${login != null}">
    <jsp:body>
    <div id="content">
	<c:if test="${msg != null}">
	<p class="msg">${msg}</p>
	</c:if>
    
    <jsp:useBean id="usuarioDao" class="br.com.etectupa.dao.UsuarioDAO" />
    
	<c:forEach var="usuarios" items="${usuarioDao.lista}" varStatus="id">
	    <c:if test="${usuarios.idUsuario == login}">
	        <c:set var="codigoUsuario" value="${usuarios.codUsuario}"/>
		</c:if>	
	</c:forEach>    

    <jsp:useBean id="contaDao" class="br.com.etectupa.dao.ContaDAO" />
    <jsp:useBean id="operacaoDao" class="br.com.etectupa.dao.OperacaoDAO" />
    <jsp:useBean id="modalidadeDao" class="br.com.etectupa.dao.ModalidadeDAO" />
    <jsp:useBean id="fornecedorDao" class="br.com.etectupa.dao.FornecedorDAO" />
    
    <c:forEach var="Lancamento" items="${listLancamento}">
    <form id="formLancamento" name="lancamento" action="ConfirmarEditarLancamento" method="post">
		<FIELDSET>
		<LEGEND>Editar Lançamento</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=codConta>Conta:</LABEL>
    				</td>
    				<td align="left"> 
    					<select name="codConta">
							
							<c:forEach var="contas" items="${contaDao.lista}" varStatus="id">
								<c:if test="${contas.codUsuario == codigoUsuario}">
									<c:if test="${contas.codConta == Lancamento.codConta}">
	        							<option value="${contas.codConta}" SELECTED>${contas.descricao}</option>
	        						</c:if>
	        						<c:if test="${contas.codConta != Lancamento.codConta}">
	        							<option value="${contas.codConta}">${contas.descricao}</option>
	        						</c:if>
								</c:if>	
								
							</c:forEach>
						</select>
    				</td>
    			</tr>
    			<tr>    			
    				<td>
		    			<LABEL accessKey=2 for=codOperacao>Despesa \ Receita:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<select name="codOperacao">
							<c:forEach var="operacoes" items="${operacaoDao.lista}" varStatus="id">
								<c:if test="${operacoes.codOperacao == Lancamento.codOperacao}">								
									<option value="${operacoes.codOperacao}" SELECTED>
									<c:if test="${operacoes.tipo == 'D'}">
									Despesa - 
									</c:if>
									<c:if test="${operacoes.tipo == 'C'}">
									Receita - 
									</c:if>
									${operacoes.descricao}
									</option>
								</c:if>
								<c:if test="${operacoes.codOperacao != Lancamento.codOperacao}">								
									<option value="${operacoes.codOperacao}">
									<c:if test="${operacoes.tipo == 'D'}">
									Despesa - 
									</c:if>
									<c:if test="${operacoes.tipo == 'C'}">
									Receita - 
									</c:if>
									${operacoes.descricao}
									</option>
								</c:if>								
							</c:forEach>
						</select>
		    		</td>
		    	</tr>	    	
    			<tr>    			
    				<td>
		    			<LABEL accessKey=3 for=codModalidade>Modalidade:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<select name="codModalidade">
							<c:forEach var="modalidades" items="${modalidadeDao.lista}" varStatus="id">
								<c:if test="${modalidades.codModalidade == Lancamento.codModalidade}">
									<option value="${modalidades.codModalidade}" SELECTED>${modalidades.descricao}</option>
								</c:if>
								<c:if test="${modalidades.codModalidade != Lancamento.codModalidade}">
									<option value="${modalidades.codModalidade}">${modalidades.descricao}</option>
								</c:if>
							</c:forEach>
						</select>
		    		</td>
		    	</tr>	    	
    			<tr>    			
    				<td>
		    			<LABEL accessKey=4 for=codFornecedor>Fornecedor:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<select name="codFornecedor">
							<c:forEach var="fornecedores" items="${fornecedorDao.lista}" varStatus="id">
								<c:if test="${fornecedores.codFornecedor == Lancamento.codFornecedor}">
									<option value="${fornecedores.codFornecedor}" SELECTED>${fornecedores.nome}</option>
								</c:if>
								<c:if test="${fornecedores.codFornecedor != Lancamento.codFornecedor}">
									<option value="${fornecedores.codFornecedor}">${fornecedores.nome}</option>
								</c:if>								
							</c:forEach>
						</select>
		    		</td>
		    	</tr>	    	
				<tr>
					<td>				    
				    	<LABEL accessKey=5 for=dataVencimento>Data Vencimento:</LABEL>
				    </td>
				    <td align="left"> 
				    	<input class="mask-data" type="text" name="dataVencimento" size="10" value="${Lancamento.dataVencimentoStr}"/>
				    </td>
				</tr>
				<tr>
					<td>				    
				    	<LABEL accessKey=6 for=dataRealizada>Data Pagamento:</LABEL>
				    </td>
				    <td align="left"> 
				    	
				    	<input class="mask-data" type="text" name="dataRealizada" size="10" value="${Lancamento.dataRealizadaStr}"/>
				    </td>
				</tr>
				<tr>    			
    				<td>
		    			<LABEL accessKey=7 for=valor>Valor:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<fmt:formatNumber var="valor" pattern="#,##0.00">${Lancamento.valor}</fmt:formatNumber>
		    			<input id="mask-number" class="direita" type="text" name="valor" size="10" value="${valor}"/>
		    		</td>
		    	</tr>	 
		    	<tr>    			
    				<td>
		    			<LABEL accessKey=8 for=observacao>Observação:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<textarea name="observacao" rows="5" cols="50">${Lancamento.observacao}</textarea>		    			
		    		</td>
		    	</tr>	   	
				
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<input type="hidden" name="nroLancamento" value="${Lancamento.nroLancamento}" />
				    	<input type="hidden" name="idUsuario" value="${login}" />
				    	<input type="hidden" name="mesAtual" value="${mesAtual}" />
				    	<input type="hidden" name="anoAtual" value="${anoAtual}" />
				    	<BUTTON class=botao name=gravar type=submit>Confirmar Edição</BUTTON>
				    	<A class=botao href="ListarLancamento?idUsuario=${login}&mesAtual=${mesAtual}&anoAtual=${anoAtual}">Cancelar</A>
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
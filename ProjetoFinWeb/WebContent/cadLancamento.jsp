<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<layout:page usuario="${login}" title="Cadastrar Lançamento" description="Cadastrar Lançamento" keywords="lançamento">
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
    <form id="formLancamento" name="lancamento" action="GravarLancamento" method="post">
		<FIELDSET>
		<LEGEND>Cadastrar Lançamento</LEGEND>
			<table class="normal">
				<tr>
					<td>
    					<LABEL accessKey=1 for=codConta>Conta:</LABEL>
    				</td>
    				<td align="left"> 
    					<select name="codConta">
							<option value="" SELECTED>Escolha</option>
							<c:forEach var="contas" items="${contaDao.lista}" varStatus="id">
								<c:if test="${contas.codUsuario == codigoUsuario}">
	        						<option value="${contas.codConta}">${contas.descricao}</option>
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
							<option value="" SELECTED>Escolha</option>
							<c:forEach var="operacoes" items="${operacaoDao.lista}" varStatus="id">
								<option value="${operacoes.codOperacao}">
								<c:if test="${operacoes.tipo == 'D'}">
								Despesa - 
								</c:if>
								<c:if test="${operacoes.tipo == 'C'}">
								Receita - 
								</c:if>
								${operacoes.descricao}
								</option>
							</c:forEach>
						</select>
		    		</td>
		    	</tr>	    	
    			<tr>    			
    				<td>
		    			<LABEL accessKey=3 for=codModalidade>Modalidade de Pagamento/Recebimento:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<select name="codModalidade">
							<option value="" SELECTED>Escolha</option>
							<c:forEach var="modalidades" items="${modalidadeDao.lista}" varStatus="id">
								<option value="${modalidades.codModalidade}">${modalidades.descricao}</option>
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
							<option value="" SELECTED>Escolha</option>
							<c:forEach var="fornecedores" items="${fornecedorDao.lista}" varStatus="id">
								<option value="${fornecedores.codFornecedor}">${fornecedores.nome}</option>
							</c:forEach>
						</select>
		    		</td>
		    	</tr>	    	
				<tr>
					<td>				    
				    	<LABEL accessKey=5 for=dataVencimento>Data Vencimento:</LABEL>
				    </td>
				    <td align="left"> 
				    	<input class="mask-data" type="text" name="dataVencimento" size="10" />
				    </td>
				</tr>
				<tr>
					<td>				    
				    	<LABEL accessKey=6 for=dataRealizada>Data Pagamento:</LABEL>
				    </td>
				    <td align="left"> 
				    	<input class="mask-data" type="text" name="dataRealizada" size="10"/>
				    </td>
				</tr>
				<tr>    			
    				<td>
		    			<LABEL accessKey=7 for=valor>Valor:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<input id="mask-number" class="direita" type="text" name="valor" size="10" value="0.00">
		    		</td>
		    	</tr>	 
		    	<tr>    			
    				<td>
		    			<LABEL accessKey=8 for=observacao>Observação:</LABEL>
		    		</td>
		    		<td align="left"> 
		    			<textarea name="observacao" rows="5" cols="50"></textarea>		    			
		    		</td>
		    	</tr>	   	
				
    		</table>
			<table align="right" class="normal">
    			<tr>
					<td>
				    	<input type="hidden" name="mesAtual" value="${mesAtual}" />
				    	<input type="hidden" name="anoAtual" value="${anoAtual}" />
				    	<BUTTON class=botao name=gravar type=submit>Gravar</BUTTON>
				    	<BUTTON class=botao name=limpar type=reset>Limpar</BUTTON>
				    	<A class=botao href="ListarLancamento?idUsuario=${login}&mesAtual=${mesAtual}&anoAtual=${anoAtual}">Cancelar</A>
				    </td>				    
				</tr>
			</table> 
		</FIELDSET>
	</form>
	</div>	
    </jsp:body>
    </c:if>
</layout:page>
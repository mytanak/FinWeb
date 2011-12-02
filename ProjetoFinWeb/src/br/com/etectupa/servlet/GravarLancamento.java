package br.com.etectupa.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.LancamentoDAO;
import br.com.etectupa.model.Lancamento;
import br.com.etectupa.util.Convert;
import br.com.etectupa.util.StringUtil;

public class GravarLancamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GravarLancamento() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codConta = 0;
		int codOperacao = 0;
		int codModalidade = 0;
		int codFornecedor = 0;
		Date dataVencimento = null;
		Date dataRealizada = null;
		double valor = 0;
		String vlr = "";
		String observacao = "";
		String msg = "";
		String pagina = "cadLancamento.jsp";

		int mesAtual = 0;
		int anoAtual = 0;
		
		if (request.getParameter("mesAtual") != null && !request.getParameter("mesAtual").equals("")){
			mesAtual = Integer.parseInt(request.getParameter("mesAtual"));
		}
		if (request.getParameter("anoAtual") != null && !request.getParameter("anoAtual").equals("")){
			anoAtual = Integer.parseInt(request.getParameter("anoAtual"));
		}
		
		if (request.getParameter("codConta") == null
				|| Integer.parseInt(request.getParameter("codConta")) == 0) {
			msg = "Informe a conta";
		} else {
			codConta = Integer.parseInt(request.getParameter("codConta"));
		}
		
		if (request.getParameter("codOperacao") == null
				|| Integer.parseInt(request.getParameter("codOperacao")) == 0) {
			msg = "Informe a Despesa/Receita";
		} else {
			codOperacao = Integer.parseInt(request.getParameter("codOperacao"));
		}
		
		if (request.getParameter("codModalidade") == null
				|| Integer.parseInt(request.getParameter("codModalidade")) == 0) {
			msg = "Informe a Modalidade";
		} else {
			codModalidade = Integer.parseInt(request.getParameter("codModalidade"));
		}
		
		if (request.getParameter("codFornecedor") == null
				|| Integer.parseInt(request.getParameter("codFornecedor")) == 0) {
			msg = "Informe o Fornecedor";
		} else {
			codFornecedor = Integer.parseInt(request.getParameter("codFornecedor"));
		}
		
		if (request.getParameter("dataVencimento") == null
				|| request.getParameter("dataVencimento").equals("")) {
			msg = "Informe a data de vencimento";
		} else {
			dataVencimento = Convert.StrToDateSql(request.getParameter("dataVencimento"));
		}
		
		if (request.getParameter("dataRealizada") != null) {
			dataRealizada = Convert.StrToDateSql(request.getParameter("dataRealizada"));
		}
		
		if (request.getParameter("valor") != null){
			vlr = request.getParameter("valor");
			vlr = vlr.replaceAll("\\.", "");
			vlr = vlr.replaceAll(",", ".");
		}		
		
		if (request.getParameter("valor") == null
				|| Double.parseDouble(vlr) == 0) {
			msg = "Informe o valor";
		} else {
			valor = Double.parseDouble(vlr);
		}
		
		if (request.getParameter("observacao") != null) {
			observacao = request.getParameter("observacao");
		}	
				
		
		if (msg.equals("")) {
			LancamentoDAO lancamentoDao = new LancamentoDAO();

		    Lancamento lancamento = new Lancamento();
		
	    	lancamento.setCodConta(codConta);
			lancamento.setCodOperacao(codOperacao);
			lancamento.setCodModalidade(codModalidade);
			lancamento.setCodFornecedor(codFornecedor);
			lancamento.setDataVencimento(dataVencimento);
			lancamento.setDataRealizada(dataRealizada);
			lancamento.setValor(valor);
			lancamento.setObservacao(observacao);
			
			try {
				lancamentoDao.inserir(lancamento);
				msg = "Cadastro realizado com sucesso!";

			} catch (Exception e) {
				msg = e.getMessage();
			}
			request.setAttribute("msg", msg);
		} else {
			request.setAttribute("msg", msg);
		}

		request.setAttribute( "mesAtual", mesAtual);
		request.setAttribute( "anoAtual", anoAtual);
		
		request.getRequestDispatcher(pagina).forward(request, response);
	
	}

}

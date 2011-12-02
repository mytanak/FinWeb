package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.OperacaoDAO;
import br.com.etectupa.model.Operacao;
import br.com.etectupa.validation.ValidaOperacao;

public class ConfirmarEditarOperacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmarEditarOperacao() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int codOperacao = Integer.parseInt(request.getParameter("codOperacao"));
		
		
		String descricao = "";
		String tipo = "";
		String msg = "";
		String pagina = "altOperacao.jsp";

		if (request.getParameter("descricao") == null
				|| request.getParameter("descricao").equals("")) {
			msg = "Informe a descrição da Operacao";
		} else {
			descricao = request.getParameter("descricao");
		}

		if (request.getParameter("tipo") == null
				|| request.getParameter("tipo").equals("")) {
			
		} 
		
		if (ValidaOperacao.existeOperacao(codOperacao, descricao)){
			msg = "Despesa/Receita já cadastrada.";
		}

		if (msg.equals("")) {
			pagina = "listarOperacao.jsp";			
			
			OperacaoDAO operacaoDao = new OperacaoDAO();
			Operacao operacao = operacaoDao.listarUnico(codOperacao);
			
			operacao.setCodOperacao(codOperacao);
			operacao.setDescricao(descricao);
			operacao.setTipo(tipo);
			
			try {
				operacaoDao.alterar(operacao);
				msg = "Alteração realizada com sucesso!";				

			} catch (Exception e) {
				msg = e.getMessage();
			}
			request.setAttribute("msg", msg);
		} else {
			request.setAttribute("msg", msg);
		}

		request.getRequestDispatcher(pagina).forward(request, response);
	}

}

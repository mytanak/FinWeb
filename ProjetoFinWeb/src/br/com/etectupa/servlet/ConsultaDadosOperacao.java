package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.OperacaoDAO;
import br.com.etectupa.displaytag.collection.ListOperacao;
import br.com.etectupa.model.Operacao;

public class ConsultaDadosOperacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConsultaDadosOperacao() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codOperacao = Integer.parseInt(request.getParameter("codOperacao"));

		OperacaoDAO operacaoDao = new OperacaoDAO();
		Operacao operacao = operacaoDao.listarUnico(codOperacao);
		ListOperacao listOperacao = new ListOperacao(operacao);
		
		request.setAttribute("listOperacao", listOperacao);
		request.getRequestDispatcher("dadosOperacao.jsp").forward(request, response);

	}

}

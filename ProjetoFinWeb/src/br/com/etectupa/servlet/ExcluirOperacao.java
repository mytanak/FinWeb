package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.OperacaoDAO;

public class ExcluirOperacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirOperacao() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codOperacao = Integer.parseInt(request.getParameter("codOperacao"));
		String pagina = "listarOperacao.jsp";

		OperacaoDAO operacaoDao = new OperacaoDAO();

		operacaoDao.excluir(codOperacao);

		request.setAttribute("msg", "Despesa/Receita excluída com sucesso!");

		request.getRequestDispatcher(pagina).forward(request, response);
	}

}

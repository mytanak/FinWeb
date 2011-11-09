package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.OperacaoDAO;
import br.com.etectupa.model.Operacao;

public class EditarOperacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarOperacao() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codOperacao = Integer.parseInt(request.getParameter("codOperacao"));

		OperacaoDAO operacaoDao = new OperacaoDAO();
		Operacao operacao = operacaoDao.listarUnico(codOperacao);

		request.setAttribute("Operacao", operacao);
		request.getRequestDispatcher("altOperacao.jsp").forward(request, response);

	}

}

package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.LancamentoDAO;
import br.com.etectupa.model.Lancamento;

public class EditarLancamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarLancamento() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int nroLancamento = Integer.parseInt(request.getParameter("nroLancamento"));

		LancamentoDAO lancamentoDao = new LancamentoDAO();
		Lancamento lancamento = lancamentoDao.listarUnico(nroLancamento);

		request.setAttribute("Lancamento", lancamento);
		request.getRequestDispatcher("altLancamento.jsp").forward(request, response);

	}

}

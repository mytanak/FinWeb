package br.com.etectupa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.LancamentoDAO;
import br.com.etectupa.model.Lancamento;

public class ListarLancamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarLancamento() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codConta = Integer.parseInt(request.getParameter("codConta"));

		LancamentoDAO lancamentoDao = new LancamentoDAO();
		List<Lancamento> lctosConta = lancamentoDao.getLista(codConta);

		request.setAttribute("lctosConta", lctosConta);
		request.getRequestDispatcher("lstLancamento.jsp").forward(request, response);

	}

}

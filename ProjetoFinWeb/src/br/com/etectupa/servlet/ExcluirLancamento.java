package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.LancamentoDAO;

public class ExcluirLancamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirLancamento() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int nroLancamento = Integer.parseInt(request.getParameter("nroLancamento"));
		String pagina = "listarLancamento.jsp";

		LancamentoDAO lancamentoDao = new LancamentoDAO();

		lancamentoDao.excluir(nroLancamento);

		request.setAttribute("msg", "Lancamento excluído com sucesso!");

		request.getRequestDispatcher(pagina).forward(request,
				response);
	}

}

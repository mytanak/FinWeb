package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.LancamentoDAO;
import br.com.etectupa.displaytag.collection.ListLancamento;
import br.com.etectupa.model.Lancamento;

public class EditarLancamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarLancamento() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int nroLancamento = Integer.parseInt(request.getParameter("nroLancamento"));
		int mesAtual = 0;
		int anoAtual = 0;
		
		if (request.getParameter("mesAtual") != null && !request.getParameter("mesAtual").equals("")){
			mesAtual = Integer.parseInt(request.getParameter("mesAtual"));
		}
		if (request.getParameter("anoAtual") != null && !request.getParameter("anoAtual").equals("")){
			anoAtual = Integer.parseInt(request.getParameter("anoAtual"));
		}

		LancamentoDAO lancamentoDao = new LancamentoDAO();
		Lancamento lancamento = lancamentoDao.listarUnico(nroLancamento);
		ListLancamento listLancamento = new ListLancamento(lancamento);

		request.setAttribute("listLancamento", listLancamento);
		request.setAttribute( "mesAtual", mesAtual);
		request.setAttribute( "anoAtual", anoAtual);
		
		request.getRequestDispatcher("altLancamento.jsp").forward(request, response);

	}

}

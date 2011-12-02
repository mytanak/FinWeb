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
		String idUsuario = request.getParameter("idUsuario");
		
		int mesAtual = 0;
		int anoAtual = 0;
		
		if (request.getParameter("mesAtual") != null && !request.getParameter("mesAtual").equals("")){
			mesAtual = Integer.parseInt(request.getParameter("mesAtual"));
		}
		if (request.getParameter("anoAtual") != null && !request.getParameter("anoAtual").equals("")){
			anoAtual = Integer.parseInt(request.getParameter("anoAtual"));
		}

		LancamentoDAO lancamentoDao = new LancamentoDAO();

		lancamentoDao.excluir(nroLancamento);

		request.setAttribute("msg", "Lancamento excluído com sucesso!");
		request.setAttribute( "mesAtual", mesAtual);
		request.setAttribute( "anoAtual", anoAtual);
		request.setAttribute("idUsuario",idUsuario);

		ListarLancamento listarLancamento = new ListarLancamento();
		listarLancamento.doGet(request, response);
	}

}

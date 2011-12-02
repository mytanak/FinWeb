package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.LancamentoDAO;

public class CadastroLancamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroLancamento() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pagina = "cadLancamento.jsp";
		int mesAtual = 0;
		int anoAtual = 0;
		
		if (request.getParameter("mesAtual") != null && !request.getParameter("mesAtual").equals("")){
			mesAtual = Integer.parseInt(request.getParameter("mesAtual"));
		}
		if (request.getParameter("anoAtual") != null && !request.getParameter("anoAtual").equals("")){
			anoAtual = Integer.parseInt(request.getParameter("anoAtual"));
		}

		request.setAttribute( "mesAtual", mesAtual);
		request.setAttribute( "anoAtual", anoAtual);

		request.getRequestDispatcher(pagina).forward(request,
				response);
	}

}

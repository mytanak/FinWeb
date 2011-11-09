package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.GrupoDAO;

public class ExcluirGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirGrupo() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codGrupo = Integer.parseInt(request.getParameter("codGrupo"));
		String pagina = "listarGrupo.jsp";

		GrupoDAO grupoDao = new GrupoDAO();

		grupoDao.excluir(codGrupo);

		request.setAttribute("msg", "Grupo excluído com sucesso!");

		request.getRequestDispatcher(pagina).forward(request,
				response);
	}

}

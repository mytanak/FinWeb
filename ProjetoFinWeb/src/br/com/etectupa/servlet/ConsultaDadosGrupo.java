package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.GrupoDAO;
import br.com.etectupa.displaytag.collection.ListGrupo;
import br.com.etectupa.model.Grupo;

public class ConsultaDadosGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConsultaDadosGrupo() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codGrupo = Integer.parseInt(request.getParameter("codGrupo"));

		GrupoDAO grupoDao = new GrupoDAO();
		Grupo grupo = grupoDao.listarUnico(codGrupo);
		ListGrupo listGrupo = new ListGrupo(grupo);
		
		request.setAttribute("listGrupo", listGrupo);
		request.getRequestDispatcher("dadosGrupo.jsp").forward(request, response);

	}

}

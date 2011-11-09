package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.GrupoDAO;
import br.com.etectupa.model.Grupo;

public class EditarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarGrupo() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codGrupo = Integer.parseInt(request.getParameter("codGrupo"));

		GrupoDAO grupoDao = new GrupoDAO();
		Grupo grupo = grupoDao.listarUnico(codGrupo);

		request.setAttribute("Grupo", grupo);
		request.getRequestDispatcher("altGrupo.jsp").forward(request, response);

	}

}

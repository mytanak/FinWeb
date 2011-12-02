package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.GrupoDAO;
import br.com.etectupa.model.Grupo;
import br.com.etectupa.validation.ValidaGrupo;

public class ConfirmarEditarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmarEditarGrupo() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codGrupo = Integer.parseInt(request.getParameter("codGrupo"));
		
		String descricao = "";
		
		String msg = "";
		String pagina = "altGrupo.jsp";

		if (request.getParameter("descricao") == null
				|| request.getParameter("descricao").equals("")) {
			msg = "Informe o nome do Grupo";
		} else {
			descricao = request.getParameter("descricao");
		}

		if (ValidaGrupo.existeGrupo(codGrupo, descricao)){
			msg = "Grupo já cadastrado.";
		}

		if (msg.equals("")) {
			pagina = "listarGrupo.jsp";			
			
			GrupoDAO grupoDao = new GrupoDAO();
			Grupo grupo = grupoDao.listarUnico(codGrupo);
			
			grupo.setCodGrupo(codGrupo);
			grupo.setDescricao(descricao);
			
			
			try {
				grupoDao.alterar(grupo);
				msg = "Alteração realizada com sucesso!";				

			} catch (Exception e) {
				msg = e.getMessage();
			}
			request.setAttribute("msg", msg);
		} else {
			request.setAttribute("msg", msg);
		}

		request.getRequestDispatcher(pagina).forward(request, response);
	}

}

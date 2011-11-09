package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.GrupoDAO;
import br.com.etectupa.model.Grupo;

public class GravarGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GravarGrupo() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String descricao = "";
		String msg = "";
		String pagina = "cadGrupo.jsp";

		if (request.getParameter("descricao") == null
				|| request.getParameter("descricao").equals("")) {
			msg = "Informe a descrição do grupo de contas";
		} else {
			descricao = request.getParameter("descricao");
		}

		if (msg.equals("")) {
			GrupoDAO grupoDao = new GrupoDAO();

			Grupo grupo = new Grupo();

			grupo.setDescricao(descricao);

			try {
				grupoDao.inserir(grupo);
				msg = "Cadastro realizado com sucesso!";

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

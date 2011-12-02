package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.GrupoDAO;
import br.com.etectupa.validation.ValidaGrupo;

public class ExcluirGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirGrupo() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codGrupo = Integer.parseInt(request.getParameter("codGrupo"));
		String pagina = "listarGrupo.jsp";
		String msg = "";
		
		if (ValidaGrupo.grupoUtilizado(codGrupo)){
			msg = "Grupo possui conta cadastrada e não pode ser excluído.";
		}
		
		if (msg.equals("")) {
			GrupoDAO grupoDao = new GrupoDAO();
			
			try {
				grupoDao.excluir(codGrupo);
				msg = "Exclusão realizada com sucesso!";

			} catch (Exception e) {
				msg = e.getMessage();
			}
			request.setAttribute("msg", msg);
		} else {
			request.setAttribute("msg", msg);
		}

		request.getRequestDispatcher(pagina).forward(request,
				response);
	}

}

package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.UsuarioDAO;

public class ExcluirLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
		String pagina = "listarUsuario.jsp";

		UsuarioDAO usuarioDao = new UsuarioDAO();

		usuarioDao.excluir(codUsuario);

		request.setAttribute("msg", "Login excluído com sucesso!");

		request.getRequestDispatcher(pagina).forward(request, response);
	}

}

package br.com.etectupa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.model.Usuario;
import br.com.etectupa.util.Criptografia;

public class AutenticarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AutenticarLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String idUsuario = "";
		String senha = "";
		String senhaCript = "";
		String pagina = "index.jsp?erro=1";
		boolean erro = true;

		if (request.getParameter("idUsuario") != null) {
			idUsuario = request.getParameter("idUsuario");
		}
		if (request.getParameter("senha") != null) {
			senha = request.getParameter("senha");
			senhaCript = Criptografia.criptografar(senha);
		}

		if (acao.equals("login")) {

			UsuarioDAO usuarioDao = new UsuarioDAO();

			List<Usuario> usuarios = usuarioDao.getLista();

			for (Usuario usuario : usuarios) {
				if (usuario.getIdUsuario().equals(idUsuario)) {
					if (usuario.getSenha().equals(senhaCript)) {
						HttpSession sessao = request.getSession();
						pagina = "home.jsp";
						sessao.setAttribute("login", idUsuario);
						request.setAttribute("login", idUsuario);
						erro = false;
						break;
					}
				}
			}
			if(erro){
				HttpSession sessao = request.getSession();
				pagina = "index.jsp";
				sessao.setAttribute("erro", 1);
				request.setAttribute("erro", 1);				
			}

		} else if (acao.equals("logout")) {
			HttpSession sessao = request.getSession();
			sessao.invalidate();
			pagina = "index.jsp";
		}

		request.getRequestDispatcher(pagina).forward(request, response);
		//response.sendRedirect(pagina);
	}

}

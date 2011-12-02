package br.com.etectupa.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.model.Usuario;
import br.com.etectupa.util.Convert;
import br.com.etectupa.util.Criptografia;
public class AlterarSenhaUsuario extends HttpServlet {
private static final long serialVersionUID = 1L;

	public AlterarSenhaUsuario() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
		String msg = "";
		String senha = "";
		
		if (request.getParameter("senha") == null || request.getParameter("senha").equals("")) {
			msg = "Informe a senha do usuário";
		} else {
			senha = request.getParameter("senha");
		}

		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.listarUnico(codUsuario);

		String senhaCript = Criptografia.criptografar(senha);
		usuario.setSenha(senhaCript);

		try {
			usuarioDao.alterar(usuario);
			msg = "Senha aterada com sucesso!";

		} catch (Exception e) {
			msg = e.getMessage();
		}
		request.setAttribute("msg", msg);

		request.getRequestDispatcher("configuracoes.jsp").forward(request, response);
	}
}

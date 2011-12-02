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
public class ConfirmarEditarUsuario extends HttpServlet {
private static final long serialVersionUID = 1L;

	public ConfirmarEditarUsuario() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
		String origem = request.getParameter("origem");
		
		String nome = "";
		String email = "";
		Date dataNascimento = null;
		String msg = "";
		String pagina = "altUsuario.jsp";

		if (request.getParameter("nome") == null || request.getParameter("nome").equals("")) {
			msg = "Informe o nome do usuário";
		} else {
			nome = request.getParameter("nome");
		}

		if (request.getParameter("email") == null || request.getParameter("email").equals("")) {
			msg = "Informe o e-mail do usuário";
		} else {
			email = request.getParameter("email");
		}
		if (request.getParameter("dataNascimento") == null || request.getParameter("dataNascimento").equals("")){
			msg = "Informe a data de nascimento do usuário";
		} else {
			dataNascimento = Convert.StrToDateSql(request.getParameter("dataNascimento"));
		}

		if (msg.equals("")) {
			if (origem == null){
				pagina = "listarUsuario.jsp";
			}else{
				pagina = "configuracoes.jsp";
			}		
			
			UsuarioDAO usuarioDao = new UsuarioDAO();
			Usuario usuario = usuarioDao.listarUnico(codUsuario);

			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setDataNascimento(dataNascimento);

			try {
				usuarioDao.alterar(usuario);
				msg = "Alteração realizada com sucesso!";

			} catch (Exception e) {
				msg = e.getMessage();
			}
			request.setAttribute("msg", msg);
		}else{
			request.setAttribute("msg", msg);
		}

		request.getRequestDispatcher(pagina).forward(request, response);
	}
}

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
import br.com.etectupa.validation.ValidaUsuario;

public class GravarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GravarLogin() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idUsuario = "";
		String nome = "";
		String senha = "";
		String email = "";
		Date dataNascimento = null;
		String msg = "";
		String pagina = "cadLogin.jsp";

		if (request.getParameter("idUsuario") == null || request.getParameter("idUsuario").equals(""))  {
			msg = "Informe a identificação do usuário";			
		} else {
			idUsuario = request.getParameter("idUsuario");
		}

		if (request.getParameter("nome") == null || request.getParameter("nome").equals("")) {
			msg = "Informe o nome do usuário";
		} else {
			nome = request.getParameter("nome");
		}

		if (request.getParameter("senha") == null || request.getParameter("senha").equals("")) {
			msg = "Informe a senha do usuário";
		} else {
			senha = request.getParameter("senha");
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

		if (ValidaUsuario.existeUsuario(idUsuario)){
			msg = "Usuário já cadastrado.";
		}

		if (msg.equals("")) {
			String senhaCript = Criptografia.criptografar(senha);

			UsuarioDAO usuarioDao = new UsuarioDAO();
			Usuario usuario = new Usuario();

			usuario.setIdUsuario(idUsuario);
			usuario.setNome(nome);
			usuario.setSenha(senhaCript);
			usuario.setEmail(email);
			usuario.setDataNascimento(dataNascimento);

			try {
				usuarioDao.inserir(usuario);
				msg = "Cadastro realizado com sucesso!";

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

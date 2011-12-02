package br.com.etectupa.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.displaytag.collection.ListUsuario;
import br.com.etectupa.model.Usuario;
import br.com.etectupa.util.Convert;
import br.com.etectupa.util.Criptografia;
import br.com.etectupa.util.GerarSenha;
import br.com.etectupa.validation.ValidaLogin;

public class RecuperarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecuperarSenha() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idUsuario = "";
		String nome = "";
		String email = "";
		Date dataNascimento = null;
		String msg = "";
		String senhaGerada = ""; 
		String pagina = "recuperarSenha.jsp";

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
			Usuario login = new Usuario();
			
			login.setIdUsuario(idUsuario);
			login.setNome(nome);
			login.setEmail(email);
			login.setDataNascimento(dataNascimento);
			
			if (ValidaLogin.existeUsuario(login)){
				senhaGerada = GerarSenha.gerarSenha(6, email);

				String senhaCript = Criptografia.criptografar(senhaGerada);

				UsuarioDAO usuarioDao = new UsuarioDAO();
				Usuario usuario = usuarioDao.getUsuario(idUsuario);

				usuario.setNome(nome);
				usuario.setEmail(email);
				usuario.setDataNascimento(dataNascimento);
				usuario.setSenha(senhaCript);
				
				ListUsuario listUsuario = new ListUsuario(usuario);
				
				try {
					usuarioDao.alterar(usuario);
					msg = "Nova senha gerada com sucesso!";
					request.setAttribute("listLogin", listUsuario);

				} catch (Exception e) {
					msg = e.getMessage();
				}			
			}else{
				msg = "Usuário não encontrado.";
			}

			request.setAttribute("msg", msg);
		}else{
			request.setAttribute("msg", msg);
		}
		
		request.setAttribute("senhaGerada", senhaGerada);

		request.getRequestDispatcher(pagina).forward(request, response);
	}

}

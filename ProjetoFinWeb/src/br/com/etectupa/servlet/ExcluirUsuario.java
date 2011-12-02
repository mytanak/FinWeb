package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.validation.ValidaConta;
import br.com.etectupa.validation.ValidaUsuario;

public class ExcluirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
		String pagina = "listarUsuario.jsp";
		String msg = "";
		
		if (ValidaUsuario.usuarioUtilizado(codUsuario)){
			msg = "Usuário possui conta cadastrada e não pode ser excluído.";
		}
		
		if (msg.equals("")) {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			
			try {
				usuarioDao.excluir(codUsuario);
				msg = "Exclusão realizada com sucesso!";

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

package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.model.Usuario;

public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
		String pagina = "altUsuario.jsp";
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = usuarioDao.listarUnico(codUsuario);
		
		request.setAttribute("Usuario", usuario);
		request.getRequestDispatcher(pagina).forward(request, response);
	}

}

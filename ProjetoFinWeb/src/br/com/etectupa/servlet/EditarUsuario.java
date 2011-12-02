package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.displaytag.collection.ListUsuario;
import br.com.etectupa.model.Usuario;

public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditarUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
		String origem = request.getParameter("origem");
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		Usuario usuario = usuarioDao.listarUnico(codUsuario);
		ListUsuario listUsuario = new ListUsuario(usuario);

		request.setAttribute("listUsuario", listUsuario);
		request.setAttribute("origem", origem);
		request.getRequestDispatcher("altUsuario.jsp").forward(request, response);	
		
	}

}

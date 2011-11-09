package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.ContaDAO;

public class ExcluirConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirConta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codConta = Integer.parseInt(request.getParameter("codConta"));
		String pagina = "listarConta.jsp";
		
		ContaDAO contaDao = new ContaDAO();
		
		contaDao.excluir(codConta);
		
		request.setAttribute("msg", "Conta excluída com sucesso!");
		
		request.getRequestDispatcher(pagina).forward(request, response);
	}

}

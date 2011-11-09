package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.FornecedorDAO;

public class ExcluirFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirFornecedor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codFornecedor = Integer.parseInt(request.getParameter("codFornecedor"));
		String pagina = "listarFornecedor.jsp";
		
		FornecedorDAO fornecedorDao = new FornecedorDAO();
		
		fornecedorDao.excluir(codFornecedor);
		
		request.setAttribute("msg", "Fornecedor excluído com sucesso!");
		
		request.getRequestDispatcher(pagina).forward(request, response);
	}

}

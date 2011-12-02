package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.FornecedorDAO;
import br.com.etectupa.validation.ValidaFornecedor;

public class ExcluirFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirFornecedor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codFornecedor = Integer.parseInt(request.getParameter("codFornecedor"));
		String pagina = "listarFornecedor.jsp";
		String msg = "";
		
		if (ValidaFornecedor.fornecedorUtilizado(codFornecedor)){
			msg = "Fornecedor possui movimentação e não pode ser excluído.";
		}
		
		if (msg.equals("")) {
			FornecedorDAO fornecedorDao = new FornecedorDAO();
			
			try {
				fornecedorDao.excluir(codFornecedor);
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

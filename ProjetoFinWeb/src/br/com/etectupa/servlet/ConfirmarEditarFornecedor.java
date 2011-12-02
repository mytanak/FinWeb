package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.FornecedorDAO;
import br.com.etectupa.model.Fornecedor;
import br.com.etectupa.validation.ValidaFornecedor;

public class ConfirmarEditarFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmarEditarFornecedor() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codFornecedor = Integer.parseInt(request.getParameter("codFornecedor"));
		
		String nome = "";
		
		String msg = "";
		String pagina = "altFornecedor.jsp";

		if (request.getParameter("nome") == null
				|| request.getParameter("nome").equals("")) {
			msg = "Informe o nome do Fornecedor";
		} else {
			nome = request.getParameter("nome");
		}

		if (ValidaFornecedor.existeFornecedor(codFornecedor, nome)){
			msg = "Fornecedor já cadastrado.";
		}

		if (msg.equals("")) {
			pagina = "listarFornecedor.jsp";			
			
			FornecedorDAO fornecedorDao = new FornecedorDAO();
			Fornecedor fornecedor = fornecedorDao.listarUnico(codFornecedor);
			
			fornecedor.setCodFornecedor(codFornecedor);
			fornecedor.setNome(nome);
			
			
			try {
				fornecedorDao.alterar(fornecedor);
				msg = "Alteração realizada com sucesso!";				

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

package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.FornecedorDAO;
import br.com.etectupa.model.Fornecedor;
import br.com.etectupa.validation.ValidaFornecedor;

public class GravarFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GravarFornecedor() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nome = "";
		String msg = "";
		String pagina = "cadFornecedor.jsp";

		if (request.getParameter("nome") == null
				|| request.getParameter("nome").equals("")) {
			msg = "Informe o nome do fornecedor";
		} else {
			nome = request.getParameter("nome");
		}

		if (ValidaFornecedor.existeFornecedor(nome)){
			msg = "Fornecedor já cadastrado.";
		}

		if (msg.equals("")) {
			FornecedorDAO fornecedorDao = new FornecedorDAO();

			Fornecedor fornecedor = new Fornecedor();

			fornecedor.setNome(nome);

			try {
				fornecedorDao.inserir(fornecedor);
				msg = "Cadastro realizado com sucesso!";

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

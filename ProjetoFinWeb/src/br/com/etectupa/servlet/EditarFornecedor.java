package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.FornecedorDAO;
import br.com.etectupa.model.Fornecedor;

public class EditarFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarFornecedor() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codFornecedor = Integer.parseInt(request.getParameter("codFornecedor"));

		FornecedorDAO fornecedorDao = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDao.listarUnico(codFornecedor);

		request.setAttribute("Fornecedor", fornecedor);
		request.getRequestDispatcher("altFornecedor.jsp").forward(request, response);

	}

}

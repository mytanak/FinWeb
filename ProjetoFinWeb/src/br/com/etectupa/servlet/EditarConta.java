package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.model.Conta;

public class EditarConta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarConta() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codConta = Integer.parseInt(request.getParameter("codConta"));

		ContaDAO contaDao = new ContaDAO();
		Conta conta = contaDao.listarUnico(codConta);

		request.setAttribute("Conta", conta);
		request.getRequestDispatcher("altConta.jsp").forward(request, response);

	}

}

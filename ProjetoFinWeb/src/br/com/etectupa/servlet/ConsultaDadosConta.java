package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.displaytag.collection.ListConta;
import br.com.etectupa.model.Conta;

public class ConsultaDadosConta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConsultaDadosConta() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codConta = Integer.parseInt(request.getParameter("codConta"));

		ContaDAO contaDao = new ContaDAO();
		Conta conta = contaDao.listarUnico(codConta);
		ListConta listConta = new ListConta(conta);
		
		request.setAttribute("listConta", listConta);
		request.getRequestDispatcher("dadosConta.jsp").forward(request, response);

	}

}

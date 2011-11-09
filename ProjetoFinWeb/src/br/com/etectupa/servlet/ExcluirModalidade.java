package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.ModalidadeDAO;

public class ExcluirModalidade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirModalidade() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codModalidade = Integer.parseInt(request
				.getParameter("codModalidade"));
		String pagina = "listarModalidade.jsp";

		ModalidadeDAO modalidadeDao = new ModalidadeDAO();

		modalidadeDao.excluir(codModalidade);

		request.setAttribute("msg", "Modalidade excluída com sucesso!");

		request.getRequestDispatcher(pagina).forward(request, response);
	}

}

package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.ModalidadeDAO;
import br.com.etectupa.model.Modalidade;

public class EditarModalidade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarModalidade() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codModalidade = Integer.parseInt(request.getParameter("codModalidade"));

		ModalidadeDAO modalidadeDao = new ModalidadeDAO();
		Modalidade modalidade = modalidadeDao.listarUnico(codModalidade);

		request.setAttribute("Modalidade", modalidade);
		request.getRequestDispatcher("altModalidade.jsp").forward(request, response);

	}

}

package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.ModalidadeDAO;
import br.com.etectupa.validation.ValidaModalidade;

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
		String msg = "";
		
		if (ValidaModalidade.modalidadeUtilizada(codModalidade)){
			msg = "Modalidade de pagamento/recebimento possui movimentação e não pode ser excluída.";
		}
		
		if (msg.equals("")) {
			ModalidadeDAO modalidadeDao = new ModalidadeDAO();
			
			try {
				modalidadeDao.excluir(codModalidade);
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

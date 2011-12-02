package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.ModalidadeDAO;
import br.com.etectupa.model.Modalidade;
import br.com.etectupa.validation.ValidaModalidade;

public class GravarModalidade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GravarModalidade() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String descricao = "";
		String msg = "";
		String pagina = "cadModalidade.jsp";

		if (request.getParameter("descricao") == null
				|| request.getParameter("descricao").equals("")) {
			msg = "Informe a descrição da modalidade de pagamento/recebimento";
		} else {
			descricao = request.getParameter("descricao");
		}
		
		if (ValidaModalidade.existeModalidade(descricao)){
			msg = "Modalidade de pagamento/recebimento já cadastrada.";
		}
		
		if (msg.equals("")) {
			ModalidadeDAO modalidadeDao = new ModalidadeDAO();

			Modalidade modalidade = new Modalidade();

			modalidade.setDescricao(descricao);

			try {
				modalidadeDao.inserir(modalidade);
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

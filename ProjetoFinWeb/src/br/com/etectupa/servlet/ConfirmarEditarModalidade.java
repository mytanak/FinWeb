package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.ModalidadeDAO;
import br.com.etectupa.model.Modalidade;
import br.com.etectupa.validation.ValidaModalidade;

public class ConfirmarEditarModalidade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmarEditarModalidade() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codModalidade = Integer.parseInt(request.getParameter("codModalidade"));
		
		
		String descricao = "";
		String msg = "";
		String pagina = "altModalidade.jsp";

		if (request.getParameter("descricao") == null
				|| request.getParameter("descricao").equals("")) {
			msg = "Informe a descrição da modalidade";
		} else {
			descricao = request.getParameter("descricao");
		}

		if (ValidaModalidade.existeModalidade(codModalidade, descricao)){
			msg = "Modalidade de pagamento/recebimento já cadastrada.";
		}
		
		if (msg.equals("")) {
			pagina = "listarModalidade.jsp";			
			
			ModalidadeDAO modalidadeDao = new ModalidadeDAO();
			Modalidade modalidade = modalidadeDao.listarUnico(codModalidade);
			
			modalidade.setCodModalidade(codModalidade);
			modalidade.setDescricao(descricao);
						
			try {
				modalidadeDao.alterar(modalidade);
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

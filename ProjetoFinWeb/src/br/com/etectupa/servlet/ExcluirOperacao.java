package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.OperacaoDAO;
import br.com.etectupa.validation.ValidaOperacao;

public class ExcluirOperacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirOperacao() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codOperacao = Integer.parseInt(request.getParameter("codOperacao"));
		String pagina = "listarOperacao.jsp";
		String msg = "";
		
		if (ValidaOperacao.operacaoUtilizada(codOperacao)){
			msg = "Despesa/Receita possui movimentação e não pode ser excluída.";
		}
		
		if (msg.equals("")) {
			OperacaoDAO operacaoDao = new OperacaoDAO();
			
			try {
				operacaoDao.excluir(codOperacao);
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

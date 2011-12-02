package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.OperacaoDAO;
import br.com.etectupa.model.Operacao;
import br.com.etectupa.validation.ValidaOperacao;

public class GravarOperacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GravarOperacao() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codGrupo = 0;
		String descricao = "";
		String tipo = "";

		String msg = "";
		String pagina = "cadOperacao.jsp";

		if (request.getParameter("codGrupo") == null
				|| Integer.parseInt(request.getParameter("codGrupo")) == 0) {
			msg = "Informe o grupo da despesa/receita";
		} else {
			codGrupo = Integer.parseInt(request.getParameter("codGrupo"));
		}

		if (request.getParameter("descricao") == null
				|| request.getParameter("descricao").equals("")) {
			msg = "Informe a descrição da despesa/receita";
		} else {
			descricao = request.getParameter("descricao");
		}
		if (request.getParameter("tipo") == null
				|| request.getParameter("tipo").equals("")) {
			msg = "Informe o tipo da despesa/receita";
		} else {
			tipo = request.getParameter("tipo");
		}

		if (ValidaOperacao.existeOperacao(descricao)){
			msg = "Despesa/Receita já cadastrada.";
		}

		if (msg.equals("")) {
			OperacaoDAO operacaoDao = new OperacaoDAO();

			Operacao operacao = new Operacao();

			operacao.setCodGrupo(codGrupo);
			operacao.setDescricao(descricao);
			operacao.setTipo(tipo);

			try {
				operacaoDao.inserir(operacao);
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

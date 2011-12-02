package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.model.Conta;
import br.com.etectupa.model.Usuario;
import br.com.etectupa.validation.ValidaConta;

public class ConfirmarEditarConta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmarEditarConta() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int codConta = Integer.parseInt(request.getParameter("codConta"));
		int codUsuario = Integer.parseInt(request.getParameter("codUsuario"));
		
		String descricao = "";
		double saldoInicial = 0;
		String msg = "";
		String pagina = "altConta.jsp";
		String vlr = "";

		if (request.getParameter("descricao") == null
				|| request.getParameter("descricao").equals("")) {
			msg = "Informe a descrição da conta";
		} else {
			descricao = request.getParameter("descricao");
		}

		if (request.getParameter("saldoInicial") != null){
			vlr = request.getParameter("saldoInicial");
			vlr = vlr.replaceAll("\\.", "");
			vlr = vlr.replaceAll(",", ".");
		}		
			
		if (request.getParameter("saldoInicial") != null && !request.getParameter("saldoInicial").equals("")){
			saldoInicial = Double.parseDouble(vlr);
		}

		if (ValidaConta.existeConta(codConta, codUsuario, descricao)){
			msg = "Conta já cadastrada.";
		}		

		if (msg.equals("")) {
			pagina = "listarConta.jsp";			
			
			ContaDAO contaDao = new ContaDAO();
			Conta conta = contaDao.listarUnico(codConta);
			
			conta.setCodUsuario(codUsuario);
			conta.setDescricao(descricao);
			conta.setSaldoInicial(saldoInicial);
			
			try {
				contaDao.alterar(conta);
				msg = "Alteração realizada com sucesso!";				

			} catch (Exception e) {
				msg = e.getMessage();
			}
			request.setAttribute("msg", msg);
		} else {
			ContaDAO contaDao = new ContaDAO();
			Conta conta = contaDao.listarUnico(codConta);

			request.setAttribute("msg", msg);
			request.setAttribute("Conta", conta);
		}

		request.getRequestDispatcher(pagina).forward(request, response);
	}

}

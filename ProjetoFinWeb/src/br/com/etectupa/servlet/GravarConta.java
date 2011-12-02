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

public class GravarConta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GravarConta() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		String pagina = "cadConta.jsp";
		String idUsuario = request.getParameter("idUsuario");		
		String descricao = "";
		double saldoInicial = 0;
		String msg = "";	
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
		
		if (ValidaConta.existeConta(descricao)){
			msg = "Conta já cadastrada.";
		}
		
		if (msg.equals("")) {
			
			ContaDAO contaDao = new ContaDAO();
			UsuarioDAO usuarioDao = new UsuarioDAO();

			Conta conta = new Conta();

			Usuario usuario = usuarioDao.getUsuario(idUsuario);

			conta.setCodUsuario(usuario.getCodUsuario());
			conta.setDescricao(descricao);
			conta.setSaldoInicial(saldoInicial);
			
			try {
				contaDao.inserir(conta);
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

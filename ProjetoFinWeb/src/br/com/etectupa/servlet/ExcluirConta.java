package br.com.etectupa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.validation.ValidaConta;

public class ExcluirConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirConta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codConta = Integer.parseInt(request.getParameter("codConta"));
		String pagina = "listarConta.jsp";
		String msg = "";
		
		if (ValidaConta.contaUtilizada(codConta)){
			msg = "Conta possui movimentação e não pode ser excluída.";
		}
		
		if (msg.equals("")) {
			ContaDAO contaDao = new ContaDAO();
			
			try {
				contaDao.excluir(codConta);
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

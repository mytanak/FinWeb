package br.com.etectupa.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.LocalDate;

import br.com.etectupa.collection.ResumoLancamento;
import br.com.etectupa.displaytag.collection.ListLancamento;
import br.com.etectupa.util.Convert;

public class ListarLancamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarLancamento() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idUsuario = request.getParameter("idUsuario");
		String altMes = request.getParameter("alteraMes");
		int mesAtual = 0;
		int anoAtual = 0;
		
		Date dataInicial;
		Date dataFinal;
		LocalDate dtInicial;
		LocalDate dtFinal;
		
		if (request.getParameter("mesAtual") != null && !request.getParameter("mesAtual").equals("")){
			mesAtual = Integer.parseInt(request.getParameter("mesAtual"));
		}
		if (request.getParameter("anoAtual") != null && !request.getParameter("anoAtual").equals("")){
			anoAtual = Integer.parseInt(request.getParameter("anoAtual"));
		}

		LocalDate today = new LocalDate();
		
		if (mesAtual == 0){
			mesAtual = today.getMonthOfYear(); 
		}
		
		if (anoAtual == 0){
			anoAtual = today.getYear(); 
		}
		
		LocalDate periodoAtual = new LocalDate(anoAtual + "-" + mesAtual + "-01");
		
		int alteraMes = 0;		

		if (altMes != null && !altMes.equals("")){
			alteraMes = Integer.parseInt(altMes);
		}

		if (alteraMes == -1){
			periodoAtual = periodoAtual.minusMonths(1);
		}
		else if (alteraMes == 1){
			periodoAtual = periodoAtual.plusMonths(1);
		}	

		dtInicial = new LocalDate(periodoAtual.getYear() + "-" + periodoAtual.getMonthOfYear() + "-" + periodoAtual.dayOfMonth().getMinimumValue());
		dtFinal = new LocalDate(periodoAtual.getYear() + "-" + periodoAtual.getMonthOfYear() + "-" + periodoAtual.dayOfMonth().getMaximumValue());

		dataInicial = Convert.StrToDateSql(dtInicial.toString("dd/MM/yyyy"));
		dataFinal = Convert.StrToDateSql(dtFinal.toString("dd/MM/yyyy"));

		request.setAttribute( "mesStr", periodoAtual.toString("MMMM"));
		request.setAttribute( "primeiroDiaMes", dtInicial.toString("dd/MM/yyyy"));
		request.setAttribute( "ultimoDiaMes", dtFinal.toString("dd/MM/yyyy"));
		request.setAttribute( "mesAtual", periodoAtual.getMonthOfYear());
		request.setAttribute( "anoAtual", periodoAtual.getYear());
		request.setAttribute( "origem", "servlet");

		ListLancamento listLancamento = new ListLancamento(idUsuario, 1, dataInicial, dataFinal);
		
		ResumoLancamento resumoLancamento = new ResumoLancamento(idUsuario, dataInicial, dataFinal);
		
		request.setAttribute( "listLancamento", listLancamento);
		request.setAttribute( "resumoLancamento", resumoLancamento);
		
		request.getRequestDispatcher("listarLancamento.jsp").forward(request, response);

	}

}

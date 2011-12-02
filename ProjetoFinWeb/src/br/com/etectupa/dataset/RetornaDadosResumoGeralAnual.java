package br.com.etectupa.dataset;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import br.com.etectupa.dao.MovtoDAO;
import br.com.etectupa.dao.SaldoDAO;
import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.model.Usuario;
import br.com.etectupa.util.Biblioteca;
import br.com.etectupa.util.Convert;

public class RetornaDadosResumoGeralAnual {
	public List<DadosGrafico> retornaDados(String idUsuario) {
		ArrayList<DadosGrafico> dadosGrafico = new ArrayList<DadosGrafico>();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		
		int ano = Biblioteca.retornaAno(Biblioteca.Today());
		Date dtInicial;
		Date dtFinal;
		
		double despesas = 0;
		double receitas = 0;

		MovtoDAO movtoDao = new MovtoDAO();
		
		for (int i = 1; i <= 12; i++) {			
			dtInicial = Convert.StrToDateSql(Biblioteca.primeiroDiaMes(ano, i));
			dtFinal = Convert.StrToDateSql(Biblioteca.ultimoDiaMes(ano, i));
			
			despesas = movtoDao.retornaMovtoDebitoPago(usuario,dtInicial,dtFinal);
			
			DadosGrafico dadosDespesas = new DadosGrafico();
			
			dadosDespesas.setDescricaoX("Despesas");
			dadosDespesas.setDescricaoY(Biblioteca.retornaMesAbrevStr(i));
			dadosDespesas.setValor(despesas);
			
			dadosGrafico.add(dadosDespesas);			

			receitas = movtoDao.retornaMovtoCreditoPago(usuario,dtInicial,dtFinal);
			
			DadosGrafico dadosReceitas = new DadosGrafico();
			
			dadosReceitas.setDescricaoX("Receitas");
			dadosReceitas.setDescricaoY(Biblioteca.retornaMesAbrevStr(i));
			dadosReceitas.setValor(receitas);
			
			dadosGrafico.add(dadosReceitas);	
		}				
			
		return dadosGrafico;
	}
	
	public List<DadosResumoGeralAnual> retornaDadosResumo(String idUsuario) {
		ArrayList<DadosResumoGeralAnual> dadosResumoGeralAnual = new ArrayList<DadosResumoGeralAnual>();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		
		int ano = Biblioteca.retornaAno(Biblioteca.Today());
		Date dtInicial;
		Date dtFinal;
		
		double despesas = 0;
		double receitas = 0;

		MovtoDAO movtoDao = new MovtoDAO();
		
		for (int i = 1; i <= 12; i++) {			
			dtInicial = Convert.StrToDateSql(Biblioteca.primeiroDiaMes(ano, i));
			dtFinal = Convert.StrToDateSql(Biblioteca.ultimoDiaMes(ano, i));
			
			despesas = movtoDao.retornaMovtoDebitoPago(usuario,dtInicial,dtFinal);
			receitas = movtoDao.retornaMovtoCreditoPago(usuario,dtInicial,dtFinal);
			
			DadosResumoGeralAnual dadosResumoAnual = new DadosResumoGeralAnual();
			
			dadosResumoAnual.setMes(Biblioteca.retornaMesAbrevStr(i));			
			dadosResumoAnual.setDespesa(despesas);
			dadosResumoAnual.setReceita(receitas);
			
			dadosResumoGeralAnual.add(dadosResumoAnual);	
		}				
			
		return dadosResumoGeralAnual;
	}
	
}

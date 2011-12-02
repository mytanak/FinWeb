package br.com.etectupa.dataset;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.etectupa.dao.GrupoDAO;
import br.com.etectupa.dao.MovtoDAO;
import br.com.etectupa.dao.OperacaoDAO;
import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.model.Grupo;
import br.com.etectupa.model.Operacao;
import br.com.etectupa.model.Usuario;
import br.com.etectupa.util.Biblioteca;
import br.com.etectupa.util.Convert;

public class RetornaDadosGrupoDespesas {
	public List<DadosGraficoPizzaSetorial> retornaDados(String idUsuario) {
		ArrayList<DadosGraficoPizzaSetorial> dadosGrafico = new ArrayList<DadosGraficoPizzaSetorial>();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		
		int ano = Biblioteca.retornaAno(Biblioteca.Today());
		Date dtInicial;
		Date dtFinal;
		
		double despesas = 0;
		
		dtInicial = Convert.StrToDateSql(Biblioteca.primeiroDiaMes(ano, 1));
		dtFinal = Convert.StrToDateSql(Biblioteca.ultimoDiaMes(ano, 12));

		MovtoDAO movtoDao = new MovtoDAO();
		GrupoDAO grupoDao = new GrupoDAO();
		OperacaoDAO operacaoDao = new OperacaoDAO();
		
		List<Grupo> grupos = grupoDao.listaGruposUtilizados("D");
		
		for (Grupo grupo : grupos) {
			DadosGraficoPizzaSetorial dadosGrafDespesas = new DadosGraficoPizzaSetorial();		
			
			List<Operacao> operacoes = operacaoDao.listarOperacoes(grupo.getCodGrupo());
			
			despesas = movtoDao.retornaMovtoDebitoPago(usuario,operacoes,dtInicial,dtFinal);
			
			dadosGrafDespesas.setDescricao(grupo.getDescricao());
			dadosGrafDespesas.setValor(despesas);
			
			dadosGrafico.add(dadosGrafDespesas);
		}
			
		return dadosGrafico;
	}	
	
}

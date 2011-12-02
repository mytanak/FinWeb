package br.com.etectupa.dataset;

import java.util.ArrayList;
import java.util.List;

public class GeraDadosGraficoPizzaSetorial {
	public List<DadosGraficoPizzaSetorial> retornaDadosGraficoPizzaSetorial(String producerId, String idUsuario) {
		ArrayList<DadosGraficoPizzaSetorial> dadosGrafico = new ArrayList<DadosGraficoPizzaSetorial>();
		
		if (producerId.equals("GrupoDespesas")) {
			
			RetornaDadosGrupoDespesas dadosGrupoDespesas = new RetornaDadosGrupoDespesas();
			dadosGrafico = (ArrayList<DadosGraficoPizzaSetorial>) dadosGrupoDespesas.retornaDados(idUsuario);
			
		}
		
		if (producerId.equals("GrupoReceitas")) {
			
			RetornaDadosGrupoReceitas dadosGrupoReceitas = new RetornaDadosGrupoReceitas();
			dadosGrafico = (ArrayList<DadosGraficoPizzaSetorial>) dadosGrupoReceitas.retornaDados(idUsuario);
			
		}
		
		return dadosGrafico;		
	}
}

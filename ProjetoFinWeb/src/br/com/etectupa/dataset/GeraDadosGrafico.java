package br.com.etectupa.dataset;

import java.util.ArrayList;
import java.util.List;

public class GeraDadosGrafico {
	public List<DadosGrafico> retornaDadosGrafico(String producerId, String idUsuario) {
		ArrayList<DadosGrafico> dadosGrafico = new ArrayList<DadosGrafico>();
		
		if (producerId.equals("ResumoGeralAnual")) {
			
			RetornaDadosResumoGeralAnual dadosResumo = new RetornaDadosResumoGeralAnual();
			dadosGrafico = (ArrayList<DadosGrafico>) dadosResumo.retornaDados(idUsuario);
			
		}
		return dadosGrafico;
	}
	
}

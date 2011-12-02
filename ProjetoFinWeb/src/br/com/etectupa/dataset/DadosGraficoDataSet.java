package br.com.etectupa.dataset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jfree.data.category.DefaultCategoryDataset;

import br.com.etectupa.util.Conecta;
import de.laures.cewolf.DatasetProduceException;
import de.laures.cewolf.DatasetProducer;

public class DadosGraficoDataSet implements DatasetProducer {

	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(DadosGraficoDataSet.class);
	private List<DadosGrafico> dadosGrafico;
	private String producerId = "";

	public DadosGraficoDataSet(String producerId, String idUsuario){
		this.producerId = producerId;
		GeraDadosGrafico geraDadosGrafico = new GeraDadosGrafico(); 
		dadosGrafico = geraDadosGrafico.retornaDadosGrafico(producerId, idUsuario);		
	}

	// Retorna uma Dataset com os dados que irão alimentar o gráfico
	public Object produceDataset(Map arg0) throws DatasetProduceException {
		
		// Criando um Dataset para o gráfico de linhas
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		
		for (DadosGrafico dados : dadosGrafico) {
			ds.addValue(dados.getValor(), dados.getDescricaoX(), dados.getDescricaoY());				
		}
		
		return ds;
	}

	// O dados deste dataset é invalidado imediatamente. O tempo de retorno influencia no cache do cewolf
	public boolean hasExpired(Map arg0, Date arg1) {
		return true;
		// Se quisessemos que os dataset expirasse em 5 segundos colocariamos
		// return (System.currentTimeMillis() - since.getTime())  > 5000;
	}

	// Retorna um Id único para o dataset
	public String getProducerId() {
		return this.producerId;
	}

}

package br.com.etectupa.dataset;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jfree.data.general.DefaultPieDataset;

import de.laures.cewolf.DatasetProduceException;
import de.laures.cewolf.DatasetProducer;

public class DadosGraficoPizzaSetorialDataSet implements DatasetProducer {

	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(DadosGraficoPizzaSetorialDataSet.class);
	private List<DadosGraficoPizzaSetorial> dadosGraficoPizza;
	private String producerId = "";

	public DadosGraficoPizzaSetorialDataSet(String producerId, String idUsuario){
		this.producerId = producerId;
		GeraDadosGraficoPizzaSetorial dadosGrafico = new GeraDadosGraficoPizzaSetorial(); 
		dadosGraficoPizza = dadosGrafico.retornaDadosGraficoPizzaSetorial(producerId, idUsuario);
	}
	
	// Retorna uma Dataset com os dados que irão alimentar o gráfico
	public Object produceDataset(Map arg0) throws DatasetProduceException {
		
		// Criando um Dataset para o gráfico de pizza
		DefaultPieDataset ds = new DefaultPieDataset();
			
		for (DadosGraficoPizzaSetorial dados : dadosGraficoPizza) {
			ds.setValue(dados.getDescricao(), dados.getValor());				
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

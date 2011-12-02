package br.com.etectupa.displaytag.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.etectupa.dao.GrupoDAO;
import br.com.etectupa.dao.OperacaoDAO;
import br.com.etectupa.displaytag.OperacaoList;
import br.com.etectupa.model.Grupo;
import br.com.etectupa.model.Operacao;

public class ListOperacao extends ArrayList {
	private static final long serialVersionUID = 899149338534L;

	public ListOperacao() {
		super();
		OperacaoDAO operacaoDao = new OperacaoDAO();
		List<Operacao> operacoes = operacaoDao.getLista();
		
		for (Operacao operacao : operacoes) {
			OperacaoList operacaoList = new OperacaoList();
			
			operacaoList.setCodGrupo(operacao.getCodGrupo());
			operacaoList.setCodOperacao(operacao.getCodOperacao());
			operacaoList.setDescricao(operacao.getDescricao());
			operacaoList.setTipo(operacao.getTipo());
			if(operacao.getTipo().equals("D")){
				operacaoList.setTipoStr("Débito");
			}else{
				operacaoList.setTipoStr("Crédito");
			}
			
			GrupoDAO grupoDao = new GrupoDAO();
			Grupo grupo = grupoDao.listarUnico(operacao.getCodGrupo());
			
			operacaoList.setDescGrupo(grupo.getDescricao());
			
			add(operacaoList);
		}

		Collections.sort(this);
	}    
	
	public ListOperacao(Operacao operacao) {
		super();
		OperacaoList operacaoList = new OperacaoList();
		
		operacaoList.setCodOperacao(operacao.getCodOperacao());
		operacaoList.setDescricao(operacao.getDescricao());
		operacaoList.setDescricao(operacao.getDescricao());
		operacaoList.setTipo(operacao.getTipo());
		if(operacao.getTipo().equals("D")){
			operacaoList.setTipoStr("Débito");
		}else{
			operacaoList.setTipoStr("Crédito");
		}
				
		GrupoDAO grupoDao = new GrupoDAO();
		Grupo grupo = grupoDao.listarUnico(operacao.getCodGrupo());
		
		operacaoList.setDescGrupo(grupo.getDescricao());

		add(operacaoList);
		
		Collections.sort(this);
	}
}

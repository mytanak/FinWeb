package br.com.etectupa.displaytag.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.etectupa.dao.ModalidadeDAO;
import br.com.etectupa.displaytag.GrupoList;
import br.com.etectupa.displaytag.ModalidadeList;


import br.com.etectupa.model.Grupo;
import br.com.etectupa.model.Modalidade;


public class ListModalidade extends ArrayList {
	private static final long serialVersionUID = 899149338534L;

	public ListModalidade() {
		super();
		ModalidadeDAO modalidadeDao = new ModalidadeDAO();
		List<Modalidade> modalidades = modalidadeDao.getLista();
		
		for (Modalidade modalidade : modalidades) {
			ModalidadeList modalidadeList = new ModalidadeList();
			
			modalidadeList.setCodModalidade(modalidade.getCodModalidade());
			modalidadeList.setCodModalidade(modalidade.getCodModalidade());
			modalidadeList.setDescricao(modalidade.getDescricao());
						
			add(modalidadeList);
		}

		Collections.sort(this);
	}    
	
	public ListModalidade(Modalidade modalidade) {
		super();
		ModalidadeList modalidadeList = new ModalidadeList();
		
		modalidadeList.setCodModalidade(modalidade.getCodModalidade());
		modalidadeList.setDescricao(modalidade.getDescricao());
				
		add(modalidadeList);
		
		Collections.sort(this);
	}

}

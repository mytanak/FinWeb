package br.com.etectupa.displaytag.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.etectupa.dao.GrupoDAO;
import br.com.etectupa.displaytag.GrupoList;
import br.com.etectupa.model.Grupo;

public class ListGrupo extends ArrayList {
	private static final long serialVersionUID = 899149338534L;

	public ListGrupo() {
		super();
		GrupoDAO grupoDao = new GrupoDAO();
		List<Grupo> grupos = grupoDao.getLista();
		
		for (Grupo grupo:grupos) {
			GrupoList grupoList = new GrupoList();
			
			grupoList.setCodGrupo(grupo.getCodGrupo());
			grupoList.setDescricao(grupo.getDescricao());
			
			add(grupoList);
		}

		Collections.sort(this);
	}    
	
	public ListGrupo(Grupo grupo) {
		super();
		GrupoList grupoList = new GrupoList();
		
		grupoList.setCodGrupo(grupo.getCodGrupo());
		grupoList.setDescricao(grupo.getDescricao());
				
		add(grupoList);
		
		Collections.sort(this);
	}    

}

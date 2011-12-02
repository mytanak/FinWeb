package br.com.etectupa.validation;

import java.util.List;

import br.com.etectupa.dao.LancamentoDAO;
import br.com.etectupa.dao.GrupoDAO;
import br.com.etectupa.model.Lancamento;
import br.com.etectupa.model.Grupo;

public class ValidaGrupo {
	public static boolean existeGrupo(String descricao) {		
		boolean result = false;
		
		GrupoDAO grupoDao = new GrupoDAO();
		Grupo grupo = grupoDao.listarUnico(descricao);
		
		if (grupo.getCodGrupo() > 0){
			result = true;
		}

		return result;
	}
	
	public static boolean existeGrupo(int codGrupo, String descricao) {		
		boolean result = false;
		
		GrupoDAO grupoDao = new GrupoDAO();
		List<Grupo> grupos = grupoDao.getLista();
		
		for (Grupo grupo : grupos) {
			if (grupo.getCodGrupo() != codGrupo){
				if (grupo.getDescricao().equals(descricao)){
					result = true;
					break;
				}
			}
		}

		return result;
	}
	
	public static boolean grupoUtilizado(int codGrupo) {		
		boolean result = false;
		
		LancamentoDAO lancamentoDao = new LancamentoDAO();
		List<Lancamento> lancamentos = lancamentoDao.Lista(codGrupo);
		
		if (lancamentos.size() > 0){
			result = true;
		}

		return result;
	}
	
}

package br.com.etectupa.validation;

import java.util.List;

import br.com.etectupa.dao.FornecedorDAO;
import br.com.etectupa.dao.GrupoDAO;
import br.com.etectupa.dao.LancamentoDAO;
import br.com.etectupa.dao.ModalidadeDAO;
import br.com.etectupa.model.Fornecedor;
import br.com.etectupa.model.Grupo;
import br.com.etectupa.model.Lancamento;
import br.com.etectupa.model.Modalidade;

public class ValidaModalidade {
	public static boolean existeModalidade(String descricao) {		
		boolean result = false;
		
		ModalidadeDAO modalidadeDao = new ModalidadeDAO();
		Modalidade modalidade = modalidadeDao.listarUnico(descricao);
		
		if (modalidade.getCodModalidade() > 0){
			result = true;
		}

		return result;
	}
	
	public static boolean existeModalidade(int codModalidade, String descricao) {		
		boolean result = false;
		
		ModalidadeDAO modalidadeDao = new ModalidadeDAO();
		List<Modalidade> modalidades = modalidadeDao.getLista();
		
		for (Modalidade modalidade : modalidades) {
			if (modalidade.getCodModalidade() != codModalidade){
				if (modalidade.getDescricao().equals(descricao)){
					result = true;
					break;
				}
			}
		}

		return result;
	}
	
	public static boolean modalidadeUtilizada(int codModalidade) {		
		boolean result = false;
		
		ModalidadeDAO modalidadeDao = new ModalidadeDAO();
		Modalidade modalidade = modalidadeDao.listarUnico(codModalidade);
		
		if (modalidade.getCodModalidade() > 0){
			LancamentoDAO lancamentoDao = new LancamentoDAO();
			List<Lancamento> lancamentos = lancamentoDao.Lista(modalidade);
			
			if (lancamentos.size() > 0){
				result = true;
			}
			
		}

		return result;
	}
	
}

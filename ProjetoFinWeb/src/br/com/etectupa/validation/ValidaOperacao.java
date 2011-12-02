package br.com.etectupa.validation;



import java.util.List;

import br.com.etectupa.dao.LancamentoDAO;
import br.com.etectupa.dao.OperacaoDAO;
import br.com.etectupa.model.Lancamento;
import br.com.etectupa.model.Operacao;

public class ValidaOperacao {
	public static boolean existeOperacao(String descricao) {		
		boolean result = false;
		
		OperacaoDAO operacaoDao = new OperacaoDAO();
		Operacao  operacao= operacaoDao.listarUnico(descricao);
		
		if (operacao.getCodOperacao() > 0){
			result = true;
		}

		return result;
	}
	
	public static boolean existeOperacao(int codOperacao, String descricao) {		
		boolean result = false;
		
		OperacaoDAO operacaoDao = new OperacaoDAO();
		List<Operacao> operacaos = operacaoDao.getLista();
		
		for (Operacao operacao : operacaos) {
			if (operacao.getCodOperacao() != codOperacao){
				if (operacao.getDescricao().equals(descricao)){
					result = true;
					break;
				}
			}
		}

		return result;
	}
	
	public static boolean operacaoUtilizada(int codOperacao) {		
		boolean result = false;
		
		OperacaoDAO operacaoDao = new OperacaoDAO();
		Operacao operacao = operacaoDao.listarUnico(codOperacao);
		
		if (operacao.getCodOperacao() > 0){
			LancamentoDAO lancamentoDao = new LancamentoDAO();
			List<Lancamento> lancamentos = lancamentoDao.Lista(operacao);
			
			if (lancamentos.size() > 0){
				result = true;
			}
			
		}
		return result;
	}
	
}

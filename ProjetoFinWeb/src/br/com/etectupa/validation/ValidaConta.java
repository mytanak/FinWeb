package br.com.etectupa.validation;

import java.util.List;

import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.dao.LancamentoDAO;
import br.com.etectupa.model.Conta;
import br.com.etectupa.model.Lancamento;

public class ValidaConta {
	public static boolean existeConta(String descricao) {		
		boolean result = false;
		
		ContaDAO contaDao = new ContaDAO();
		Conta conta = contaDao.listarUnico(descricao);
		
		if (conta.getCodConta() > 0){
			result = true;
		}

		return result;
	}
	
	public static boolean existeConta(int codConta, int codUsuario, String descricao) {		
		boolean result = false;
		
		ContaDAO contaDao = new ContaDAO();
		List<Conta> contas = contaDao.Lista(codUsuario);
		
		for (Conta conta : contas) {
			if (conta.getCodConta() != codConta){
				if (conta.getDescricao().equals(descricao)){
					result = true;
					break;
				}
			}
		}

		return result;
	}

	public static boolean contaUtilizada(int codConta) {		
		boolean result = false;
		
		ContaDAO contaDao = new ContaDAO();
		Conta conta = contaDao.listarUnico(codConta);
		
		if (conta.getCodConta() > 0){
			LancamentoDAO lancamentoDao = new LancamentoDAO();
			List<Lancamento> lancamentos = lancamentoDao.Lista(conta);
			
			if (lancamentos.size() > 0){
				result = true;
			}
			
		}

		return result;
	}
	
}

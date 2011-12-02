package br.com.etectupa.validation;

import java.util.List;

import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.dao.FornecedorDAO;
import br.com.etectupa.dao.LancamentoDAO;
import br.com.etectupa.model.Conta;
import br.com.etectupa.model.Fornecedor;
import br.com.etectupa.model.Lancamento;

public class ValidaFornecedor {
	public static boolean existeFornecedor(String nome) {		
		boolean result = false;
		
		FornecedorDAO fornecedorDao = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDao.listarUnico(nome);
		
		if (fornecedor.getCodFornecedor() > 0){
			result = true;
		}

		return result;
	}
	
	public static boolean existeFornecedor(int codFornecedor, String nome) {		
		boolean result = false;
		
		FornecedorDAO fornecedorDao = new FornecedorDAO();
		List<Fornecedor> fornecedores = fornecedorDao.getLista();
		
		for (Fornecedor fornecedor : fornecedores) {
			if (fornecedor.getCodFornecedor() != codFornecedor){
				if (fornecedor.getNome().equals(nome)){
					result = true;
					break;
				}
			}
		}

		return result;
	}
	
	public static boolean fornecedorUtilizado(int codFornecedor) {		
		boolean result = false;
		
		FornecedorDAO fornecedorDao = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDao.listarUnico(codFornecedor);
		
		if (fornecedor.getCodFornecedor() > 0){
			LancamentoDAO lancamentoDao = new LancamentoDAO();
			List<Lancamento> lancamentos = lancamentoDao.Lista(fornecedor);
			
			if (lancamentos.size() > 0){
				result = true;
			}
			
		}

		return result;
	}
	
}

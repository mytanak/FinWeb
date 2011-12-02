package br.com.etectupa.displaytag.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.etectupa.dao.FornecedorDAO;
import br.com.etectupa.displaytag.FornecedorList;
import br.com.etectupa.model.Fornecedor;

public class ListFornecedor extends ArrayList {
	private static final long serialVersionUID = 899149338534L;

	public ListFornecedor() {
		super();
		FornecedorDAO fornecedorDao = new FornecedorDAO();
		List<Fornecedor> fornecedores = fornecedorDao.getLista();
		
		for (Fornecedor fornecedor : fornecedores) {
			FornecedorList fornecedorList = new FornecedorList();
			
			fornecedorList.setCodFornecedor(fornecedor.getCodFornecedor());
			fornecedorList.setNome(fornecedor.getNome());
			
			
			add(fornecedorList);
		}

		Collections.sort(this);
	}    
	
	public ListFornecedor(Fornecedor fornecedor) {
		super();
		FornecedorList fornecedorList = new FornecedorList();
		
		fornecedorList.setCodFornecedor(fornecedor.getCodFornecedor());
		fornecedorList.setNome(fornecedor.getNome());
				
		add(fornecedorList);
		
		Collections.sort(this);
	}

}

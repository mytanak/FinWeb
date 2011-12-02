package br.com.etectupa.displaytag.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.etectupa.collection.ContaListResumo;
import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.dao.SaldoDAO;
import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.displaytag.ContaList;
import br.com.etectupa.model.Conta;
import br.com.etectupa.model.Usuario;

public class ListConta extends ArrayList {
	private static final long serialVersionUID = 899149338534L;

	public ListConta(String idUsuario) {
		super();
		ContaDAO contaDao = new ContaDAO();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		
		List<Conta> contas = contaDao.Lista(usuario.getCodUsuario());
		
		for (Conta conta : contas) {
			ContaList contaList = new ContaList();
			
			SaldoDAO saldoContaDao = new SaldoDAO();		
			
			contaList.setCodConta(conta.getCodConta());
			contaList.setDescricao(conta.getDescricao());
			contaList.setSaldoInicial(conta.getSaldoInicial());
			contaList.setSaldoAtual(saldoContaDao.retornaSaldoConta(conta));
			
			
			add(contaList);
		}

		Collections.sort(this);
	}    
	
	public ListConta(Conta conta) {
		super();
		ContaList contaList = new ContaList();
		
		SaldoDAO saldoContaDao = new SaldoDAO();		
		
		contaList.setCodConta(conta.getCodConta());
		contaList.setDescricao(conta.getDescricao());
		contaList.setSaldoInicial(conta.getSaldoInicial());
		contaList.setSaldoAtual(saldoContaDao.retornaSaldoConta(conta));
		
		
		add(contaList);
		
		Collections.sort(this);
	}    
	

}

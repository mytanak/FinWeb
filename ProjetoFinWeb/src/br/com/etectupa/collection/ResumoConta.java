package br.com.etectupa.collection;

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

public class ResumoConta extends ArrayList {
	private static final long serialVersionUID = 899149338534L;

	public ResumoConta(String idUsuario) {
		super();
		ContaDAO contaDao = new ContaDAO();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		
		List<Conta> contas = contaDao.Lista(usuario.getCodUsuario());
		
		ContaListResumo contaListResumo = new ContaListResumo();
		
		double saldoInicial = 0;
		double saldo = 0;
		
		for (Conta conta : contas) {
			SaldoDAO saldoDao = new SaldoDAO();
			saldoInicial += conta.getSaldoInicial();
			saldo += saldoDao.retornaSaldoConta(conta);
		}
		
		contaListResumo.setSaldoInicial(saldoInicial);
		contaListResumo.setSaldo(saldo);
		
		add(contaListResumo);			

		Collections.sort(this);
	}    

}

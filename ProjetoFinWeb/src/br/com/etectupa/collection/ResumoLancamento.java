package br.com.etectupa.collection;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.dao.FornecedorDAO;
import br.com.etectupa.dao.LancamentoDAO;
import br.com.etectupa.dao.ModalidadeDAO;
import br.com.etectupa.dao.MovtoDAO;
import br.com.etectupa.dao.OperacaoDAO;
import br.com.etectupa.dao.SaldoDAO;
import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.displaytag.LancamentoList;
import br.com.etectupa.model.Conta;
import br.com.etectupa.model.Fornecedor;
import br.com.etectupa.model.Lancamento;
import br.com.etectupa.model.Modalidade;
import br.com.etectupa.model.Operacao;
import br.com.etectupa.model.Usuario;

public class ResumoLancamento extends ArrayList {
	private static final long serialVersionUID = 899149338534L;

	public ResumoLancamento(String idUsuario) {
		super();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		LancamentoListResumo resumo = new LancamentoListResumo();
		
		double saldoInicial = 0;
		double debito = 0;
		double credito = 0;
		double total = 0;
		double debitoGeral = 0;
		double creditoGeral = 0;
		double totalGeral = 0;
		double saldo = 0;
 
		SaldoDAO saldoDao = new SaldoDAO();
		saldoInicial += saldoDao.retornaSaldoInicial(usuario);
		saldo += saldoDao.retornaSaldo(usuario);
		
		MovtoDAO movtoDao = new MovtoDAO();
		debito += movtoDao.retornaMovtoDebito(usuario);
		credito += movtoDao.retornaMovtoCredito(usuario);
		debitoGeral += movtoDao.retornaMovtoDebitoPago(usuario);
		creditoGeral += movtoDao.retornaMovtoCreditoPago(usuario);
		
		total = credito - debito;
		totalGeral = saldoInicial + creditoGeral - debitoGeral;

		resumo.setSaldoInicial(saldoInicial);
		resumo.setDebito(debito);
		resumo.setCredito(credito);
		resumo.setTotal(total);
		resumo.setDebitoGeral(debitoGeral);
		resumo.setCreditoGeral(creditoGeral);
		resumo.setTotalGeral(totalGeral);
		resumo.setSaldo(saldo);
		
		add(resumo);

		Collections.sort(this);
	}    

	public ResumoLancamento(String idUsuario, Date dtInicial, Date dtFinal) {
		super();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		LancamentoListResumo resumo = new LancamentoListResumo();
		
		double saldoInicial = 0;
		double debito = 0;
		double credito = 0;
		double total = 0;
		double debitoGeral = 0;
		double creditoGeral = 0;
		double totalGeral = 0;
		double saldo = 0;
 
		SaldoDAO saldoDao = new SaldoDAO();
		saldoInicial += saldoDao.retornaSaldoInicial(usuario);
		saldo += saldoDao.retornaSaldo(usuario);
		
		MovtoDAO movtoDao = new MovtoDAO();
		debito += movtoDao.retornaMovtoDebito(usuario, dtInicial, dtFinal);
		credito += movtoDao.retornaMovtoCredito(usuario, dtInicial, dtFinal);
		debitoGeral += movtoDao.retornaMovtoDebitoPago(usuario);
		creditoGeral += movtoDao.retornaMovtoCreditoPago(usuario);
		
		total = credito - debito;
		totalGeral = saldoInicial + creditoGeral - debitoGeral;
		
		resumo.setSaldoInicial(saldoInicial);
		resumo.setDebito(debito);
		resumo.setCredito(credito);
		resumo.setTotal(total);
		resumo.setDebitoGeral(debitoGeral);
		resumo.setCreditoGeral(creditoGeral);
		resumo.setTotalGeral(totalGeral);
		resumo.setSaldo(saldo);
		
		add(resumo);

		Collections.sort(this);
	}    

	public ResumoLancamento(int codConta) {
		super();
		ContaDAO contaDao = new ContaDAO();
		Conta conta = contaDao.listarUnico(codConta);
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.listarUnico(conta.getCodUsuario());
		
		LancamentoListResumo resumo = new LancamentoListResumo();
		
		double saldoInicial = 0;
		double debito = 0;
		double credito = 0;
		double total = 0;
		double debitoGeral = 0;
		double creditoGeral = 0;
		double totalGeral = 0;
		double saldo = 0;
 
		SaldoDAO saldoDao = new SaldoDAO();
		saldoInicial += saldoDao.retornaSaldoConta(conta);
		saldo += saldoDao.retornaSaldoConta(conta);
		
		MovtoDAO movtoDao = new MovtoDAO();
		debito += movtoDao.retornaMovtoDebito(conta);
		credito += movtoDao.retornaMovtoCredito(conta);
		debitoGeral += movtoDao.retornaMovtoDebitoPago(conta);
		creditoGeral += movtoDao.retornaMovtoCreditoPago(conta);
		
		total = credito - debito;
		totalGeral = saldoInicial + creditoGeral - debitoGeral;
		
		resumo.setSaldoInicial(saldoInicial);
		resumo.setDebito(debito);
		resumo.setCredito(credito);
		resumo.setTotal(total);
		resumo.setDebitoGeral(debitoGeral);
		resumo.setCreditoGeral(creditoGeral);
		resumo.setTotalGeral(totalGeral);
		resumo.setSaldo(saldo);
		
		add(resumo);
		
		Collections.sort(this);
	}    

	public ResumoLancamento(int codConta, Date dtInicial, Date dtFinal) {
		super();
		ContaDAO contaDao = new ContaDAO();
		Conta conta = contaDao.listarUnico(codConta);
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.listarUnico(conta.getCodUsuario());
		
		LancamentoListResumo resumo = new LancamentoListResumo();
		
		double saldoInicial = 0;
		double debito = 0;
		double credito = 0;
		double total = 0;
		double debitoGeral = 0;
		double creditoGeral = 0;
		double totalGeral = 0;
		double saldo = 0;
 
		SaldoDAO saldoDao = new SaldoDAO();
		saldoInicial += saldoDao.retornaSaldoConta(conta);
		saldo += saldoDao.retornaSaldoConta(conta);
		
		MovtoDAO movtoDao = new MovtoDAO();
		debito += movtoDao.retornaMovtoDebito(conta, dtInicial, dtFinal);
		credito += movtoDao.retornaMovtoCredito(conta, dtInicial, dtFinal);
		debitoGeral += movtoDao.retornaMovtoDebitoPago(conta);
		creditoGeral += movtoDao.retornaMovtoCreditoPago(conta);
		
		total = credito - debito;
		totalGeral = saldoInicial + creditoGeral - debitoGeral;
		
		resumo.setSaldoInicial(saldoInicial);
		resumo.setDebito(debito);
		resumo.setCredito(credito);
		resumo.setTotal(total);
		resumo.setDebitoGeral(debitoGeral);
		resumo.setCreditoGeral(creditoGeral);
		resumo.setTotalGeral(totalGeral);
		resumo.setSaldo(saldo);
		
		add(resumo);
		
		Collections.sort(this);
	}    
	
}

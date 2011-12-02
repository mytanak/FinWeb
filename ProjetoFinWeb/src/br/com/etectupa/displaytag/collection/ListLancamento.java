package br.com.etectupa.displaytag.collection;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.joda.time.LocalDate;

import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.dao.FornecedorDAO;
import br.com.etectupa.dao.LancamentoDAO;
import br.com.etectupa.dao.ModalidadeDAO;
import br.com.etectupa.dao.OperacaoDAO;
import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.displaytag.LancamentoList;
import br.com.etectupa.model.Conta;
import br.com.etectupa.model.Fornecedor;
import br.com.etectupa.model.Lancamento;
import br.com.etectupa.model.Modalidade;
import br.com.etectupa.model.Operacao;
import br.com.etectupa.model.Usuario;

public class ListLancamento extends ArrayList {
	private static final long serialVersionUID = 899149338534L;

	public ListLancamento(String idUsuario) {
		super();
		LancamentoDAO lancamentoDao = new LancamentoDAO();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		
		ContaDAO contaDao = new ContaDAO();
		List<Conta> contas = contaDao.Lista(usuario.getCodUsuario());
		
		List<Lancamento> lancamentos = lancamentoDao.Lista(contas);
		
		for (Lancamento lancamento : lancamentos) {
			LancamentoList lancamentoList = new LancamentoList();
			
			lancamentoList.setNroLancamento(lancamento.getNroLancamento());
			lancamentoList.setCodConta(lancamento.getCodConta());
			lancamentoList.setCodFornecedor(lancamento.getCodFornecedor());
			lancamentoList.setCodModalidade(lancamento.getCodModalidade());
			lancamentoList.setCodOperacao(lancamento.getCodOperacao());
			lancamentoList.setDataRealizada(lancamento.getDataRealizada());
			
			if (lancamento.getDataRealizada() != null){
				LocalDate dataRealizadaStr = new LocalDate(lancamento.getDataRealizada());
				lancamentoList.setDataRealizadaStr(dataRealizadaStr.toString("dd/MM/yyyy"));
			}	
					
			lancamentoList.setDataVencimento(lancamento.getDataVencimento());

			LocalDate dataVencimentoStr = new LocalDate(lancamento.getDataVencimento());
			lancamentoList.setDataVencimentoStr(dataVencimentoStr.toString("dd/MM/yyyy"));

			lancamentoList.setObservacao(lancamento.getObservacao());
			lancamentoList.setValor(lancamento.getValor());
			
			Conta conta = contaDao.listarUnico(lancamento.getCodConta());
			
			lancamentoList.setDescConta(conta.getDescricao());
			lancamentoList.setSaldoInicial(conta.getSaldoInicial());
			
			FornecedorDAO fornecedorDao = new FornecedorDAO();
			Fornecedor fornecedor = fornecedorDao.listarUnico(lancamento.getCodFornecedor());
			
			lancamentoList.setNomeFornecedor(fornecedor.getNome());

			ModalidadeDAO modalidadeDao = new ModalidadeDAO();
			Modalidade modalidade = modalidadeDao.listarUnico(lancamento.getCodModalidade());
			
			lancamentoList.setDescModalidade(modalidade.getDescricao());

			OperacaoDAO operacaoDao = new OperacaoDAO();
			Operacao operacao = operacaoDao.listarUnico(lancamento.getCodOperacao());
			
			lancamentoList.setDescOperacao(operacao.getDescricao());
			lancamentoList.setTipoOperacao(operacao.getTipo());
			
			if (operacao.getTipo().equals("D")){
				lancamentoList.setDebitos(lancamento.getValor());			
			}else {
				lancamentoList.setCreditos(lancamento.getValor());
			}
			
			add(lancamentoList);
		}

		Collections.sort(this);
	}    
	
	public ListLancamento(String idUsuario, int opcao, Date dtInicial, Date dtFinal) {
		super();
		LancamentoDAO lancamentoDao = new LancamentoDAO();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		
		ContaDAO contaDao = new ContaDAO();
		List<Conta> contas = contaDao.Lista(usuario.getCodUsuario());
		
		switch (opcao) {
		// Todos lançamentos com vencimento do período pagos e não pagos
		case 1: {
			List<Lancamento> Vencidos = lancamentoDao.ListaVencidos(contas,
					dtInicial, dtFinal);

			for (Lancamento lancamento : Vencidos) {
				LancamentoList lancamentoList = new LancamentoList();

				lancamentoList.setNroLancamento(lancamento.getNroLancamento());
				lancamentoList.setCodConta(lancamento.getCodConta());
				lancamentoList.setCodFornecedor(lancamento.getCodFornecedor());
				lancamentoList.setCodModalidade(lancamento.getCodModalidade());
				lancamentoList.setCodOperacao(lancamento.getCodOperacao());
				lancamentoList.setDataRealizada(lancamento.getDataRealizada());
				
				if (lancamento.getDataRealizada() != null){
					LocalDate dataRealizadaStr = new LocalDate(lancamento.getDataRealizada());
					lancamentoList.setDataRealizadaStr(dataRealizadaStr.toString("dd/MM/yyyy"));
				}	
											
				lancamentoList.setDataVencimento(lancamento.getDataVencimento());

				LocalDate dataVencimentoStr = new LocalDate(lancamento.getDataVencimento());
				lancamentoList.setDataVencimentoStr(dataVencimentoStr.toString("dd/MM/yyyy"));

				lancamentoList.setDataVencimento(lancamento.getDataVencimento());
				lancamentoList.setObservacao(lancamento.getObservacao());
				lancamentoList.setValor(lancamento.getValor());

				Conta conta = contaDao.listarUnico(lancamento.getCodConta());

				lancamentoList.setDescConta(conta.getDescricao());
				lancamentoList.setSaldoInicial(conta.getSaldoInicial());

				FornecedorDAO fornecedorDao = new FornecedorDAO();
				Fornecedor fornecedor = fornecedorDao.listarUnico(lancamento
						.getCodFornecedor());

				lancamentoList.setNomeFornecedor(fornecedor.getNome());

				ModalidadeDAO modalidadeDao = new ModalidadeDAO();
				Modalidade modalidade = modalidadeDao.listarUnico(lancamento
						.getCodModalidade());

				lancamentoList.setDescModalidade(modalidade.getDescricao());

				OperacaoDAO operacaoDao = new OperacaoDAO();
				Operacao operacao = operacaoDao.listarUnico(lancamento.getCodOperacao());

				lancamentoList.setDescOperacao(operacao.getDescricao());
				lancamentoList.setTipoOperacao(operacao.getTipo());

				if (operacao.getTipo().equals("D")){
					lancamentoList.setDebitos(lancamento.getValor());			
				}else {
					lancamentoList.setCreditos(lancamento.getValor());
				}

				add(lancamentoList);
			}

			break;

		}
		// Todos lançamentos pagos no período
		case 2: {
			List<Lancamento> Pagos = lancamentoDao.ListaPagos(contas,
					dtInicial, dtFinal);

			for (Lancamento lancamento : Pagos) {
				LancamentoList lancamentoList = new LancamentoList();

				lancamentoList.setNroLancamento(lancamento.getNroLancamento());
				lancamentoList.setCodConta(lancamento.getCodConta());
				lancamentoList.setCodFornecedor(lancamento.getCodFornecedor());
				lancamentoList.setCodModalidade(lancamento.getCodModalidade());
				lancamentoList.setCodOperacao(lancamento.getCodOperacao());
				lancamentoList.setDataRealizada(lancamento.getDataRealizada());
				
				if (lancamento.getDataRealizada() != null){
					LocalDate dataRealizadaStr = new LocalDate(lancamento.getDataRealizada());
					lancamentoList.setDataRealizadaStr(dataRealizadaStr.toString("dd/MM/yyyy"));
				}	
						
				lancamentoList.setDataVencimento(lancamento.getDataVencimento());

				LocalDate dataVencimentoStr = new LocalDate(lancamento.getDataVencimento());
				lancamentoList.setDataVencimentoStr(dataVencimentoStr.toString("dd/MM/yyyy"));

				lancamentoList.setDataVencimento(lancamento.getDataVencimento());
				lancamentoList.setObservacao(lancamento.getObservacao());
				lancamentoList.setValor(lancamento.getValor());

				Conta conta = contaDao.listarUnico(lancamento.getCodConta());

				lancamentoList.setDescConta(conta.getDescricao());
				lancamentoList.setSaldoInicial(conta.getSaldoInicial());

				FornecedorDAO fornecedorDao = new FornecedorDAO();
				Fornecedor fornecedor = fornecedorDao.listarUnico(lancamento
						.getCodFornecedor());

				lancamentoList.setNomeFornecedor(fornecedor.getNome());

				ModalidadeDAO modalidadeDao = new ModalidadeDAO();
				Modalidade modalidade = modalidadeDao.listarUnico(lancamento
						.getCodModalidade());

				lancamentoList.setDescModalidade(modalidade.getDescricao());

				OperacaoDAO operacaoDao = new OperacaoDAO();
				Operacao operacao = operacaoDao.listarUnico(lancamento.getCodOperacao());

				lancamentoList.setDescOperacao(operacao.getDescricao());
				lancamentoList.setTipoOperacao(operacao.getTipo());

				if (operacao.getTipo().equals("D")){
					lancamentoList.setDebitos(lancamento.getValor());			
				}else {
					lancamentoList.setCreditos(lancamento.getValor());
				}
				
				add(lancamentoList);
			}

			break;

		}
		// Todos lançamentos vencidos no período pagos
		case 3: {
			List<Lancamento> Vencidos = lancamentoDao.ListaVencidosPagos(contas, dtInicial, dtFinal);

			for (Lancamento lancamento : Vencidos) {
				LancamentoList lancamentoList = new LancamentoList();

				lancamentoList.setNroLancamento(lancamento.getNroLancamento());
				lancamentoList.setCodConta(lancamento.getCodConta());
				lancamentoList.setCodFornecedor(lancamento.getCodFornecedor());
				lancamentoList.setCodModalidade(lancamento.getCodModalidade());
				lancamentoList.setCodOperacao(lancamento.getCodOperacao());
				lancamentoList.setDataRealizada(lancamento.getDataRealizada());
				
				if (lancamento.getDataRealizada() != null){
					LocalDate dataRealizadaStr = new LocalDate(lancamento.getDataRealizada());
					lancamentoList.setDataRealizadaStr(dataRealizadaStr.toString("dd/MM/yyyy"));
				}	
						
				lancamentoList.setDataVencimento(lancamento.getDataVencimento());

				LocalDate dataVencimentoStr = new LocalDate(lancamento.getDataVencimento());
				lancamentoList.setDataVencimentoStr(dataVencimentoStr.toString("dd/MM/yyyy"));

				lancamentoList.setDataVencimento(lancamento.getDataVencimento());
				lancamentoList.setObservacao(lancamento.getObservacao());
				lancamentoList.setValor(lancamento.getValor());

				Conta conta = contaDao.listarUnico(lancamento.getCodConta());

				lancamentoList.setDescConta(conta.getDescricao());
				lancamentoList.setSaldoInicial(conta.getSaldoInicial());

				FornecedorDAO fornecedorDao = new FornecedorDAO();
				Fornecedor fornecedor = fornecedorDao.listarUnico(lancamento
						.getCodFornecedor());

				lancamentoList.setNomeFornecedor(fornecedor.getNome());

				ModalidadeDAO modalidadeDao = new ModalidadeDAO();
				Modalidade modalidade = modalidadeDao.listarUnico(lancamento
						.getCodModalidade());

				lancamentoList.setDescModalidade(modalidade.getDescricao());

				OperacaoDAO operacaoDao = new OperacaoDAO();
				Operacao operacao = operacaoDao.listarUnico(lancamento
						.getCodOperacao());

				lancamentoList.setDescOperacao(operacao.getDescricao());
				lancamentoList.setTipoOperacao(operacao.getTipo());

				if (operacao.getTipo().equals("D")){
					lancamentoList.setDebitos(lancamento.getValor());			
				}else {
					lancamentoList.setCreditos(lancamento.getValor());
				}

				add(lancamentoList);
			}

			break;

		}
		
		// Todos lançamentos vencidos no período não pagos
		case 4: {
			List<Lancamento> Vencidos = lancamentoDao.ListaVencidosNaoPagos(contas, dtInicial, dtFinal);

			for (Lancamento lancamento : Vencidos) {
				LancamentoList lancamentoList = new LancamentoList();

				lancamentoList.setNroLancamento(lancamento.getNroLancamento());
				lancamentoList.setCodConta(lancamento.getCodConta());
				lancamentoList.setCodFornecedor(lancamento.getCodFornecedor());
				lancamentoList.setCodModalidade(lancamento.getCodModalidade());
				lancamentoList.setCodOperacao(lancamento.getCodOperacao());
				lancamentoList.setDataRealizada(lancamento.getDataRealizada());
				
				if (lancamento.getDataRealizada() != null){
					LocalDate dataRealizadaStr = new LocalDate(lancamento.getDataRealizada());
					lancamentoList.setDataRealizadaStr(dataRealizadaStr.toString("dd/MM/yyyy"));
				}	
						
				lancamentoList.setDataVencimento(lancamento.getDataVencimento());

				LocalDate dataVencimentoStr = new LocalDate(lancamento.getDataVencimento());
				lancamentoList.setDataVencimentoStr(dataVencimentoStr.toString("dd/MM/yyyy"));

				lancamentoList.setDataVencimento(lancamento.getDataVencimento());
				lancamentoList.setObservacao(lancamento.getObservacao());
				lancamentoList.setValor(lancamento.getValor());

				Conta conta = contaDao.listarUnico(lancamento.getCodConta());

				lancamentoList.setDescConta(conta.getDescricao());
				lancamentoList.setSaldoInicial(conta.getSaldoInicial());

				FornecedorDAO fornecedorDao = new FornecedorDAO();
				Fornecedor fornecedor = fornecedorDao.listarUnico(lancamento
						.getCodFornecedor());

				lancamentoList.setNomeFornecedor(fornecedor.getNome());

				ModalidadeDAO modalidadeDao = new ModalidadeDAO();
				Modalidade modalidade = modalidadeDao.listarUnico(lancamento
						.getCodModalidade());

				lancamentoList.setDescModalidade(modalidade.getDescricao());

				OperacaoDAO operacaoDao = new OperacaoDAO();
				Operacao operacao = operacaoDao.listarUnico(lancamento
						.getCodOperacao());

				lancamentoList.setDescOperacao(operacao.getDescricao());
				lancamentoList.setTipoOperacao(operacao.getTipo());

				if (operacao.getTipo().equals("D")){
					lancamentoList.setDebitos(lancamento.getValor());			
				}else {
					lancamentoList.setCreditos(lancamento.getValor());
				}

				add(lancamentoList);
			}

			break;

		}
		}

		Collections.sort(this);
	}    

	public ListLancamento(int codConta) {
		super();
		LancamentoDAO lancamentoDao = new LancamentoDAO();
		
		ContaDAO contaDao = new ContaDAO();
		Conta conta = contaDao.listarUnico(codConta);
		
		List<Lancamento> lancamentos = lancamentoDao.Lista(conta);
		
		for (Lancamento lancamento : lancamentos) {
			LancamentoList lancamentoList = new LancamentoList();
			
			lancamentoList.setNroLancamento(lancamento.getNroLancamento());
			lancamentoList.setCodConta(lancamento.getCodConta());
			lancamentoList.setCodFornecedor(lancamento.getCodFornecedor());
			lancamentoList.setCodModalidade(lancamento.getCodModalidade());
			lancamentoList.setCodOperacao(lancamento.getCodOperacao());
			lancamentoList.setDataRealizada(lancamento.getDataRealizada());
			
			if (lancamento.getDataRealizada() != null){
				LocalDate dataRealizadaStr = new LocalDate(lancamento.getDataRealizada());
				lancamentoList.setDataRealizadaStr(dataRealizadaStr.toString("dd/MM/yyyy"));
			}	
					
			lancamentoList.setDataVencimento(lancamento.getDataVencimento());

			LocalDate dataVencimentoStr = new LocalDate(lancamento.getDataVencimento());
			lancamentoList.setDataVencimentoStr(dataVencimentoStr.toString("dd/MM/yyyy"));

			lancamentoList.setDataVencimento(lancamento.getDataVencimento());
			lancamentoList.setObservacao(lancamento.getObservacao());
			lancamentoList.setValor(lancamento.getValor());
			
			lancamentoList.setDescConta(conta.getDescricao());
			lancamentoList.setSaldoInicial(conta.getSaldoInicial());
			
			FornecedorDAO fornecedorDao = new FornecedorDAO();
			Fornecedor fornecedor = fornecedorDao.listarUnico(lancamento.getCodFornecedor());
			
			lancamentoList.setNomeFornecedor(fornecedor.getNome());

			ModalidadeDAO modalidadeDao = new ModalidadeDAO();
			Modalidade modalidade = modalidadeDao.listarUnico(lancamento.getCodModalidade());
			
			lancamentoList.setDescModalidade(modalidade.getDescricao());

			OperacaoDAO operacaoDao = new OperacaoDAO();
			Operacao operacao = operacaoDao.listarUnico(lancamento.getCodOperacao());
			
			lancamentoList.setDescModalidade(operacao.getDescricao());
			lancamentoList.setTipoOperacao(operacao.getTipo());

			if (operacao.getTipo().equals("D")){
				lancamentoList.setDebitos(lancamento.getValor());			
			}else {
				lancamentoList.setCreditos(lancamento.getValor());
			}
			
			add(lancamentoList);
		}

		Collections.sort(this);
	}    

	public ListLancamento(Lancamento lancamento) {
		super();
		
		LancamentoList lancamentoList = new LancamentoList();
		
		lancamentoList.setNroLancamento(lancamento.getNroLancamento());
		lancamentoList.setCodConta(lancamento.getCodConta());
		lancamentoList.setCodFornecedor(lancamento.getCodFornecedor());
		lancamentoList.setCodModalidade(lancamento.getCodModalidade());
		lancamentoList.setCodOperacao(lancamento.getCodOperacao());
		lancamentoList.setDataRealizada(lancamento.getDataRealizada());
		
		if (lancamento.getDataRealizada() != null){
			LocalDate dataRealizadaStr = new LocalDate(lancamento.getDataRealizada());
			lancamentoList.setDataRealizadaStr(dataRealizadaStr.toString("dd/MM/yyyy"));
		}	
				
		lancamentoList.setDataVencimento(lancamento.getDataVencimento());

		LocalDate dataVencimentoStr = new LocalDate(lancamento.getDataVencimento());
		lancamentoList.setDataVencimentoStr(dataVencimentoStr.toString("dd/MM/yyyy"));

		lancamentoList.setDataVencimento(lancamento.getDataVencimento());
		lancamentoList.setObservacao(lancamento.getObservacao());
		lancamentoList.setValor(lancamento.getValor());
		
		ContaDAO contaDao = new ContaDAO();		
		Conta conta = contaDao.listarUnico(lancamento.getCodConta());
		
		lancamentoList.setDescConta(conta.getDescricao());
		lancamentoList.setSaldoInicial(conta.getSaldoInicial());
		
		FornecedorDAO fornecedorDao = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDao.listarUnico(lancamento.getCodFornecedor());
		
		lancamentoList.setNomeFornecedor(fornecedor.getNome());

		ModalidadeDAO modalidadeDao = new ModalidadeDAO();
		Modalidade modalidade = modalidadeDao.listarUnico(lancamento.getCodModalidade());
		
		lancamentoList.setDescModalidade(modalidade.getDescricao());

		OperacaoDAO operacaoDao = new OperacaoDAO();
		Operacao operacao = operacaoDao.listarUnico(lancamento.getCodOperacao());
		
		lancamentoList.setDescOperacao(operacao.getDescricao());
		lancamentoList.setTipoOperacao(operacao.getTipo());
		
		if (operacao.getTipo().equals("D")){
			lancamentoList.setDebitos(lancamento.getValor());			
		}else {
			lancamentoList.setCreditos(lancamento.getValor());
		}
		
		add(lancamentoList);

		Collections.sort(this);
	}    

	public ListLancamento(String idUsuario, int opcao, Date dataBase) {
		super();
		LancamentoDAO lancamentoDao = new LancamentoDAO();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		
		ContaDAO contaDao = new ContaDAO();
		List<Conta> contas = contaDao.Lista(usuario.getCodUsuario());
		
		switch (opcao) {
		// Contas a pagar com vencimento superior ou igual à data base informada		
		case 1: {
			List<Lancamento> Vencidos = lancamentoDao.ListaProximosLancamentos(contas, dataBase);

			for (Lancamento lancamento : Vencidos) {

				OperacaoDAO operacaoDao = new OperacaoDAO();
				Operacao operacao = operacaoDao.listarUnico(lancamento.getCodOperacao());
				
				if (operacao.getTipo().equals("D")){
					LancamentoList lancamentoList = new LancamentoList();
	
					lancamentoList.setNroLancamento(lancamento.getNroLancamento());
					lancamentoList.setCodConta(lancamento.getCodConta());
					lancamentoList.setCodFornecedor(lancamento.getCodFornecedor());
					lancamentoList.setCodModalidade(lancamento.getCodModalidade());
					lancamentoList.setCodOperacao(lancamento.getCodOperacao());
					lancamentoList.setDataRealizada(lancamento.getDataRealizada());
					
					if (lancamento.getDataRealizada() != null){
						LocalDate dataRealizadaStr = new LocalDate(lancamento.getDataRealizada());
						lancamentoList.setDataRealizadaStr(dataRealizadaStr.toString("dd/MM/yyyy"));
					}	
												
					lancamentoList.setDataVencimento(lancamento.getDataVencimento());
	
					LocalDate dataVencimentoStr = new LocalDate(lancamento.getDataVencimento());
					lancamentoList.setDataVencimentoStr(dataVencimentoStr.toString("dd/MM/yyyy"));
	
					lancamentoList.setDataVencimento(lancamento.getDataVencimento());
					lancamentoList.setObservacao(lancamento.getObservacao());
					lancamentoList.setValor(lancamento.getValor());
	
					Conta conta = contaDao.listarUnico(lancamento.getCodConta());
	
					lancamentoList.setDescConta(conta.getDescricao());
					lancamentoList.setSaldoInicial(conta.getSaldoInicial());
	
					FornecedorDAO fornecedorDao = new FornecedorDAO();
					Fornecedor fornecedor = fornecedorDao.listarUnico(lancamento
							.getCodFornecedor());
	
					lancamentoList.setNomeFornecedor(fornecedor.getNome());
	
					ModalidadeDAO modalidadeDao = new ModalidadeDAO();
					Modalidade modalidade = modalidadeDao.listarUnico(lancamento
							.getCodModalidade());
	
					lancamentoList.setDescModalidade(modalidade.getDescricao());
	
	
					lancamentoList.setDescOperacao(operacao.getDescricao());
					lancamentoList.setTipoOperacao(operacao.getTipo());
	
					if (operacao.getTipo().equals("D")){
						lancamentoList.setDebitos(lancamento.getValor());			
					}else {
						lancamentoList.setCreditos(lancamento.getValor());
					}
	
					add(lancamentoList);
				}
			}

			break;

		}
		
		// Contas a pagar com vencimento inferior à data base informada
		case 2: {
			List<Lancamento> Vencidos = lancamentoDao.ListaLancamentosAtraso(contas, dataBase);

			for (Lancamento lancamento : Vencidos) {

				OperacaoDAO operacaoDao = new OperacaoDAO();
				Operacao operacao = operacaoDao.listarUnico(lancamento.getCodOperacao());
				
				if (operacao.getTipo().equals("D")){
					LancamentoList lancamentoList = new LancamentoList();
	
					lancamentoList.setNroLancamento(lancamento.getNroLancamento());
					lancamentoList.setCodConta(lancamento.getCodConta());
					lancamentoList.setCodFornecedor(lancamento.getCodFornecedor());
					lancamentoList.setCodModalidade(lancamento.getCodModalidade());
					lancamentoList.setCodOperacao(lancamento.getCodOperacao());
					lancamentoList.setDataRealizada(lancamento.getDataRealizada());
					
					if (lancamento.getDataRealizada() != null){
						LocalDate dataRealizadaStr = new LocalDate(lancamento.getDataRealizada());
						lancamentoList.setDataRealizadaStr(dataRealizadaStr.toString("dd/MM/yyyy"));
					}	
												
					lancamentoList.setDataVencimento(lancamento.getDataVencimento());
	
					LocalDate dataVencimentoStr = new LocalDate(lancamento.getDataVencimento());
					lancamentoList.setDataVencimentoStr(dataVencimentoStr.toString("dd/MM/yyyy"));
	
					lancamentoList.setDataVencimento(lancamento.getDataVencimento());
					lancamentoList.setObservacao(lancamento.getObservacao());
					lancamentoList.setValor(lancamento.getValor());
	
					Conta conta = contaDao.listarUnico(lancamento.getCodConta());
	
					lancamentoList.setDescConta(conta.getDescricao());
					lancamentoList.setSaldoInicial(conta.getSaldoInicial());
	
					FornecedorDAO fornecedorDao = new FornecedorDAO();
					Fornecedor fornecedor = fornecedorDao.listarUnico(lancamento
							.getCodFornecedor());
	
					lancamentoList.setNomeFornecedor(fornecedor.getNome());
	
					ModalidadeDAO modalidadeDao = new ModalidadeDAO();
					Modalidade modalidade = modalidadeDao.listarUnico(lancamento
							.getCodModalidade());
	
					lancamentoList.setDescModalidade(modalidade.getDescricao());
	
	
					lancamentoList.setDescOperacao(operacao.getDescricao());
					lancamentoList.setTipoOperacao(operacao.getTipo());
	
					if (operacao.getTipo().equals("D")){
						lancamentoList.setDebitos(lancamento.getValor());			
					}else {
						lancamentoList.setCreditos(lancamento.getValor());
					}
	
					add(lancamentoList);
				}
			}

			break;

		}
		
		// Contas a receber com vencimento superior ou igual à data base informada		
		case 3: {
			List<Lancamento> Vencidos = lancamentoDao.ListaProximosLancamentos(contas, dataBase);

			for (Lancamento lancamento : Vencidos) {

				OperacaoDAO operacaoDao = new OperacaoDAO();
				Operacao operacao = operacaoDao.listarUnico(lancamento.getCodOperacao());
				
				if (operacao.getTipo().equals("C")){
					LancamentoList lancamentoList = new LancamentoList();
	
					lancamentoList.setNroLancamento(lancamento.getNroLancamento());
					lancamentoList.setCodConta(lancamento.getCodConta());
					lancamentoList.setCodFornecedor(lancamento.getCodFornecedor());
					lancamentoList.setCodModalidade(lancamento.getCodModalidade());
					lancamentoList.setCodOperacao(lancamento.getCodOperacao());
					lancamentoList.setDataRealizada(lancamento.getDataRealizada());
					
					if (lancamento.getDataRealizada() != null){
						LocalDate dataRealizadaStr = new LocalDate(lancamento.getDataRealizada());
						lancamentoList.setDataRealizadaStr(dataRealizadaStr.toString("dd/MM/yyyy"));
					}	
												
					lancamentoList.setDataVencimento(lancamento.getDataVencimento());
	
					LocalDate dataVencimentoStr = new LocalDate(lancamento.getDataVencimento());
					lancamentoList.setDataVencimentoStr(dataVencimentoStr.toString("dd/MM/yyyy"));
	
					lancamentoList.setDataVencimento(lancamento.getDataVencimento());
					lancamentoList.setObservacao(lancamento.getObservacao());
					lancamentoList.setValor(lancamento.getValor());
	
					Conta conta = contaDao.listarUnico(lancamento.getCodConta());
	
					lancamentoList.setDescConta(conta.getDescricao());
					lancamentoList.setSaldoInicial(conta.getSaldoInicial());
	
					FornecedorDAO fornecedorDao = new FornecedorDAO();
					Fornecedor fornecedor = fornecedorDao.listarUnico(lancamento
							.getCodFornecedor());
	
					lancamentoList.setNomeFornecedor(fornecedor.getNome());
	
					ModalidadeDAO modalidadeDao = new ModalidadeDAO();
					Modalidade modalidade = modalidadeDao.listarUnico(lancamento
							.getCodModalidade());
	
					lancamentoList.setDescModalidade(modalidade.getDescricao());
	
	
					lancamentoList.setDescOperacao(operacao.getDescricao());
					lancamentoList.setTipoOperacao(operacao.getTipo());
	
					if (operacao.getTipo().equals("D")){
						lancamentoList.setDebitos(lancamento.getValor());			
					}else {
						lancamentoList.setCreditos(lancamento.getValor());
					}
	
					add(lancamentoList);
				}
			}

			break;

		}
		
		// Contas a receber com vencimento inferior à data base informada
		case 4: {
			List<Lancamento> Vencidos = lancamentoDao.ListaLancamentosAtraso(contas, dataBase);

			for (Lancamento lancamento : Vencidos) {

				OperacaoDAO operacaoDao = new OperacaoDAO();
				Operacao operacao = operacaoDao.listarUnico(lancamento.getCodOperacao());
				
				if (operacao.getTipo().equals("C")){
					LancamentoList lancamentoList = new LancamentoList();
	
					lancamentoList.setNroLancamento(lancamento.getNroLancamento());
					lancamentoList.setCodConta(lancamento.getCodConta());
					lancamentoList.setCodFornecedor(lancamento.getCodFornecedor());
					lancamentoList.setCodModalidade(lancamento.getCodModalidade());
					lancamentoList.setCodOperacao(lancamento.getCodOperacao());
					lancamentoList.setDataRealizada(lancamento.getDataRealizada());
					
					if (lancamento.getDataRealizada() != null){
						LocalDate dataRealizadaStr = new LocalDate(lancamento.getDataRealizada());
						lancamentoList.setDataRealizadaStr(dataRealizadaStr.toString("dd/MM/yyyy"));
					}	
												
					lancamentoList.setDataVencimento(lancamento.getDataVencimento());
	
					LocalDate dataVencimentoStr = new LocalDate(lancamento.getDataVencimento());
					lancamentoList.setDataVencimentoStr(dataVencimentoStr.toString("dd/MM/yyyy"));
	
					lancamentoList.setDataVencimento(lancamento.getDataVencimento());
					lancamentoList.setObservacao(lancamento.getObservacao());
					lancamentoList.setValor(lancamento.getValor());
	
					Conta conta = contaDao.listarUnico(lancamento.getCodConta());
	
					lancamentoList.setDescConta(conta.getDescricao());
					lancamentoList.setSaldoInicial(conta.getSaldoInicial());
	
					FornecedorDAO fornecedorDao = new FornecedorDAO();
					Fornecedor fornecedor = fornecedorDao.listarUnico(lancamento
							.getCodFornecedor());
	
					lancamentoList.setNomeFornecedor(fornecedor.getNome());
	
					ModalidadeDAO modalidadeDao = new ModalidadeDAO();
					Modalidade modalidade = modalidadeDao.listarUnico(lancamento
							.getCodModalidade());
	
					lancamentoList.setDescModalidade(modalidade.getDescricao());
	
	
					lancamentoList.setDescOperacao(operacao.getDescricao());
					lancamentoList.setTipoOperacao(operacao.getTipo());
	
					if (operacao.getTipo().equals("D")){
						lancamentoList.setDebitos(lancamento.getValor());			
					}else {
						lancamentoList.setCreditos(lancamento.getValor());
					}
	
					add(lancamentoList);
				}
			}

			break;

		}

		}

		Collections.sort(this);
	}    
	
}

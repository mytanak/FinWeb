package br.com.etectupa.model;

import java.sql.Date;

public class Lancamento {
	private int nroLancamento;
	private int codConta;
	private int codOperacao;
	private int codModalidade;
	private int codFornecedor;
	private Date dataVencimento;
	private Date dataRealizada;
	private double valor;
	private String observacao;

	public int getNroLancamento() {
		return nroLancamento;
	}

	public void setNroLancamento(int nroLancamento) {
		this.nroLancamento = nroLancamento;
	}

	public int getCodConta() {
		return codConta;
	}

	public void setCodConta(int codConta) {
		this.codConta = codConta;
	}

	public int getCodOperacao() {
		return codOperacao;
	}

	public void setCodOperacao(int codOperacao) {
		this.codOperacao = codOperacao;
	}

	public int getCodModalidade() {
		return codModalidade;
	}

	public void setCodModalidade(int codModalidade) {
		this.codModalidade = codModalidade;
	}

	public int getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(int codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public Date getDataRealizada() {
		return dataRealizada;
	}

	public void setDataRealizada(Date dataRealizada) {
		this.dataRealizada = dataRealizada;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

}

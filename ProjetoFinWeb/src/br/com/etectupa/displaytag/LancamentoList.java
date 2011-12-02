package br.com.etectupa.displaytag;

import java.io.Serializable;
import java.sql.Date;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class LancamentoList extends Object implements Comparable, Serializable {
	private int nroLancamento;
	private int codConta;
	private String descConta;
	private double saldoInicial;
	private int codOperacao;
	private String descOperacao;
	private String tipoOperacao;
	private int codModalidade;
	private String descModalidade;
	private int codFornecedor;
	private String nomeFornecedor;
	private Date dataVencimento;
	private Date dataRealizada;
	private double valor;
	private String observacao;
	private double debitos;
	private double creditos;
	private String dataVencimentoStr;
	private String dataRealizadaStr;

	public String getDataVencimentoStr() {
		return dataVencimentoStr;
	}

	public void setDataVencimentoStr(String dataVencimentoStr) {
		this.dataVencimentoStr = dataVencimentoStr;
	}

	public String getDataRealizadaStr() {
		return dataRealizadaStr;
	}

	public void setDataRealizadaStr(String dataRealizadaStr) {
		this.dataRealizadaStr = dataRealizadaStr;
	}

	public double getDebitos() {
		return debitos;
	}

	public void setDebitos(double debitos) {
		this.debitos = debitos;
	}

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}

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

	public String getDescConta() {
		return descConta;
	}

	public void setDescConta(String descConta) {
		this.descConta = descConta;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public String getDescOperacao() {
		return descOperacao;
	}

	public void setDescOperacao(String descOperacao) {
		this.descOperacao = descOperacao;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public String getDescModalidade() {
		return descModalidade;
	}

	public void setDescModalidade(String descModalidade) {
		this.descModalidade = descModalidade;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	@Override
	public int compareTo(Object object) {
		LancamentoList lancamentoList = (LancamentoList) object;
		return new CompareToBuilder()
				.append(this.nroLancamento, lancamentoList.nroLancamento)
				.append(this.codConta, lancamentoList.codConta)
				.append(this.descConta, lancamentoList.descConta)
				.append(this.saldoInicial, lancamentoList.saldoInicial)
				.append(this.codFornecedor, lancamentoList.codFornecedor)
				.append(this.nomeFornecedor, lancamentoList.nomeFornecedor)
				.append(this.codModalidade, lancamentoList.codModalidade)
				.append(this.descModalidade, lancamentoList.descModalidade)
				.append(this.codOperacao, lancamentoList.codOperacao)
				.append(this.descOperacao, lancamentoList.descOperacao)
				.append(this.dataRealizada, lancamentoList.dataRealizada)
				.append(this.dataVencimento, lancamentoList.dataVencimento)
				.append(this.dataRealizadaStr, lancamentoList.dataRealizadaStr)
				.append(this.dataVencimentoStr, lancamentoList.dataVencimentoStr)
				.append(this.tipoOperacao, lancamentoList.tipoOperacao)
				.append(this.valor, lancamentoList.valor)
				.append(this.observacao, lancamentoList.observacao)
				.append(this.debitos, lancamentoList.debitos)
				.append(this.creditos, lancamentoList.creditos)
				.toComparison();
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
				.append("nroLancamento", this.nroLancamento)
				.append("codConta", this.codConta)
				.append("descConta", this.descConta)
				.append("saldoInicial", this.saldoInicial)
				.append("codFornecedor", this.codFornecedor)
				.append("nomeFornecedor", this.nomeFornecedor)
				.append("codModalidade", this.codModalidade)
				.append("descModalidade", this.descModalidade)
				.append("codOperacao", this.codOperacao)
				.append("descOperacao", this.descOperacao)
				.append("dataRealizada", this.dataRealizada)
				.append("dataVencimento", this.dataVencimento)
				.append("dataRealizadaStr", this.dataRealizadaStr)
				.append("dataVencimentoStr", this.dataVencimentoStr)
				.append("tipoOperacao", this.tipoOperacao)
				.append("valor", this.valor)
				.append("observacao", this.observacao)
				.append("debitos", this.debitos)
				.append("creditos", this.creditos).toString();
	}

}

package br.com.etectupa.displaytag;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ContaList extends Object implements Comparable, Serializable {
	private int codConta;
	private int codUsuario;
	private String descricao;
	private double saldoInicial;
	private double saldoAtual;

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public int getCodConta() {
		return codConta;
	}

	public void setCodConta(int codConta) {
		this.codConta = codConta;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	@Override
	public int compareTo(Object object) {
		ContaList contaList = (ContaList) object;
		return new CompareToBuilder().append(this.codConta, contaList.codConta)
				.append(this.codConta, contaList.codConta)
				.append(this.descricao, contaList.descricao)
				.append(this.saldoInicial, contaList.saldoInicial)
				.append(this.saldoAtual, contaList.saldoAtual).toComparison();
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE) //
				.append("codConta", this.codConta) //$NON-NLS-1$
				.append("descricao", this.descricao) //$NON-NLS-1$
				.append("saldoInicial", this.saldoInicial) //$NON-NLS-1$
				.append("saldoAtual", this.saldoAtual)
				.toString();
	}

}

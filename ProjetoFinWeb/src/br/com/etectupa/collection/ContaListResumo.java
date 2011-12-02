package br.com.etectupa.collection;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ContaListResumo extends Object implements Comparable, Serializable {
	private double saldoInicial;
	private double saldo;
	
	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int compareTo(Object object) {
		ContaListResumo contaList = (ContaListResumo) object;
		return new CompareToBuilder().append(this.saldoInicial, contaList.saldoInicial)
				.append(this.saldo, contaList.saldo).toComparison();
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE) //
				.append("saldoInicial", this.saldoInicial) //$NON-NLS-1$
				.append("saldo", this.saldo)
				.toString();
	}

}

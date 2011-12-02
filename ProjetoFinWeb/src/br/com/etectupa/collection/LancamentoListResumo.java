package br.com.etectupa.collection;

import java.io.Serializable;
import java.sql.Date;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class LancamentoListResumo extends Object implements Comparable, Serializable {
	private double saldoInicial;
	private double debito;
	private double credito;
	private double total;
	private double debitoGeral;
	private double creditoGeral;
	private double totalGeral;
	private double saldo;

	public double getDebitoGeral() {
		return debitoGeral;
	}

	public void setDebitoGeral(double debitoGeral) {
		this.debitoGeral = debitoGeral;
	}

	public double getCreditoGeral() {
		return creditoGeral;
	}

	public void setCreditoGeral(double creditoGeral) {
		this.creditoGeral = creditoGeral;
	}

	public double getTotalGeral() {
		return totalGeral;
	}

	public void setTotalGeral(double totalGeral) {
		this.totalGeral = totalGeral;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getDebito() {
		return debito;
	}

	public void setDebito(double debito) {
		this.debito = debito;
	}

	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	@Override
	public int compareTo(Object object) {
		LancamentoListResumo lancamentoList = (LancamentoListResumo) object;
		return new CompareToBuilder()
				.append(this.saldoInicial, lancamentoList.saldoInicial)
				.append(this.debito, lancamentoList.debito)
				.append(this.credito, lancamentoList.credito)
				.append(this.total, lancamentoList.total)
				.append(this.debitoGeral, lancamentoList.debitoGeral)
				.append(this.creditoGeral, lancamentoList.creditoGeral)
				.append(this.totalGeral, lancamentoList.totalGeral)
				.append(this.saldo, lancamentoList.saldo)
				.toComparison();
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
				.append("saldoInicial", this.saldoInicial)
				.append("debito", this.debito)
				.append("credito", this.credito)
				.append("total", this.total)
				.append("debitoGeral", this.debitoGeral)
				.append("creditoGeral", this.creditoGeral)
				.append("totalGeral", this.totalGeral)
				.append("saldo", this.saldo).toString();
	}

}

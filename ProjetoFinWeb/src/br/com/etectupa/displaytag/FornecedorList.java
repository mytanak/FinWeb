package br.com.etectupa.displaytag;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class FornecedorList extends Object implements Comparable, Serializable{
	private int codFornecedor;
	private String nome;

	public int getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(int codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int compareTo(Object object) {
		FornecedorList usuarioList = (FornecedorList) object;
		return new CompareToBuilder().append(this.codFornecedor, usuarioList.codFornecedor)
				.append(this.nome, usuarioList.nome)
				.toComparison();
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE) //
				.append("codFornecedor", this.codFornecedor) //$NON-NLS-1$
				.append("nome", this.nome) //$NON-NLS-1$
				.toString();
	}

}

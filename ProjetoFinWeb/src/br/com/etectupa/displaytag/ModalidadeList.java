package br.com.etectupa.displaytag;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ModalidadeList extends Object implements Comparable, Serializable {
	private int codModalidade;
	private String descricao;

	public int getCodModalidade() {
		return codModalidade;
	}

	public void setCodModalidade(int codModalidade) {
		this.codModalidade = codModalidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
		@Override
		public int compareTo(Object object) {
			ModalidadeList modalidadeList = (ModalidadeList) object;
			return new CompareToBuilder().append(this.codModalidade, modalidadeList.codModalidade)
					.append(this.codModalidade, modalidadeList.codModalidade)
					.append(this.descricao, modalidadeList.descricao).toComparison();
		}
		
		public String toString() {
			return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE) //
					.append("codModalidade", this.codModalidade) //$NON-NLS-1$
					.append("descricao", this.descricao) //$NON-NLS-1$
					.toString();
		}

	}
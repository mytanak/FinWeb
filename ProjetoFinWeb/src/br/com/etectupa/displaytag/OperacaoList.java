package br.com.etectupa.displaytag;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class OperacaoList extends Object implements Comparable, Serializable {
	private int codOperacao;
	private int codGrupo;
	private String descricao;
	private String tipo;
	private String tipoStr;
	private String descGrupo;	

	public String getDescGrupo() {
		return descGrupo;
	}

	public void setDescGrupo(String descGrupo) {
		this.descGrupo = descGrupo;
	}

	public String getTipoStr() {
		return tipoStr;
	}

	public void setTipoStr(String tipoStr) {
		this.tipoStr = tipoStr;
	}

	public int getCodOperacao() {
		return codOperacao;
	}

	public void setCodOperacao(int codOperacao) {
		this.codOperacao = codOperacao;
	}

	public int getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(int codGrupo) {
		this.codGrupo = codGrupo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Object object) {
		OperacaoList operacaoList = (OperacaoList) object;
		return new CompareToBuilder().append(this.codOperacao, operacaoList.codOperacao)
				.append(this.codGrupo, operacaoList.codGrupo)	
				.append(this.codOperacao, operacaoList.codOperacao)
				.append(this.descricao, operacaoList.descricao)
				.append(this.tipo, operacaoList.tipo)
				.append(this.tipoStr, operacaoList.tipoStr)
				.append(this.descGrupo, operacaoList.descGrupo).toComparison();
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE) //
				.append("codGrupo", this.codGrupo) //$NON-NLS-1$
				.append("codOperacao", this.codOperacao) //$NON-NLS-1$
				.append("descricao", this.descricao) //$NON-NLS-1$
				.append("tipo", this.tipo) //$NON-NLS-1$
				.append("tipoStr", this.tipoStr)
				.append("descGrupo", this.descGrupo)
				.toString();
	}

}


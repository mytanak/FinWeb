package br.com.etectupa.displaytag;

import java.io.Serializable;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class GrupoList extends Object implements Comparable, Serializable{
	private int codGrupo;
	private String descricao;

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

	@Override
	public int compareTo(Object object) {
		GrupoList grupoList = (GrupoList) object;
		return new CompareToBuilder().append(this.codGrupo, grupoList.codGrupo)
				.append(this.descricao,grupoList.descricao)
				.toComparison();
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE) //
				.append("codGrupo", this.codGrupo) //$NON-NLS-1$
				.append("descricao", this.descricao) //$NON-NLS-1$
				.toString();
	}



}

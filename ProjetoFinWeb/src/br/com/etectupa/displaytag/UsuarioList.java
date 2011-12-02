package br.com.etectupa.displaytag;

import java.io.Serializable;
import java.sql.Date;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UsuarioList extends Object implements Comparable, Serializable {
	private int codUsuario;
	private String idUsuario;
	private String nome;
	private String senha;
	private String email;
	private Date dataNascimento;
	private String dataNascimentoStr;

	public String getDataNascimentoStr() {
		return dataNascimentoStr;
	}

	public void setDataNascimentoStr(String dataNascimentoStr) {
		this.dataNascimentoStr = dataNascimentoStr;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int compareTo(Object object) {
		UsuarioList usuarioList = (UsuarioList) object;
		return new CompareToBuilder().append(this.codUsuario, usuarioList.codUsuario)
				.append(this.idUsuario, usuarioList.idUsuario)
				.append(this.nome, usuarioList.nome)
				.append(this.email, usuarioList.email)
				.append(this.dataNascimento, usuarioList.dataNascimento)
				.append(this.dataNascimentoStr, usuarioList.dataNascimentoStr).toComparison();
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE) //
				.append("codUsuario", this.codUsuario) //$NON-NLS-1$
				.append("idUsuario", this.idUsuario) //$NON-NLS-1$
				.append("nome", this.nome) //$NON-NLS-1$
				.append("email", this.email) //$NON-NLS-1$
				.append("dataNascimento", this.dataNascimento) //$NON-NLS-1$
				.append("dataNascimentoStr", this.dataNascimentoStr)
				.toString();
	}

}

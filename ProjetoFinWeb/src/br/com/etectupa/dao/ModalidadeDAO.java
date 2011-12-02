package br.com.etectupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.etectupa.model.Modalidade;
import br.com.etectupa.util.Conecta;

public class ModalidadeDAO {
	public void inserir(Modalidade modalidade) {
		String sql = "INSERT INTO Modalidade (descricao) " 
				+ "   VALUES (?)";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, modalidade.getDescricao());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Modalidade modalidade) {
		String sql = "UPDATE Modalidade " 
	            + "   SET descricao = ? "
				+ " WHERE codModalidade = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, modalidade.getDescricao());
			stmt.setInt(2, modalidade.getCodModalidade());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int codModalidade) {
		String sql = "DELETE FROM Modalidade " 
	              + " WHERE codModalidade = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codModalidade);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Modalidade listarUnico(int codModalidade) {
		Modalidade modalidade = new Modalidade();
		String sql = "SELECT * FROM Modalidade " 
		          + " WHERE codModalidade = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codModalidade);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			modalidade.setCodModalidade(rs.getInt("codModalidade"));
			modalidade.setDescricao(rs.getString("descricao"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modalidade;
	}

	public Modalidade listarUnico(String descricao) {
		Modalidade modalidade = new Modalidade();
		String sql = "SELECT * FROM Modalidade " 
		          + " WHERE descricao = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, descricao);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			modalidade.setCodModalidade(rs.getInt("codModalidade"));
			modalidade.setDescricao(rs.getString("descricao"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modalidade;
	}

	public List<Modalidade> getLista() {
		ArrayList<Modalidade> modalidades = new ArrayList<Modalidade>();
		String sql = "SELECT * FROM Modalidade";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Modalidade modalidade = new Modalidade();
				modalidade.setCodModalidade(rs.getInt("codModalidade"));
				modalidade.setDescricao(rs.getString("descricao"));
								
				modalidades.add(modalidade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modalidades;
	}
}

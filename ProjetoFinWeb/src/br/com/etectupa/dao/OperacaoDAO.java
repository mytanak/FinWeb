package br.com.etectupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.etectupa.model.Operacao;
import br.com.etectupa.util.Conecta;

public class OperacaoDAO {
	public void inserir(Operacao operacao) {
		String sql = "INSERT INTO Operacao (codGrupo, "
				+ "                         descricao, "
				+ "                         tipo) " 
				+ "   VALUES (?, "
				+ "           ?, " 
				+ "           ?)";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, operacao.getCodGrupo());
			stmt.setString(2, operacao.getDescricao());
			stmt.setString(3, operacao.getTipo());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Operacao operacao) {
		String sql = "UPDATE Operacao " 
	            + "   SET codGrupo = ?, " 
	            + "       descricao = ?, "
				+ "       tipo = ? " 
				+ " WHERE codOperacao = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, operacao.getCodGrupo());
			stmt.setString(2, operacao.getDescricao());
			stmt.setString(3, operacao.getTipo());
			stmt.setInt(4, operacao.getCodOperacao());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int codOperacao) {
		String sql = "DELETE FROM Operacao " 
	              + " WHERE codOperacao = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codOperacao);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Operacao listarUnico(int codOperacao) {
		Operacao operacao = new Operacao();
		String sql = "SELECT * FROM Operacao " 
		          + " WHERE codOperacao = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codOperacao);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			operacao.setCodOperacao(rs.getInt("codOperacao"));
			operacao.setCodGrupo(rs.getInt("codGrupo"));
			operacao.setDescricao(rs.getString("descricao"));
			operacao.setTipo(rs.getString("tipo"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return operacao;
	}

	public Operacao listarUnico(String descricao) {
		Operacao operacao = new Operacao();
		String sql = "SELECT * FROM Operacao " 
		          + " WHERE descricao = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, descricao);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			operacao.setCodOperacao(rs.getInt("codOperacao"));
			operacao.setCodGrupo(rs.getInt("codGrupo"));
			operacao.setDescricao(rs.getString("descricao"));
			operacao.setTipo(rs.getString("tipo"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return operacao;
	}

	public List<Operacao> getLista() {
		ArrayList<Operacao> operacaos = new ArrayList<Operacao>();
		String sql = "SELECT * FROM Operacao";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Operacao operacao = new Operacao();
				operacao.setCodOperacao(rs.getInt("codOperacao"));
				operacao.setCodGrupo(rs.getInt("codGrupo"));
				operacao.setDescricao(rs.getString("descricao"));
				operacao.setTipo(rs.getString("tipo"));
								
				operacaos.add(operacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return operacaos;
	}
	
	public List<Operacao> listarOperacoes(int codGrupo) {
		ArrayList<Operacao> operacoes = new ArrayList<Operacao>();
		String sql = "SELECT * FROM Operacao" +
				     " WHERE codGrupo = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codGrupo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Operacao operacao = new Operacao();
				operacao.setCodOperacao(rs.getInt("codOperacao"));
				operacao.setCodGrupo(rs.getInt("codGrupo"));
				operacao.setDescricao(rs.getString("descricao"));
				operacao.setTipo(rs.getString("tipo"));
								
				operacoes.add(operacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return operacoes;
	}
	
}

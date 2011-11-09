package br.com.etectupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.etectupa.model.Grupo;
import br.com.etectupa.util.Conecta;

public class GrupoDAO {
	public void inserir(Grupo grupo) {
		String sql = "INSERT INTO Grupo (descricao) " 
				+ "   VALUES (?)";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, grupo.getDescricao());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Grupo grupo) {
		String sql = "UPDATE Grupo " 
	            + "   SET descricao = ? "
				+ " WHERE codGrupo = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, grupo.getDescricao());
			stmt.setInt(2, grupo.getCodGrupo());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int codGrupo) {
		String sql = "DELETE FROM Grupo " 
	              + " WHERE codGrupo = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codGrupo);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Grupo listarUnico(int codGrupo) {
		Grupo grupo = new Grupo();
		String sql = "SELECT * FROM Grupo " 
		          + " WHERE codGrupo = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codGrupo);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			grupo.setCodGrupo(rs.getInt("codGrupo"));
			grupo.setDescricao(rs.getString("descricao"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return grupo;
	}

	public List<Grupo> getLista() {
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		String sql = "SELECT * FROM Grupo";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Grupo grupo = new Grupo();
				grupo.setCodGrupo(rs.getInt("codGrupo"));
				grupo.setDescricao(rs.getString("descricao"));
								
				grupos.add(grupo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return grupos;
	}
}

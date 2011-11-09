package br.com.etectupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.etectupa.model.Fornecedor;
import br.com.etectupa.util.Conecta;

public class FornecedorDAO {
	public void inserir(Fornecedor fornecedor) {
		String sql = "INSERT INTO Fornecedor (nome) " 
				+ "   VALUES (?)";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Fornecedor fornecedor) {
		String sql = "UPDATE Fornecedor " 
	            + "   SET nome = ? "
				+ " WHERE codFornecedor = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, fornecedor.getNome());
			stmt.setInt(2, fornecedor.getCodFornecedor());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int codFornecedor) {
		String sql = "DELETE FROM Fornecedor " 
	              + " WHERE codFornecedor = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codFornecedor);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Fornecedor listarUnico(int codFornecedor) {
		Fornecedor fornecedor = new Fornecedor();
		String sql = "SELECT * FROM Fornecedor " 
		          + " WHERE codFornecedor = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codFornecedor);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			fornecedor.setCodFornecedor(rs.getInt("codFornecedor"));
			fornecedor.setNome(rs.getString("nome"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fornecedor;
	}

	public List<Fornecedor> getLista() {
		ArrayList<Fornecedor> fornecedors = new ArrayList<Fornecedor>();
		String sql = "SELECT * FROM Fornecedor";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setCodFornecedor(rs.getInt("codFornecedor"));
				fornecedor.setNome(rs.getString("nome"));
								
				fornecedors.add(fornecedor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fornecedors;
	}
}

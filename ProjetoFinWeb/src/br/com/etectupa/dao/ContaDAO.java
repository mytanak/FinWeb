package br.com.etectupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.etectupa.model.Conta;
import br.com.etectupa.util.Conecta;

public class ContaDAO {
	public void inserir(Conta conta) {
		String sql = "INSERT INTO Conta (codUsuario, descricao, saldoInicial) " 
				+ "   VALUES (?," 
				+ "           ?,"
				+ "           ?)";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodUsuario());
			stmt.setString(2, conta.getDescricao());
			stmt.setDouble(3, conta.getSaldoInicial());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Conta conta) {
		String sql = "UPDATE Conta " 
	            + "   SET descricao = ?, "
	            + "       saldoInicial = ? "
				+ " WHERE codConta = ?" 
	            + "   AND codUsuario = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);			
			stmt.setString(1, conta.getDescricao());
			stmt.setDouble(2, conta.getSaldoInicial());
			stmt.setInt(3, conta.getCodConta());
			stmt.setInt(4, conta.getCodUsuario());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int codConta) {
		String sql = "DELETE FROM Conta " 
	              + " WHERE codConta = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codConta);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Conta listarUnico(int codConta) {
		Conta conta = new Conta();
		String sql = "SELECT * FROM Conta " 
		          + " WHERE codConta = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codConta);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			conta.setCodConta(rs.getInt("codConta"));
			conta.setCodUsuario(rs.getInt("codUsuario"));
			conta.setDescricao(rs.getString("descricao"));
			conta.setSaldoInicial(rs.getDouble("saldoInicial"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conta;
	}

	public List<Conta> getLista() {
		ArrayList<Conta> contas = new ArrayList<Conta>();
		String sql = "SELECT * FROM Conta";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Conta conta = new Conta();
				conta.setCodConta(rs.getInt("codConta"));
				conta.setCodUsuario(rs.getInt("codUsuario"));
				conta.setDescricao(rs.getString("descricao"));
				conta.setSaldoInicial(rs.getDouble("saldoInicial"));
								
				contas.add(conta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contas;
	}
}

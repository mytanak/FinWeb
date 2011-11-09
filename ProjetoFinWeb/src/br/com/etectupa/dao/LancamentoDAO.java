package br.com.etectupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.etectupa.model.Lancamento;
import br.com.etectupa.util.Conecta;

public class LancamentoDAO {
	public void inserir(Lancamento lancamento) {
		String sql = "INSERT INTO Lancamento (codConta, "
				+ "                           codOperacao, "
				+ "                           codModalidade, "
				+ "                           codFornecedor, "
				+ "                           dataVencimento, "
				+ "                           dataRealizada, "
				+ "                           valor, "
				+ "                           observacao) " 
				+ "   VALUES (?, "
				+ "           ?, " 
				+ "           ?, " 
				+ "           ?, " 
				+ "           ?, "
				+ "           ?, " 
				+ "           ?, " 
				+ "           ?)";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, lancamento.getCodConta());
			stmt.setInt(2, lancamento.getCodOperacao());
			stmt.setInt(3, lancamento.getCodModalidade());
			stmt.setInt(4, lancamento.getCodFornecedor());
			stmt.setDate(5, lancamento.getDataVencimento());
			stmt.setDate(6, lancamento.getDataRealizada());
			stmt.setDouble(7, lancamento.getValor());
			stmt.setString(8, lancamento.getObservacao());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Lancamento lancamento) {
		String sql = "UPDATE Lancamento " 
	            + "   SET codConta = ?, "
				+ "       codOperacao = ?, " 
	            + "       codModalidade = ?, "
				+ "       codFornecedor = ?, "
				+ "       dataVencimento = ?, "
				+ "       dataRealizada = ?, " 
				+ "       valor = ?, "
				+ "       observacao = ? " 
				+ " WHERE nroLancamento = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, lancamento.getCodConta());
			stmt.setInt(2, lancamento.getCodOperacao());
			stmt.setInt(3, lancamento.getCodModalidade());
			stmt.setInt(4, lancamento.getCodFornecedor());
			stmt.setDate(5, lancamento.getDataVencimento());
			stmt.setDate(6, lancamento.getDataRealizada());
			stmt.setDouble(7, lancamento.getValor());
			stmt.setString(8, lancamento.getObservacao());
			stmt.setInt(9, lancamento.getNroLancamento());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int nroLancamento) {
		String sql = "DELETE FROM Lancamento " 
	              + " WHERE nroLancamento = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, nroLancamento);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Lancamento listarUnico(int nroLancamento) {
		Lancamento lancamento = new Lancamento();
		String sql = "SELECT * FROM Lancamento " 
		          + " WHERE nroLancamento = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, nroLancamento);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			lancamento.setNroLancamento(rs.getInt("nroLancamento"));
			lancamento.setCodConta(rs.getInt("codConta"));
			lancamento.setCodOperacao(rs.getInt("codOperacao"));
			lancamento.setCodModalidade(rs.getInt("codModalidade"));
			lancamento.setCodFornecedor(rs.getInt("codFornecedor"));
			lancamento.setDataVencimento(rs.getDate("dataVencimento"));
			lancamento.setDataRealizada(rs.getDate("dataRealizada"));
			lancamento.setValor(rs.getDouble("valor"));
			lancamento.setObservacao(rs.getString("observacao"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lancamento;
	}

	public List<Lancamento> getLista() {
		ArrayList<Lancamento> lancamentos = new ArrayList<Lancamento>();
		String sql = "SELECT * FROM Lancamento";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Lancamento lancamento = new Lancamento();
				lancamento.setNroLancamento(rs.getInt("nroLancamento"));
				lancamento.setCodConta(rs.getInt("codConta"));
				lancamento.setCodOperacao(rs.getInt("codOperacao"));
				lancamento.setCodModalidade(rs.getInt("codModalidade"));
				lancamento.setCodFornecedor(rs.getInt("codFornecedor"));
				lancamento.setDataVencimento(rs.getDate("dataVencimento"));
				lancamento.setDataRealizada(rs.getDate("dataRealizada"));
				lancamento.setValor(rs.getDouble("valor"));
				lancamento.setObservacao(rs.getString("observacao"));
				
				lancamentos.add(lancamento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lancamentos;
	}
	
	public List<Lancamento> getLista(int codConta) {
		ArrayList<Lancamento> lancamentos = new ArrayList<Lancamento>();
		String sql = "SELECT * FROM Lancamento"
					+ " WHERE codConta = ?";
		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codConta);

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Lancamento lancamento = new Lancamento();
				lancamento.setNroLancamento(rs.getInt("nroLancamento"));
				lancamento.setCodConta(rs.getInt("codConta"));
				lancamento.setCodOperacao(rs.getInt("codOperacao"));
				lancamento.setCodModalidade(rs.getInt("codModalidade"));
				lancamento.setCodFornecedor(rs.getInt("codFornecedor"));
				lancamento.setDataVencimento(rs.getDate("dataVencimento"));
				lancamento.setDataRealizada(rs.getDate("dataRealizada"));
				lancamento.setValor(rs.getDouble("valor"));
				lancamento.setObservacao(rs.getString("observacao"));
				
				lancamentos.add(lancamento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lancamentos;
	}
	
}

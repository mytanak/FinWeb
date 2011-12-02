package br.com.etectupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.etectupa.model.Conta;
import br.com.etectupa.model.Usuario;
import br.com.etectupa.util.Conecta;

public class SaldoDAO {

	public double retornaSaldoConta(Conta conta) {
		double saldo = 0;
		String sql = "SELECT (saldoInicial + credito - debito) AS saldoAtual" +
                    "  FROM (SELECT Conta.saldoInicial, "+ 
					"	               SUM(Debito) AS Debito, "+ 
					"	               SUM(Credito) AS Credito "+
					"	          FROM (SELECT Conta.codConta, "+
					"	                       CASE WHEN Operacao.tipo = 'D' "+
					"	                            THEN Lancamento.valor  "+
					"	                            ELSE 0 "+
					"	                       END AS Debito, "+
					"	                       CASE WHEN Operacao.tipo = 'C' "+
					"	                            THEN Lancamento.valor "+
					"	                            ELSE 0 "+
					"	                       END AS Credito "+
					"	                  FROM Conta(NOLOCK) " +
					"                     LEFT JOIN Lancamento(NOLOCK)" +
					"	                    ON Conta.codConta = Lancamento.codConta" +
					"	                   AND Lancamento.dataRealizada IS NOT NULL"+
					"	                  LEFT JOIN Operacao(NOLOCK) "+
					"	                    ON Operacao.codOperacao = Lancamento.codOperacao "+
					"	                 WHERE Conta.codConta = ?) AS Lcto "+
					"	         INNER JOIN Conta(NOLOCK) "+
					"	            ON Conta.codConta = Lcto.codConta "+
					"	         GROUP BY Conta.saldoInicial) AS Saldo";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodConta());

			ResultSet rs = stmt.executeQuery();

			rs.next();

			saldo = rs.getDouble("saldoAtual");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return saldo;
	}
	
	public double retornaSaldo(Usuario usuario) {
		double saldo = 0;
		
		ContaDAO contaDao = new ContaDAO();
		List<Conta> contas = contaDao.Lista(usuario.getCodUsuario());
		
		for (Conta conta : contas) {
			saldo += retornaSaldoConta(conta);
		}

		return saldo;
	}

	public double retornaSaldoInicial(Usuario usuario) {
		double saldo = 0;
		String sql = "SELECT SUM(saldoInicial) AS saldoInicial" +
                    "   FROM Conta "+ 
					"  WHERE codUsuario = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());

			ResultSet rs = stmt.executeQuery();

			rs.next();

			saldo = rs.getDouble("saldoInicial");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return saldo;
	}
	
}

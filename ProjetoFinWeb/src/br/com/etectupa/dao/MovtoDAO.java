package br.com.etectupa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.etectupa.model.Conta;
import br.com.etectupa.model.Operacao;
import br.com.etectupa.model.Usuario;
import br.com.etectupa.util.Conecta;

public class MovtoDAO {

	public double retornaMovtoDebito(Conta conta) {
		double debito = 0;
		String sql = "SELECT SUM(Valor) AS debito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  WHERE Lancamento.codConta = ?  "+
					"    AND Operacao.tipo = 'D' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodConta());

			ResultSet rs = stmt.executeQuery();

			rs.next();

			debito = rs.getDouble("debito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return debito;
	}
	
	public double retornaMovtoCredito(Conta conta) {
		double credito = 0;
		String sql = "SELECT SUM(Valor) AS credito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  WHERE Lancamento.codConta = ?  "+
					"    AND Operacao.tipo = 'C' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodConta());

			ResultSet rs = stmt.executeQuery();

			rs.next();

			credito = rs.getDouble("credito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return credito;
	}
		
	public double retornaMovtoDebito(Usuario usuario) {
		double debito = 0;
		String sql = "SELECT SUM(Valor) AS debito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  INNER JOIN Conta(NOLOCK) "+
					"     ON Lancamento.codConta = Conta.codConta "+
					"  WHERE Conta.codUsuario = ?  "+
					"    AND Operacao.tipo = 'D' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());

			ResultSet rs = stmt.executeQuery();

			rs.next();

			debito = rs.getDouble("debito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return debito;
	}
	
	public double retornaMovtoCredito(Usuario usuario) {
		double credito = 0;
		String sql = "SELECT SUM(Valor) AS credito "+
				"	FROM Lancamento(NOLOCK) "+
				"  INNER JOIN Operacao(NOLOCK) "+
				"     ON Operacao.codOperacao = Lancamento.codOperacao "+
				"  INNER JOIN Conta(NOLOCK) "+
				"     ON Lancamento.codConta = Conta.codConta "+
				"  WHERE Conta.codUsuario = ?  "+
				"    AND Operacao.tipo = 'C' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());

			ResultSet rs = stmt.executeQuery();

			rs.next();

			credito = rs.getDouble("credito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return credito;
	}	

	public double retornaMovtoDebitoPago(Conta conta) {
		double debito = 0;
		String sql = "SELECT SUM(Valor) AS debito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  WHERE Lancamento.codConta = ?  " +
					"    AND Lancamento.dataRealizada IS NOT NULL "+
					"    AND Operacao.tipo = 'D' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodConta());

			ResultSet rs = stmt.executeQuery();

			rs.next();

			debito = rs.getDouble("debito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return debito;
	}
	
	public double retornaMovtoCreditoPago(Conta conta) {
		double credito = 0;
		String sql = "SELECT SUM(Valor) AS credito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  WHERE Lancamento.codConta = ?  "+
					"    AND Lancamento.dataRealizada IS NOT NULL "+
					"    AND Operacao.tipo = 'C' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodConta());

			ResultSet rs = stmt.executeQuery();

			rs.next();

			credito = rs.getDouble("credito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return credito;
	}
		
	public double retornaMovtoDebitoPago(Usuario usuario) {
		double debito = 0;
		String sql = "SELECT SUM(Valor) AS debito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  INNER JOIN Conta(NOLOCK) "+
					"     ON Lancamento.codConta = Conta.codConta "+
					"  WHERE Conta.codUsuario = ?  "+
					"    AND Lancamento.dataRealizada IS NOT NULL "+
					"    AND Operacao.tipo = 'D' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());

			ResultSet rs = stmt.executeQuery();

			rs.next();

			debito = rs.getDouble("debito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return debito;
	}
	
	public double retornaMovtoCreditoPago(Usuario usuario) {
		double credito = 0;
		String sql = "SELECT SUM(Valor) AS credito "+
				"	FROM Lancamento(NOLOCK) "+
				"  INNER JOIN Operacao(NOLOCK) "+
				"     ON Operacao.codOperacao = Lancamento.codOperacao "+
				"  INNER JOIN Conta(NOLOCK) "+
				"     ON Lancamento.codConta = Conta.codConta "+
				"  WHERE Conta.codUsuario = ?  "+
				"    AND Lancamento.dataRealizada IS NOT NULL "+
				"    AND Operacao.tipo = 'C' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());

			ResultSet rs = stmt.executeQuery();

			rs.next();

			credito = rs.getDouble("credito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return credito;
	}	

	public double retornaMovtoDebito(Conta conta, Date dtInicial, Date dtFinal) {
		double debito = 0;
		String sql = "SELECT SUM(Valor) AS debito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  WHERE Lancamento.codConta = ?  "+
					"    AND Lancamento.dataVencimento BETWEEN ? AND ?" +
					"    AND Operacao.tipo = 'D' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodConta());
			stmt.setDate(2, dtInicial);
			stmt.setDate(3, dtFinal);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			debito = rs.getDouble("debito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return debito;
	}
	
	public double retornaMovtoCredito(Conta conta, Date dtInicial, Date dtFinal) {
		double credito = 0;
		String sql = "SELECT SUM(Valor) AS credito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  WHERE Lancamento.codConta = ?  "+
					"    AND Lancamento.dataVencimento BETWEEN ? AND ?" +
					"    AND Operacao.tipo = 'C' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodConta());
			stmt.setDate(2, dtInicial);
			stmt.setDate(3, dtFinal);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			credito = rs.getDouble("credito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return credito;
	}
		
	public double retornaMovtoDebito(Usuario usuario, Date dtInicial, Date dtFinal) {
		double debito = 0;
		String sql = "SELECT SUM(Valor) AS debito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  INNER JOIN Conta(NOLOCK) "+
					"     ON Lancamento.codConta = Conta.codConta "+
					"  WHERE Conta.codUsuario = ?  "+
					"    AND Lancamento.dataVencimento BETWEEN ? AND ?" +
					"    AND Operacao.tipo = 'D' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());
			stmt.setDate(2, dtInicial);
			stmt.setDate(3, dtFinal);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			debito = rs.getDouble("debito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return debito;
	}
	
	public double retornaMovtoCredito(Usuario usuario, Date dtInicial, Date dtFinal) {
		double credito = 0;
		String sql = "SELECT SUM(Valor) AS credito "+
				"	FROM Lancamento(NOLOCK) "+
				"  INNER JOIN Operacao(NOLOCK) "+
				"     ON Operacao.codOperacao = Lancamento.codOperacao "+
				"  INNER JOIN Conta(NOLOCK) "+
				"     ON Lancamento.codConta = Conta.codConta "+
				"  WHERE Conta.codUsuario = ?  "+
				"    AND Lancamento.dataVencimento BETWEEN ? AND ?" +
				"    AND Operacao.tipo = 'C' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());
			stmt.setDate(2, dtInicial);
			stmt.setDate(3, dtFinal);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			credito = rs.getDouble("credito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return credito;
	}	

	public double retornaMovtoDebitoPago(Conta conta, Date dtInicial, Date dtFinal) {
		double debito = 0;
		String sql = "SELECT SUM(Valor) AS debito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  WHERE Lancamento.codConta = ?  "+
					"    AND Lancamento.dataVencimento BETWEEN ? AND ?" +
					"    AND Lancamento.dataRealizada IS NOT NULL " +
					"    AND Operacao.tipo = 'D' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodConta());
			stmt.setDate(2, dtInicial);
			stmt.setDate(3, dtFinal);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			debito = rs.getDouble("debito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return debito;
	}
	
	public double retornaMovtoCreditoPago(Conta conta, Date dtInicial, Date dtFinal) {
		double credito = 0;
		String sql = "SELECT SUM(Valor) AS credito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  WHERE Lancamento.codConta = ?  "+
					"    AND Lancamento.dataVencimento BETWEEN ? AND ?" +
					"    AND Lancamento.dataRealizada IS NOT NULL " +
					"    AND Operacao.tipo = 'C' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodConta());
			stmt.setDate(2, dtInicial);
			stmt.setDate(3, dtFinal);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			credito = rs.getDouble("credito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return credito;
	}
		
	public double retornaMovtoDebitoPago(Usuario usuario, Date dtInicial, Date dtFinal) {
		double debito = 0;
		String sql = "SELECT SUM(Valor) AS debito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  INNER JOIN Conta(NOLOCK) "+
					"     ON Lancamento.codConta = Conta.codConta "+
					"  WHERE Conta.codUsuario = ?  "+
					"    AND Lancamento.dataVencimento BETWEEN ? AND ?" +
					"    AND Lancamento.dataRealizada IS NOT NULL " +
					"    AND Operacao.tipo = 'D' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());
			stmt.setDate(2, dtInicial);
			stmt.setDate(3, dtFinal);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			debito = rs.getDouble("debito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return debito;
	}
	
	public double retornaMovtoCreditoPago(Usuario usuario, Date dtInicial, Date dtFinal) {
		double credito = 0;
		String sql = "SELECT SUM(Valor) AS credito "+
				"	FROM Lancamento(NOLOCK) "+
				"  INNER JOIN Operacao(NOLOCK) "+
				"     ON Operacao.codOperacao = Lancamento.codOperacao "+
				"  INNER JOIN Conta(NOLOCK) "+
				"     ON Lancamento.codConta = Conta.codConta "+
				"  WHERE Conta.codUsuario = ?  "+
				"    AND Lancamento.dataVencimento BETWEEN ? AND ?" +
				"    AND Lancamento.dataRealizada IS NOT NULL " +
				"    AND Operacao.tipo = 'C' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());
			stmt.setDate(2, dtInicial);
			stmt.setDate(3, dtFinal);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			credito = rs.getDouble("credito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return credito;
	}	

	public double retornaMovtoDebitoPago(Usuario usuario, List<Operacao> operacoes, Date dtInicial, Date dtFinal) {
		double debito = 0;
		
		for (Operacao operacao : operacoes) {
			String sql = "SELECT SUM(Valor) AS debito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  INNER JOIN Conta(NOLOCK) "+
					"     ON Lancamento.codConta = Conta.codConta "+
					"  WHERE Conta.codUsuario = ?  "+
					"    AND Lancamento.dataVencimento BETWEEN ? AND ?" +
					"    AND Operacao.codOperacao = ?" +
					"    AND Lancamento.dataRealizada IS NOT NULL " +
					"    AND Operacao.tipo = 'D' ";

			try {
				Conecta conn = Conecta.getInstance();
				Connection conexao = conn.getConnection();
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, usuario.getCodUsuario());
				stmt.setDate(2, dtInicial);
				stmt.setDate(3, dtFinal);
				stmt.setInt(4, operacao.getCodOperacao());
	
				ResultSet rs = stmt.executeQuery();
	
				rs.next();
	
				debito += rs.getDouble("debito");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return debito;
	}


	public double retornaMovtoCreditoPago(Usuario usuario, List<Operacao> operacoes, Date dtInicial, Date dtFinal) {
		double credito = 0;
		
		for (Operacao operacao : operacoes) {
			String sql = "SELECT SUM(Valor) AS credito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  INNER JOIN Conta(NOLOCK) "+
					"     ON Lancamento.codConta = Conta.codConta "+
					"  WHERE Conta.codUsuario = ?  "+
					"    AND Lancamento.dataVencimento BETWEEN ? AND ?" +
					"    AND Operacao.codOperacao = ?" +
					"    AND Lancamento.dataRealizada IS NOT NULL " +
					"    AND Operacao.tipo = 'C' ";

			try {
				Conecta conn = Conecta.getInstance();
				Connection conexao = conn.getConnection();
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, usuario.getCodUsuario());
				stmt.setDate(2, dtInicial);
				stmt.setDate(3, dtFinal);
				stmt.setInt(4, operacao.getCodOperacao());
	
				ResultSet rs = stmt.executeQuery();
	
				rs.next();
	
				credito += rs.getDouble("credito");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return credito;
	}

	public double retornaMovtoDebitoAtraso(Conta conta, Date data) {
		double debito = 0;
		String sql = "SELECT SUM(Valor) AS debito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  WHERE Lancamento.codConta = ?  "+
					"    AND Lancamento.dataVencimento < ? " +
					"    AND Lancamento.dataRealizada IS NULL " +
					"    AND Operacao.tipo = 'D' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodConta());
			stmt.setDate(2, data);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			debito = rs.getDouble("debito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return debito;
	}
	
	public double retornaMovtoCreditoAtraso(Conta conta, Date data) {
		double credito = 0;
		String sql = "SELECT SUM(Valor) AS credito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  WHERE Lancamento.codConta = ?  "+
					"    AND Lancamento.dataVencimento < ? " +
					"    AND Lancamento.dataRealizada IS NULL " +
					"    AND Operacao.tipo = 'C' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCodConta());
			stmt.setDate(2, data);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			credito = rs.getDouble("credito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return credito;
	}
		
	public double retornaMovtoDebitoAtraso(Usuario usuario, Date data) {
		double debito = 0;
		String sql = "SELECT SUM(Valor) AS debito "+
					"	FROM Lancamento(NOLOCK) "+
					"  INNER JOIN Operacao(NOLOCK) "+
					"     ON Operacao.codOperacao = Lancamento.codOperacao "+
					"  INNER JOIN Conta(NOLOCK) "+
					"     ON Lancamento.codConta = Conta.codConta "+
					"  WHERE Conta.codUsuario = ?  "+
					"    AND Lancamento.dataVencimento < ? " +
					"    AND Lancamento.dataRealizada IS NULL " +
					"    AND Operacao.tipo = 'D' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());
			stmt.setDate(2, data);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			debito = rs.getDouble("debito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return debito;
	}
	
	public double retornaMovtoCreditoAtraso(Usuario usuario, Date data) {
		double credito = 0;
		String sql = "SELECT SUM(Valor) AS credito "+
				"	FROM Lancamento(NOLOCK) "+
				"  INNER JOIN Operacao(NOLOCK) "+
				"     ON Operacao.codOperacao = Lancamento.codOperacao "+
				"  INNER JOIN Conta(NOLOCK) "+
				"     ON Lancamento.codConta = Conta.codConta "+
				"  WHERE Conta.codUsuario = ?  "+
				"    AND Lancamento.dataVencimento < ? " +
				"    AND Lancamento.dataRealizada IS NULL " +
				"    AND Operacao.tipo = 'C' ";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, usuario.getCodUsuario());
			stmt.setDate(2, data);
			
			ResultSet rs = stmt.executeQuery();

			rs.next();

			credito = rs.getDouble("credito");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return credito;
	}	
	
	
}

package br.com.etectupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.etectupa.model.Usuario;
import br.com.etectupa.util.Conecta;

public class UsuarioDAO {
	public void inserir(Usuario usuario) {
		String sql = "INSERT INTO Usuario (idUsuario, nome, senha, email, dataNascimento) " 
				+ "   VALUES (?," 
				+ "           ?," 
				+ "           ?,"
				+ "           ?,"
				+ "           ?)";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getIdUsuario());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getEmail());
			stmt.setDate(5, usuario.getDataNascimento());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario) {
		String sql = "UPDATE Usuario " 
	            + "   SET idUsuario = ?, "
	            + "       nome = ?, "
	            + "       senha = ?, "
	            + "       email = ?, "
	            + "       dataNascimento = ? "
				+ " WHERE codUsuario = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getIdUsuario());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, usuario.getEmail());
			stmt.setDate(5, usuario.getDataNascimento());
			stmt.setInt(6, usuario.getCodUsuario());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int codUsuario) {
		String sql = "DELETE FROM Usuario " 
	              + " WHERE codUsuario = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codUsuario);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario listarUnico(int codUsuario) {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM Usuario " 
		          + " WHERE codUsuario = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codUsuario);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			usuario.setCodUsuario(rs.getInt("codUsuario"));
			usuario.setIdUsuario(rs.getString("idUsuario"));
			usuario.setNome(rs.getString("nome"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setEmail(rs.getString("email"));
			usuario.setDataNascimento(rs.getDate("dataNascimento"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}
	public Usuario getUsuario(String idUsuario) {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM Usuario " 
		          + " WHERE idUsuario = ?";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, idUsuario);

			ResultSet rs = stmt.executeQuery();

			rs.next();

			usuario.setCodUsuario(rs.getInt("codUsuario"));
			usuario.setIdUsuario(rs.getString("idUsuario"));
			usuario.setNome(rs.getString("nome"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setEmail(rs.getString("email"));
			usuario.setDataNascimento(rs.getDate("dataNascimento"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public List<Usuario> getLista() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT * FROM Usuario";

		try {
			Conecta conn = Conecta.getInstance();
			Connection conexao = conn.getConnection();
			Statement stmt = conexao.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCodUsuario(rs.getInt("codUsuario"));
				usuario.setIdUsuario(rs.getString("idUsuario"));				
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDataNascimento(rs.getDate("dataNascimento"));
								
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}
}

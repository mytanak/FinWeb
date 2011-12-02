package br.com.etectupa.validation;

import java.util.List;

import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.model.Conta;
import br.com.etectupa.model.Usuario;

public class ValidaLogin {
	public static boolean existeUsuario(Usuario login) {
		boolean result = false;

		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(login.getIdUsuario());

		if (usuario.getCodUsuario() > 0) {
			if (usuario.getNome().equals(login.getNome())
					&& usuario.getEmail().equals(login.getEmail())
					&& usuario.getDataNascimento().equals(login.getDataNascimento())) {
				result = true;
			}

		}

		return result;
	}

}

package br.com.etectupa.validation;

import java.util.List;

import br.com.etectupa.dao.ContaDAO;
import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.model.Conta;
import br.com.etectupa.model.Usuario;

public class ValidaUsuario {
	public static boolean existeUsuario(String idUsuario) {		
		boolean result = false;
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		
		if (usuario.getCodUsuario() > 0){
			result = true;
		}

		return result;
	}
	
	public static boolean usuarioUtilizado(int codUsuario) {		
		boolean result = false;
		
		ContaDAO contaDao = new ContaDAO();
		List<Conta> contas = contaDao.Lista(codUsuario);
		
		if (contas.size() > 0){
			result = true;
		}

		return result;
	}
	
}

package br.com.etectupa.displaytag.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.joda.time.LocalDate;

import br.com.etectupa.dao.UsuarioDAO;
import br.com.etectupa.displaytag.UsuarioList;
import br.com.etectupa.model.Usuario;

public class ListUsuario extends ArrayList {
	private static final long serialVersionUID = 899149338534L;

	public ListUsuario() {
		super();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDao.getLista();
		
		for (Usuario usuario : usuarios) {
			
			if (!usuario.getIdUsuario().equals("Admin")){
				UsuarioList usuarioList = new UsuarioList();
				
				usuarioList.setCodUsuario(usuario.getCodUsuario());
				usuarioList.setIdUsuario(usuario.getIdUsuario());
				usuarioList.setNome(usuario.getNome());
				usuarioList.setEmail(usuario.getEmail());
				usuarioList.setDataNascimento(usuario.getDataNascimento());			
				if (usuario.getDataNascimento() != null){
					LocalDate dataNascimentoStr = new LocalDate(usuario.getDataNascimento());
					usuarioList.setDataNascimentoStr(dataNascimentoStr.toString("dd/MM/yyyy"));
				}
				add(usuarioList);
			}
		}

		Collections.sort(this);
	}    
	
	public ListUsuario(String idUsuario) {
		super();
		UsuarioList usuarioList = new UsuarioList();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = usuarioDao.getUsuario(idUsuario);
		
		usuarioList.setCodUsuario(usuario.getCodUsuario());
		usuarioList.setIdUsuario(usuario.getIdUsuario());
		usuarioList.setNome(usuario.getNome());
		usuarioList.setEmail(usuario.getEmail());
		usuarioList.setDataNascimento(usuario.getDataNascimento());			
		if (usuario.getDataNascimento() != null){
			LocalDate dataNascimentoStr = new LocalDate(usuario.getDataNascimento());
			usuarioList.setDataNascimentoStr(dataNascimentoStr.toString("dd/MM/yyyy"));
		}
		add(usuarioList);

		Collections.sort(this);
	}    

	public ListUsuario(Usuario usuario) {
		super();
		UsuarioList usuarioList = new UsuarioList();
		
		usuarioList.setCodUsuario(usuario.getCodUsuario());
		usuarioList.setIdUsuario(usuario.getIdUsuario());
		usuarioList.setNome(usuario.getNome());
		usuarioList.setEmail(usuario.getEmail());
		usuarioList.setDataNascimento(usuario.getDataNascimento());			
		if (usuario.getDataNascimento() != null){
			LocalDate dataNascimentoStr = new LocalDate(usuario.getDataNascimento());
			usuarioList.setDataNascimentoStr(dataNascimentoStr.toString("dd/MM/yyyy"));
		}
		add(usuarioList);

		Collections.sort(this);
	}    

}

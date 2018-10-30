package br.com.cast.apilivro.service;

import br.com.cast.apilivro.entidade.Usuario;
import br.com.cast.apilivro.excecao.UsuarioInvalidoException;
import br.com.cast.apilivro.repository.UsuarioRepository;

public class UsuarioBusiness {
	
	private UsuarioRepository usuarioDAO;

	public UsuarioBusiness() {
		this.usuarioDAO = new UsuarioRepository();
	}
	
	public Usuario autenticar(String usuario, String senha) 
			throws UsuarioInvalidoException {
		
		Usuario identidade = usuarioDAO.autenticar(usuario, senha);
		
		if (identidade == null) {
			throw new UsuarioInvalidoException();
		}
		
		return identidade;
	}

}

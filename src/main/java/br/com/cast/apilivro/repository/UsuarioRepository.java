package br.com.cast.apilivro.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.apilivro.entidade.Usuario;

@Repository
public class UsuarioRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public Usuario buscarPorId(Integer id) {
		return em.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public Usuario autenticar(String usuario, String senha) {
		String qlString = "from " + Usuario.class.getName() + " u " +
				"where u.usuario = :usuario " + 
				" and u.senha = :senha";
		
		Query query = em.createQuery(qlString)
				.setParameter("usuario", usuario)
				.setParameter("senha", senha);
		
		List<Usuario> resultado = query.getResultList();
		
		return resultado.size() > 0 ? resultado.get(0) : null;
	}

	public void fechar() {
		em.close();
	}
	
}

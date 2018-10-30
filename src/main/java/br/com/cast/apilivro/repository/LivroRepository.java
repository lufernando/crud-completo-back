package br.com.cast.apilivro.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.apilivro.entidade.Livro;

@Repository
public class LivroRepository {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void inserir(Livro liv) {
		em.persist(liv);
	}

	@Transactional
	public void alterar(Livro liv) {
		em.merge(liv);
	}

	@Transactional
	public void remover(Livro liv) {
		em.remove(liv);
	}

	public Livro buscarPorId(Integer id) {
		return em.find(Livro.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Livro> listarLivros() {

		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT l ").append("FROM ").append(Livro.class.getName()).append(" l ")
				.append("JOIN FETCH l.autor ").append("JOIN FETCH l.categoria");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();

	}

	public Livro verificarDuplicidade(String titulo, Integer id) {

		String qlString = "FROM " + Livro.class.getName() + " WHERE titulo = (:titulo) ";
		Integer paramId = 1;

		if (paramId != null) {
			qlString += "AND id != (:id)";
		}

		Query query = em.createQuery(qlString);
		query.setParameter("titulo", titulo);

		if (paramId != null) {
			query.setParameter("id", id);
		}

		try {
			return (Livro) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}

}

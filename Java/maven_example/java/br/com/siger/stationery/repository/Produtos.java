package br.com.siger.stationery.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.siger.stationery.model.Produto;
import br.com.siger.stationery.model.Produto_;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public Produtos(EntityManager manager) {
		this.manager = manager;
	}

	public List<Produto> todos() {
		// JPQL com problema de n+1
		// TypedQuery<Produto> query = manager.createQuery("from
		// Produto",Produto.class);
		TypedQuery<Produto> query = manager.createQuery("from Produto p join fetch p.setor", Produto.class);
		return query.getResultList();
	}

	public List<Produto> emOferta() {
		/*CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
		Root<Produto> produto = criteria.from(Produto.class);
		// produto.fetch("setor");
		produto.fetch(Produto_.setor);
		TypedQuery<Produto> query = manager
				.createQuery(criteria.select(produto)
				.where(
						builder.equal(from.get("oferta"), true)
						)
				);
						//builder.equal(produto.get(Produto_.oferta), true)));*/
		
		
		TypedQuery<Produto> query = manager.createQuery("from Produto p join fetch p.setor where p.oferta=:oferta", Produto.class);
		query.setParameter("oferta", true);
		return query.getResultList();

	}

	public Produto porId(Long id) {
		return manager.find(Produto.class, id);
	}
}

package br.com.siger.stationery.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.siger.stationery.model.Setor;

public class CriaSetores {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
		Setor setor1 = new Setor(null, "escrita e marcadores");
		Setor setor2 = new Setor(null, "papeis e pastas");
		Setor setor3 = new Setor(null, "envelopes e etiquetas");
		Setor setor4 = new Setor(null, "aretesanato e pintura");
		Setor setor5 = new Setor(null, "escolar e escritorio");
		Setor setor6 = new Setor(null, "informatica");
		Setor setor7 = new Setor(null, "embalagens");
		
		manager.persist(setor1);
		manager.persist(setor2);
		manager.persist(setor3);
		manager.persist(setor4);
		manager.persist(setor5);
		manager.persist(setor6);
		manager.persist(setor7);
		
		transaction.commit();
		manager.close();
		
	}
}

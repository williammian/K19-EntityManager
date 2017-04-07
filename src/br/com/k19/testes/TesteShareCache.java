package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Cidade;

public class TesteShareCache {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("K21_entity_manager_pu");
		
		EntityManager manager1 = factory.createEntityManager();
		
		System.out.println("------ PRIMEIRO FIND --------");
		Cidade cidade = manager1.find(Cidade.class, 1L);
		
		EntityManager manager2 = factory.createEntityManager();
		
		System.out.println("------- SEGUNDO FIND --------");
		manager2.find(Cidade.class, 1L);
		
		manager1.close();
		manager2.close();
		factory.close();
	}
	
}

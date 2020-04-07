package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldo {
public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta contaDoHariel = em.find(Conta.class, 2L);
		
		
		em.getTransaction().begin();
		contaDoHariel.setSaldo(20.0);
		em.getTransaction().commit(); 
		
		
		
	}
}

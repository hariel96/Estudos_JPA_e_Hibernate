package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		
		// Objeto transient, não tem id no bd e também não esta sendo gerenciado pela jpa
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(1245);
		conta.setNumero(9346);
		
		em.getTransaction().begin();
		
		// transformando objeto de transient em managed, ou seja, fazendo com que o objeto tenha sincronização automatica com o banco
		em.persist(conta);
		
		// remove do bd, faz um delete. A conta passa de managed para removed
		em.remove(conta);
		
		em.getTransaction().commit();
	
	}
	
}

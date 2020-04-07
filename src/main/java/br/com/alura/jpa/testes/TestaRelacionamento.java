package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelacionamento {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setAgencia(125500);
		conta.setNumero(624);
		conta.setSaldo(300.0);
		conta.setTitular("leonardo");
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Churrascaria");
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setConta(conta);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		em.close();
		
	}

}

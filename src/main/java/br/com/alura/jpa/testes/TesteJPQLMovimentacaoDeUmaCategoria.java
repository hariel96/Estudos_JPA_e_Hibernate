package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TesteJPQLMovimentacaoDeUmaCategoria {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Categoria categoria = new Categoria();
		categoria.setId(5L);

		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);

		List<Movimentacao> resultList = query.getResultList();

		for (Movimentacao movimentacao : resultList) {
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
			System.out.println("Valor: " + movimentacao.getValor());

		}
	}
}

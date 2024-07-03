package com.tarefa.mod32.tarefa32.DAO;

import com.tarefa.mod32.tarefa32.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDAO implements IProdutoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void cadastrar(Produto produto) {
        entityManager.persist(produto);
    }
}

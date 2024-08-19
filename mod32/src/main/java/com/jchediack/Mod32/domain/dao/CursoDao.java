package com.jchediack.Mod32.domain.dao;

import com.jchediack.Mod32.domain.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CursoDao implements ICursoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void cadastrar(Curso curso) {
        entityManager.persist(curso);
    }
}

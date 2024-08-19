package com.jchediack.Mod32;

import com.jchediack.Mod32.domain.Curso;
import com.jchediack.Mod32.domain.dao.ICursoDao;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CursoTest {

    @Autowired
    private ICursoDao cursoDao;

    @Test
    @Transactional
    public void cadastrar() {
        Curso curso = new Curso();

        curso.setCodigo("A1");
        curso.setNome("Curso de Java");
        curso.setDescricao("Profissão BackEnd Java");

        cursoDao.cadastrar(curso);

    }

}

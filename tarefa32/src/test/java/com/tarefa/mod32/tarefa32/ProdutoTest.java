package com.tarefa.mod32.tarefa32;

import com.tarefa.mod32.tarefa32.DAO.IProdutoDAO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTest {

    @Autowired
    private IProdutoDAO produtoDAO;

    @Test
    @Transactional
    public void cadastrar() {
        Produto produto = new Produto();

        produto.setNome("Iphone 11");
        produto.setDescricao("Produto produzido pela empresa Apple");

        produtoDAO.cadastrar(produto);
    }
}

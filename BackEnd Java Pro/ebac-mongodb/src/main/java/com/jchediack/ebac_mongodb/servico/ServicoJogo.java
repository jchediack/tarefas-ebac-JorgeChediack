package com.jchediack.ebac_mongodb.servico;

import com.jchediack.ebac_mongodb.modelo.Jogo;
import com.jchediack.ebac_mongodb.repositorio.RepositorioJogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

@Service
@EnableMongoRepositories(basePackageClasses = RepositorioJogo.class)
public class ServicoJogo {

    @Autowired
    private RepositorioJogo repositorioJogo;

    public Jogo criarJogo(Jogo jogo) {
        return repositorioJogo.insert(jogo);
    }
}

package com.jchediack.ebac_mongodb.repositorio;

import com.jchediack.ebac_mongodb.modelo.Jogo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioJogo extends MongoRepository<Jogo, String> {
    long count();

}

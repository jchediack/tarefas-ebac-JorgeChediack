package com.jchediack.clientes.repository;

import com.jchediack.clientes.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface IClienteRepository extends MongoRepository {
    Optional<Cliente> findByCpf(Long cpf);
}

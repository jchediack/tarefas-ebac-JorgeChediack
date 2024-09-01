package com.jchediack.clientes.usecase;

import java.util.Optional;

import com.jchediack.clientes.domain.Cliente;
import com.jchediack.clientes.exception.EntityNotFoundException;
import com.jchediack.clientes.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscaCliente {

	private IClienteRepository clienteRepository;
	
	@Autowired
	public BuscaCliente(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public Page<Cliente> buscar(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	public Boolean isCadastrado(String id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.isPresent() ? true : false;
	}

	public Cliente buscarPorCpf(Long cpf) {
		return clienteRepository.findByCpf(cpf)
				.orElseThrow(() -> new EntityNotFoundException(Cliente.class, "cpf", String.valueOf(cpf)));
	}

	
}

/**
 * 
 */
package br.com.jchediack.service;

import java.util.List;

import br.com.jchediack.domain.Cliente;
import br.com.jchediack.exceptions.DAOException;
import br.com.jchediack.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}

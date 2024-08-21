/**
 * 
 */
package br.com.jchediack.dao;

import java.util.List;

import br.com.jchediack.dao.generic.IGenericDAO;
import br.com.jchediack.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente, Long>{

	List<Cliente> filtrarClientes(String query);

}

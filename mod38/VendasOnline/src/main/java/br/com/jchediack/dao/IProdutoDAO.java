/**
 * 
 */
package br.com.jchediack.dao;

import java.util.List;

import br.com.jchediack.dao.generic.IGenericDAO;
import br.com.jchediack.domain.Produto;


public interface IProdutoDAO extends IGenericDAO<Produto, String>{

	List<Produto> filtrarProdutos(String query);

}

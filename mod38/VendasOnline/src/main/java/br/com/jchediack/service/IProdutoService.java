/**
 * 
 */
package br.com.jchediack.service;

import java.util.List;

import br.com.jchediack.domain.Produto;
import br.com.jchediack.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}

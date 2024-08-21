/**
 * 
 */
package br.com.jchediack.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.jchediack.dao.IProdutoDAO;
import br.com.jchediack.domain.Produto;
import br.com.jchediack.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
	
	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}

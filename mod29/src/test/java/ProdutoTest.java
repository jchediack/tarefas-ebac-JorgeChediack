import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ProdutoTest {

    @Test
    public void cadastrarTest() throws Exception {

        IProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();

        produto.setCodigo("15");
        produto.setNome("iPhone 15");

        Integer qtd = dao.cadastrar(produto);
        Assertions.assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        Assertions.assertNotNull(produtoBD);
        Assertions.assertNotNull(produtoBD.getId());
        Assertions.assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        Assertions.assertEquals(produto.getNome(), produtoBD.getNome());

        produto.setId(01L);

        Integer qtdAtual = dao.atualizar(produto);
        Assertions.assertTrue(qtdAtual == 1);

        Integer qtdDel = dao.excluir(produtoBD);
        Assertions.assertNotNull(qtdDel);

        List<Produto> countBusT = dao.buscarTodos();
        Assertions.assertNotNull(countBusT);;

    }
}

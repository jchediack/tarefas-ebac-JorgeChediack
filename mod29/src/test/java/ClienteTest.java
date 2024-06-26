import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ClienteTest {

    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente();

        cliente.setCodigo("10");
        cliente.setNome("Gilcelia Moreira");

        Integer qtd = dao.cadastrar(cliente);
        Assertions.assertTrue(qtd == 1);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        Assertions.assertNotNull(clienteBD);
        Assertions.assertNotNull(clienteBD.getId());
        Assertions.assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        Assertions.assertEquals(cliente.getNome(), clienteBD.getNome());

        cliente.setId(1L);

        Integer qtdAtual = dao.atualizar(cliente);
        Assertions.assertTrue(qtdAtual == 1);

        Integer qtdDel = dao.excluir(clienteBD);
        Assertions.assertNotNull(qtdDel);

        List<Cliente> countBusT = dao.buscarTodos();
        Assertions.assertNotNull(countBusT);;

    }

}

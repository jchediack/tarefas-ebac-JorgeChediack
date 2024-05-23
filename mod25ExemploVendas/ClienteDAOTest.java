package mod25ExemploVendas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;
    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDao = new ClienteDaoMock();
    }

    @BeforeEach
    public void init() {
        cliente = new Cliente();
        cliente.setNome("Jeff");
        cliente.setCpf(1234567890L);
        cliente.setTel(31999999L);
        cliente.getEnd("Rua Andorinhas");
        cliente.setNumero(74);
        cliente.setCidade("Contagem");
        cliente.setEstado("MG");
        clienteDao.salvar(cliente);
    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteDao.buscarPorCPF(cliente.getCpf());
        Assertions.assertNotNull(clienteConsultado);
    }
    @Test
    public void salvarCliente(){
        Boolean retorno = clienteDao.salvar(cliente);
        Assertions.assertTrue(retorno);
    }
    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }
}

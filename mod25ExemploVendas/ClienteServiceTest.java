package mod25ExemploVendas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClienteServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
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

    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assertions.assertNotNull(clienteConsultado);
    }
    @Test
    public void salvarCliente(){
        Boolean retorno = clienteService.salvar(cliente);
        Assertions.assertTrue(retorno);
    }
    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente() {
        cliente.setNome("Jefferson Henrique");
        clienteService.alterar(cliente);
        Assertions.assertEquals("Jefferson Henrique", cliente.getNome());
    }
}

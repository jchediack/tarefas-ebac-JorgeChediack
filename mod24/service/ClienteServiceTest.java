package mod24.service;

import mod24.dao.ClienteDao;
import mod24.dao.ClienteDaoMock;
import mod24.dao.IClienteDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteServiceTest {

    @Test
    public void salvarTest () {
        IClienteDao clienteDaoMock = new ClienteDaoMock();
        ClienteService clienteService = new ClienteService(clienteDaoMock);
        String retorno = clienteService.salvar();
        Assertions.assertEquals("Sucesso", retorno);
    }

    @Test
    public void esperadoErroSalvarTest() {
        IClienteDao clienteDao = new ClienteDao();
        ClienteService clienteService = new ClienteService(clienteDao);
        UnsupportedOperationException thrown = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            clienteService.salvar();
        });
        Assertions.assertEquals("Não funciona sem config de banco", thrown.getMessage());
    }

}

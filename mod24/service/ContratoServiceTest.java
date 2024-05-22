package mod24.service;

import mod24.dao.ContratoDao;
import mod24.dao.ContratoDaoMock;
import mod24.dao.IContratoDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService contratoService = new ContratoService(dao);
        String result = contratoService.salvar();
        Assertions.assertEquals("Sucesso", result);
    }

    @Test
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService contratoService = new ContratoService(dao);
        UnsupportedOperationException thrown = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            contratoService.salvar();
        });
        Assertions.assertEquals("Não funciona com o banco de dados", thrown.getMessage());
    }

    @Test
    public void buscarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService contratoService = new ContratoService(dao);
        String result = contratoService.buscar();
        Assertions.assertEquals("Sucesso", result);
    }
    @Test
    public void esperadoErroNoBuscarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService contratoService = new ContratoService(dao);
        UnsupportedOperationException thrown = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            contratoService.buscar();
        });
        Assertions.assertEquals("Não funciona com o banco de dados", thrown.getMessage());
    }
    @Test
    public void excluirTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService contratoService = new ContratoService(dao);
        String result = contratoService.excluir();
        Assertions.assertEquals("Sucesso", result);
    }
    @Test
    public void esperadoErroNoExcluirComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService contratoService = new ContratoService(dao);
        UnsupportedOperationException thrown = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            contratoService.excluir();
        });
        Assertions.assertEquals("Não funciona com o banco de dados", thrown.getMessage());
    }
    @Test
    public void atualizarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService contratoService = new ContratoService(dao);
        String result = contratoService.atualizar();
        Assertions.assertEquals("Sucesso", result);
    }
    @Test
    public void esperadoErroNoAtualizarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService contratoService = new ContratoService(dao);
        UnsupportedOperationException thrown = Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            contratoService.atualizar();
        });
        Assertions.assertEquals("Não funciona com o banco de dados", thrown.getMessage());
    }
}

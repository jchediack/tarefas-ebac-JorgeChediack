package mod24.service;

import mod24.dao.ClienteDao;
import mod24.dao.IClienteDao;

public class ClienteService {

    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao) {
        //clienteDao = new ClienteDao();
        this.clienteDao = clienteDao;
    }
   // ClienteDao clienteDao = new ClienteDao();

    public String salvar() {
        clienteDao.salvar();
        return "Sucesso";
    }
}

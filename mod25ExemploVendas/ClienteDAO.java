package mod25ExemploVendas;

public class ClienteDAO implements IClienteDAO{
    @Override
    public Boolean salvar(Cliente cliente) {
    return true;
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) {
        return null;
    }

    @Override
    public void excluir(Long cpf) {

    }

    @Override
    public void alterar(Cliente cliente) {

    }
}

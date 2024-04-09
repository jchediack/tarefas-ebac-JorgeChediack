/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroclienteswing;

/**
 *
 * @author jorgechediack
 */

import java.util.Collection;


public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);
    public void excluir (Long cpf);
    public void alterar (Cliente cliente);
    public Cliente consultar (Long cpf);
    public Collection<Cliente> buscarTodos();

}
package br.com.jchediack.ebac.ebac_filas.produtor;

import br.com.jchediack.ebac.ebac_filas.service.ServicoRabbitMQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/mensagens")
public class Produtor {

    @Autowired
    private ServicoRabbitMQ servicoRabbitMQ;

    @PostMapping
    public void enviarMensagem(@RequestBody String mensagem) {
        System.out.println("============ PRODUTOR -> Enviando mensagem: " + mensagem + " ============ ");
        servicoRabbitMQ.enviaMensagem(mensagem);
    }
}

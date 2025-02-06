package br.com.jchediack.ebac.ebac_eventos.consumidor;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConfigConsumidor {

    @KafkaListener(topics = "${kafka.ebac.nome.topico}", groupId = "ebacGroup")
    public void consumirMensagem(String mensagem){
        System.out.println("==================== CONSUMIDOR -> INICIO MENSAGEM: ====================");
        System.out.println(mensagem);
        System.out.println("==================== CONSUMIDOR -> FIM MENSAGEM: ====================");
    }

    @DltHandler
    public void consumirMensagemDLT (String mensagem) {
        System.out.println("==================== CONSUMIDOR -> <<DLT>> INICIO MENSAGEM: ====================");
        System.out.println(mensagem);
        System.out.println("==================== CONSUMIDOR -> <<DLT>> FIM MENSAGEM: ====================");
    }

}

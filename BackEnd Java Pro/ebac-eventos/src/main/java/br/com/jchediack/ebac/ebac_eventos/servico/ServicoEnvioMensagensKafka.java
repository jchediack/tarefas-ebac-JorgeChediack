package br.com.jchediack.ebac.ebac_eventos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ServicoEnvioMensagensKafka {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.ebac.nome.topico}")
    private String nomeTopico;

    public void enviarMensagem(String mensagem) {
        System.out.println("==================== PRODUTOR -> INICIO MENSAGEM: ====================");
        kafkaTemplate.send(nomeTopico, mensagem);
        System.out.println(mensagem);
        System.out.println("==================== PRODUTOR -> FIM MENSAGEM: ====================");
    }

}

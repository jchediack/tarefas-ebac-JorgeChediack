package com.jchediack.ebac_mongodb.controller;

import com.jchediack.ebac_mongodb.modelo.Jogo;
import com.jchediack.ebac_mongodb.servico.ServicoJogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private ServicoJogo servicoJogo;

    @PostMapping
    public Jogo criarJogo(@RequestBody Jogo jogo) {
        return servicoJogo.criarJogo(jogo);
    }
}

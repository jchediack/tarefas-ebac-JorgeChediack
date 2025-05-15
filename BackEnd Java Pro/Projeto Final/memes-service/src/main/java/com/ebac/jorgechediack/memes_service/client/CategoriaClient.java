package com.ebac.jorgechediack.memes_service.client;

import com.ebac.jorgechediack.memes_service.client.dto.CategoriaDTO;
import com.ebac.jorgechediack.memes_service.client.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "categoria-service", url = "http://localhost:8082")
public interface CategoriaClient {

    @GetMapping("/categorias/{id}")
    CategoriaDTO buscarCategoriaPorId(@PathVariable("id") Long id);
}

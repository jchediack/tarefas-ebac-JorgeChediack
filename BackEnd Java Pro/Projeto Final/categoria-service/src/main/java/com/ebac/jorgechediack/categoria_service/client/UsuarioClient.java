package com.ebac.jorgechediack.categoria_service.client;

import com.ebac.jorgechediack.categoria_service.client.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service", url = "http://localhost:8081")
public interface UsuarioClient {

    @GetMapping("/usuarios/{id}")
    UsuarioDTO buscarUsuarioPorId(@PathVariable("id") Long id);

}

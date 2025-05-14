package com.ebac.jorgechediack.usuario_service.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;

}

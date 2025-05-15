package com.ebac.jorgechediack.memes_service.client.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private Date dataCadastro;
}

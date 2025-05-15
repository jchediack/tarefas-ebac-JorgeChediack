package com.ebac.jorgechediack.memes_service.client.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CategoriaDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Date dataCadastro;
    private Long usuarioId;
}

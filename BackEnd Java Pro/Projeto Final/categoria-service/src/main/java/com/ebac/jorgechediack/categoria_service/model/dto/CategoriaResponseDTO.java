package com.ebac.jorgechediack.categoria_service.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CategoriaResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Date dataCadastro;
    private Long usuarioId;
}

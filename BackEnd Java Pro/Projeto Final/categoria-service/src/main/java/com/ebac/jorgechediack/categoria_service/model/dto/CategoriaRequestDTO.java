package com.ebac.jorgechediack.categoria_service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CategoriaRequestDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private Date dataCadastro;
    @NotNull
    private Long usuarioId;
}

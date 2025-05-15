package com.ebac.jorgechediack.memes_service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class MemesResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Date dataCadastro;
    private Long categoriaId;
    private Long usuarioId;
}

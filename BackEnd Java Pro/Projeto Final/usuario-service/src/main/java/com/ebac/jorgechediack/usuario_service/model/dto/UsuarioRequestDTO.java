package com.ebac.jorgechediack.usuario_service.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    private String email;
    @NotNull(message = "Data de cadastro é obrigatória")
    private LocalDate dataCadastro;

}

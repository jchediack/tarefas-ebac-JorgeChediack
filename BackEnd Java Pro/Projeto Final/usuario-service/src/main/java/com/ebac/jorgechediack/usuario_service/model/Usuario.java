package com.ebac.jorgechediack.usuario_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_usuario")
    @SequenceGenerator(name = "sequence_usuario", sequenceName = "sequence_usuario", allocationSize = 50)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Data de cadastro é obrigatória")
    private LocalDate dataCadastro;

    public Usuario(String nome, String email, LocalDate dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }

}

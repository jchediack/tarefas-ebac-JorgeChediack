package com.ebac.jorgechediack.categoria_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaMeme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_categoria_meme")
    @SequenceGenerator(name = "sequence_categoria_meme", sequenceName = "sequence_categoria_meme", allocationSize = 50)
    private Long id;

    private String nome;
    private String descricao;
    private Date dataCadastro;

    private Long usuarioId;

    public CategoriaMeme(String nome, String descricao, Date dataCadastro, Long usuarioId) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.usuarioId = usuarioId;
    }
}

package com.ebac.jorgechediack.memes_service.model;

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
public class Memes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_meme")
    @SequenceGenerator(name = "sequence_meme", sequenceName = "sequence_meme", allocationSize = 50)
    private Long id;

    private String nome;
    private String descricao;
    private Date dataCadastro;
    private Long categoriaId;
    private Long usuarioId;

    public Memes(String nome, String descricao, Date dataCadastro, Long categoriaId, Long usuarioId) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.categoriaId = categoriaId;
        this.usuarioId = usuarioId;
    }
}

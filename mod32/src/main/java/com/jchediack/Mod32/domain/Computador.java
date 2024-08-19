package com.jchediack.Mod32.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_COMPUTADOR")
public class Computador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
    @SequenceGenerator(name = "aluno_seq", sequenceName = "sq_aluno", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;
    @Column(name = "DESCRICAO", length = 150, nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "computadores")
    private List<Aluno> alunos;
}

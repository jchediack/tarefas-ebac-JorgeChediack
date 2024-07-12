package com.jchediack.mod33.domain;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio_seq")
    @SequenceGenerator(name = "acessorio_seq", sequenceName = "sq_acessorio", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;
    @Column(name = "NOME", length = 150, nullable = false)
    private String nome;
    @Column(name = "DESCRICAO", length = 150, nullable = false)
    private String descricao;

    @ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros;
}

package com.jchediack.mod33.domain;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_MARCA")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marca_seq")
    @SequenceGenerator(name = "marca_seq", sequenceName = "sq_marca", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;
    @Column(name = "NOME", length = 150, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "marca")
    private List<Carro> carros;

}

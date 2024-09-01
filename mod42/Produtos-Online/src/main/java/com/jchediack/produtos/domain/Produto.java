package com.jchediack.produtos.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="Produto", description="Produto")
public class Produto {

    @Id
    @Schema(description="Identificador único")
    private String id;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description="Nome", minLength = 1, maxLength=50, nullable = false)
    private String nome;

    @NotNull
    @Schema(description="Preco", nullable = false)
    private Double preco;

}

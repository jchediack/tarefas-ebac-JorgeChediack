package com.ebac.jorgechediack.categoria_service.controller;

import com.ebac.jorgechediack.categoria_service.model.dto.CategoriaRequestDTO;
import com.ebac.jorgechediack.categoria_service.model.dto.CategoriaResponseDTO;
import com.ebac.jorgechediack.categoria_service.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/categorias")
@Tag(name = "Categorias Meme Controller")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma categoria por ID", description = "Retorna os detalhes de uma categoria específica")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoria encontrada"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable Long id) {
        log.info("Recebida requisição para buscar categoria com ID: {}", id);
        try {
            CategoriaResponseDTO categoria = categoriaService.buscarPorId(id);
            return ResponseEntity.ok(categoria);
        } catch (IllegalArgumentException e) {
            log.warn("Categoria com ID {} não encontrada", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Cadastrar nova categoria")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<CategoriaResponseDTO> cadastrar(@RequestBody @Valid CategoriaRequestDTO dto) {
        return ResponseEntity.ok(categoriaService.cadastrar(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todas as categorias")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoria encontrada"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    public ResponseEntity<List<CategoriaResponseDTO>> listar() {
        return ResponseEntity.ok(categoriaService.listar());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma categoria", description = "Remove uma categoria do sistema pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("Recebida requisição para deletar categoria com ID: {}", id);
        try {
            categoriaService.buscarPorId(id);
            categoriaService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            log.warn("Categoria com ID {} não encontrada", id);
            return ResponseEntity.notFound().build();
        }
    }
}

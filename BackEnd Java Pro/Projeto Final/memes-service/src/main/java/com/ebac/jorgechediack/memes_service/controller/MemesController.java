package com.ebac.jorgechediack.memes_service.controller;

import com.ebac.jorgechediack.memes_service.model.dto.MemesRequestDTO;
import com.ebac.jorgechediack.memes_service.model.dto.MemesResponseDTO;
import com.ebac.jorgechediack.memes_service.service.MemesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/memes")
@Tag(name = "Memes Controller")
public class MemesController {

    private final MemesService memesService;

    @PostMapping
    @Operation(summary = "Cadastrar novo meme")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Meme criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<MemesResponseDTO> cadastrar(@RequestBody @Valid MemesRequestDTO dto) {
        MemesResponseDTO salvo = memesService.cadastrar(dto);
        return ResponseEntity.status(201).body(salvo);
    }

    @GetMapping
    @Operation(summary = "Listar todos os memes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Memes encontrados")
    })
    public ResponseEntity<List<MemesResponseDTO>> listarTodos() {
        return ResponseEntity.ok(memesService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar meme por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Meme encontrado"),
            @ApiResponse(responseCode = "404", description = "Meme não encontrado")
    })
    public ResponseEntity<MemesResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(memesService.buscarPorId(id));
        } catch (IllegalArgumentException ex) {
            log.warn("Meme com ID {} não encontrado", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar meme por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Meme atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Meme não encontrado")
    })
    public ResponseEntity<MemesResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid MemesRequestDTO dto) {
        try {
            return ResponseEntity.ok(memesService.atualizar(id, dto));
        } catch (IllegalArgumentException ex) {
            log.warn("Erro ao atualizar meme com ID {}: {}", id, ex.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar meme por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Meme deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Meme não encontrado")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            memesService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException ex) {
            log.warn("Erro ao deletar meme com ID {}: {}", id, ex.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}

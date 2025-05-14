package com.ebac.jorgechediack.usuario_service.controller;

import com.ebac.jorgechediack.usuario_service.model.Usuario;
import com.ebac.jorgechediack.usuario_service.model.dto.UsuarioRequestDTO;
import com.ebac.jorgechediack.usuario_service.model.dto.UsuarioResponseDTO;
import com.ebac.jorgechediack.usuario_service.service.UsuarioService;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários Controller")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Cria um novo usuário", description = "Cadastra um novo usuário no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<UsuarioResponseDTO> criar(@Valid @RequestBody UsuarioRequestDTO usuarioDTO) {
        log.info("Recebida requisição para criar usuário com email: {}", usuarioDTO.getEmail());
        UsuarioResponseDTO criado = usuarioService.cadastrar(usuarioDTO);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um usuário por ID", description = "Retorna os detalhes de um usuário específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        log.info("Recebida requisição para buscar usuário com ID: {}", id);
        try {
            UsuarioResponseDTO usuario = usuarioService.buscarPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (IllegalArgumentException e) {
            log.warn("Usuário com ID {} não encontrado", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Lista todos os usuários", description = "Retorna a lista de todos os usuários cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso")
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        log.info("Recebida requisição para listar todos os usuários");
        List<UsuarioResponseDTO> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um usuário", description = "Atualiza apenas o nome do usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "400", description = "Operação não permitida")
    })
    public ResponseEntity<UsuarioResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO usuarioDTO) {
        log.info("Recebida requisição para atualizar usuário com ID: {}", id);
        try {
            UsuarioResponseDTO atualizado = usuarioService.atualizar(id, usuarioDTO);
            return ResponseEntity.ok(atualizado);
        } catch (IllegalArgumentException e) {
            log.error("Erro ao atualizar usuário: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um usuário", description = "Remove um usuário do sistema pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("Recebida requisição para deletar usuário com ID: {}", id);
        try {
            usuarioService.buscarPorId(id);
            usuarioService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            log.warn("Usuário com ID {} não encontrado", id);
            return ResponseEntity.notFound().build();
        }
    }
}

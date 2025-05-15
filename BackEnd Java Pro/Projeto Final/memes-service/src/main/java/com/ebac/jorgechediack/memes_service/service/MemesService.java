package com.ebac.jorgechediack.memes_service.service;

import com.ebac.jorgechediack.memes_service.client.CategoriaClient;
import com.ebac.jorgechediack.memes_service.client.UsuarioClient;
import com.ebac.jorgechediack.memes_service.client.dto.CategoriaDTO;
import com.ebac.jorgechediack.memes_service.client.dto.UsuarioDTO;
import com.ebac.jorgechediack.memes_service.model.Memes;
import com.ebac.jorgechediack.memes_service.model.dto.MemesRequestDTO;
import com.ebac.jorgechediack.memes_service.model.dto.MemesResponseDTO;
import com.ebac.jorgechediack.memes_service.model.mapper.MemesMapper;
import com.ebac.jorgechediack.memes_service.repository.MemesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemesService {

    private final MemesRepository repository;
    private final UsuarioClient usuarioClient;
    private final CategoriaClient categoriaClient;

    public MemesResponseDTO cadastrar(MemesRequestDTO requestDTO) {
        log.info("Iniciando cadastro de meme: '{}'", requestDTO.getNome());

        // Validação do usuário
        UsuarioDTO usuario;
        try {
            usuario = usuarioClient.buscarUsuarioPorId(requestDTO.getUsuarioId());
        } catch (Exception ex) {
            log.error("Usuário com ID {} não encontrado. Erro: {}", requestDTO.getUsuarioId(), ex.getMessage());
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        // Validação da categoria
        CategoriaDTO categoria;
        try {
            categoria = categoriaClient.buscarCategoriaPorId(requestDTO.getCategoriaId());
        } catch (Exception ex) {
            log.error("Categoria com ID {} não encontrada. Erro: {}", requestDTO.getCategoriaId(), ex.getMessage());
            throw new IllegalArgumentException("Categoria não encontrada");
        }

        // Mapeamento e persistência
        Memes meme = MemesMapper.toEntity(requestDTO);
        meme.setUsuarioId(usuario.getId());
        meme.setCategoriaId(categoria.getId());

        Memes salvo = repository.save(meme);

        log.info("Meme cadastrado com sucesso: ID={}, Nome={}", salvo.getId(), salvo.getNome());
        return MemesMapper.toDTO(salvo);
    }

    public List<MemesResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(MemesMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MemesResponseDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(MemesMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Meme não encontrado com ID: " + id));
    }

    public MemesResponseDTO atualizar(Long id, MemesRequestDTO requestDTO) {
        log.info("Atualizando meme com ID: {}", id);

        // Busca o meme existente
        Memes existente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Meme não encontrado com ID: " + id));

        // Validação do usuário
        UsuarioDTO usuario;
        try {
            usuario = usuarioClient.buscarUsuarioPorId(requestDTO.getUsuarioId());
        } catch (Exception ex) {
            log.error("Usuário com ID {} não encontrado. Erro: {}", requestDTO.getUsuarioId(), ex.getMessage());
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        // Validação da categoria
        CategoriaDTO categoria;
        try {
            categoria = categoriaClient.buscarCategoriaPorId(requestDTO.getCategoriaId());
        } catch (Exception ex) {
            log.error("Categoria com ID {} não encontrada. Erro: {}", requestDTO.getCategoriaId(), ex.getMessage());
            throw new IllegalArgumentException("Categoria não encontrada");
        }

        // Atualiza os campos
        existente.setNome(requestDTO.getNome());
        existente.setDescricao(requestDTO.getDescricao());
        existente.setDataCadastro(requestDTO.getDataCadastro());
        existente.setCategoriaId(categoria.getId());
        existente.setUsuarioId(usuario.getId());

        Memes atualizado = repository.save(existente);
        log.info("Meme atualizado com sucesso: ID={}, Nome={}", atualizado.getId(), atualizado.getNome());

        return MemesMapper.toDTO(atualizado);
    }

    public void deletar(Long id) {
        log.info("Deletando meme com ID: {}", id);

        if (!repository.existsById(id)) {
            log.warn("Tentativa de deletar meme inexistente com ID: {}", id);
            throw new IllegalArgumentException("Meme não encontrado com ID: " + id);
        }

        repository.deleteById(id);
        log.info("Meme deletado com sucesso: ID={}", id);
    }

}

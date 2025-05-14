package com.ebac.jorgechediack.categoria_service.service;

import com.ebac.jorgechediack.categoria_service.client.UsuarioClient;
import com.ebac.jorgechediack.categoria_service.client.dto.UsuarioDTO;
import com.ebac.jorgechediack.categoria_service.model.CategoriaMeme;
import com.ebac.jorgechediack.categoria_service.model.dto.CategoriaRequestDTO;
import com.ebac.jorgechediack.categoria_service.model.dto.CategoriaResponseDTO;
import com.ebac.jorgechediack.categoria_service.model.mapper.CategoriaMapper;
import com.ebac.jorgechediack.categoria_service.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoriaService {

    private final CategoriaRepository repository;
    private final UsuarioClient usuarioClient;

    public CategoriaResponseDTO cadastrar(CategoriaRequestDTO requestDTO) {
        log.info("Iniciando cadastro da categoria: '{}'", requestDTO.getNome());

        UsuarioDTO usuario;
        try {
            usuario = usuarioClient.buscarUsuarioPorId(requestDTO.getUsuarioId());
        } catch (Exception ex) {
            log.warn("Usuário com ID {} não encontrado. Erro: {}", requestDTO.getUsuarioId(), ex.getMessage());
            throw new IllegalArgumentException("Categoria não encontrada");
        }

        CategoriaMeme categoria = CategoriaMapper.toEntity(requestDTO);
        categoria.setUsuarioId(usuario.getId());

        CategoriaMeme salvo = repository.save(categoria);
        log.info("Categoria cadastrada com sucesso: ID={}, Nome={}", salvo.getId(), salvo.getNome());

        return CategoriaMapper.toDTO(salvo);
    }

    public List<CategoriaResponseDTO> listar() {
        log.info("Listando todas as categorias");
        return repository.findAll().stream()
                .map(CategoriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CategoriaResponseDTO buscarPorId(Long id) {
        log.info("Buscando categoria com ID: {}", id);
        CategoriaMeme categoriaMeme = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrado"));
        log.info("Categoria ID {} encontrado com sucesso. Nome='{}'", id, categoriaMeme.getNome());
        return CategoriaMapper.toDTO(categoriaMeme);
    }

    public void deletar(Long id) {
        log.info("Deletando categoria com ID: {}", id);
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Categoria não encontrada");
        }
        repository.deleteById(id);
        log.info("Categoria com ID {} deletada com sucesso", id);
    }
}

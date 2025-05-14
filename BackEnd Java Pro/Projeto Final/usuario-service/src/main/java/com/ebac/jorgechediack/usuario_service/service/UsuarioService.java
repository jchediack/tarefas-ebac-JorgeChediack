package com.ebac.jorgechediack.usuario_service.service;

import com.ebac.jorgechediack.usuario_service.model.Usuario;
import com.ebac.jorgechediack.usuario_service.model.dto.UsuarioRequestDTO;
import com.ebac.jorgechediack.usuario_service.model.dto.UsuarioResponseDTO;
import com.ebac.jorgechediack.usuario_service.model.mapper.UsuarioMapper;
import com.ebac.jorgechediack.usuario_service.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO requestDTO) {
        log.info("Tentando cadastrar usuário com e-mail: {}", requestDTO.getEmail());
        if (usuarioRepository.existsByEmail(requestDTO.getEmail())) {
            log.warn("E-mail já cadastrado: {}", requestDTO.getEmail());
            throw new IllegalArgumentException("E-mail já está em uso");
        }
        Usuario usuario = UsuarioMapper.toEntity(requestDTO);
        Usuario salvo = usuarioRepository.save(usuario);
        log.info("Usuário cadastrado com sucesso: ID={}, email={}", salvo.getId(), salvo.getEmail());
        return UsuarioMapper.toDTO(salvo);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO usuarioAtualizado) {
        log.info("Tentando atualizar usuário com ID: {}. Dados recebidos para atualização: Nome='{}', Email='{}'",
                id, usuarioAtualizado.getNome(), usuarioAtualizado.getEmail());

        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Falha ao atualizar: Usuário com ID {} não encontrado.", id);
                    return new IllegalArgumentException("Usuário não encontrado");
                });

        boolean modificado = false;

        // Atualizar Nome
        // Se um nome for fornecido e for diferente do existente, atualiza.
        if (usuarioAtualizado.getNome() != null && !usuarioAtualizado.getNome().equals(usuarioExistente.getNome())) {
            log.info("Atualizando nome do usuário ID {} de '{}' para '{}'.", id, usuarioExistente.getNome(), usuarioAtualizado.getNome());
            usuarioExistente.setNome(usuarioAtualizado.getNome());
            modificado = true;
        } else if (usuarioAtualizado.getNome() != null) {
            log.info("Nome fornecido para usuário ID {} ('{}') é o mesmo que o existente. Nenhuma alteração no nome.", id, usuarioAtualizado.getNome());
        } else {
            log.info("Nenhum nome (ou nome nulo) fornecido para atualização para usuário ID {}. Nome existente ('{}') mantido.", id, usuarioExistente.getNome());
        }

        // Atualizar Email
        // Se um email for fornecido, não for vazio, e for diferente do existente, tenta atualizar.
        if (usuarioAtualizado.getEmail() != null &&
                !usuarioAtualizado.getEmail().isEmpty() &&
                !usuarioAtualizado.getEmail().equals(usuarioExistente.getEmail())) {

            log.info("Tentando alterar email do usuário ID {} de '{}' para '{}'.",
                    id, usuarioExistente.getEmail(), usuarioAtualizado.getEmail());

            // Verifica se o novo email já está em uso por outro usuário
            Optional<Usuario> usuarioComNovoEmail = usuarioRepository.findByEmail(usuarioAtualizado.getEmail());
            if (usuarioComNovoEmail.isPresent() && !usuarioComNovoEmail.get().getId().equals(id)) {
                log.warn("Falha ao atualizar email para usuário ID {}: O email '{}' já está em uso pelo usuário ID {}.",
                        id, usuarioAtualizado.getEmail(), usuarioComNovoEmail.get().getId());
                throw new IllegalArgumentException("Email já está em uso por outro usuário");
            }

            log.info("Email do usuário ID {} será atualizado para '{}'.", id, usuarioAtualizado.getEmail());
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            modificado = true;
        } else if (usuarioAtualizado.getEmail() != null && !usuarioAtualizado.getEmail().isEmpty()) {
            // Email fornecido é o mesmo que o existente ou não é válido para alteração (ex: é o mesmo)
            log.info("Email fornecido para usuário ID {} ('{}') é o mesmo que o existente ou não requer alteração. Nenhuma alteração no email.", id, usuarioAtualizado.getEmail());
        } else if (usuarioAtualizado.getEmail() == null) {
            // Email não foi fornecido na requisição de atualização
            log.info("Nenhum email fornecido para atualização para usuário ID {}. Email existente ('{}') mantido.", id, usuarioExistente.getEmail());
        } else { // usuarioAtualizado.getEmail() é uma string vazia ""
            log.warn("Tentativa de definir um email vazio para o usuário ID {}. Email existente ('{}') mantido. Esta operação não é permitida se o email for obrigatório.", id, usuarioExistente.getEmail());
            // Se o email não puder ser vazio, uma exceção deve ser lançada aqui ou antes, por validação.
            // throw new IllegalArgumentException("Email não pode ser vazio.");
        }

        if (modificado) {
            Usuario atualizado = usuarioRepository.save(usuarioExistente);
            log.info("Usuário ID {} atualizado com sucesso. Novo estado: Nome='{}', Email='{}'",
                    id, atualizado.getNome(), atualizado.getEmail());
            return UsuarioMapper.toDTO(atualizado);
        } else {
            log.info("Nenhuma alteração efetiva nos dados do usuário ID {}. Retornando usuário existente sem salvar.", id);
            return UsuarioMapper.toDTO(usuarioExistente);
        }
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        log.info("Buscando usuário com ID: {}", id);
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        log.info("Usuário ID {} encontrado com sucesso. Nome='{}'", id, usuario.getNome());
        return UsuarioMapper.toDTO(usuario);
    }

    public List<UsuarioResponseDTO> listarTodos() {
        log.info("Listando todos os usuários cadastrados");
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        log.info("Deletando usuário com ID: {}", id);
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
        log.info("Usuário com ID {} deletado com sucesso", id);
    }
}

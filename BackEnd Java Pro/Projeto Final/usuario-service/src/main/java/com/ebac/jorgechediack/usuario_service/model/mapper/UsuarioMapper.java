package com.ebac.jorgechediack.usuario_service.model.mapper;

import com.ebac.jorgechediack.usuario_service.model.Usuario;
import com.ebac.jorgechediack.usuario_service.model.dto.UsuarioRequestDTO;
import com.ebac.jorgechediack.usuario_service.model.dto.UsuarioResponseDTO;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        return Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .dataCadastro(dto.getDataCadastro())
                .build();
    }

    public static UsuarioResponseDTO toDTO(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setDataCadastro(usuario.getDataCadastro());
        return dto;
    }
}

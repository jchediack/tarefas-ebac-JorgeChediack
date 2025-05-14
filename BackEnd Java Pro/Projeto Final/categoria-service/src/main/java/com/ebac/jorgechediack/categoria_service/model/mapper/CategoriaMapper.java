package com.ebac.jorgechediack.categoria_service.model.mapper;

import com.ebac.jorgechediack.categoria_service.model.CategoriaMeme;
import com.ebac.jorgechediack.categoria_service.model.dto.CategoriaRequestDTO;
import com.ebac.jorgechediack.categoria_service.model.dto.CategoriaResponseDTO;

public class CategoriaMapper {

    public static CategoriaMeme toEntity(CategoriaRequestDTO dto) {
        return CategoriaMeme.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .dataCadastro(dto.getDataCadastro())
                .usuarioId(dto.getUsuarioId())
                .build();
    }

    public static CategoriaResponseDTO toDTO(CategoriaMeme entity) {
        CategoriaResponseDTO dto = new CategoriaResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setDataCadastro(entity.getDataCadastro());
        dto.setUsuarioId(entity.getUsuarioId());
        return dto;
    }
}

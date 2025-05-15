package com.ebac.jorgechediack.memes_service.model.mapper;

import com.ebac.jorgechediack.memes_service.model.Memes;
import com.ebac.jorgechediack.memes_service.model.dto.MemesRequestDTO;
import com.ebac.jorgechediack.memes_service.model.dto.MemesResponseDTO;

public class MemesMapper {

    public static Memes toEntity(MemesRequestDTO dto) {
        return Memes.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .dataCadastro(dto.getDataCadastro())
                .categoriaId(dto.getCategoriaId())
                .usuarioId(dto.getUsuarioId())
                .build();
    }

    public static MemesResponseDTO toDTO(Memes entity) {
        MemesResponseDTO dto = new  MemesResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setDataCadastro(entity.getDataCadastro());
        dto.setCategoriaId(entity.getCategoriaId());
        dto.setUsuarioId(entity.getUsuarioId());
        return dto;
    }
}
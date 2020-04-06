package com.mirante.api.service.mapper;

import com.mirante.api.model.Endereco;
import com.mirante.api.service.dto.EnderecoDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper extends EntityMapper<EnderecoDTO, Endereco> {

    Endereco toEntity(EnderecoDTO dto);

    EnderecoDTO toDto(Endereco entity);

    default Endereco fromId(Long id) {
        if (id == null) {
            return null;
        }
        Endereco endereco = new Endereco();
        endereco.setId(id);
        return endereco;
    }
}

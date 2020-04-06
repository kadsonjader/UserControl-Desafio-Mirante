package com.mirante.api.service.mapper;

import com.mirante.api.model.Telefone;
import com.mirante.api.service.dto.TelefoneDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelefoneMapper extends EntityMapper<TelefoneDTO, Telefone> {

    Telefone toEntity(TelefoneDTO dto);

    TelefoneDTO toDto(Telefone entity);

    default Telefone fromId(Long id) {
        if (id == null) {
            return null;
        }
        Telefone telefone = new Telefone();
        telefone.setId(id);
        return telefone;
    }

}

package com.mirante.api.service.mapper;

import com.mirante.api.model.Cliente;
import com.mirante.api.service.dto.ClienteDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {

    Cliente toEntity(ClienteDTO dto);

    ClienteDTO toDto(Cliente entity);

    default Cliente fromId(Long id) {
        if (id == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setId(id);
        return cliente;
    }
}

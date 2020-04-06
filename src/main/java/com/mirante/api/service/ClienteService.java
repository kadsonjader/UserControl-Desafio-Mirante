package com.mirante.api.service;

import java.util.List;

import com.mirante.api.service.dto.ClienteDTO;

public interface ClienteService {
    ClienteDTO save(ClienteDTO cliente);

    ClienteDTO getOne(Long id);

    List<ClienteDTO> findAll();

    void delete(Long id);
}

package com.mirante.api.service.impl;

import com.mirante.api.model.Cliente;
import com.mirante.api.repository.ClienteRepository;
import com.mirante.api.service.ClienteService;
import com.mirante.api.service.dto.ClienteDTO;
import com.mirante.api.service.mapper.ClienteMapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        setMappings(cliente);

        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDto(cliente);
    }

    private void setMappings(Cliente cliente) {
        cliente.getTelefones().forEach(telefone -> telefone.setCliente(cliente));
        cliente.getEmails().forEach(email -> email.setCliente(cliente));
        cliente.getEndereco().setCliente(cliente);
    }

    @Override
    public ClienteDTO getOne(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) return null;
        return clienteMapper.toDto(cliente);
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toDto(clientes);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}

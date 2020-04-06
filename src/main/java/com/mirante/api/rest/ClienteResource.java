package com.mirante.api.rest;

import com.mirante.api.service.ClienteService;
import com.mirante.api.service.dto.ClienteDTO;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clientes")
public class ClienteResource {

    private final Logger log = LoggerFactory.getLogger(ClienteResource.class);
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody @Valid ClienteDTO cliente) {
        log.debug("Requisicao para criar Cliente : {}", cliente);

        if (cliente.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Um novo cliente nao pode possuir um ID");
        }

        cliente = clienteService.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> update(@RequestBody @Valid ClienteDTO cliente) {
        log.debug("Requisicao para editar Cliente : {}", cliente);
        cliente = clienteService.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getOne(@PathVariable Long id) {
        log.debug("Requisicao para buscar Cliente com id: {}", id);
        ClienteDTO cliente = clienteService.getOne(id);
        if (cliente == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        log.debug("Requisicao para listar Clientes");
        List<ClienteDTO> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("Requisicao para deletar Cliente com id : {}", id);
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

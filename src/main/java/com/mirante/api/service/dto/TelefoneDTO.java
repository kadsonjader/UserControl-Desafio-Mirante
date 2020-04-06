package com.mirante.api.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import com.mirante.api.model.TipoTelefone;

@Data
@NoArgsConstructor
public class TelefoneDTO implements Serializable {
    private Long id;
    private String numero;
    private TipoTelefone tipo;
}

package com.mirante.api.model;

import lombok.Getter;

import java.io.Serializable;

public enum TipoTelefone implements Serializable {
    CELULAR("Celular"),
    COMERCIAL("Comercial"),
    RESIDENCIAL("Residencial");

    @Getter
    private String descricao;

    TipoTelefone(String descricao) {
        this.descricao = descricao;
    }
}

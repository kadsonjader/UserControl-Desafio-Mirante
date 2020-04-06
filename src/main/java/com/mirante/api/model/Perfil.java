package com.mirante.api.model;

import lombok.Getter;

public enum Perfil {
    ADMIN("ADMIN"),
    USUARIO("USUARIO");

    public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Getter
    private String descricao;

    Perfil(String descricao) {
        this.descricao = descricao;
    }
}

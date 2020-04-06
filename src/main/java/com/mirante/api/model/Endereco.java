package com.mirante.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{cep.notempty}")
    private String cep;

    @NotEmpty(message = "{logradouro.notempty}")
    private String logradouro;

    @NotEmpty(message = "{bairro.notempty}")
    private String bairro;

    @NotEmpty(message = "{cidade.notempty}")
    private String cidade;

    @NotEmpty(message = "{uf.notempty}")
    private String uf;

    private String complemento;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
}

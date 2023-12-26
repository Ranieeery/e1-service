package br.com.empresa1.report.dto.backoffice;

import com.avenuecode.core.service.dao.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TituloReciboDTO implements Entity<Long>{

    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
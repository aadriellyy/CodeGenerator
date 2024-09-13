package br.jus.tse.administrativa.contato.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnderecoRequest {
    
    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("cep")
    private String cep;
    
    @JsonProperty("logradouro")
    private String logradouro;
    
    
    @JsonProperty("complemento")
    private String complemento;
    
    
    @JsonProperty("id_dono")
    private Long idDdono;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Long getIdDdono() {
        return this.idDdono;
    }

    public void setIdDdono(Long idDdono) {
        this.idDdono = idDdono;
    }
    
    
}

package br.jus.tse.administrativa.contato.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TelefoneRequest {
    
    @JsonProperty("id_dono")
    private Long idDoDono;
    
    
    @JsonProperty("id_telefone")
    private Long id;
    
    
    @JsonProperty("numero_telefone")
    private String telefone;


    public Long getIdDoDono() {
        return this.idDoDono;
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTelefone() {
        return this.telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public void setIdDoDono(Long idDoDono) {
        this.idDoDono = idDoDono;
    }
    
}

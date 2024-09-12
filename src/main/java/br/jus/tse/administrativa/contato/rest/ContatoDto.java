package br.jus.tse.administrativa.contato.rest;

import br.jus.tse.administrativa.contato.ContatoPessoal;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ContatoDto {


    private Long id;
    private String nomeCompleto;
    private String cpf;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ContatoDTO{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

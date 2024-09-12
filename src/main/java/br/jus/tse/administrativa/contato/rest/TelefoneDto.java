package br.jus.tse.administrativa.contato.rest;

import br.jus.tse.administrativa.contato.ContatoPessoal;

public class TelefoneDto {

    private Long id;
    private String telefone;
    private ContatoPessoal dono;

    @Override
    public String toString() {
        return "TelefoneDto{" +
                "id=" + id +
                ", telefone='" + telefone + '\'' +
                ", dono=" + dono +
                '}';
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public ContatoPessoal getDono() {
        return dono;
    }
    public void setDono(ContatoPessoal dono) {
        this.dono = dono;
    }

}

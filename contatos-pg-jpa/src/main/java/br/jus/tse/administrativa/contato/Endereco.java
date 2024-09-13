package br.jus.tse.administrativa.contato;

import java.util.Objects;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENDERECO")
@Access(AccessType.FIELD)
@SequenceGenerator(name = "sqEndereco", sequenceName = "SQ_ENDERECO",allocationSize = 1)
public class Endereco {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sqEndereco")
    @Id
    @Column(name="ID_ENDERECO")
    private Long id;
    
    @Column(name="CEP")
    private String cep;
    
    @Column(name="LOGRADOURO")
    private String logradouro;
    
    @Column(name="COMPLEMENTO")
    private String complemento;
    
    @OneToOne(optional=false)
    @JoinColumn(name="FKID_PESSOA", nullable=false)
    private ContatoPessoal dono;

    public Endereco(String cep, String logradouro, String complemento) {
        super();
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
    }

    public Long getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public ContatoPessoal getDono() {
        return dono;
    }

    public void setDono(ContatoPessoal dono) {
        this.dono = dono;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id,cep,logradouro,complemento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Endereco other = (Endereco) obj;
        return Objects.equals(this.cep,other.cep) && Objects.equals(this.logradouro, other.logradouro)&& Objects.equals(this.complemento, other.complemento) && Objects.equals(this.id, other.id) && Objects.equals(this.dono,other.dono);
    }

}

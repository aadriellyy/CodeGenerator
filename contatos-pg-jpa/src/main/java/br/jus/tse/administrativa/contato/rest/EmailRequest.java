package br.jus.tse.administrativa.contato.rest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class EmailRequest {
    
    
    @NotNull(groups = {ValidOnUpdate.class}, message = "Id de Email está inválido.")
    @JsonProperty("id_email")
    private Long id;
    
    
    @NotNull(groups = {ValidOnCreation.class, ValidOnUpdate.class}, message = "Email está inválido.")
    @Email(groups = {ValidOnCreation.class, ValidOnUpdate.class}, message = "Email está inválido.")
    @JsonProperty("email")
    private String email;

    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return this.email;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    
    public Set<String>isValidOnStage (Class<?> stage) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        
        Set<ConstraintViolation<EmailRequest>>violacoes = validator.validate(this, stage);
        
        if (violacoes.isEmpty()) {
            return Collections.emptySet();
        }
        
        Set<String> violations = new HashSet<>() ;
        violacoes.forEach((violacao)->{
            violations.add(violacao.getMessageTemplate());
        });
        
        return violations;
    }
}

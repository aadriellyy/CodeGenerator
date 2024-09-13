package br.jus.tse.administrativa.contato.rest;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.tse.administrativa.contato.Email;
import br.jus.tse.administrativa.contato.EmailService;

@RestController
@RequestMapping("/contatos/")
public class EmailRestController {
    
    private EmailService emailService;
    
    public EmailRestController(EmailService emailService) {
        this.emailService = emailService;
    }
    
    @PostMapping(value="/{id_dono}/emails",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> adicionar(@PathVariable("id_dono") Long idDono, @RequestBody EmailRequest emailRequest) {
        
        if (idDono == null) {
            return ResponseEntity.badRequest().body("id_dono está inválido");
        }
        
        Set<String> validations = emailRequest.isValidOnStage(ValidOnCreation.class);
        if (!validations.isEmpty()) {
            return ResponseEntity.badRequest().body(validations);
        }
         
        return ResponseEntity.ok().header("Custom-Header", "foo").body(emailRequest);
    }
    
    @GetMapping(value="/{id_dono}/emails",produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> todos(@PathVariable("id_dono") Long idDono) {
        if (idDono == null) {
            return ResponseEntity.badRequest().body("id_dono está inválido");
        }
        List<Email> emails = emailService.buscarTodos(); 
        return ResponseEntity.ok().header("Custom-Header", "foo").body(emails);
    }
    @GetMapping(value="/{id_dono}/emails/{id_email}", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarPorId(@PathVariable("id_dono") Long idDono,@PathVariable("id_email") Long id) {
        if (idDono == null) {
            return ResponseEntity.badRequest().body("id_dono está inválido");
        }
        
        Optional<Email> possivelEmail = emailService.buscarPorId(id);
        if (possivelEmail.isPresent()) {
            return ResponseEntity.ok().header("Custom-Header", "foo").body(possivelEmail.get());
        }
        return ResponseEntity.notFound().header("not-found-id", String.valueOf(id)).build();
        
    }
    
    @PutMapping(value="/{id_dono}/emails",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> atualizar(@PathVariable("id_dono") Long idDono,@RequestBody EmailRequest emailRequest) {
        Set<String> validations = emailRequest.isValidOnStage(ValidOnUpdate.class);
        if (!validations.isEmpty()) {
            return ResponseEntity.badRequest().body(validations);
        }
        
        return ResponseEntity.ok().header("Custom-Header", "foo").body(emailRequest);
        
    }
    
    @DeleteMapping(value="/{id_dono}/emails/{id_email}", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> excluir(@PathVariable("id_dono") Long idDono,@PathVariable("id_email") Long id) {
        
        return ResponseEntity.ok().header("Custom-Header", "foo").body("Excluido o id " + id);
        
    }
}

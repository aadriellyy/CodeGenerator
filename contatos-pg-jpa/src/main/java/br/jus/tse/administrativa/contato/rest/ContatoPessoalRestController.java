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

import br.jus.tse.administrativa.contato.ContatoPessoal;
import br.jus.tse.administrativa.contato.ContatoPessoalService;

@RestController
@RequestMapping("/contatos")
public class ContatoPessoalRestController {
    private ContatoPessoalService contatoPessoalService;
    
    public ContatoPessoalRestController(ContatoPessoalService contatoPessoalService) {
        this.contatoPessoalService = contatoPessoalService;
    }
    
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> adicionar(@RequestBody  ContatoPessoalRequest contatoPessoalRequest) {
       Set<String> validations = contatoPessoalRequest.isValidOnStage(ValidOnCreation.class);
       
       if (!validations.isEmpty()) {
           return ResponseEntity.badRequest().body(validations);
       }
        return ResponseEntity.ok().header("Custom-Header", "foo").body(contatoPessoalRequest);
    }
    
    @GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> todos() {
        List<ContatoPessoal> contatos = contatoPessoalService.buscarTodos(); 
        return ResponseEntity.ok().header("Custom-Header", "foo").body(contatos);
    }
    @GetMapping(value="/{id_contato}", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarPorId(@PathVariable("id_contato") Long id) {
        Optional<ContatoPessoal> possivelContato = contatoPessoalService.buscarPorId(id);
        if (possivelContato.isPresent()) {
            return ResponseEntity.ok().header("Custom-Header", "foo").body(possivelContato.get());
        }
        return ResponseEntity.notFound().header("not-found-id", String.valueOf(id)).build();
        
    }
    
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> atualizar(@RequestBody ContatoPessoalRequest contatoPessoalRequest) {
        Set<String> validations = contatoPessoalRequest.isValidOnStage(ValidOnUpdate.class);
        if (!validations.isEmpty()) {
            return ResponseEntity.badRequest().body(validations);
        }
        return ResponseEntity.ok().header("Custom-Header", "foo").body(contatoPessoalRequest);
        
    }
    
    @DeleteMapping(value="/{id_contato}", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> excluir(@PathVariable("id_contato") Long id) {
        
        return ResponseEntity.ok().header("Custom-Header", "foo").body("Excluido o id " + id);
        
    }
}

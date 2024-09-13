package br.jus.tse.administrativa.contato.rest;


import java.util.List;
import java.util.Optional;

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

import br.jus.tse.administrativa.contato.Telefone;
import br.jus.tse.administrativa.contato.TelefoneService;

@RestController
@RequestMapping("/contatos")
public class TelefoneRestController {
    
    private TelefoneService telefoneService;
    
    public TelefoneRestController(TelefoneService emailService) {
        this.telefoneService = emailService;
    }
    
    @PostMapping(value="{id_dono}/telefones",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> adicionar(@PathVariable("id_dono") Long idDono, @RequestBody TelefoneRequest telefoneRequest) {
        return ResponseEntity.ok().header("Custom-Header", "foo").body(telefoneRequest);
    }
    
    @GetMapping(value="{id_dono}/telefones",produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> todos(@PathVariable("id_dono") Long idDono) {
        List<Telefone> emails = telefoneService.buscarTodos(); 
        return ResponseEntity.ok().header("Custom-Header", "foo").body(emails);
    }
    @GetMapping(value="/{id_dono}/telefones/{id_telefone}", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarPorId(@PathVariable("id_dono") Long idDono, @PathVariable("id_telefone") Long id) {
        Optional<Telefone> possivelTelefone = telefoneService.buscarPorId(id);
        if (possivelTelefone.isPresent()) {
            return ResponseEntity.ok().header("Custom-Header", "foo").body(possivelTelefone.get());
        }
        return ResponseEntity.notFound().header("not-found-id", String.valueOf(id)).build();
        
    }
    
    @PutMapping(value="{id_dono}",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> atualizar(@PathVariable("id_dono") Long idDono, @RequestBody TelefoneRequest telefoneRequest) {
        
        return ResponseEntity.ok().header("Custom-Header", "foo").body(telefoneRequest);
        
    }
    
    @DeleteMapping(value="/{id_telefone}", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> excluir(@PathVariable("id_telefone") Long id) {
        
        return ResponseEntity.ok().header("Custom-Header", "foo").body("Excluido o id " + id);
        
    }
}

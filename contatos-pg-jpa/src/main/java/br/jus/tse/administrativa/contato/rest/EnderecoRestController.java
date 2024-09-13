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

import br.jus.tse.administrativa.contato.Endereco;
import br.jus.tse.administrativa.contato.EnderecoService;

@RestController
@RequestMapping("/contatos")
public class EnderecoRestController {
    
    private EnderecoService enderecoService;
    
    public EnderecoRestController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }
    
    @PostMapping(value="/{id_morador}/enderecos",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> adicionar(@PathVariable("id_morador") Long id, @RequestBody EnderecoRequest enderecoRequest) {
        
        return ResponseEntity.ok().header("Custom-Header", "foo").body(enderecoRequest);
    }
    
    @GetMapping(value="/{id_morador}/enderecos",produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> todos(@PathVariable("id_morador") Long id) {
        
        List<Endereco> enderecos = enderecoService.buscarTodos(); 
        return ResponseEntity.ok().header("Custom-Header", "foo").body(enderecos);
    }
    @GetMapping(value="/{id_morador}/enderecos/{id_endereco}", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarPorId( @PathVariable("id_morador") Long idDono, @PathVariable("id_endereco") Long id) {
        Optional<Endereco> possivelEndereco = enderecoService.buscarPorId(id);
        if (possivelEndereco.isPresent()) {
            return ResponseEntity.ok().header("Custom-Header", "foo").body(possivelEndereco.get());
        }
        return ResponseEntity.notFound().header("not-found-id", String.valueOf(id)).build();
        
    }
    
    @PutMapping(value="/{id_morador}/enderecos/",consumes = {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> atualizar(@PathVariable("id_morador") Long idDono,@RequestBody Endereco enderecoRequest) {
        
        return ResponseEntity.ok().header("Custom-Header", "foo").body(enderecoRequest);
        
    }
    
    @DeleteMapping(value="/{id_morador}/enderecos/{id_endereco}", produces= {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> excluir(@PathVariable("id_morador") Long idDono, @PathVariable("id_endereco") Long id) {
        
        return ResponseEntity.ok().header("Custom-Header", "foo").body("Excluido o id " + id);
        
    }
}

package br.jus.tse.administrativa.contato.rest;


import br.jus.tse.administrativa.contato.ContatoPessoal;
import br.jus.tse.administrativa.contato.ListaContatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ListaContatosService contatoService;

    @PostMapping(value="/contato-com-telefone", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> adicionarContato(@RequestBody ContatoPessoal contato){
        this.contatoService.salvarContato(contato);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping(value="/contato", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getContato(@RequestParam("id") Long id){
        Optional<ContatoPessoal> contato = contatoService.buscarContatoPessoal(id);
        return ResponseEntity.status(HttpStatus.OK).body(contato);
    }

    @GetMapping(value="/lista-contatos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllContatos(){
        List<ContatoPessoal> contatos = contatoService.listarContatoPessoal();
        return ResponseEntity.status(HttpStatus.OK).body(contatos);
    }

}

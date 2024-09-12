package br.jus.tse.administrativa.contato.rest;

import br.jus.tse.administrativa.contato.Telefone;
import br.jus.tse.administrativa.contato.ListaContatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    @Autowired
    private ListaContatosService telefoneService;

    @GetMapping(value="/lista-telefone", produces= {MediaType.APPLICATION_JSON_VALUE})
    public List<Telefone> getAll(){
        List<Telefone> telefoneList = telefoneService.listarTelefones();
        System.out.println(telefoneList);
        return telefoneList;
    }

    @PostMapping(value="/adicionar-telefone", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> adicionarTelefone(@RequestBody Telefone telefone){
        telefoneService.adicionarTelefone(telefone);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping(value="/telefone", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Telefone> getTelefone(@RequestParam("id") Long id){
        Optional<Telefone> telefone = telefoneService.buscarTelefone(id);
        return telefone;
    }

    @PatchMapping(value="/atualizar-telefone", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> atualizarTelefone(@RequestBody Telefone telefone){
        telefoneService.regravarTelefone(telefone);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping(value = "/deletar-telefone", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deletarTelefone(@RequestBody Telefone telefone){
        telefoneService.removerTelefone(telefone);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}

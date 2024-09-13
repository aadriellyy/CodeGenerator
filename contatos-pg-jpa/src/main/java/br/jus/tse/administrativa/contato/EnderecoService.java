package br.jus.tse.administrativa.contato;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {
    
    private EnderecoDao enderecoDao;

    public EnderecoService(EnderecoDao enderecoDao) {
        super();
        this.enderecoDao = enderecoDao;
    }
    
    
    @Transactional
    public List<Endereco>buscarTodos(){
        return enderecoDao.recuperarTodos();
    }

    @Transactional
    public Optional<Endereco> buscarPorId(Long id) {
       return enderecoDao.recuperarPorId(id);
    }
    
    
}

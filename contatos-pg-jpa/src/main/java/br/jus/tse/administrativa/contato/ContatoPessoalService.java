package br.jus.tse.administrativa.contato;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContatoPessoalService {
    
    private ContatoPessoalDao contatoPessoalDao;

    public ContatoPessoalService(ContatoPessoalDao contatoPessoalDao) {
        super();
        this.contatoPessoalDao = contatoPessoalDao;
    }
    
    
    @Transactional
    public List<ContatoPessoal>buscarTodos(){
        return contatoPessoalDao.recuperarTodos();
    }

    @Transactional
    public Optional<ContatoPessoal> buscarPorId(Long id) {
       return contatoPessoalDao.recuperarPorId(id);
    }
    
    
}

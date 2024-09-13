package br.jus.tse.administrativa.contato;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelefoneService {
    
    private TelefoneDao telefoneDao;

    public TelefoneService(TelefoneDao telefoneDao) {
        super();
        this.telefoneDao = telefoneDao;
    }
    
    
    @Transactional
    public List<Telefone>buscarTodos(){
        return telefoneDao.recuperarTodos();
    }

    @Transactional
    public Optional<Telefone> buscarPorId(Long id) {
       return telefoneDao.recuperarPorId(id);
    }
    
    
}

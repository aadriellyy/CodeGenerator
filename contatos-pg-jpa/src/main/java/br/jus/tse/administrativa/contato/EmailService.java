package br.jus.tse.administrativa.contato;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {
    
    private EmailDao emailDao;
    
    public EmailService(EmailDao emailDao) {
        super();
        this.emailDao = emailDao;
    }

    @Transactional
    public List<Email>buscarTodos(){
        return emailDao.recuperarTodos();
    }

    @Transactional
    public Optional<Email> buscarPorId(Long id) {
       return emailDao.recuperarPorId(id);
    }
}

package br.jus.tse.administrativa.contato;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

@Repository
public class ContatoPessoalDaoJpa implements ContatoPessoalDao {

    private EntityManager em;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ContatoPessoalDaoJpa.class);
    
    public ContatoPessoalDaoJpa(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public void gravar(ContatoPessoal contato) {
        this.em.persist(contato);

    }

    @Override
    public Optional<ContatoPessoal> recuperarPorId(Long id) {
        String jpql = "select pessoa from ContatoPessoal pessoa where pessoa.id=:id_pessoa";
        
        TypedQuery<ContatoPessoal>typedObjectQuery = em.createQuery(jpql, ContatoPessoal.class);
        typedObjectQuery.setParameter("id_pessoa", id);
        
        try {
            ContatoPessoal contato =  typedObjectQuery.getSingleResult();
            return Optional.of(contato);
        }
        catch(PersistenceException e) {
            LOGGER.error("Não foi possível recuperar o 'ContatoPessoal' {} =>{}", id, e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public List<ContatoPessoal> recuperarTodos() {
        String jpql = "select pessoa from ContatoPessoal pessoa";
        
        TypedQuery<ContatoPessoal>typedObjectQuery = em.createQuery(jpql, ContatoPessoal.class);
        
        try {
            return typedObjectQuery.getResultList();
        }
        catch(PersistenceException e) {
            LOGGER.error("Não foi possível recuperar a lista de  'ContatoPessoais' {}.",e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    @Override
    public void regravar(ContatoPessoal contato) {
       try {
           em.merge(contato);
       }catch(PersistenceException pe) {
           LOGGER.error("Não foi possível atualizar o   'ContatoPessoal' {} => {}.", contato, pe.getMessage(), pe);
       }
    }

    @Override
    public void apagar(ContatoPessoal contato) {
        em.remove(contato);
      
    }

}

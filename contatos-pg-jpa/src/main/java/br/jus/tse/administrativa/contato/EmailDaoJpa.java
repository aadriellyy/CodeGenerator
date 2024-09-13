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
public class EmailDaoJpa implements EmailDao{

    private EntityManager em;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailDaoJpa.class);

    public EmailDaoJpa(EntityManager em){
        super();
        this.em = em;
    }

    @Override
    public void gravar(Email email) {
        this.em.persist(email);
    }

    @Override
    public Optional<Email> recuperarPorId(Long id) {
        String jpql = "select email from Email email where email.id=:id_email";
        TypedQuery<Email>typedObjectQuery = em.createQuery(jpql,Email.class);
        typedObjectQuery.setParameter("id_email",id);

        try{
            Email email = typedObjectQuery.getSingleResult();
            return Optional.of(email);
        }
        catch(PersistenceException e){
            LOGGER.error("Não foi possível recuperar o 'Email' {} =>{}",id,e.getMessage(),e);
        }
        return Optional.empty();
    }


    @Override
    public List<Email> recuperarTodos() {
        String jpql = "select email from Email email";

        TypedQuery<Email>typedObjectQuery = em.createQuery(jpql,Email.class);
        try{
            return typedObjectQuery.getResultList();
        }
        catch(PersistenceException e){
            LOGGER.error("Não foi possível recuperar a lista de  'Emails' {}.",e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    @Override
    public void regravar(Email email) {
        try{
            em.merge(email);
        } catch(PersistenceException pe){
            LOGGER.error("Não foi possível atualizar o   'Email' {} => {}.", email, pe.getMessage(), pe);
        }
    }

    @Override
    public void apagar(Email email) {
        em.remove(email);
    }

    
}

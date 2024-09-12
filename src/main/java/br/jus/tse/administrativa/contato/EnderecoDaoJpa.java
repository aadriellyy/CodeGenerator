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
public class EnderecoDaoJpa implements EnderecoDao {

    private EntityManager em;

    private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoDaoJpa.class);

    public EnderecoDaoJpa(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public void gravar(Endereco endereco) {
        this.em.persist(endereco);
    }

    @Override
    public Optional<Endereco> recuperarPorId(Long id) {
        String jpql = "select endereco from Endereco endereco where endereco.id=:id_endereco";
        TypedQuery<Endereco>typedObjectQuery = em.createQuery(jpql,Endereco.class);
        typedObjectQuery.setParameter("id_endereco",id);

        try{
            Endereco endereco = typedObjectQuery.getSingleResult();
            return Optional.of(endereco);
        }
        catch(PersistenceException e){
            LOGGER.error("Não foi possível recuperar o 'Endereco' {} =>{}",id,e.getMessage(),e);
        }
        return Optional.empty();
    }

    @Override
    public List<Endereco> recuperarTodos() {
        String jpql = "select endereco from Endereco endereco";

        TypedQuery<Endereco>typedObjectQuery = em.createQuery(jpql,Endereco.class);
        try{
            return typedObjectQuery.getResultList();
        }
        catch(PersistenceException e){
            LOGGER.error("Não foi possível recuperar a lista de  'Endereco' {}.",e.getMessage(), e);
        }
        return Collections.emptyList();
    }

    @Override
    public void regravar(Endereco endereco) {
        try{
            em.merge(endereco);
        } catch(PersistenceException pe){
            LOGGER.error("Não foi possível atualizar o   'Endereco' {} => {}.", endereco, pe.getMessage(), pe);
        }
    }

    @Override
    public void apagar(Endereco endereco) {
        em.remove(endereco);
    }

}

package br.jus.tse.administrativa.contato;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ListaContatosService {

    private TelefoneDao telefoneDao;
    private ContatoPessoalDao contatoDao;

    public ListaContatosService(TelefoneDao telefoneDao, ContatoPessoalDao contatoDao) {
        this.telefoneDao = telefoneDao;
        this.contatoDao = contatoDao;
    }

    @Transactional
    public void salvarContato(ContatoPessoal contato){
        this.contatoDao.gravar(contato);
    }

    @Transactional
    public Optional<ContatoPessoal> buscarContatoPessoal(Long id){
        Optional<ContatoPessoal> contato = this.contatoDao.recuperarPorId(id);
        return contato;
    }

    @Transactional
    public void regravarContato(ContatoPessoal contato){
        this.contatoDao.regravar(contato);
    }

    @Transactional
    public List<ContatoPessoal> listarContatoPessoal(){
        return this.contatoDao.recuperarTodos();
    }

    @Transactional
    public void excluirContato(ContatoPessoal contato){
        this.contatoDao.apagar(contato);
    }

    @Transactional
    public void adicionarTelefone(Telefone telefone) {
        this.telefoneDao.gravar(telefone);
    }

    @Transactional
    public List<Telefone> listarTelefones() {
        return this.telefoneDao.recuperarTodos();
    }

    @Transactional
    public Optional<Telefone> buscarTelefone(Long id){
        return this.telefoneDao.recuperarPorId(id);
    }

    @Transactional
    public void removerTelefone(Telefone telefone) {
        this.telefoneDao.apagar(telefone);
    }

    @Transactional
    public void regravarTelefone(Telefone telefone) {
        this.telefoneDao.regravar(telefone);
    }

}

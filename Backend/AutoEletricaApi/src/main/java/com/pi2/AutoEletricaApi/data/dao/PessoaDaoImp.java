package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

@Repository
public class PessoaDaoImp implements PessoaDao {

   
    private EntityManager manager;
    
    @Autowired
    public PessoaDaoImp(EntityManager manager) {
        this.manager = manager;
    }

    
    
    @Override
    public List<Pessoa> getPessoas() {
        Session currentSession = manager.unwrap(Session.class);
        Query<Pessoa> query = currentSession.createQuery("from Pessoa", Pessoa.class);
        List<Pessoa> lista = query.getResultList();
        return lista;
    }

    @Override
    public Pessoa getPessoa(int id) {
        Session currentSession = manager.unwrap(Session.class);
        Pessoa pessoaObj = currentSession.get(Pessoa.class, id);
        return pessoaObj;
    }

    @Override
    public void savePessoa(Pessoa pessoa) {
      Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(pessoa);
    }

    @Override
    public void deletePessoa(int id) {
        Session currentSession = manager.unwrap(Session.class);
        Pessoa pessoaObj = currentSession.get(Pessoa.class, id);
        currentSession.delete(pessoaObj);
    }

    @Override
    public List<Pessoa> getPessoaPorNome(String nome) {
        Session currentSession = manager.unwrap(Session.class);
        List<Pessoa> lista = manager.createQuery("SELECT p FROM Pessoa p WHERE p.nome LIKE : nome").setParameter("nome", nome).getResultList();
        return lista;
    }

}

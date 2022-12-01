package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Situacao;
import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SituacaoDaoImp implements SituacaoDao {

    
    private EntityManager manager;

    @Autowired
    public SituacaoDaoImp(EntityManager manager) {
        this.manager = manager;
    }
    
    

    @Override
    public List<Situacao> getSituacoes() {
        Session currentSession = manager.unwrap(Session.class);
        Query<Situacao> query = currentSession.createQuery("from Situacao", Situacao.class);
        List<Situacao> lista = query.getResultList();
        return lista;
    }

    @Override
    public Situacao getSituacao(int id) {
     Session currentSession = manager.unwrap(Session.class);
     Situacao situacaoObj = currentSession.get(Situacao.class, id);
     return situacaoObj;
    }

    @Override
    public void saveSituacao(Situacao situacao) {
        Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(situacao);
    }

    @Override
    public void deleteSituacao(int id) {
      Session currentSession = manager.unwrap(Session.class);
      Situacao situacaoObj = currentSession.get(Situacao.class, id);
      currentSession.delete(situacaoObj);
    }



}

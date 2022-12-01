package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.NotaFiscal;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

@Repository
public class NotaFiscalDaoImp implements NotaFiscalDao {

    
    private EntityManager manager;

    @Autowired
    public NotaFiscalDaoImp(EntityManager manager) {
        this.manager = manager;
    }
    
    

    @Override
    public List<NotaFiscal> getNotasFiscais() {
        Session currentSession = manager.unwrap(Session.class);
        Query<NotaFiscal> query = currentSession.createQuery("from NotaFiscal", NotaFiscal.class);
        List<NotaFiscal> lista = query.getResultList();
        return lista;
    }

    @Override
    public NotaFiscal getNotaFiscal(int id) {
        Session currentSession = manager.unwrap(Session.class);
        NotaFiscal notafiscalObj = currentSession.get(NotaFiscal.class, id);
        return notafiscalObj;
    }

    @Override
    public void saveNotaFiscal(NotaFiscal notafiscal) {
        Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(notafiscal);      
    }

    @Override
    public void deleteNotaFiscal(int id) {
          Session currentSession = manager.unwrap(Session.class);
        NotaFiscal notafiscalObj = currentSession.get(NotaFiscal.class, id);
        currentSession.delete(notafiscalObj);
    }


}

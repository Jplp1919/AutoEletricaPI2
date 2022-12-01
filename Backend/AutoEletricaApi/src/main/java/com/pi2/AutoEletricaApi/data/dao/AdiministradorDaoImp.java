package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Adiministrador;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdiministradorDaoImp implements AdiministradorDao {

    
    private EntityManager manager;

    @Autowired
    public AdiministradorDaoImp(EntityManager manager) {
        this.manager = manager;
    }
  
    
    @Override
    public List<Adiministrador> getAdiministradores() {
        Session currentSession = manager.unwrap(Session.class);
        Query<Adiministrador> query = currentSession.createQuery("from Adiministrador", Adiministrador.class);
        List<Adiministrador> lista = query.getResultList();
        return lista;
    }

    @Override
    public Adiministrador getAdiministrador(int id) {
        Session currentSession = manager.unwrap(Session.class);
        Adiministrador adiministradorObj = currentSession.get(Adiministrador.class, id);
        return adiministradorObj;
    }

    @Override
    public void saveAdiministrador(Adiministrador adiministrador) {
        Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(adiministrador);
    }

    @Override
    public void deleteAdiministrador(int id) {
        Session currentSession = manager.unwrap(Session.class);
        Adiministrador adiministradorObj = currentSession.get(Adiministrador.class, id);
        currentSession.delete(adiministradorObj);
    }

}

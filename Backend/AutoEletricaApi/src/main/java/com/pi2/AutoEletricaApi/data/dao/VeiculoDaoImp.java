package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VeiculoDaoImp implements VeiculoDao {

    
    private EntityManager manager;

    @Autowired
    public VeiculoDaoImp(EntityManager manager) {
        this.manager = manager;
    }
    
    

    @Override
    public List<Veiculo> getVeiculos() {
        Session currentSession = manager.unwrap(Session.class);
        Query<Veiculo> query = currentSession.createQuery("from Veiculo", Veiculo.class);
        List<Veiculo> lista = query.getResultList();
        return lista;
    }

    @Override
    public Veiculo getVeiculo(int id) {
        Session currentSession = manager.unwrap(Session.class);
        Veiculo veiculoObj = currentSession.get(Veiculo.class, id);
        return veiculoObj;
    }

    @Override
    public void saveVeiculo(Veiculo veiculo) {
      Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(veiculo);
    }

    @Override
    public void deleteVeiculo(int id) {
      Session currentSession = manager.unwrap(Session.class);
        Veiculo veiculoObj = currentSession.get(Veiculo.class, id);
        currentSession.delete(veiculoObj);
    }

}

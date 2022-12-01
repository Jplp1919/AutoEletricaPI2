package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.OrdemServico;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdemServicoDaoImp implements OrdemServicoDao {

    @Autowired
    private EntityManager manager;

    @Override
    public List<OrdemServico> getOrdemServicos() {
        Session currentSession = manager.unwrap(Session.class);
        Query<OrdemServico> query = currentSession.createQuery("from OrdemServico", OrdemServico.class);
        List<OrdemServico> lista = query.getResultList();
        return lista;
    }

    @Override
    public OrdemServico getOrdemServico(int id) {
        Session currentSession = manager.unwrap(Session.class);
        OrdemServico ordemServicoObj = currentSession.get(OrdemServico.class, id);
        return ordemServicoObj;
    }

    @Override
    public void saveOrdemServico(OrdemServico ordemservico) {
        Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(ordemservico);
    }

    @Override
    public void deleteOrdemServico(int id) {
        Session currentSession = manager.unwrap(Session.class);
        OrdemServico odeOrdemServicoObj = currentSession.get(OrdemServico.class, id);
        currentSession.delete(odeOrdemServicoObj);
    }

}

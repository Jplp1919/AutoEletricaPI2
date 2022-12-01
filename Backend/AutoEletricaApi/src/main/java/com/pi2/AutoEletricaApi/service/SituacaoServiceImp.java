
package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.Situacao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pi2.AutoEletricaApi.data.dao.SituacaoDao;
import org.springframework.data.jpa.repository.Modifying;

@Service
public class SituacaoServiceImp implements SituacaoService{
    
    @Autowired
    private SituacaoDao situacaoDao;
    
    @Transactional
    @Override
    public List<Situacao> getSituacoes() {
       return situacaoDao.getSituacoes();
    }
    
    @Transactional
    @Override
    public Situacao getSituacao(int id) {
      return situacaoDao.getSituacao(id);
    }
    
    @Modifying
    @Transactional
    @Override
    public void saveSituacao(Situacao situacao) {
      situacaoDao.saveSituacao(situacao);
    }
    
    @Modifying
    @Transactional
    @Override
    public void deleteSituacao(int id) {
     situacaoDao.deleteSituacao(id);
    
    
    }
    

    
}

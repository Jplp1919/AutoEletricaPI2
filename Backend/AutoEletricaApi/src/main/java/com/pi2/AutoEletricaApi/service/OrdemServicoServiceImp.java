package com.pi2.AutoEletricaApi.service;


import com.pi2.AutoEletricaApi.data.OrdemServico;
import com.pi2.AutoEletricaApi.data.dao.OrdemServicoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdemServicoServiceImp  implements OrdemServicoService{
    
    @Autowired
    private OrdemServicoDao ordemServicoDao;

    @Transactional
    @Override
    public List<OrdemServico> getOrdemServicos() {
       return ordemServicoDao.getOrdemServicos();
    
    }

    @Transactional
    @Override
    public OrdemServico getOrdemServico(int id) {
    return ordemServicoDao.getOrdemServico(id);
    }

    @Transactional
    @Override
    public void saveOrdemServico(OrdemServico ordemservico) {
      ordemServicoDao.saveOrdemServico(ordemservico);
    }

    @Transactional
    @Override
    public void deleteOrdemServico(int id) {
     ordemServicoDao.deleteOrdemServico(id);
    }
    
}

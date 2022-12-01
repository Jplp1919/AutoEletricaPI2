package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.Veiculo;
import com.pi2.AutoEletricaApi.data.dao.VeiculoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VeiculoServiceImp implements VeiculoService{

     @Autowired
    private VeiculoDao veiculoDao;
    
     @Transactional
    @Override
    public List<Veiculo> getVeiculos() {
       return veiculoDao.getVeiculos();
    }
    
    @Transactional
    @Override
    public Veiculo getVeiculo(int id) {
       return veiculoDao.getVeiculo(id);  
    
    }
    
    @Transactional
    @Override
    public void saveVeiculo(Veiculo veiculo) {
     veiculoDao.saveVeiculo(veiculo);
    }
    
    @Transactional
    @Override
    public void deleteVeiculo(int id) {
     veiculoDao.deleteVeiculo(id);
    
    }
    
}

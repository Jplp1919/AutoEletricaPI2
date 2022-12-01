package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.Adiministrador;
import com.pi2.AutoEletricaApi.data.dao.AdiministradorDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdiministradorServiceImp implements AdiministradorService {
    
    @Autowired
    private AdiministradorDao adiministradorDao;
    
    @Transactional
    @Override
    public List<Adiministrador> getAdiministradores() {
        return adiministradorDao.getAdiministradores();
    }
    
    @Transactional
    @Override
    public Adiministrador getAdiministrador(int id) {
        return adiministradorDao.getAdiministrador(id);
    }
    
    @Transactional
    @Override
    public void saveAdiministrador(Adiministrador adiministrador) {
        adiministradorDao.saveAdiministrador(adiministrador);
    }
    
    @Transactional
    @Override
    public void deleteAdiministrador(int id) {
        adiministradorDao.deleteAdiministrador(id);
        
    }
    
}

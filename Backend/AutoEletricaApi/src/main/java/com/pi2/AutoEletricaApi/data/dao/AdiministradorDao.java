package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Adiministrador;
import java.util.List;


public interface AdiministradorDao {
        
    List<Adiministrador> getAdiministradores();

    Adiministrador getAdiministrador(int id);

    void saveAdiministrador(Adiministrador adiministrador);

    void deleteAdiministrador(int id);
}

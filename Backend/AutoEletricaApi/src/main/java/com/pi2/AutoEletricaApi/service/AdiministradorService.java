package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.Adiministrador;
import java.util.List;

public interface AdiministradorService {

    List<Adiministrador> getAdiministradores();

    Adiministrador getAdiministrador(int id);

    void saveAdiministrador(Adiministrador adiministrador);

    void deleteAdiministrador(int id);
}

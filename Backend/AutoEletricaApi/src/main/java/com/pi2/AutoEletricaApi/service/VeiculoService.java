package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.Veiculo;
import java.util.List;

public interface VeiculoService {

    List<Veiculo> getVeiculos();

    Veiculo getVeiculo(int id);

    void saveVeiculo(Veiculo veiculo);

    void deleteVeiculo(int id);
}

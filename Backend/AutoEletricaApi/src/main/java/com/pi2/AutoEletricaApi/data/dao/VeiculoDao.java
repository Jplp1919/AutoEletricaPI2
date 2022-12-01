package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Veiculo;
import java.util.List;

public interface VeiculoDao {

    List<Veiculo> getVeiculos();

    Veiculo getVeiculo(int id);

    void saveVeiculo(Veiculo veiculo);

    void deleteVeiculo(int id);
}

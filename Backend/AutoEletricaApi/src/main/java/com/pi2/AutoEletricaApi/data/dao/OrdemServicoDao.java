package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.OrdemServico;
import java.util.List;


public interface OrdemServicoDao {
    
    List<OrdemServico> getOrdemServicos();

    OrdemServico getOrdemServico(int id);

    void saveOrdemServico(OrdemServico ordemservico);

    void deleteOrdemServico(int id);
}

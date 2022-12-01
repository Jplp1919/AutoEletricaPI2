package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.OrdemServico;
import java.util.List;


public interface OrdemServicoService {
        
    List<OrdemServico> getOrdemServicos();

    OrdemServico getOrdemServico(int id);

    void saveOrdemServico(OrdemServico ordemservico);

    void deleteOrdemServico(int id);
}

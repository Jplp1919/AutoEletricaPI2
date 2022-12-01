package com.pi2.AutoEletricaApi.data.controller;

import com.pi2.AutoEletricaApi.data.OrdemServico;
import com.pi2.AutoEletricaApi.service.OrdemServicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrdemServicoController {
    @Autowired
    private OrdemServicoService ordemServicoService;
    
        @GetMapping("/ordemservico")
    public List<OrdemServico> getOrdemServicos() {
        return ordemServicoService.getOrdemServicos();
    }
    
        @PostMapping("/ordemservico")
    public OrdemServico saveOrdemServico(@RequestBody OrdemServico ordemServicoObj) {
        ordemServicoService.saveOrdemServico(ordemServicoObj);
        return ordemServicoObj;
    }
    
    
        @GetMapping("/ordemservico/{id}")
    public OrdemServico getOrdemServico(@PathVariable int id) {
        OrdemServico ordemServicoObj = ordemServicoService.getOrdemServico(id);
        if (ordemServicoObj == null) {
            throw new RuntimeException("Ordem de Servico nao encontrado");
        }
        return ordemServicoObj;
    }
    
        @DeleteMapping("/ordemservico/{id}")
    public String deleteOrdemServico(@PathVariable int id) {
        ordemServicoService.deleteOrdemServico(id);
        return "Ordem de servico deletada com o id: " + id;
    }

        @PutMapping("/ordemservico")
    public OrdemServico updateOrdemServico(@RequestBody OrdemServico ordemServicoObj) {
       ordemServicoService.saveOrdemServico(ordemServicoObj);
        return ordemServicoObj;
    }
}

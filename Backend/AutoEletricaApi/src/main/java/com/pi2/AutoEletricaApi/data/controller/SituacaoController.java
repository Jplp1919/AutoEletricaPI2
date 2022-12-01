package com.pi2.AutoEletricaApi.data.controller;

import com.pi2.AutoEletricaApi.data.Situacao;
import com.pi2.AutoEletricaApi.service.SituacaoService;
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
public class SituacaoController {

    @Autowired
    private SituacaoService situacaoService;

    @GetMapping("/situacao")
    public List<Situacao> getSituacaos() {
        return situacaoService.getSituacoes();
    }

    @PostMapping("/situacao")
    public Situacao saveSituacao(@RequestBody Situacao situacaoObj) {
        situacaoService.saveSituacao(situacaoObj);
        return situacaoObj;
    }

    @GetMapping("/situacao/{id}")
    public Situacao getSituacao(@PathVariable int id) {
        Situacao situacaoObj = situacaoService.getSituacao(id);
        if(situacaoObj == null){
        throw new RuntimeException("Situacao nao encontrada");
        }
        return situacaoObj;
    }

    @DeleteMapping("/situacao/{id}")
    public String deleteSituacao(@PathVariable int id) {
        situacaoService.deleteSituacao(id);
        return "Pessoa deletada com o id: " + id;
    }

    @PutMapping("/situacao")
    public Situacao updateSituacao(@RequestBody Situacao situacaoObj){
     situacaoService.saveSituacao(situacaoObj);
     return situacaoObj;
    }
    
    
}

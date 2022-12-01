package com.pi2.AutoEletricaApi.data.controller;

import com.pi2.AutoEletricaApi.data.Veiculo;
import com.pi2.AutoEletricaApi.service.VeiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/veiculo")
    public List<Veiculo> getVeiculos() {
        return veiculoService.getVeiculos();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/veiculo")
    public Veiculo saveVeiculo(@RequestBody Veiculo veiculoObj) {
        veiculoService.saveVeiculo(veiculoObj);
        return veiculoObj;
    }

    @GetMapping("/veiculo/{id}")
    public Veiculo getVeiculo(@PathVariable int id) {
        Veiculo veiculoObj = veiculoService.getVeiculo(id);
        if (veiculoObj == null) {
            throw new RuntimeException("Veiculo nao encontrado");
        }
        return veiculoObj;
    }

    @DeleteMapping("/veiculo/{id}")
    public String deleteVeiculo(@PathVariable int id) {
        veiculoService.deleteVeiculo(id);
        return "Veiculo deletado com o id: " + id;
    }

    @PutMapping("/veiculo")
    public Veiculo updateVeiculo(@RequestBody Veiculo veiculoObj) {
        veiculoService.saveVeiculo(veiculoObj);
        return veiculoObj;
    }
}

package com.pi2.AutoEletricaApi.data.controller;


import com.pi2.AutoEletricaApi.data.Adiministrador;
import com.pi2.AutoEletricaApi.service.AdiministradorService;
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
public class AdiministradorController {
    
    @Autowired
    private AdiministradorService adiministradorService;
    
        @GetMapping("/adiministrador")
    public List<Adiministrador> getAdiministradores() {
        return adiministradorService.getAdiministradores();
    }
    
        @PostMapping("/adiministrador")
    public Adiministrador saveAdiministrador(@RequestBody Adiministrador adiministradorObj) {
        adiministradorService.saveAdiministrador(adiministradorObj);
        return adiministradorObj;
    }

    @GetMapping("/adiministrador/{id}")
    public Adiministrador getAdiministrador(@PathVariable int id) {
        Adiministrador adiministradorObj = adiministradorService.getAdiministrador(id);
        if (adiministradorObj == null) {
            throw new RuntimeException("Adiministrador nao encontrado");
        }
        return adiministradorObj;
    }

        @DeleteMapping("/adiministrador/{id}")
    public String deleteAdiministrador(@PathVariable int id) {
        adiministradorService.deleteAdiministrador(id);
        return "Adiministrador deletada com o id: " + id;
    }
    
                @PutMapping("/adiministrador")
    public Adiministrador updateAdiministrador(@RequestBody Adiministrador adiministradorObj) {
       adiministradorService.saveAdiministrador(adiministradorObj);
        return adiministradorObj;
    }
}

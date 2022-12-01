package com.pi2.AutoEletricaApi.data.controller;

import com.pi2.AutoEletricaApi.data.NotaFiscal;
import com.pi2.AutoEletricaApi.service.NotaFiscalService;
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
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService notaFiscalService;

    @GetMapping("/notafiscal")
    public List<NotaFiscal> getNotasFiscais() {
        return notaFiscalService.getNotasFiscais();
    }

    @PostMapping("/notafiscal")
    public NotaFiscal saveNotaFiscal(@RequestBody NotaFiscal notaFiscalObj) {
        notaFiscalService.saveNotaFiscal(notaFiscalObj);
        return notaFiscalObj;
    }

    @GetMapping("/notafiscal/{id}")
    public NotaFiscal getNotaFiscal(@PathVariable int id) {
        NotaFiscal notaFiscalObj = notaFiscalService.getNotaFiscal(id);
        if (notaFiscalObj == null) {
            throw new RuntimeException("Nota Fiscal nao encontrada");
        }
        return notaFiscalObj;
    }

    @DeleteMapping("/notafiscal/{id}")
    public String deleteNotaFiscal(@PathVariable int id) {
        notaFiscalService.deleteNotaFiscal(id);
        return "Nota Fiscal deletada com o id: " + id;
    }

    @PutMapping("/notafiscal")
    public NotaFiscal updateNotaFiscal(@RequestBody NotaFiscal notaFiscalObj) {
        notaFiscalService.saveNotaFiscal(notaFiscalObj);
        return notaFiscalObj;
    }

}

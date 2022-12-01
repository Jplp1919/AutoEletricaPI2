package com.pi2.AutoEletricaApi.data.controller;

import com.pi2.AutoEletricaApi.data.Pessoa;
import com.pi2.AutoEletricaApi.service.PessoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/pessoa")
    public List<Pessoa> getPessoas() {
        return pessoaService.getPessoas();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/pessoa")
    public Pessoa savePessoa(@RequestBody Pessoa pessoaObj) {
        pessoaService.savePessoa(pessoaObj);
        return pessoaObj;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/pessoa/{id}")
    public Pessoa getPessoa(@PathVariable int id) {
        Pessoa pessoaObj = pessoaService.getPessoa(id);
        if (pessoaObj == null) {
            throw new RuntimeException("Pessoa nao encontrada");
        }
        return pessoaObj;
    }

    @GetMapping("/pessoa/nome/{nome}")
    public List<Pessoa> getPessoaPorNome(@PathVariable String nome) {
        List<Pessoa> pessoaObj = pessoaService.getPessoaPorNome(nome);
        if (pessoaObj == null) {
            throw new RuntimeException("Pessoa nao encontrada");
        }
        return pessoaObj;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/pessoa/{id}")
    public String deletePessoa(@PathVariable int id) {
        pessoaService.deletePessoa(id);
        return "Pessoa deletada com o id: " + id;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/pessoa")
    public ResponseEntity updatePessoa(@RequestBody Pessoa pessoaObj) {
         
        try{
           pessoaService.savePessoa(pessoaObj);  
           return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
       
       
    }
}

package com.pi2.AutoEletricaApi.data.controller;

import com.pi2.AutoEletricaApi.data.Produto;
import com.pi2.AutoEletricaApi.service.ProdutoService;
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
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produto")
    public List<Produto> getProdutos() {
        return produtoService.getProdutos();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/produto")
    public Produto saveProduto(@RequestBody Produto produtoObj) {
        produtoService.saveProduto(produtoObj);
        return produtoObj;
    }

    @GetMapping("/produto/{id}")
    public Produto getProduto(@PathVariable int id) {
        Produto produtoObj = produtoService.getProduto(id);
        if (produtoObj == null) {
            throw new RuntimeException("Produto nao encontrado");
        }
        return produtoObj;
    }

    @DeleteMapping("/produto/{id}")
    public String deleteProduto(@PathVariable int id) {
        produtoService.deleteProduto(id);
        return "Produto deletado com o id: " + id;
    }

    @PutMapping("/produto")
    public Produto updateProduto(@RequestBody Produto produtoObj) {
        produtoService.saveProduto(produtoObj);
        return produtoObj;
    }

}

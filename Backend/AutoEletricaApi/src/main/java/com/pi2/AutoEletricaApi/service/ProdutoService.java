package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.Produto;
import java.util.List;


public interface ProdutoService {
    
    List<Produto> getProdutos();

    Produto getProduto(int id);

    void saveProduto(Produto produto);

    void deleteProduto(int id);
}

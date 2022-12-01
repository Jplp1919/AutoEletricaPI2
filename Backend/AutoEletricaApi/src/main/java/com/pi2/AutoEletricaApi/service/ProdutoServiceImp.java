package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.Produto;
import com.pi2.AutoEletricaApi.data.dao.ProdutoDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoServiceImp implements ProdutoService {

    @Autowired
    private ProdutoDao produtoDao;

    @Transactional
    @Override
    public List<Produto> getProdutos() {
        return produtoDao.getProdutos();
    }

    @Transactional
    @Override
    public Produto getProduto(int id) {
        return produtoDao.getProduto(id);
    }

    @Transactional
    @Override
    public void saveProduto(Produto produto) {
        produtoDao.saveProduto(produto);
    }

    @Transactional
    @Override
    public void deleteProduto(int id) {
       produtoDao.deleteProduto(id);
    }
}

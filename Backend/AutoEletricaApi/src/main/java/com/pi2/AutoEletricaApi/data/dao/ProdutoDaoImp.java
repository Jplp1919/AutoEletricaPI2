package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDaoImp implements ProdutoDao {

    
    private EntityManager manager;

    @Autowired
    public ProdutoDaoImp(EntityManager manager) {
        this.manager = manager;
    }
    
    

    @Override
    public List<Produto> getProdutos() {
        Session currentSession = manager.unwrap(Session.class);
        Query<Produto> query = currentSession.createQuery("from Produto", Produto.class);
        List<Produto> lista = query.getResultList();
        return lista;
    }

    @Override
    public Produto getProduto(int id) {
        Session currentSession = manager.unwrap(Session.class);
        Produto produtoObj = currentSession.get(Produto.class, id);
        return produtoObj;
    }

    @Override
    public void saveProduto(Produto produto) {
        Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(produto);
    }

    @Override
    public void deleteProduto(int id) {
        Session currentSession = manager.unwrap(Session.class);
        Produto produtoObj = currentSession.get(Produto.class, id);
        currentSession.delete(produtoObj);
    }

}

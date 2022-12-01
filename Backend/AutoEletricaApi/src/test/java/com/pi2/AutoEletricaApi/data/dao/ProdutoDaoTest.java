/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Produto;
import com.pi2.AutoEletricaApi.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ProdutoDaoTest {

    private ProdutoDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new ProdutoDaoImp(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();

    }

    @Test
    void deveEncontrarProdutoCadastrado() {
        Produto produto = new Produto();
        produto.setIdproduto(134);
        produto.setNome("Nome de Testes");
        produto.setValor(18.0);
        produto.setNcm(11);
        produto.setEstoque(12);
        produto.setSituacao_idsituacao(1);
        dao.saveProduto(produto);

        Produto salvo = dao.getProduto(produto.getIdproduto());
        assertNotNull(salvo);
        assertEquals(134, salvo.getIdproduto());
        assertEquals("Nome de Testes", salvo.getNome());
        assertEquals(18.0, salvo.getValor());
        assertEquals(11, salvo.getNcm());
        assertEquals(12, salvo.getEstoque());
        assertEquals(1, salvo.getSituacao_idsituacao());
    }

    @Test
    void deveCadastrarUmProduto() {
        Produto produto = new Produto();
        produto.setIdproduto(134);
        produto.setNome("Nome de Testes");
        produto.setValor(18.0);
        produto.setNcm(11);
        produto.setEstoque(12);
        produto.setSituacao_idsituacao(1);
        dao.saveProduto(produto);

        Produto salvo = dao.getProduto(produto.getIdproduto());
        assertNotNull(salvo);
    }

    @Test
    void naoDeveEncontrarUmProdutoNaoCadastrado() {

        Produto salvo = dao.getProduto(9999);
        assertNull(salvo);
    }
    
    @Test
    void deveAtualizatUmProduto(){
        Produto produto = new Produto();
        produto.setIdproduto(134);
        produto.setNome("Nome de Testes");
        produto.setValor(18.0);
        produto.setNcm(11);
        produto.setEstoque(12);
        produto.setSituacao_idsituacao(1);
        dao.saveProduto(produto);
        
        produto.setNome("Esperado");
        produto.setValor(15.0);
        
       dao.saveProduto(produto);
        Produto salvo = dao.getProduto(produto.getIdproduto());
        assertEquals("Esperado", salvo.getNome());
        assertEquals(15.0, salvo.getValor());
    }

    @Test
    void deveDeletarUmProduto() {
        Produto produto = new Produto();
        produto.setIdproduto(134);
        produto.setNome("Nome de Testes");
        produto.setValor(18.0);
        produto.setNcm(11);
        produto.setEstoque(12);
        produto.setSituacao_idsituacao(1);
        dao.saveProduto(produto);

        dao.deleteProduto(produto.getIdproduto());
        Produto salvo = dao.getProduto(produto.getIdproduto());
        
        assertNull(salvo);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.NotaFiscal;
import com.pi2.AutoEletricaApi.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Usuario
 */
public class NotaFiscalDaoTest {
  
    private NotaFiscalDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new NotaFiscalDaoImp(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();

    }

    @Test
    void deveEncontrarNotaFiscalCadastrado() {
        NotaFiscal notaFiscal= new NotaFiscal();
        notaFiscal.setIdnotafiscal(125);
        notaFiscal.setChavenfe(555);
        notaFiscal.setValor(1345.0);
        notaFiscal.setPessoa_idcliente(1);
        notaFiscal.setOrdemservico_idordemservico(1);
        notaFiscal.setProduto_idproduto(1);
        
        dao.saveNotaFiscal(notaFiscal);

        NotaFiscal salvo = dao.getNotaFiscal(notaFiscal.getIdnotafiscal());
        assertNotNull(salvo);
        assertEquals(125, salvo.getIdnotafiscal());
        assertEquals(555, salvo.getChavenfe());
        assertEquals(1345.0, salvo.getValor());
        assertEquals(1, salvo.getOrdemservico_idordemservico());
        assertEquals(1, salvo.getProduto_idproduto());
        assertEquals(1, salvo.getPessoa_idcliente());
        
    }

    @Test
    void deveCadastrarUmNotaFiscal() {
        NotaFiscal notaFiscal= new NotaFiscal();
        notaFiscal.setIdnotafiscal(125);
        notaFiscal.setChavenfe(555);
        notaFiscal.setValor(1345.0);
        notaFiscal.setPessoa_idcliente(1);
        notaFiscal.setOrdemservico_idordemservico(1);
        notaFiscal.setProduto_idproduto(1);
        
        dao.saveNotaFiscal(notaFiscal);

        NotaFiscal salvo = dao.getNotaFiscal(notaFiscal.getIdnotafiscal());
        assertNotNull(salvo);
    }

    @Test
    void naoDeveEncontrarUmNotaFiscalNaoCadastrado() {

        NotaFiscal salvo = dao.getNotaFiscal(9999);
        assertNull(salvo);
    }
    
    @Test
    void deveAtualizatUmNotaFiscal(){
         NotaFiscal notaFiscal= new NotaFiscal();
        notaFiscal.setIdnotafiscal(125);
        notaFiscal.setChavenfe(555);
        notaFiscal.setValor(1345.0);
        notaFiscal.setPessoa_idcliente(1);
        notaFiscal.setOrdemservico_idordemservico(1);
        notaFiscal.setProduto_idproduto(1);
        
        dao.saveNotaFiscal(notaFiscal);

        
        notaFiscal.setChavenfe(321);
        notaFiscal.setValor(158.0);
        
       dao.saveNotaFiscal(notaFiscal);
        NotaFiscal salvo = dao.getNotaFiscal(notaFiscal.getIdnotafiscal());
        assertEquals(321, salvo.getChavenfe());
        assertEquals(158.0, salvo.getValor());
    }

    @Test
    void deveDeletarUmNotaFiscal() {
        NotaFiscal notaFiscal= new NotaFiscal();
        notaFiscal.setIdnotafiscal(125);
        notaFiscal.setChavenfe(555);
        notaFiscal.setValor(1345.0);
        notaFiscal.setPessoa_idcliente(1);
        notaFiscal.setOrdemservico_idordemservico(1);
        notaFiscal.setProduto_idproduto(1);
        
        dao.saveNotaFiscal(notaFiscal);


        dao.deleteNotaFiscal(notaFiscal.getIdnotafiscal());
        NotaFiscal salvo = dao.getNotaFiscal(notaFiscal.getIdnotafiscal());
        
        assertNull(salvo);
    }
    

    
}

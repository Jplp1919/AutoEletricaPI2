package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Situacao;
import com.pi2.AutoEletricaApi.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class SituacaoDaoTest {

    private SituacaoDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new SituacaoDaoImp(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();

    }

    @Test
    void deveEncontrarSituacaoCadastrada() {
        Situacao situacao = new Situacao();
        situacao.setAtivo(15);

        dao.saveSituacao(situacao);

        Situacao salvo = dao.getSituacao(situacao.getIdsituacao());
        assertNotNull(salvo);
        assertEquals(15, salvo.getAtivo());

    }

    @Test
    void deveCadastrarUmaSituacao() {
        Situacao situacao = new Situacao();
        situacao.setId_situacao(125);
        situacao.setAtivo(15);

        dao.saveSituacao(situacao);
        Situacao salvo = dao.getSituacao(situacao.getIdsituacao());
        assertNotNull(salvo);
    }

    @Test
    void naoDeveEncontrarUmaSituacaoNaoCadastrada() {

        Situacao salvo = dao.getSituacao(9999);
        assertNull(salvo);
    }

    @Test
    void deveAtualizatUmVeiculo() {
        Situacao situacao = new Situacao();
        situacao.setId_situacao(125);
        situacao.setAtivo(15);

        dao.saveSituacao(situacao);

        situacao.setAtivo(24);

        dao.saveSituacao(situacao);
        Situacao salvo = dao.getSituacao(situacao.getIdsituacao());
        assertEquals(24, salvo.getAtivo());
    }

    @Test
    void deveDeletarUmVeiculo() {
        Situacao situacao = new Situacao();
        situacao.setId_situacao(125);
        situacao.setAtivo(15);

        dao.saveSituacao(situacao);

        dao.deleteSituacao(situacao.getIdsituacao());
        Situacao salvo = dao.getSituacao(situacao.getIdsituacao());

        assertNull(salvo);
    }

}

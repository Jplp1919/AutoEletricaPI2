package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Adiministrador;
import com.pi2.AutoEletricaApi.util.JPAUtil;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class AdiministradorDaoTest {

    private AdiministradorDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new AdiministradorDaoImp(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();

    }

    @Test
    void deveriaCadastrarUmAdiministrador() {
        Adiministrador adiministrador = new Adiministrador();
        adiministrador.setIdadiministrador(12222);
        adiministrador.setDatadeadimissao(LocalDate.of(2016, 11, 01));
        adiministrador.setCargo("Chefe");
        adiministrador.setSalario(180.0);
        adiministrador.setSetor("Setor 1");
        adiministrador.setPessoa_idcliente(1);
        adiministrador.setSituacao_idsituacao(1);

        dao.saveAdiministrador(adiministrador);

        Adiministrador salvo = dao.getAdiministrador(adiministrador.getIdadiministrador());
        assertNotNull(salvo);
    }

    @Test
    void deveriaAtualizarUmAdiministrador() {
        Adiministrador adiministrador = new Adiministrador();
        adiministrador.setIdadiministrador(12222);
        adiministrador.setDatadeadimissao(LocalDate.of(2016, 11, 01));
        adiministrador.setCargo("Chefe");
        adiministrador.setSalario(180.0);
        adiministrador.setSetor("Setor 1");
        adiministrador.setPessoa_idcliente(1);
        adiministrador.setSituacao_idsituacao(1);

        dao.saveAdiministrador(adiministrador);

        adiministrador.setCargo("Esperado");
        adiministrador.setSalario(28.0);

        dao.saveAdiministrador(adiministrador);

        Adiministrador salvo = dao.getAdiministrador(adiministrador.getIdadiministrador());
        assertEquals("Esperado", salvo.getCargo());
        assertEquals(28, salvo.getSalario());
    }

    @Test
    void deveEncontrarAdiministradorCadastrado() {
        Adiministrador adiministrador = new Adiministrador();
        adiministrador.setIdadiministrador(12222);
        adiministrador.setDatadeadimissao(LocalDate.of(2016, 11, 01));
        adiministrador.setCargo("Chefe");
        adiministrador.setSalario(180.0);
        adiministrador.setSetor("Setor 1");
        adiministrador.setPessoa_idcliente(1);
        adiministrador.setSituacao_idsituacao(1);

        dao.saveAdiministrador(adiministrador);
        Adiministrador salvo = dao.getAdiministrador(adiministrador.getIdadiministrador());
        assertNotNull(salvo);
        assertEquals(12222, salvo.getIdadiministrador());
        assertEquals(LocalDate.of(2016, 11, 01), salvo.getDatadeadimissao());
        assertEquals("Chefe", salvo.getCargo());
        assertEquals(180.0, salvo.getSalario());
        assertEquals("Setor 1", salvo.getSetor());
        assertEquals(1, salvo.getPessoa_idcliente());
        assertEquals(1, salvo.getSituacao_idsituacao());

    }

    @Test
    void naoDeveEncontrarAdiministradorNaoCadastrado() {
        Adiministrador salvo = dao.getAdiministrador(99999);
        assertNull(salvo);
    }

    @Test
    void deveRemoverUmAdiministrador() {
        Adiministrador adiministrador = new Adiministrador();
        adiministrador.setIdadiministrador(12222);
        adiministrador.setDatadeadimissao(LocalDate.of(2016, 11, 01));
        adiministrador.setCargo("Chefe");
        adiministrador.setSalario(180.0);
        adiministrador.setSetor("Setor 1");
        adiministrador.setPessoa_idcliente(1);
        adiministrador.setSituacao_idsituacao(1);

        dao.saveAdiministrador(adiministrador);
        
        dao.deleteAdiministrador(adiministrador.getIdadiministrador());
        Adiministrador salvo = dao.getAdiministrador(adiministrador.getIdadiministrador());
        assertNull(salvo);
    }

}

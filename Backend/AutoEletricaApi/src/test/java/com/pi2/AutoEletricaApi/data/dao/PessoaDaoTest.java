package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Pessoa;
import com.pi2.AutoEletricaApi.data.Situacao;
import com.pi2.AutoEletricaApi.util.JPAUtil;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.apache.catalina.Manager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class PessoaDaoTest {

    private PessoaDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new PessoaDaoImp(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();

    }

    @Test
    void deveriaCadastrarUmaPessoa() {
        Situacao s = new Situacao();
        s.setId_situacao(983);
        s.setAtivo(2);
        em.persist(s);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste");
        pessoa.setIdade(18);
        pessoa.setCpf("00890122234");
        pessoa.setEmail("email@mail.com");
        pessoa.setSexo("sim");
        pessoa.setRg("09121233");
        pessoa.setSituacao_idsituacao(s.getIdsituacao());

        dao.savePessoa(pessoa);

        Pessoa salvo = dao.getPessoa(pessoa.getIdcliente());
        assertNotNull(salvo);
    }

    @Test
    void deveriaAtualizarUmaPessoa() {
        Situacao s = new Situacao();
        s.setAtivo(2);
        em.persist(s);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste");
        pessoa.setIdade(18);
        pessoa.setCpf("0004222234");
        pessoa.setEmail("email@mail.com");
        pessoa.setSexo("sim");
        pessoa.setRg("5121233");
        pessoa.setSituacao_idsituacao(s.getIdsituacao());
        dao.savePessoa(pessoa);

        pessoa.setNome("Esperado");
        pessoa.setIdade(28);

        dao.savePessoa(pessoa);

        Pessoa salvo = dao.getPessoa(pessoa.getIdcliente());
        assertEquals("Esperado", salvo.getNome());
        assertEquals(28, salvo.getIdade());
    }

    @Test
    void deveRetornarPessoasCadastradas() {
        Situacao s = new Situacao();
        s.setAtivo(2);
        em.persist(s);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste");
        pessoa.setIdade(18);
        pessoa.setCpf("53011122234");
        pessoa.setEmail("email@mail.com");
        pessoa.setSexo("sim");
        pessoa.setRg("1031233");
        pessoa.setSituacao_idsituacao(s.getIdsituacao());

        dao.savePessoa(pessoa);
        assertNotNull(dao.getPessoas());
    }

    @Test
    void deveRetornarPessoaCadastradaPeloNome() {
        Situacao s = new Situacao();
        s.setAtivo(2);
        em.persist(s);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste");
        pessoa.setIdade(18);
        pessoa.setCpf("05011122234");
        pessoa.setEmail("email@mail.com");
        pessoa.setSexo("sim");
        pessoa.setRg("7121233");
        pessoa.setSituacao_idsituacao(s.getIdsituacao());

        dao.savePessoa(pessoa);
       List <Pessoa> salvo = dao.getPessoaPorNome("Teste");
        assertNotNull(salvo);
    }

    @Test
    void deveRetornarDadosDaPessoaCadastradaCorretamente() {
        Situacao s = new Situacao();
        s.setId_situacao(983);
        s.setAtivo(2);
        em.persist(s);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste");
        pessoa.setIdade(18);
        pessoa.setCpf("55411122234");
        pessoa.setEmail("email@mail.com");
        pessoa.setSexo("sim");
        pessoa.setRg("9121233");
        pessoa.setSituacao_idsituacao(s.getIdsituacao());

        dao.savePessoa(pessoa);

        Pessoa salvo = dao.getPessoa(pessoa.getIdcliente());
        assertNotNull(salvo);
        assertEquals("Teste", salvo.getNome());
        assertEquals(18, salvo.getIdade());
        assertEquals("55411122234", salvo.getCpf());
        assertEquals("email@mail.com", salvo.getEmail());
        assertEquals("sim", pessoa.getSexo());
        assertEquals("9121233", pessoa.getRg());
        assertEquals(s.getIdsituacao(), pessoa.getSituacao_idsituacao());
    }

    @Test
    void naoDeveRetornarUmaPessoaNaoCadastrada() {
        Pessoa pessoa = dao.getPessoa(99999);
        assertNull(pessoa);

    }

    @Test
    void deveDeletarUmaPessoa() {
        Situacao s = new Situacao();
        s.setId_situacao(983);
        s.setAtivo(2);
        em.persist(s);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste");
        pessoa.setIdade(18);
        pessoa.setCpf("55411122234");
        pessoa.setEmail("email@mail.com");
        pessoa.setSexo("sim");
        pessoa.setRg("9121233");
        pessoa.setSituacao_idsituacao(s.getIdsituacao());

        dao.savePessoa(pessoa);
        dao.deletePessoa(pessoa.getIdcliente());
        Pessoa salvo = dao.getPessoa(pessoa.getIdcliente());
        assertNull(salvo);

    }

}

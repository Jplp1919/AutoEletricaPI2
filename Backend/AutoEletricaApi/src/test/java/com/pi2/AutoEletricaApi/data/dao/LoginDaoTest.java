package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Login;
import com.pi2.AutoEletricaApi.data.Pessoa;
import com.pi2.AutoEletricaApi.data.Situacao;
import com.pi2.AutoEletricaApi.util.JPAUtil;
import javax.persistence.EntityManager;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginDaoTest {

    private LoginDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new LoginDaoImp(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();
    }

    @Test
    void deveriaCadastrarUmLogin() {
        Situacao s = new Situacao();
        s.setId_situacao(983);
        s.setAtivo(2);
        em.persist(s);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("TesteName");
        pessoa.setIdade(18);
        pessoa.setCpf("00890122234");
        pessoa.setEmail("email@mail.com");
        pessoa.setSexo("sim");
        pessoa.setRg("09121233");
        pessoa.setSituacao_idsituacao(s.getIdsituacao());

        em.persist(pessoa);

        Login login = new Login();
        login.setUsuario("testeUser");
        login.setSenha("senha");
        login.setPessoa_idcliente(pessoa.getIdcliente());

        dao.saveLogin(login);

        Login salvo = dao.getLogin(login.getIdlogin());
        assertNotNull(salvo);
    }

    @Test
    void deveRetornarUmLoginPelaPessoa() {
        Situacao s = new Situacao();
        s.setId_situacao(983);
        s.setAtivo(2);
        em.persist(s);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("TesteName");
        pessoa.setIdade(18);
        pessoa.setCpf("00890122234");
        pessoa.setEmail("email@mail.com");
        pessoa.setSexo("sim");
        pessoa.setRg("09121233");
        pessoa.setSituacao_idsituacao(s.getIdsituacao());

        em.persist(pessoa);

        Login login = new Login();
        login.setUsuario("testeUser");
        login.setSenha("senha");
        login.setPessoa_idcliente(pessoa.getIdcliente());

        dao.saveLogin(login);

        Login salvo = dao.getLoginFromPessoa(pessoa.getIdcliente());
        assertNotNull(salvo);
    }

    
    @Test
    void deveRetornarUmLogin(){
         Situacao s = new Situacao();
        s.setId_situacao(983);
        s.setAtivo(2);
        em.persist(s);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("TesteName");
        pessoa.setIdade(18);
        pessoa.setCpf("00890122234");
        pessoa.setEmail("email@mail.com");
        pessoa.setSexo("sim");
        pessoa.setRg("09121233");
        pessoa.setSituacao_idsituacao(s.getIdsituacao());

        em.persist(pessoa);

        Login login = new Login();
        login.setUsuario("testeUser");
        login.setSenha("senha");
        login.setPessoa_idcliente(pessoa.getIdcliente());

        dao.saveLogin(login);

        Login salvo = dao.getLogin(login.getIdlogin());
        assertNotNull(salvo);
        
        
    }
    
    @Test
    void deveDeletarUmLogin() {
        Situacao s = new Situacao();
        s.setId_situacao(983);
        s.setAtivo(2);
        em.persist(s);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("TesteName");
        pessoa.setIdade(18);
        pessoa.setCpf("00890122234");
        pessoa.setEmail("email@mail.com");
        pessoa.setSexo("sim");
        pessoa.setRg("09121233");
        pessoa.setSituacao_idsituacao(s.getIdsituacao());

        em.persist(pessoa);

        Login login = new Login();
        login.setUsuario("testeUser");
        login.setSenha("senha");
        login.setPessoa_idcliente(pessoa.getIdcliente());

        dao.saveLogin(login);
        dao.deleteLogin(login.getIdlogin());
        Login salvo = dao.getLogin(login.getIdlogin());
        assertNull(salvo);

    }

    @Test
    void naoDeveRetornarUmLoginNaoCadastrado(){
        assertNull(dao.getLogin(999));
    }
    
    @Test 
    void deveEncontrarUmLoginPeloUsuario(){
        Situacao s = new Situacao();
        s.setId_situacao(983);
        s.setAtivo(2);
        em.persist(s);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("TesteName");
        pessoa.setIdade(18);
        pessoa.setCpf("00890122234");
        pessoa.setEmail("email@mail.com");
        pessoa.setSexo("sim");
        pessoa.setRg("09121233");
        pessoa.setSituacao_idsituacao(s.getIdsituacao());

        em.persist(pessoa);

        Login login = new Login();
        login.setUsuario("testeUser");
        login.setSenha("senha");
        login.setPessoa_idcliente(pessoa.getIdcliente());
        
        dao.saveLogin(login);       
        Login salvo = dao.getLoginByUser("testeUser", "senha");
        assertNotNull(salvo);
    }
}

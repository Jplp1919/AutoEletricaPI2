package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Veiculo;
import com.pi2.AutoEletricaApi.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


public class VeiculoDaoTest {
    
    private VeiculoDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new VeiculoDaoImp(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();

    }

    @Test
    void deveEncontrarVeiculoCadastrado() {
        Veiculo veiculo= new Veiculo();
        veiculo.setIdveiculo(125);
        veiculo.setTipoveiculo("carro esportivo");
        veiculo.setDescricao("Usado");
        veiculo.setMarca("Toy yoda");
        veiculo.setPlaca("acab11");
        veiculo.setQuilometragem(1200);
        veiculo.setPessoa_idcliente(1);
        veiculo.setSituacao_idsituacao(1);
        
        dao.saveVeiculo(veiculo);

        Veiculo salvo = dao.getVeiculo(veiculo.getIdveiculo());
        assertNotNull(salvo);
        assertEquals(125, salvo.getIdveiculo());
        assertEquals("carro esportivo", salvo.getTipoveiculo());
        assertEquals("Usado", salvo.getDescricao());
        assertEquals("Toy yoda", salvo.getMarca());
        assertEquals("acab11", salvo.getPlaca());
        assertEquals(1, salvo.getPessoa_idcliente());
        assertEquals(1, salvo.getSituacao_idsituacao());
    }

    @Test
    void deveCadastrarUmVeiculo() {
        Veiculo veiculo= new Veiculo();
        veiculo.setIdveiculo(125);
        veiculo.setTipoveiculo("carro esportivo");
        veiculo.setDescricao("Usado");
        veiculo.setMarca("Toy yoda");
        veiculo.setPlaca("acab11");
        veiculo.setQuilometragem(1200);
        veiculo.setPessoa_idcliente(1);
        veiculo.setSituacao_idsituacao(1);
        
        dao.saveVeiculo(veiculo);
        Veiculo salvo = dao.getVeiculo(veiculo.getIdveiculo());
        assertNotNull(salvo);
    }

    @Test
    void naoDeveEncontrarUmVeiculoNaoCadastrado() {

        Veiculo salvo = dao.getVeiculo(9999);
        assertNull(salvo);
    }
    
    @Test
    void deveAtualizatUmVeiculo(){
        Veiculo veiculo= new Veiculo();
        veiculo.setIdveiculo(125);
        veiculo.setTipoveiculo("carro esportivo");
        veiculo.setDescricao("Usado");
        veiculo.setMarca("Toy yoda");
        veiculo.setPlaca("acab11");
        veiculo.setQuilometragem(1200);
        veiculo.setPessoa_idcliente(1);
        veiculo.setSituacao_idsituacao(1);
        
        dao.saveVeiculo(veiculo);
        
        veiculo.setMarca("Toyota");
        veiculo.setDescricao("Esperado");
        
       dao.saveVeiculo(veiculo);
        Veiculo salvo = dao.getVeiculo(veiculo.getIdveiculo());
        assertEquals("Toyota", salvo.getMarca());
        assertEquals("Esperado", salvo.getDescricao());
    }

    @Test
    void deveDeletarUmVeiculo() {
        Veiculo veiculo= new Veiculo();
        veiculo.setIdveiculo(125);
        veiculo.setTipoveiculo("carro esportivo");
        veiculo.setDescricao("Usado");
        veiculo.setMarca("Toy yoda");
        veiculo.setPlaca("acab11");
        veiculo.setQuilometragem(1200);
        veiculo.setPessoa_idcliente(1);
        veiculo.setSituacao_idsituacao(1);
        
        dao.saveVeiculo(veiculo);

        dao.deleteVeiculo(veiculo.getIdveiculo());
        Veiculo salvo = dao.getVeiculo(veiculo.getIdveiculo());
        
        assertNull(salvo);
    }
}

package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Login;
import com.pi2.AutoEletricaApi.data.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImp implements LoginDao {

    private EntityManager manager;

    @Autowired
    public LoginDaoImp(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Login> getLogins() {
        Session currentSession = manager.unwrap(Session.class);
        Query<Login> query = currentSession.createQuery("from Login", Login.class);
        List<Login> lista = query.getResultList();
        return lista;
    }

    @Override
    public Login getLogin(int id) {
        Session currentSession = manager.unwrap(Session.class);
        Login loginObj = currentSession.get(Login.class, id);
        return loginObj;
    }

    @Override
    public void saveLogin(Login login) {
        Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(login);
    }

    @Override
    public void deleteLogin(int id) {
        Session currentSession = manager.unwrap(Session.class);
        Login loginObj = currentSession.get(Login.class, id);
        currentSession.delete(loginObj);
    }

    @Override
    public Login getLoginFromPessoa(int id) {
     Session currentSession = manager.unwrap(Session.class);
     Login login = (Login) manager.createQuery("SELECT l FROM Login l WHERE l.pessoa_idcliente LIKE : id").setParameter("id",id ).getSingleResult();
        return login;
    
    }

    @Override
    public Login getLoginByUser(String user, String senha) {
     Session currentSession = manager.unwrap(Session.class);
        //("SELECT l FROM Login l WHERE l.usuario LIKE : user and l.senha LIKE senha" 
     try{
     Login login = (Login) manager.createQuery("SELECT l FROM Login l WHERE l.usuario = :user and l.senha = :senha").setParameter("user",user ).setParameter("senha", senha).getSingleResult();
        return login;}
     catch(NoResultException e){
         System.out.println(e);
        
     }
      return null;
    }

}

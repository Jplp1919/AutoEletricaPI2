package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.Login;
import com.pi2.AutoEletricaApi.data.dao.LoginDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public List<Login> getLogins() {
        return loginDao.getLogins();
    }

    @Override
    public Login getLogin(int id) {
        return loginDao.getLogin(id);
    }

    @Override
    public void saveLogin(Login login) {
        loginDao.saveLogin(login);
    }

    @Override
    public void deleteLogin(int id) {
        loginDao.deleteLogin(id);
    }

    @Override
    public Login getLoginFromPessoa(int id) {
        return loginDao.getLoginFromPessoa(id);
    }

    @Override
    public Login getLoginByUser(String user, String senha) {
     return loginDao.getLoginByUser(user, senha);
    }

}

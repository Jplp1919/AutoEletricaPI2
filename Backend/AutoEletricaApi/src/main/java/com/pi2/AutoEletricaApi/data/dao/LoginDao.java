package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Login;
import java.util.List;


public interface LoginDao {
    
    List<Login> getLogins();

    Login getLoginFromPessoa(int id);
    
    Login getLogin(int id);
    
    Login getLoginByUser(String user, String senha);

    void saveLogin(Login login);

    void deleteLogin(int id);
}

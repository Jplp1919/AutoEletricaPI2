package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.Login;
import java.util.List;

public interface LoginService {

    List<Login> getLogins();

    Login getLogin(int id);

    void saveLogin(Login login);

    Login getLoginByUser(String user, String senha);
    
    Login getLoginFromPessoa(int id);

    void deleteLogin(int id);
}

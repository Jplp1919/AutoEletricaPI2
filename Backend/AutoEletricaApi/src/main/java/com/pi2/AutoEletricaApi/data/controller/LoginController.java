package com.pi2.AutoEletricaApi.data.controller;

import com.pi2.AutoEletricaApi.data.Login;
import com.pi2.AutoEletricaApi.service.LoginService;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /*    @GetMapping("/login")
    public List<Login> getLogins() {
        return loginService.getLogins();
    }*/
    @PostMapping("/login")
    public Login saveLogin(@RequestBody Login loginObj) {
        loginService.saveLogin(loginObj);
        return loginObj;
    }

    @GetMapping("/login/{id}")
    public Login getLogin(@PathVariable int id) {
        Login loginObj = loginService.getLogin(id);
        if (loginObj == null) {
            throw new RuntimeException("Login nao encontrado");
        }
        return loginObj;

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/login")
    public ResponseEntity login(@RequestParam String usuario, @RequestParam String senha) {

        Login login = loginService.getLoginByUser(usuario, senha);
        if (login != null) {

            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/login/{id}")
    public String deleteLogin(@PathVariable int id) {
        loginService.deleteLogin(id);
        return "Login deletado com o id: " + id;
    }

    @PutMapping("/login")
    public Login updateLogin(@RequestBody Login loginObj) {
        loginService.saveLogin(loginObj);
        return loginObj;
    }

    @GetMapping("/login/Pessoa/{id}")
    public Login getLoginFromPessoa(@PathVariable int id) {
        Login loginObj = loginService.getLoginFromPessoa(id);
        if (loginObj == null) {
            throw new RuntimeException("Login nao encontrado");
        }
        return loginObj;
    }

}

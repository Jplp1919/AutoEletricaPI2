package com.pi2.AutoEletricaApi.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idlogin;
    @Column
    String usuario;
    @Column
    String senha;
    @Column
    Integer pessoa_idcliente;

    public Integer getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(Integer idlogin) {
        this.idlogin = idlogin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getPessoa_idcliente() {
        return pessoa_idcliente;
    }

    public void setPessoa_idcliente(Integer pessoa_idcliente) {
        this.pessoa_idcliente = pessoa_idcliente;
    }
    
}

package com.pi2.AutoEletricaApi.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idcliente;
    @Column
    String nome;
    @Column
    Integer idade;
    @Column
    String cpf;
    @Column
    String email;
    @Column
    String sexo;
    @Column
    String rg;
    @Column
     Double inscricaoestadual;
    @Column
    Double inscricaomunicipal;
     @Column
    Integer limitecred; 
    @Column
    Integer situacao_idsituacao;

    public Double getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(Double inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public Double getInscricaomunicipal() {
        return inscricaomunicipal;
    }

    public void setInscricaomunicipal(Double inscricaomunicipal) {
        this.inscricaomunicipal = inscricaomunicipal;
    }

    public Integer getLimitecred() {
        return limitecred;
    }

    public void setLimitecred(Integer limitecred) {
        this.limitecred = limitecred;
    }
 
    
    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getSituacao_idsituacao() {
        return situacao_idsituacao;
    }

    public void setSituacao_idsituacao(Integer situacao_idsituacao) {
        this.situacao_idsituacao = situacao_idsituacao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
    
    
    
}

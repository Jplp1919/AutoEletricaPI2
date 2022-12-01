package com.pi2.AutoEletricaApi.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "adiministrador")
public class Adiministrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idadiministrador;
    @Column
    LocalDate datadeadimissao;
    @Column
    String setor;
    @Column
    String cargo;
    @Column
    Double salario;
    @Column
    Integer situacao_idsituacao;
    @Column
    Integer pessoa_idcliente;

    public Integer getIdadiministrador() {
        return idadiministrador;
    }

    public void setIdadiministrador(Integer idadiministrador) {
        this.idadiministrador = idadiministrador;
    }

    public LocalDate getDatadeadimissao() {
        return datadeadimissao;
    }

    public void setDatadeadimissao(LocalDate datadeadimissao) {
        this.datadeadimissao = datadeadimissao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getSituacao_idsituacao() {
        return situacao_idsituacao;
    }

    public void setSituacao_idsituacao(Integer situacao_idsituacao) {
        this.situacao_idsituacao = situacao_idsituacao;
    }

    public Integer getPessoa_idcliente() {
        return pessoa_idcliente;
    }

    public void setPessoa_idcliente(Integer pessoa_idcliente) {
        this.pessoa_idcliente = pessoa_idcliente;
    }

    
}

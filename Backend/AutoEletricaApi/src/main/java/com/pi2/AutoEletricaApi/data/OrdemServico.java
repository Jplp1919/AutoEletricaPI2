package com.pi2.AutoEletricaApi.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordemservico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idordemservico;
    @Column
    String serivco;
    @Column
    String estado;
    @Column
    String descricao;
    @Column
    Integer pessoa_idcliente;
    @Column
    Integer veiculo_idveiculo;
    @Column
    Integer produto_idproduto;

    public Integer getIdordemservico() {
        return idordemservico;
    }

    public void setIdordemservico(Integer idordemservico) {
        this.idordemservico = idordemservico;
    }

    public String getSerivco() {
        return serivco;
    }

    public void setSerivco(String serivco) {
        this.serivco = serivco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPessoa_idcliente() {
        return pessoa_idcliente;
    }

    public void setPessoa_idcliente(Integer pessoa_idcliente) {
        this.pessoa_idcliente = pessoa_idcliente;
    }

    public Integer getVeiculo_idveiculo() {
        return veiculo_idveiculo;
    }

    public void setVeiculo_idveiculo(Integer veiculo_idveiculo) {
        this.veiculo_idveiculo = veiculo_idveiculo;
    }

    public Integer getProduto_idproduto() {
        return produto_idproduto;
    }

    public void setProduto_idproduto(Integer produto_idproduto) {
        this.produto_idproduto = produto_idproduto;
    }
    
    

}

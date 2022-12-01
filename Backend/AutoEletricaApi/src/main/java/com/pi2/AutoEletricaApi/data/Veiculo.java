package com.pi2.AutoEletricaApi.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idveiculo;
    @Column
    String tipoveiculo;
    @Column
    String descricao;
    @Column
    String marca;
    @Column
    String placa;
    @Column
    Integer quilometragem;
    @Column
    Integer pessoa_idcliente;
    @Column
    Integer situacao_idsituacao;

    public Integer getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(Integer idveiculo) {
        this.idveiculo = idveiculo;
    }

    public String getTipoveiculo() {
        return tipoveiculo;
    }

    public void setTipoveiculo(String tipoveiculo) {
        this.tipoveiculo = tipoveiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Integer getPessoa_idcliente() {
        return pessoa_idcliente;
    }

    public void setPessoa_idcliente(Integer pessoa_idcliente) {
        this.pessoa_idcliente = pessoa_idcliente;
    }

    public Integer getSituacao_idsituacao() {
        return situacao_idsituacao;
    }

    public void setSituacao_idsituacao(Integer situacao_idsituacao) {
        this.situacao_idsituacao = situacao_idsituacao;
    }

}

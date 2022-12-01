package com.pi2.AutoEletricaApi.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idproduto;
    @Column
    String Nome;
    @Column
    Integer ncm;
    @Column
    Double valor;
    @Column
    Integer estoque;
    @Column
    Integer situacao_idsituacao;

    public Integer getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Integer idproduto) {
        this.idproduto = idproduto;
    }



    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Integer getNcm() {
        return ncm;
    }

    public void setNcm(Integer ncm) {
        this.ncm = ncm;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Integer getSituacao_idsituacao() {
        return situacao_idsituacao;
    }

    public void setSituacao_idsituacao(Integer situacao_idsituacao) {
        this.situacao_idsituacao = situacao_idsituacao;
    }

    
    
    

}

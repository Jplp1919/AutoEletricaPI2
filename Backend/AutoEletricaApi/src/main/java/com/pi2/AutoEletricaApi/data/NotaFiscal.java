package com.pi2.AutoEletricaApi.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "notafiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idnotafiscal;
    @Column
    Integer chavenfe;
    @Column
    double valor;
    @Column
    Integer produto_idproduto;
    @Column
    Integer pessoa_idcliente;
    @Column
    Integer ordemservico_idordemservico;

    public Integer getIdnotafiscal() {
        return idnotafiscal;
    }

    public void setIdnotafiscal(Integer idnotafiscal) {
        this.idnotafiscal = idnotafiscal;
    }

    public Integer getChavenfe() {
        return chavenfe;
    }

    public void setChavenfe(Integer chavenfe) {
        this.chavenfe = chavenfe;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getProduto_idproduto() {
        return produto_idproduto;
    }

    public void setProduto_idproduto(Integer produto_idproduto) {
        this.produto_idproduto = produto_idproduto;
    }

    public Integer getPessoa_idcliente() {
        return pessoa_idcliente;
    }

    public void setPessoa_idcliente(Integer pessoa_idcliente) {
        this.pessoa_idcliente = pessoa_idcliente;
    }

    public Integer getOrdemservico_idordemservico() {
        return ordemservico_idordemservico;
    }

    public void setOrdemservico_idordemservico(Integer ordemservico_idordemservico) {
        this.ordemservico_idordemservico = ordemservico_idordemservico;
    }
    
    
}

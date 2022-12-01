package com.pi2.AutoEletricaApi.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "situacao")
public class Situacao {

    @Id
    Integer idsituacao;
    
    @Column
    Integer ativo;

    public Integer getIdsituacao() {
        return idsituacao;
    }

    public void setId_situacao(Integer id_situacao) {
        this.idsituacao = idsituacao;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

}

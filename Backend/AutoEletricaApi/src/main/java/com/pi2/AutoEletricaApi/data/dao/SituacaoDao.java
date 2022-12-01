package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.Situacao;
import java.util.List;

public interface SituacaoDao {

    List<Situacao> getSituacoes();

    Situacao getSituacao(int id);

    void saveSituacao(Situacao situacao);

    void deleteSituacao(int id);

}

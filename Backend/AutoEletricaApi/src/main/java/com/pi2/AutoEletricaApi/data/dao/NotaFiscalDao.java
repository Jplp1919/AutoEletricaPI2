package com.pi2.AutoEletricaApi.data.dao;

import com.pi2.AutoEletricaApi.data.NotaFiscal;
import java.util.List;

public interface NotaFiscalDao {

    List<NotaFiscal> getNotasFiscais();

    NotaFiscal getNotaFiscal(int id);
    

    void saveNotaFiscal(NotaFiscal notafiscal);

    void deleteNotaFiscal(int id);
}

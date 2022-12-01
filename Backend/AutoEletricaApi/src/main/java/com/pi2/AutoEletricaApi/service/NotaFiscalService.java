package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.NotaFiscal;
import java.util.List;

public interface NotaFiscalService {

    List<NotaFiscal> getNotasFiscais();

    NotaFiscal getNotaFiscal(int id);

    void saveNotaFiscal(NotaFiscal notafiscal);

    void deleteNotaFiscal(int id);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.NotaFiscal;
import com.pi2.AutoEletricaApi.data.dao.NotaFiscalDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotaFiscalServiceImp implements NotaFiscalService {

    @Autowired
    private NotaFiscalDao notaFiscalDao;

    @Transactional
    @Override
    public List<NotaFiscal> getNotasFiscais() {
        return notaFiscalDao.getNotasFiscais();
    }

    @Transactional
    @Override
    public NotaFiscal getNotaFiscal(int id) {
        return notaFiscalDao.getNotaFiscal(id);
    }

    @Transactional
    @Override
    public void saveNotaFiscal(NotaFiscal notafiscal) {
      notaFiscalDao.saveNotaFiscal(notafiscal);
    }

    @Transactional
    @Override
    public void deleteNotaFiscal(int id) {
     notaFiscalDao.deleteNotaFiscal(id);
    }

}

package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.Pessoa;
import com.pi2.AutoEletricaApi.data.dao.PessoaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaServiceImp implements PessoaService {

    @Autowired
    private PessoaDao pessoaDao;

    @Transactional
    @Override
    public List<Pessoa> getPessoas() {
    return pessoaDao.getPessoas();
    }

    @Transactional
    @Override
    public Pessoa getPessoa(int id) {
    return pessoaDao.getPessoa(id);
    }

    @Transactional
    @Override
    public void savePessoa(Pessoa pessoa) {
    pessoaDao.savePessoa(pessoa);
    }

    @Transactional
    @Override
    public void deletePessoa(int id) {
    pessoaDao.deletePessoa(id);
    }

    @Override
    public List<Pessoa> getPessoaPorNome(String nome) {
    return pessoaDao.getPessoaPorNome(nome);
    }

}

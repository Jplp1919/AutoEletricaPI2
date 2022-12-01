package com.pi2.AutoEletricaApi.data.dao;


import com.pi2.AutoEletricaApi.data.Pessoa;
import java.util.List;


public interface PessoaDao {
    
    List<Pessoa> getPessoas();

    Pessoa getPessoa(int id);
    
    List<Pessoa> getPessoaPorNome(String nome);

    void savePessoa(Pessoa pessoa);

    void deletePessoa(int id);
}

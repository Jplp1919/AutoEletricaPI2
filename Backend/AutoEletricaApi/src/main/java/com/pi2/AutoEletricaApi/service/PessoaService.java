package com.pi2.AutoEletricaApi.service;

import com.pi2.AutoEletricaApi.data.Pessoa;
import java.util.List;

public interface PessoaService {

    List<Pessoa> getPessoas();

    Pessoa getPessoa(int id);

   List<Pessoa> getPessoaPorNome (String nome);
    
    void savePessoa(Pessoa pessoa);

    void deletePessoa(int id);
}

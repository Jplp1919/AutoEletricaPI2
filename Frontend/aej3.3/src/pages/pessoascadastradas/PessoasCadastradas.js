
import Banner from "../../component/Layout/Banner";
import NavBar from "../../component/Layout/NavBar";
import Button from "../../component/Button"
import * as React from 'react';
import TextField from "../../component/TextField";
import { Navigate } from "react-router-dom";
import { useNavigate } from "react-router-dom";

//import { useEffect } from "react";
//import { useMemo } from "react";
//import { ReactDOM } from "react";

import './PessoasCadastradas.css';

import { useState } from 'react';
import axios from 'axios';


function PessoasCadastradas() {
  const [data, setData] = useState([]);
  const navigate = useNavigate();
  const [idPessoa, setIdPessoa] = useState('');


  const deletarPessoa = async (event) => {
    event.preventDefault()
    const response = await axios.delete(
      'http://localhost:8080/api/pessoa', {
      params: { idPessoa: idPessoa }
    }).catch(function (error) {
      if (error.response) {
        alert("ID Não Encontrado")
        console.log(error.response.data);
        console.log(error.response.status);
        console.log(error.response.headers);
      } else if (error.request) {
        console.log(error.request);
      } else {
        console.log('Erro! ', error.message);
      }

    });

    if (response.status == 200) {

      navigate('/pessoascadastradas');
      alert("Sucesso")

    }

  }

  async function getPessoas() {
    axios.get(
      "http://localhost:8080/api/pessoa"
    ).then(json => setData(json.data))
    console.log(data.data);
  }

  getPessoas();

  const renderTable = () => {
    return data.map((item, i) => {
      return (
        <tr key={i}>
          <td>{item.idcliente}</td>
          <td>{item.nome}</td>
          <td>{item.idade}</td>
          <td>{item.cpf}</td>
          <td>{item.email}</td>
          <td>{item.sexo}</td>
          <td>{item.rg}</td>
          <td>{item.inscricaoestadual}</td>
          <td>{item.inscricaomunicipal}</td>
          <td>{item.limitecred}</td>
          <td>{item.situacao_idsituacao}</td>
        </tr>
      )
    })
  }




  return (

    <div>
      <NavBar></NavBar>
      <Banner h1="Pessoas Cadastradas"></Banner>

      <table>
        <thead>
          <th>Id Cliente</th>
          <th>Nome</th>
          <th>Idade</th>
          <th>CPF</th>
          <th>E-Mail</th>
          <th>Sexo</th>
          <th>RG</th>
          <th>Inscrição Estadual</th>
          <th>Inscrição Municipal</th>
          <th>Limite de Credito</th>
          <th>Situação</th>
        </thead>

        <tbody>{renderTable()}

        </tbody>

      </table>

    </div>
  )
}




export default PessoasCadastradas;

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

import './VeiculosCadastrados.css';

import { useState } from 'react';
import axios from 'axios';


function VeiculosCadastrados() {
  const [data, setData] = useState([]);



  async function getVeiculo() {
    axios.get(
      "http://localhost:8080/api/veiculo"
    ).then(json => setData(json.data))
    console.log(data.data);
  }

  getVeiculo();

  const renderTable = () => {
    return data.map((item, i) => {
      return (
        <tr key={i}>
          <td>{item.idveiculo}</td>
          <td>{item.tipoveiculo}</td>
          <td>{item.descricao}</td>
          <td>{item.marca}</td>
          <td>{item.placa}</td>
          <td>{item.quilometragem}</td>
          <td>{item.pessoa_idcliente}</td>
          <td>{item.situacao_idsituacao}</td>
        </tr>
      )
    })
  }




  return (

    <div>
      <NavBar></NavBar>
      <Banner h1="Veiculos Cadastrados"></Banner>

      <table>
        <thead>
          <th>Id Veiculo</th>
          <th>Tipo</th>
          <th>Descrição</th>
          <th>Marca</th>
          <th>Placa</th>
          <th>Quilometragem</th>
          <th>Id Cliente</th>
          <th>Situação</th>
        </thead>

        <tbody>{renderTable()}

        </tbody>

      </table>

    </div>
  )
}




export default VeiculosCadastrados;
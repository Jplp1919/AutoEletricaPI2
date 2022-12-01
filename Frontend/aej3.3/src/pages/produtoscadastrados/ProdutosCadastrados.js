
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

import './ProdutosCadastrados.css';

import { useState } from 'react';
import axios from 'axios';


function ProdutosCadastrados() {
  const [data, setData] = useState([]);



  async function getProduto() {
    axios.get(
      "http://localhost:8080/api/produto"
    ).then(json => setData(json.data))
    console.log(data.data);
  }

  getProduto();

  const renderTable = () => {
    return data.map((item, i) => {
      return (
        <tr key={i}>
          <td>{item.idproduto}</td>
          <td>{item.nome}</td>
          <td>{item.ncm}</td>
          <td>{item.valor}</td>
          <td>{item.estoque}</td>
          <td>{item.situacao_idsituacao}</td>
        </tr>
      )
    })
  }




  return (

    <div>
      <NavBar></NavBar>
      <Banner h1="Produtos Cadastrados"></Banner>

      <table>
        <thead>
          <th>Id Produto</th>
          <th>Nome</th>
          <th>NCM</th>
          <th>Valor</th>
          <th>Estoque</th>
          <th>Situação</th>
        </thead>

        <tbody>{renderTable()}

        </tbody>

      </table>

    </div>
  )
}




export default ProdutosCadastrados;
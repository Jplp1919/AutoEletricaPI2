import Banner from "../../component/Layout/Banner";
import NavBar from "../../component/Layout/NavBar";
import ProdNav from "../../component/ProdNav";
import './Produtos.css'
import TextField from "../../component/TextField";
import { useState } from 'react';
import axios from 'axios';


function Produtos() {


    
    const [nome, setNome] = useState('')
    const [ncm, setNcm] = useState('')
    const [valor, setValor] = useState('')
    const [estoque, setEstoque] = useState('')
    const [idsit, setIdsit] = useState('')

    const salvarProduto = async (e) => {
        console.log(idsit)
        e.preventDefault();
        const response = await axios.post(
            'http://localhost:8080/api/produto',
            {
                nome: nome, ncm: ncm, valor: valor, estoque: estoque, situacao_idsituacao: idsit
            }


        ).catch(function (error) {
            if (error.response) {
                alert("Valores invalidos")
                console.log(error.response.data);
                console.log(error.response.status);
                console.log(error.response.headers);
            } else if (error.request) {
                alert("REQUEST ERROR")
                console.log(error.request);
            } else {
                alert(error)
                console.log('Erro! ', error.message);
            }

        });
        if (response.status == 200) {

            alert("Sucesso")
        }
        

    }



    return (


        <div>
            <NavBar></NavBar>
            <Banner h1="Produtos"></Banner>
            <ProdNav></ProdNav>

            <div>
                <section className="form">
                    <form className="text-field" >
                        <select className="custom-select"
                            onChange={(e) => setIdsit(e.target.value)}>
                            <option value="0">Tipo</option>
                            <option value="1">Jurídica</option>
                            <option value="2">Física</option>
                        </select>

                        <TextField
                            required={false}
                            placeholder="Nome"
                            value={nome}
                            onChange={value => setNome(value)}
                        />

                        <TextField
                            required={false}
                            placeholder="NCM"
                            value={ncm}
                            onChange={value => setNcm(value)}
                        />


                        <TextField
                            required={true}
                            placeholder="Valor"
                            value={valor}
                            onChange={value => setValor(value)}
                        />

                        <TextField
                            required={true}
                            placeholder="Estoque"
                            value={estoque}
                            onChange={value => setEstoque(value)}
                        />



                        <div className="btn">
                            <button className="btn-off">Cancelar</button>
                            <button onClick={salvarProduto} className="btn-on">Salvar</button>
                        </div>
                    </form>
                </section>

            </div>

        </div>


    );
}

export default Produtos;
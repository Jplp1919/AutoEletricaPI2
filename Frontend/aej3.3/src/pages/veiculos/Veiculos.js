import Banner from "../../component/Layout/Banner";
import NavBar from "../../component/Layout/NavBar";
import ProdNav from "../../component/ProdNav";
import './Veiculos.css'
import TextField from "../../component/TextField";
import { useState } from 'react';
import axios from 'axios';


function Veiculos() {

    const [tipoVeiculo, setTipoVeiculo] = useState('')
    const [descricao, setDescricao] = useState('')
    const [marca, setMarca] = useState('')
    const [placa, setPlaca] = useState('')
    const [quilometragem, setQuilometragem] = useState('')
    const [idCliente, setIdCliente] = useState('')
    const [idsit, setIdsit] = useState('')

    const salvarVeiculo = async (e) => {
        console.log(idsit)
        e.preventDefault();
        const response = await axios.post(
            'http://localhost:8080/api/veiculo',
            {
                tipoveiculo: tipoVeiculo, descricao: descricao, marca: marca, placa: placa, quilometragem: quilometragem, 
                pessoa_idcliente: idCliente, situacao_idsituacao: idsit
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
            <Banner h1="Veiculos"></Banner>
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
                            required={true}
                            placeholder="Tipo Veiculo"
                            value={tipoVeiculo}
                            onChange={value => setTipoVeiculo(value)}
                        />

                        <TextField
                            required={false}
                            placeholder="Descrição"
                            value={descricao}
                            onChange={value => setDescricao(value)}
                        />


                        <TextField
                            required={true}
                            placeholder="Marca"
                            value={marca}
                            onChange={value => setMarca(value)}
                        />

                        <TextField
                            required={true}
                            placeholder="Placa"
                            value={placa}
                            onChange={value => setPlaca(value)}
                        />

                        <TextField
                            required={false}
                            placeholder="Quilometragem"
                            value={quilometragem}
                            onChange={value => setQuilometragem(value)}
                        />

                        <TextField
                            required={true}
                            placeholder="ID Cliente"
                            value={idCliente}
                            onChange={value => setIdCliente(value)}
                        />
                        
                        <div className="btn">
                            <button className="btn-off">Cancelar</button>
                            <button onClick={salvarVeiculo} className="btn-on">Salvar</button>
                        </div>                        
                    </form>
                    
                </section>
                

            </div>


                         

        </div>






    );
}

export default Veiculos;
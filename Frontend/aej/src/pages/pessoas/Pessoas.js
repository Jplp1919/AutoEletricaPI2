
import Banner from "../../component/Layout/Banner";
import NavBar from "../../component/Layout/NavBar";
//import Button from '../../component/Button';
import './Pessoas.css';
import { useState } from 'react';
import TextField from "../../component/TextField";
import axios from 'axios';
import { responsiveFontSizes } from "@mui/material";

function Pessoas() {

    const [nome, setNome] = useState('')
    const [idade, setIdade] = useState('')
    const [cpf, setCpf] = useState('')
    const [email, setEmail] = useState('')
    const [sexo, setSexo] = useState('')
    const [rg, setRg] = useState('')
    const [estadual, setEstadual] = useState('')
    const [municipal, setMunicipal] = useState('')
    const [limite, setLimite] = useState('')
    const [idsit, setIdsit] = useState('')

    const salvarPessoa = async (e) => {
        console.log(idsit)
        e.preventDefault();
        const response = await axios.post(
            'http://localhost:8080/api/pessoa',
            {
                nome: nome, idade: idade, cpf: cpf, email: email, sexo: sexo, rg: rg, inscricaoestadual: estadual,
                inscricaomunicipal: municipal, limitecred: limite, situacao_idsituacao: idsit
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
            <Banner h1="Pessoas"></Banner>

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
                            placeholder="Nome"
                            value={nome}
                            onChange={value => setNome(value)}
                        />

                        <TextField
                            required={true}
                            placeholder="Idade"
                            value={idade}
                            onChange={value => setIdade(value)}
                        />


                        <TextField
                            required={true}
                            placeholder="CPF"
                            value={cpf}
                            onChange={value => setCpf(value)}
                        />

                        <TextField
                            required={true}
                            placeholder="E-mail"
                            value={email}
                            onChange={value => setEmail(value)}
                        />

                        <TextField
                            required={true}
                            placeholder="Sexo"
                            value={sexo}
                            onChange={value => setSexo(value)}
                        />

                        <TextField
                            required={true}
                            placeholder="RG"
                            value={rg}
                            onChange={value => setRg(value)}
                        />
                        <TextField
                            required={false}
                            placeholder="Incrição Estadual"
                            value={estadual}
                            onChange={value => setEstadual(value)}
                        />

                        <TextField
                            required={false}
                            placeholder="Incrição Municipal"
                            value={municipal}
                            onChange={value => setMunicipal(value)}
                        />
                        <TextField
                            required={false}
                            placeholder="Limite de Credito"
                            value={limite}
                            onChange={value => setLimite(value)}
                        />

                        <div className="btn">
                            <button className="btn-off">Cancelar</button>

                            <button onClick={salvarPessoa} className="btn-on">Salvar</button>
                        </div>
                    </form>
                </section>

            </div>


        </div>

    );
}

export default Pessoas;
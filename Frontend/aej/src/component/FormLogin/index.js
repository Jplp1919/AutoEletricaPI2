import './Form.css'
import TextField from "../TextField";
import Button from '../Button';
import Logo from '../Logo';
import { useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import Home from '../../pages/home/Home';
import { useNavigate} from "react-router-dom";
const Form = (props) => {
    const navigate = useNavigate();
    const [name, setName] = useState('')
    const [password, setPassword] = useState('')


    const onSave = async (event) => {
        event.preventDefault()
        const response = await axios.get(
            'http://localhost:8080/api/login', {
            params: { usuario: name, senha: password }
        }).catch(function (error) {
            if (error.response) {
              alert("Login ou Senha Incorreto(s)")
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
         
            navigate('/home');
            alert("Sucesso")
           
        } 

    }

    return (

        <section className='form'>
            <form onSubmit={onSave}>

                <Logo
                />

                <h2>Auto Elétrica Jair</h2>

                <TextField
                    required={true}
                    placeholder="Usuário"
                    value={name}
                    onChange={value => setName(value)}
                />

                <TextField
                    required={true}
                    placeholder="Senha"
                    value={password}
                    onChange={value => setPassword(value)}
                />

                <Button >

                    Entrar

                </Button>

            </form>
        </section>


    )

}

export default Form
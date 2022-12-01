import Banner from "../../component/Layout/Banner";
import NavBar from "../../component/Layout/NavBar";
import './Emissoes.css'



function Emissoes() {

    return (
        <div>
            <NavBar></NavBar>
            <Banner h1="Emissoes"></Banner>

            <header className="nav-list">
                <form className="form">
                    <input type="text" id="" name="" placeholder="Razão Social" />
                    <input type="text" id="" name="" placeholder="CNPJ" />
                    <input type="text" id="" name="" placeholder="Nome Fantasia" />
                    <input type="text" id="" name="" placeholder="Telefone" />
                    <input type="text" id="" name="" placeholder="DDD" />
                    <input type="text" id="" name="" placeholder="Nome de Contato" />
                </form>
            </header>


          
                <div className="nav-list">
                    <ul>
                        <li><a href="/">Endereço</a></li>
                        <li><a href="/">Contatos</a></li>
                        <li><a href="/">Inscrições</a></li>
                    </ul>
                </div>
            


            <div>
            <section className="form">
                <form className="text-field">
                
                    <select className="custom-select">
                        <option value="0">País/Região</option>
                        <option value="1">-</option>
                        <option value="2">-</option>
                    </select>

                    <input type="text" id="" name="" placeholder="Estado" />
                    <input type="text" id="" name="" placeholder="CEP" />
                    <input type="text" id="" name="" placeholder="Cidade" />
                    <input type="text" id="" name="" placeholder="Endereço" />
                    <input type="text" id="" name="" placeholder="Bairro" />
                    <input type="text" id="" name="" placeholder="Residência" />
                    <input type="text" id="" name="" placeholder="Complemento" />
                    
                     <div className="btn">              
                    <button className="btn-off">Cancelar</button>
                    <button className="btn-on">Salvar</button>
                    </div>
                </form>
            </section>

            </div>
        








        </div>


    );
}

export default Emissoes;
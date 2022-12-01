import Login from "./pages/login/Login";
import Home from "./pages/home/Home"
import Cadastro from "./pages/cadastro/Cadastro"
import Pessoas from "./pages/pessoas/Pessoas"
import {BrowserRouter as Router, Routes, Route} from "react-router-dom"
import Pesquisa from "./pages/pesquisa/Pesquisa"
import Agenda from "./pages/agenda/Agenda"
import Contabil from "./pages/contabil/Contabil"
import Emissoes from "./pages/emissoes/Emissoes"
import Veiculos from "./pages/veiculos/Veiculos"
import Peças from "./pages/produtos/Produtos"
import Serviços from "./pages/serviços/Serviços"
import Produtos from "./pages/produtos/Produtos"
import PessoasCadastradas from "./pages/pessoascadastradas/PessoasCadastradas";
import VeiculosCadastrados from "./pages/veiculoscadastrados/VeiculosCadastrados";
import ProdutosCadastrados from "./pages/produtoscadastrados/ProdutosCadastrados";
import AtualizarPessoa from "./pages/atualizarpessoa/AtualizarPessoa";

function App() {


   return (

    <Router>
      <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/Home" element={<Home/>}/>
            <Route path="/Cadastro" element={<Cadastro/>}/>
            <Route path="/Pessoas" element={<Pessoas/>}/>
            <Route path="/Pesquisa" element={<Pesquisa/>}/>
            <Route path="/Veiculos" element={<Veiculos/>}/>
            <Route path="/Peças" element={<Peças/>}/>
            <Route path="/Agenda" element={<Agenda/>}/>
            <Route path="/Contabil" element={<Contabil/>}/>
            <Route path="/Emissoes" element={<Emissoes/>}/>
            <Route path="/Serviços" element={<Serviços/>}/>
            <Route path="/Produtos" element={<Produtos/>}/>
            <Route path="/PessoasCadastradas" element={<PessoasCadastradas/>}/>
            <Route path="/VeiculosCadastrados" element={<VeiculosCadastrados/>}/>
            <Route path="/ProdutosCadastrados" element={<ProdutosCadastrados/>}/>
            <Route path="/AtualizarPessoa" element={<AtualizarPessoa/>}/>
            
      </Routes>
    </Router>
  )
}

export default App;

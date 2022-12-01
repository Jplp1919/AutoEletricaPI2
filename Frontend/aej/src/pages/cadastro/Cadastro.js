import Banner from "../../component/Layout/Banner";
import NavBar from "../../component/Layout/NavBar";
import './Cadastro.css';
import { Link } from "react-router-dom";

function Cadastro() {
  return (

 
      <div>
        <NavBar></NavBar>
        <Banner h1="Cadastro"></Banner>
       
        <div className="container">
          <div>
            <Link to="/Pessoas">
              <a href='/'>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                   <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3Zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z" />
                </svg>
                  <h5> Pessoas </h5>
              </a>
              </Link>
            </div>

            <div>
              <Link to="/Pesquisa">
              <a href='/'>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                  <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                </svg>
                  <h5>Produtos</h5>
              </a>
              </Link>
            </div>


        </div>

      </div>
  );
}

export default Cadastro;
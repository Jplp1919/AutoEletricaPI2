import { Link } from "react-router-dom";
import Banner from "../../component/Layout/Banner";
import NavBar from "../../component/Layout/NavBar";
import ProdNav from "../../component/ProdNav";
//import Button from '../../component/Button';
import './Pesquisa.css';


function Pesquisa() {
  return (


    <div>
      <NavBar></NavBar>
      <Banner h1="Pesquisa"></Banner>
      <ProdNav></ProdNav>

      <div className="container">
        <form className='btn-src'>
          <input type="text" placeholder=" " name="search" />
          <button type="submit">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
              <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
            </svg>
          </button>
        </form>
      </div>

      <div className="table-cont">
        <table>
          <tr>
            <th>Cliente</th>
            <th>Veículo</th>
            <th>Placa</th>
          </tr>
          <tr>
            <td>--</td>
            <td>--</td>
            <td>--</td>
          </tr>
          <tr>
            <td>--</td>
            <td>--</td>
            <td>--</td>
          </tr>
          <tr>
            <td>--</td>
            <td>--</td>
            <td>--</td>
          </tr>
          <tr>
            <td>--</td>
            <td>--</td>
            <td>--</td>
          </tr>
        </table>
      </div>

      <div className="navBtn">
        <button className="btn-on"><Link to="/Veiculos"><a>Detalhes</a></Link></button>
        <button className="btn-on"><Link to="/Serviços"><a>Serviços</a></Link></button>
        <button className="btn-on"><Link to="/Emissoes">      <a>NF</a></Link></button>
      </div>
    </div>

  );
}

export default Pesquisa;
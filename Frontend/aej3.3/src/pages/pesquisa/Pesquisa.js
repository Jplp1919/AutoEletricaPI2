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

   
    </div>

  );
}

export default Pesquisa;
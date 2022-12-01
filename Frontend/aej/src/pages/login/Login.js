import { useState } from "react";
import './Login.css';
import Form from "../../component/FormLogin";


function Login() {

   const [users, setUser] = useState([])

   const onNewUser = (user) => {
      console.log(user)
      setUser([...users, user])
   }

   return (
      <div className="App">
         <Form onSavedUser={user => onNewUser(user)} />
      </div>
   )
}

export default Login;

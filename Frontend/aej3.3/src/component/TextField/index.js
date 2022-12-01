import { useState } from 'react'
import './TextField.css'


const TextField = (props) => {

 // captura o evento do input
    const onType =(event) =>{
        props.onChange(event.target.value)
    }
   
    return(
        <div className="text-field">
            <input value={props.value} onChange={onType} required={props.required} placeholder={props.placeholder}/>            
        </div>
    )

}

export default TextField
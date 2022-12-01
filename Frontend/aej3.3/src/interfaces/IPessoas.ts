import Pessoas from "./Pessoa"

export default interface IPessoas {
    id: number
    nome: string
    pessoas: Pessoas[]
  }
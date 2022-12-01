

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Auto_Eletrica
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Auto_Eletrica` ;

-- -----------------------------------------------------
-- Schema Auto_Eletrica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Auto_Eletrica` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema new_schema1
-- -----------------------------------------------------
USE `Auto_Eletrica` ;

-- -----------------------------------------------------
-- Table `Auto_Eletrica`.`Situacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Auto_Eletrica`.`Situacao` (
  `idSituacao` INT NOT NULL AUTO_INCREMENT,
  `Ativo` TINYINT NOT NULL,
  PRIMARY KEY (`idSituacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Auto_Eletrica`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Auto_Eletrica`.`Pessoa` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `idade` INT NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `rg` VARCHAR(11) NULL,
  `sexo` VARCHAR(255) NULL,
  `inscricaoEstadual` DOUBLE NULL,
  `inscricaoMunicipal` DOUBLE NULL,
  `limiteCred` INT NULL,
  `Situacao_idSituacao` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  UNIQUE INDEX `rg_UNIQUE` (`rg` ASC) VISIBLE,
  INDEX `fk_Pessoa_Situacao_idx` (`Situacao_idSituacao` ASC) VISIBLE,
  CONSTRAINT `fk_Pessoa_Situacao`
    FOREIGN KEY (`Situacao_idSituacao`)
    REFERENCES `Auto_Eletrica`.`Situacao` (`idSituacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Auto_Eletrica`.`Adiministrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Auto_Eletrica`.`Adiministrador` (
  `idAdiministrador` INT NOT NULL,
  `datadeAdimissao` DATE NOT NULL,
  `setor` VARCHAR(255) NULL,
  `cargo` VARCHAR(255) NULL,
  `salario` DOUBLE NULL,
  `Situacao_idSituacao` INT NOT NULL,
  `Pessoa_idCliente` INT NOT NULL,
  PRIMARY KEY (`idAdiministrador`),
  INDEX `fk_Adiministrador_Situacao1_idx` (`Situacao_idSituacao` ASC) VISIBLE,
  INDEX `fk_Adiministrador_Pessoa1_idx` (`Pessoa_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Adiministrador_Situacao1`
    FOREIGN KEY (`Situacao_idSituacao`)
    REFERENCES `Auto_Eletrica`.`Situacao` (`idSituacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Adiministrador_Pessoa1`
    FOREIGN KEY (`Pessoa_idCliente`)
    REFERENCES `Auto_Eletrica`.`Pessoa` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Auto_Eletrica`.`veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Auto_Eletrica`.`veiculo` (
  `idveiculo` INT NOT NULL AUTO_INCREMENT,
  `tipoVeiculo` VARCHAR(255) NOT NULL,
  `descricao` VARCHAR(255) NULL,
  `marca` VARCHAR(255) NOT NULL,
  `placa` VARCHAR(8) NOT NULL,
  `quilometragem` INT NULL,
  `Pessoa_idCliente` INT NOT NULL,
  `Situacao_idSituacao` INT NOT NULL,
  PRIMARY KEY (`idveiculo`),
  INDEX `fk_veiculo_Pessoa1_idx` (`Pessoa_idCliente` ASC) VISIBLE,
  INDEX `fk_veiculo_Situacao1_idx` (`Situacao_idSituacao` ASC) VISIBLE,
  CONSTRAINT `fk_veiculo_Pessoa1`
    FOREIGN KEY (`Pessoa_idCliente`)
    REFERENCES `Auto_Eletrica`.`Pessoa` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_veiculo_Situacao1`
    FOREIGN KEY (`Situacao_idSituacao`)
    REFERENCES `Auto_Eletrica`.`Situacao` (`idSituacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Auto_Eletrica`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Auto_Eletrica`.`Produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL,
  `ncm` INT NULL,
  `valor` DOUBLE NOT NULL,
  `estoque` DOUBLE NOT NULL,
  `Situacao_idSituacao` INT NOT NULL,
  PRIMARY KEY (`idProduto`),
  INDEX `fk_Produto_Situacao1_idx` (`Situacao_idSituacao` ASC) VISIBLE,
  CONSTRAINT `fk_Produto_Situacao1`
    FOREIGN KEY (`Situacao_idSituacao`)
    REFERENCES `Auto_Eletrica`.`Situacao` (`idSituacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Auto_Eletrica`.`OrdemServico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Auto_Eletrica`.`OrdemServico` (
  `idOrdemServico` INT NOT NULL AUTO_INCREMENT,
  `servico` VARCHAR(255) NULL,
  `estado` VARCHAR(255) NOT NULL,
  `descricao` VARCHAR(255) NULL,
  `Pessoa_idCliente` INT NOT NULL,
  `veiculo_idveiculo` INT NOT NULL,
  `Produto_idProduto` INT NOT NULL,
  PRIMARY KEY (`idOrdemServico`),
  INDEX `fk_OrdemServico_Pessoa1_idx` (`Pessoa_idCliente` ASC) VISIBLE,
  INDEX `fk_OrdemServico_veiculo1_idx` (`veiculo_idveiculo` ASC) VISIBLE,
  INDEX `fk_OrdemServico_Produto1_idx` (`Produto_idProduto` ASC) VISIBLE,
  CONSTRAINT `fk_OrdemServico_Pessoa1`
    FOREIGN KEY (`Pessoa_idCliente`)
    REFERENCES `Auto_Eletrica`.`Pessoa` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdemServico_veiculo1`
    FOREIGN KEY (`veiculo_idveiculo`)
    REFERENCES `Auto_Eletrica`.`veiculo` (`idveiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdemServico_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `Auto_Eletrica`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Auto_Eletrica`.`NotaFiscal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Auto_Eletrica`.`NotaFiscal` (
  `idNotaFiscal` INT NOT NULL AUTO_INCREMENT,
  `chaveNFe` INT NULL,
  `valor` DOUBLE NULL,
  `Produto_idProduto` INT NOT NULL,
  `Pessoa_idCliente` INT NOT NULL,
  `OrdemServico_idOrdemServico` INT NOT NULL,
  PRIMARY KEY (`idNotaFiscal`),
  INDEX `fk_NotaFiscal_Produto1_idx` (`Produto_idProduto` ASC) VISIBLE,
  INDEX `fk_NotaFiscal_Pessoa1_idx` (`Pessoa_idCliente` ASC) VISIBLE,
  INDEX `fk_NotaFiscal_OrdemServico1_idx` (`OrdemServico_idOrdemServico` ASC) VISIBLE,
  CONSTRAINT `fk_NotaFiscal_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `Auto_Eletrica`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NotaFiscal_Pessoa1`
    FOREIGN KEY (`Pessoa_idCliente`)
    REFERENCES `Auto_Eletrica`.`Pessoa` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NotaFiscal_OrdemServico1`
    FOREIGN KEY (`OrdemServico_idOrdemServico`)
    REFERENCES `Auto_Eletrica`.`OrdemServico` (`idOrdemServico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Auto_Eletrica`.`Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Auto_Eletrica`.`Login` (
  `idLogin` INT NOT NULL AUTO_INCREMENT,
  `Usuario` VARCHAR(45) NULL,
  `Senha` VARCHAR(45) NULL,
  `Pessoa_idCliente` INT NOT NULL,
  PRIMARY KEY (`idLogin`, `Pessoa_idCliente`),
  UNIQUE INDEX `Usuario_UNIQUE` (`Usuario` ASC) VISIBLE,
  INDEX `fk_Login_Pessoa1_idx` (`Pessoa_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Login_Pessoa1`
    FOREIGN KEY (`Pessoa_idCliente`)
    REFERENCES `Auto_Eletrica`.`Pessoa` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

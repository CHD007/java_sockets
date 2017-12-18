CREATE SCHEMA `server_supplier_db` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `server_supplier_db`.`servers` (
  `idservers` INT NOT NULL AUTO_INCREMENT,
  `serverName` VARCHAR(45) NOT NULL,
  `processor` TEXT NOT NULL,
  PRIMARY KEY (`idservers`));


CREATE TABLE `server_supplier_db`.`universities` (
  `idUnivers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUnivers`));

CREATE TABLE `server_supplier_db`.`supplies` (
  `idsupplies` INT NOT NULL AUTO_INCREMENT,
  `serverFk` INT(25) NOT NULL,
  `univerFk` INT(25) NOT NULL,
  PRIMARY KEY (`idsupplies`),
  INDEX `fk_supplies_1_idx` (`serverFk` ASC),
  INDEX `fk_supplies_2_idx` (`univerFk` ASC),
  CONSTRAINT `fk_supplies_1`
    FOREIGN KEY (`serverFk`)
    REFERENCES `server_supplier_db`.`servers` (`idservers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_supplies_2`
    FOREIGN KEY (`univerFk`)
    REFERENCES `server_supplier_db`.`universities` (`idUnivers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


INSERT INTO `server_supplier_db`.`servers` (`idservers`, `serverName`, `processor`) VALUES ('1', 'server 1', 'intel');
INSERT INTO `server_supplier_db`.`servers` (`idservers`, `serverName`, `processor`) VALUES ('2', 'server 2', 'amd');


INSERT INTO `server_supplier_db`.`universities` (`idUnivers`, `name`, `address`) VALUES ('1', 'LETI', 'ul. Prof Popova');
INSERT INTO `server_supplier_db`.`universities` (`idUnivers`, `name`, `address`) VALUES ('2', 'SPBGU', 'ul. Pushkina dom Kolotushkina');


INSERT INTO `server_supplier_db`.`supplies` (`idsupplies`, `serverFk`, `univerFk`) VALUES ('1', '1', '1');
INSERT INTO `server_supplier_db`.`supplies` (`idsupplies`, `serverFk`, `univerFk`) VALUES ('2', '2', '1');
INSERT INTO `server_supplier_db`.`supplies` (`idsupplies`, `serverFk`, `univerFk`) VALUES ('3', '1', '2');
INSERT INTO `server_supplier_db`.`supplies` (`idsupplies`, `serverFk`, `univerFk`) VALUES ('4', '2', '2');


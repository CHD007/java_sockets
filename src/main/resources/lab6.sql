CREATE SCHEMA `suplier`

CREATE TABLE `suplier`.`univers` (
  `idunivers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` TEXT NOT NULL,
  PRIMARY KEY (`idunivers`));

CREATE TABLE `suplier`.`mount_servers` (
  `idmount_servers` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `processor` TEXT NOT NULL,
  PRIMARY KEY (`idmount_servers`));


CREATE TABLE `suplier`.`supplies` (
  `idsupplies` INT NOT NULL AUTO_INCREMENT,
  `serverFk` INT(25) NOT NULL,
  `iniverFk` INT(25) NOT NULL,
  PRIMARY KEY (`idsupplies`),
  INDEX `asdf_idx` (`serverFk` ASC),
  INDEX `qwet_idx` (`iniverFk` ASC),
  CONSTRAINT `asdf`
  FOREIGN KEY (`serverFk`)
  REFERENCES `suplier`.`mount_servers` (`idmount_servers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `qwet`
  FOREIGN KEY (`iniverFk`)
  REFERENCES `suplier`.`univers` (`idunivers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


INSERT INTO `suplier`.`mount_servers` (`idmount_servers`, `name`, `processor`) VALUES ('1', 'SERVER1', 'intel');
INSERT INTO `suplier`.`mount_servers` (`idmount_servers`, `name`, `processor`) VALUES ('2', 'SERVER2', 'amd');


INSERT INTO `suplier`.`univers` (`idunivers`, `name`, `address`) VALUES ('1', 'LETI', 'ul. Prof Popova');
INSERT INTO `suplier`.`univers` (`idunivers`, `name`, `address`) VALUES ('2', 'EORIRI', 'ul. SLFKGH BNv');


INSERT INTO `suplier`.`supplies` (`idsupplies`, `serverFk`, `univerFk`) VALUES ('1', '1', '1');
INSERT INTO `suplier`.`supplies` (`idsupplies`, `serverFk`, `univerFk`) VALUES ('2', '1', '2');
INSERT INTO `suplier`.`supplies` (`idsupplies`, `serverFk`, `univerFk`) VALUES ('3', '2', '1');
INSERT INTO `suplier`.`supplies` (`idsupplies`, `serverFk`, `univerFk`) VALUES ('4', '2', '2');

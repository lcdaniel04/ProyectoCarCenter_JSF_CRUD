-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema carcenter_bd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema carcenter_bd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `carcenter_bd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `carcenter_bd` ;

-- -----------------------------------------------------
-- Table `carcenter_bd`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carcenter_bd`.`clientes` (
  `IDE_CLIENTE` INT NOT NULL AUTO_INCREMENT,
  `PRIMER_NOMBRE` VARCHAR(20) NOT NULL,
  `SEGUNDO_NOMBRE` VARCHAR(20) NULL DEFAULT NULL,
  `PRIMER_APELLIDO` VARCHAR(20) NOT NULL,
  `SEGUNDO_APELLIDO` VARCHAR(20) NULL DEFAULT NULL,
  `TIPO_DOCUMENTO` VARCHAR(15) NOT NULL,
  `NUM_DOCUMENTO` DECIMAL(15,0) NOT NULL,
  `NUM_CELULAR` DECIMAL(10,0) NOT NULL,
  `DIRECCION` VARCHAR(50) NULL DEFAULT NULL,
  `CORREO_ELECTRONICO` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IDE_CLIENTE`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carcenter_bd`.`mecanicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carcenter_bd`.`mecanicos` (
  `IDE_MECANICO` INT NOT NULL AUTO_INCREMENT,
  `PRIMER_NOMBRE` VARCHAR(20) NOT NULL,
  `SEGUNDO_NOMBRE` VARCHAR(20) NULL DEFAULT NULL,
  `PRIMER_APELLIDO` VARCHAR(20) NOT NULL,
  `SEGUNDO_APELLIDO` VARCHAR(20) NULL DEFAULT NULL,
  `TIPO_DOCUMENTO` VARCHAR(15) NOT NULL,
  `NUM_DOCUMENTO` DECIMAL(15,0) NOT NULL,
  `NUM_CELULAR` DECIMAL(10,0) NOT NULL,
  `DIRECCION` VARCHAR(50) NOT NULL,
  `CORREO_ELECTRONICO` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IDE_MECANICO`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carcenter_bd`.`vehiculos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carcenter_bd`.`vehiculos` (
  `IDE_VEHICULO` VARCHAR(20) NOT NULL,
  `MARCA` VARCHAR(45) NOT NULL,
  `IDE_CLIENTE` INT NOT NULL,
  PRIMARY KEY (`IDE_VEHICULO`),
  INDEX `IDX_CLIENTE` (`IDE_CLIENTE` ASC) VISIBLE,
  CONSTRAINT `FK_VEH_CLI`
    FOREIGN KEY (`IDE_CLIENTE`)
    REFERENCES `carcenter_bd`.`clientes` (`IDE_CLIENTE`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carcenter_bd`.`mantenimientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carcenter_bd`.`mantenimientos` (
  `IDE_MANTENIMIENTO` INT NOT NULL AUTO_INCREMENT,
  `ESTADO` VARCHAR(15) NOT NULL,
  `VALORACION` VARCHAR(50) NOT NULL,
  `IDE_VEHICULO` VARCHAR(20) NOT NULL,
  `IDE_MECANICO` INT NOT NULL,
  `VAL_CANTIDAD_USADA` DECIMAL(5,0) NOT NULL DEFAULT '1',
  `TIPO_PRODUCTO` DECIMAL(1,0) NOT NULL DEFAULT '1',
  `COD_PRODUCTO` DECIMAL(5,0) NULL DEFAULT NULL,
  PRIMARY KEY (`IDE_MANTENIMIENTO`),
  INDEX `IDX_VEHICULO` (`IDE_VEHICULO` ASC) INVISIBLE,
  INDEX `IDX_MECANICO` (`IDE_MECANICO` ASC) VISIBLE,
  CONSTRAINT `FK_MAN_MEC`
    FOREIGN KEY (`IDE_MECANICO`)
    REFERENCES `carcenter_bd`.`mecanicos` (`IDE_MECANICO`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_MAN_VEH`
    FOREIGN KEY (`IDE_VEHICULO`)
    REFERENCES `carcenter_bd`.`vehiculos` (`IDE_VEHICULO`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carcenter_bd`.`facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carcenter_bd`.`facturas` (
  `IDE_FACTURA` INT NOT NULL AUTO_INCREMENT,
  `NUM_FACTURA` VARCHAR(45) NOT NULL,
  `IDE_CLIENTE` INT NOT NULL,
  `IDE_MANTENIMIENTO` INT NOT NULL,
  `VR_TOTAL` DECIMAL(25,0) NOT NULL,
  `FEC_REGISTRO` DATETIME(6) NULL DEFAULT NULL,
  `SUBTOTAL` DECIMAL(25,0) NOT NULL,
  `VAL_IVA` DECIMAL(25,0) NOT NULL,
  PRIMARY KEY (`IDE_FACTURA`),
  INDEX `IDX_CLIENTE` (`IDE_CLIENTE` ASC) INVISIBLE,
  INDEX `IDX_MANTENIMIENTO` (`IDE_MANTENIMIENTO` ASC) VISIBLE,
  CONSTRAINT `FK_FAC_CLI`
    FOREIGN KEY (`IDE_CLIENTE`)
    REFERENCES `carcenter_bd`.`clientes` (`IDE_CLIENTE`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_FAC_MAN`
    FOREIGN KEY (`IDE_MANTENIMIENTO`)
    REFERENCES `carcenter_bd`.`mantenimientos` (`IDE_MANTENIMIENTO`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carcenter_bd`.`repuestos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carcenter_bd`.`repuestos` (
  `IDE_REPUESTO` INT NOT NULL,
  `NOM_REPUESTO` VARCHAR(50) NOT NULL,
  `PRECIO_UNIDAD` DECIMAL(25,0) NOT NULL,
  `NUM_UNIDAD` DECIMAL(10,0) NOT NULL,
  `DESCUENTO` DECIMAL(25,0) NOT NULL,
  PRIMARY KEY (`IDE_REPUESTO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carcenter_bd`.`servicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carcenter_bd`.`servicios` (
  `IDE_SERVICIO` INT NOT NULL AUTO_INCREMENT,
  `NOM_SERVICIO` VARCHAR(50) NOT NULL,
  `VR_MANO_OBRA` DECIMAL(20,2) NOT NULL,
  `DESCUENTO` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`IDE_SERVICIO`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `carcenter_bd`.`detalles_factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carcenter_bd`.`detalles_factura` (
  `NUM_DETALLE` INT NOT NULL AUTO_INCREMENT,
  `IDE_SERVICIO` INT NULL DEFAULT NULL,
  `IDE_REPUESTO` INT NULL DEFAULT NULL,
  `VAL_CANTIDAD` DECIMAL(15,0) NOT NULL,
  `VAL_SUBTOTAL` DECIMAL(30,0) NULL DEFAULT NULL,
  `IDE_FACTURA` INT NOT NULL,
  PRIMARY KEY (`NUM_DETALLE`),
  INDEX `IDX_REPUESTO` (`IDE_REPUESTO` ASC) INVISIBLE,
  INDEX `IDX_SERVICIO` (`IDE_SERVICIO` ASC) INVISIBLE,
  INDEX `IDX_FACTURA` (`IDE_FACTURA` ASC) VISIBLE,
  CONSTRAINT `FK_DEF_FAC`
    FOREIGN KEY (`IDE_FACTURA`)
    REFERENCES `carcenter_bd`.`facturas` (`IDE_FACTURA`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_DEF_REP`
    FOREIGN KEY (`IDE_REPUESTO`)
    REFERENCES `carcenter_bd`.`repuestos` (`IDE_REPUESTO`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `FK_DEF_SER`
    FOREIGN KEY (`IDE_SERVICIO`)
    REFERENCES `carcenter_bd`.`servicios` (`IDE_SERVICIO`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `carcenter_bd` ;

-- -----------------------------------------------------
-- Placeholder table for view `carcenter_bd`.`prefactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `carcenter_bd`.`prefactura` (`TIPO_DOC_CLIENTE` INT, `NUM_DOC_CLIENTE` INT, `PRIMER_NOMBRE_CLIENTE` INT, `SEGUNDO_NOMBRE_CLIENTE` INT, `PRIMER_APELLIDO_CLIENTE` INT, `SEGUNDO_APELLIDO_CLIENTE` INT, `TIPO_DOC_MECANICO` INT, `NUM_DOC_MECANICO` INT, `PRIMER_NOMBRE_MECANICO` INT, `SEGUNDO_NOMBRE_MECANICO` INT, `PRIMER_APELLIDO_MECANICO` INT, `SEGUNDO_APELLIDO_MECANICO` INT, `IDE_MANTENIMIENTO` INT, `IDE_CLIENTE` INT, `IDE_MECANICO` INT, `PRODUCTO` INT, `VAL_CANTIDAD_USADA` INT, `TIPO_PRODUCTO` INT, `COD_PRODUCTO` INT, `VALOR` INT);

-- -----------------------------------------------------
-- View `carcenter_bd`.`prefactura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `carcenter_bd`.`prefactura`;
USE `carcenter_bd`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `carcenter_bd`.`prefactura` AS select `cli`.`TIPO_DOCUMENTO` AS `TIPO_DOC_CLIENTE`,`cli`.`NUM_DOCUMENTO` AS `NUM_DOC_CLIENTE`,`cli`.`PRIMER_NOMBRE` AS `PRIMER_NOMBRE_CLIENTE`,`cli`.`SEGUNDO_NOMBRE` AS `SEGUNDO_NOMBRE_CLIENTE`,`cli`.`PRIMER_APELLIDO` AS `PRIMER_APELLIDO_CLIENTE`,`cli`.`SEGUNDO_APELLIDO` AS `SEGUNDO_APELLIDO_CLIENTE`,`mec`.`TIPO_DOCUMENTO` AS `TIPO_DOC_MECANICO`,`mec`.`NUM_DOCUMENTO` AS `NUM_DOC_MECANICO`,`mec`.`PRIMER_NOMBRE` AS `PRIMER_NOMBRE_MECANICO`,`mec`.`SEGUNDO_NOMBRE` AS `SEGUNDO_NOMBRE_MECANICO`,`mec`.`PRIMER_APELLIDO` AS `PRIMER_APELLIDO_MECANICO`,`mec`.`SEGUNDO_APELLIDO` AS `SEGUNDO_APELLIDO_MECANICO`,`man`.`IDE_MANTENIMIENTO` AS `IDE_MANTENIMIENTO`,`cli`.`IDE_CLIENTE` AS `IDE_CLIENTE`,`mec`.`IDE_MECANICO` AS `IDE_MECANICO`,`man`.`VALORACION` AS `PRODUCTO`,`man`.`VAL_CANTIDAD_USADA` AS `VAL_CANTIDAD_USADA`,`man`.`TIPO_PRODUCTO` AS `TIPO_PRODUCTO`,`man`.`COD_PRODUCTO` AS `COD_PRODUCTO`,(case when (`man`.`TIPO_PRODUCTO` = 1) then (select (`s`.`VR_MANO_OBRA` - `s`.`DESCUENTO`) AS `VALOR` from `carcenter_bd`.`servicios` `s` where (`s`.`IDE_SERVICIO` = `man`.`COD_PRODUCTO`)) else (select (`r`.`PRECIO_UNIDAD` - `r`.`DESCUENTO`) AS `VALOR` from `carcenter_bd`.`repuestos` `r` where (`r`.`IDE_REPUESTO` = `man`.`COD_PRODUCTO`)) end) AS `VALOR` from (((`carcenter_bd`.`mantenimientos` `man` join `carcenter_bd`.`vehiculos` `ve`) join `carcenter_bd`.`clientes` `cli`) join `carcenter_bd`.`mecanicos` `mec`) where ((`man`.`IDE_VEHICULO` = `ve`.`IDE_VEHICULO`) and (`man`.`IDE_MECANICO` = `mec`.`IDE_MECANICO`) and (`ve`.`IDE_CLIENTE` = `cli`.`IDE_CLIENTE`) and (`man`.`ESTADO` = 'T'));

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

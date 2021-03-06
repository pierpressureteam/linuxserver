-- MySQL Script generated by MySQL Workbench
-- 04/25/16 22:04:13
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pier_pressure_database` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `pier_pressure_database` ;

-- -----------------------------------------------------
-- Table `mydb`.`usersaccount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pier_pressure_database`.`usersaccount` (
  `username` VARCHAR(40) NOT NULL COMMENT '',
  `password` VARCHAR(40) NOT NULL COMMENT '',
  `email` VARCHAR(100) NOT NULL COMMENT '',
  `activated` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '',
  `firstname` VARCHAR(40) NULL COMMENT '',
  `lastname` VARCHAR(40) NULL COMMENT '',
  PRIMARY KEY (`username`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`shiptype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pier_pressure_database`.`shiptype` (
  `typename` VARCHAR(50) NOT NULL COMMENT '',
  `typebigname` VARCHAR(50) NOT NULL COMMENT '',
  `shiplength` DOUBLE NOT NULL COMMENT '',
  `shipwith` DOUBLE NOT NULL COMMENT '',
  `shipdepth` DOUBLE NOT NULL COMMENT '',
  `capacity` DOUBLE NOT NULL COMMENT '',
  `weight` DOUBLE NULL COMMENT '',
  PRIMARY KEY (`typename`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ships`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pier_pressure_database`.`ships` (
  `mmsi` INT NOT NULL COMMENT '',
  `shiptype_typename` VARCHAR(50) NOT NULL COMMENT '',
  `shipname` VARCHAR(50) NULL COMMENT '',
  PRIMARY KEY (`mmsi`, `shiptype_typename`)  COMMENT '',
  INDEX `fk_ships_shiptype1_idx` (`shiptype_typename` ASC)  COMMENT '',
  CONSTRAINT `fk_ships_shiptype1`
    FOREIGN KEY (`shiptype_typename`)
    REFERENCES `pier_pressure_database`.`shiptype` (`typename`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usersaccount_has_ships`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pier_pressure_database`.`usersaccount_has_ships` (
  `usersaccount_username` VARCHAR(40) NOT NULL COMMENT '',
  `ships_mmsi` INT NOT NULL COMMENT '',
  PRIMARY KEY (`usersaccount_username`, `ships_mmsi`)  COMMENT '',
  INDEX `fk_usersaccount_has_ships_ships1_idx` (`ships_mmsi` ASC)  COMMENT '',
  INDEX `fk_usersaccount_has_ships_usersaccount_idx` (`usersaccount_username` ASC)  COMMENT '',
  CONSTRAINT `fk_usersaccount_has_ships_usersaccount`
    FOREIGN KEY (`usersaccount_username`)
    REFERENCES `pier_pressure_database`.`usersaccount` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usersaccount_has_ships_ships1`
    FOREIGN KEY (`ships_mmsi`)
    REFERENCES `pier_pressure_database`.`ships` (`mmsi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`aisinformation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pier_pressure_database`.`aisinformation` (
  `idaisinformation` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `current_time_ais` LONG NOT NULL COMMENT '',
  `x_coordinates` DOUBLE NOT NULL COMMENT '',
  `y_coordinates` DOUBLE NOT NULL COMMENT '',
  `speed` DOUBLE NOT NULL COMMENT '',
  `co2_submission` DOUBLE NULL COMMENT '',
  `ships_mmsi` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idaisinformation`)  COMMENT '',
  INDEX `fk_aisinformation_ships1_idx` (`ships_mmsi` ASC)  COMMENT '',
  CONSTRAINT `fk_aisinformation_ships1`
    FOREIGN KEY (`ships_mmsi`)
    REFERENCES `pier_pressure_database`.`ships` (`mmsi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

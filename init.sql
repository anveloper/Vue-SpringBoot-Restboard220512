-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema devan_board
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema devan_board
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `devan_board` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `devan_board` ;

-- -----------------------------------------------------
-- Table `devan_board`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devan_board`.`user` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `username` VARCHAR(80) NOT NULL,
  `join_date` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`seq`),
  UNIQUE INDEX `userid_UNIQUE` (`userid` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `devan_board`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devan_board`.`board` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `writer` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `view_cnt` INT UNSIGNED NULL DEFAULT '0',
  `reg_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `modi_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`),
  INDEX `FK_USERID_WRITER_idx` (`writer` ASC) VISIBLE,
  CONSTRAINT `FK_USERID_WRITER`
    FOREIGN KEY (`writer`)
    REFERENCES `devan_board`.`user` (`userid`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 354
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `devan_board`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devan_board`.`comment` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `board_no` INT NOT NULL,
  `writer` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `reg_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `modi_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`),
  INDEX `FK_USERID_WRITER_idx` (`writer` ASC) VISIBLE,
  INDEX `FK_BOARD_NO_idx` (`board_no` ASC) VISIBLE,
  CONSTRAINT `FK_BOARD_NO`
    FOREIGN KEY (`board_no`)
    REFERENCES `devan_board`.`board` (`no`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_USERID_COWRITER`
    FOREIGN KEY (`writer`)
    REFERENCES `devan_board`.`user` (`userid`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

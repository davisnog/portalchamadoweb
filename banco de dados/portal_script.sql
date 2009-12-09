SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `portal` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
SHOW WARNINGS;
USE `portal`;

-- -----------------------------------------------------
-- Table `portal`.`state`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portal`.`state` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `state` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(255) NOT NULL ,
  `uf` VARCHAR(2) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `portal`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portal`.`city` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `city` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(255) NOT NULL ,
  `state_id` BIGINT(20) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `fk_city_state` ON `city` (`state_id` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `portal`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portal`.`address` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `address` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `complement` VARCHAR(255) NULL ,
  `district` VARCHAR(255) NULL ,
  `number` INT(11) NULL ,
  `street` VARCHAR(255) NULL ,
  `zip_code` INT(11) NOT NULL ,
  `city_id` BIGINT(20) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `fk_address_city1` ON `address` (`city_id` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `portal`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portal`.`person` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `person` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `active` BIT(1) NOT NULL ,
  `cell` VARCHAR(255) NULL ,
  `phone` VARCHAR(255) NULL ,
  `role` VARCHAR(255) NOT NULL ,
  `email` VARCHAR(255) NOT NULL ,
  `password` VARCHAR(255) NOT NULL ,
  `address_id` BIGINT(20) NULL ,
  `name` VARCHAR(255) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `fk_person_address1` ON `person` (`address_id` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `portal`.`service_provider`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portal`.`service_provider` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `service_provider` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `person_id` BIGINT(20) NOT NULL ,
  `fantasy_name` VARCHAR(255) NULL DEFAULT NULL ,
  `logo` TINYBLOB NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `fk_service_provider_person1` ON `service_provider` (`person_id` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `portal`.`classification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portal`.`classification` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `classification` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `note` INT(11) NOT NULL ,
  `observation` VARCHAR(255) NOT NULL ,
  `service_provider_id` BIGINT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `fk_classification_service_provider1` ON `classification` (`service_provider_id` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `portal`.`corporation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portal`.`corporation` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `corporation` (
  `cnpj` BIGINT NULL DEFAULT NULL ,
  `corporation_name` VARCHAR(255) NULL DEFAULT NULL ,
  `municipal_registration` VARCHAR(255) NULL DEFAULT NULL ,
  `state_registration` VARCHAR(255) NULL DEFAULT NULL ,
  `service_provider_id` BIGINT NOT NULL ,
  PRIMARY KEY (`service_provider_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `fk_corporation_service_provider1` ON `corporation` (`service_provider_id` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `portal`.`individual`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portal`.`individual` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `individual` (
  `cpf` BIGINT NULL DEFAULT NULL ,
  `service_provider_id` BIGINT NOT NULL ,
  PRIMARY KEY (`service_provider_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `fk_individual_service_provider1` ON `individual` (`service_provider_id` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `portal`.`service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portal`.`service` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `service` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `tag` VARCHAR(45) NULL ,
  `description` VARCHAR(255) NOT NULL ,
  `value` DOUBLE NULL ,
  `active` BIT NOT NULL DEFAULT 1 ,
  `service_provider_id` BIGINT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `fk_service_service_provider1` ON `service` (`service_provider_id` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `portal`.`service_request`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portal`.`service_request` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `service_request` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `description` VARCHAR(255) NOT NULL ,
  `request_date` DATETIME NOT NULL ,
  `service_provider_id` BIGINT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE INDEX `fk_service_request_service_provider1` ON `service_request` (`service_provider_id` ASC) ;

SHOW WARNINGS;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

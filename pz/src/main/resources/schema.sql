SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `pzdb` DEFAULT CHARACTER SET latin1 ;
USE `pzdb` ;

-- -----------------------------------------------------
-- Table `pzdb`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pzdb`.`role` (
  `roleid` INT(11) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`roleid`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pzdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pzdb`.`user` (
  `userid` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `role_id` INT(255) NOT NULL,
  PRIMARY KEY (`userid`),
  INDEX `fk_user_role` (`role_id` ASC),
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `pzdb`.`role` (`roleid`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`device`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pzdb`.`device` (
  `deviceid` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `mac_adress` VARCHAR(45) NOT NULL,
  `user_userid` INT(11) NOT NULL,
  PRIMARY KEY (`deviceid`),
  INDEX `fk_device_user1_idx` (`user_userid` ASC),
  CONSTRAINT `fk_device_user1`
    FOREIGN KEY (`user_userid`)
    REFERENCES `pzdb`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pzdb`.`group` (
  `groupid` INT NOT NULL,
  `gr_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`groupid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`device_has_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pzdb`.`device_has_group` (
  `device_deviceid` INT NOT NULL,
  `group_groupid` INT NOT NULL,
  INDEX `fk_device_has_group_group1_idx` (`group_groupid` ASC),
  INDEX `fk_device_has_group_device_idx` (`device_deviceid` ASC),
  CONSTRAINT `fk_device_has_group_device`
    FOREIGN KEY (`device_deviceid`)
    REFERENCES `pzdb`.`device` (`deviceid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_device_has_group_group1`
    FOREIGN KEY (`group_groupid`)
    REFERENCES `pzdb`.`group` (`groupid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`package`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pzdb`.`package` (
  `packageid` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `package` BLOB NOT NULL,
  `user_userid` INT(11) NOT NULL,
  PRIMARY KEY (`packageid`),
  INDEX `fk_package_user1_idx` (`user_userid` ASC),
  CONSTRAINT `fk_package_user1`
    FOREIGN KEY (`user_userid`)
    REFERENCES `pzdb`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `pzdb` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

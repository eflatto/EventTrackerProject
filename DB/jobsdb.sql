-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jobsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jobsdb` ;

-- -----------------------------------------------------
-- Schema jobsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jobsdb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema jobsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jobsdb` ;

-- -----------------------------------------------------
-- Schema jobsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jobsdb` DEFAULT CHARACTER SET utf8 ;
USE `jobsdb` ;
USE `jobsdb` ;

-- -----------------------------------------------------
-- Table `status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `status` ;

CREATE TABLE IF NOT EXISTS `status` (
  `id` INT(11) NOT NULL,
  `status_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `job_application`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job_application` ;

CREATE TABLE IF NOT EXISTS `job_application` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(45) NOT NULL,
  `notes` TEXT NULL DEFAULT NULL,
  `date_applied` DATE NULL DEFAULT NULL,
  `job_title` VARCHAR(45) NULL DEFAULT NULL,
  `job_description` TEXT NULL DEFAULT NULL,
  `salary` INT(11) NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `status_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_job_application_user_idx` (`user_id` ASC),
  INDEX `fk_job_application_status1_idx` (`status_id` ASC),
  CONSTRAINT `fk_job_application_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_job_application_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE = '';
DROP USER IF EXISTS edwin@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'edwin'@'localhost' IDENTIFIED BY 'edwin';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'edwin'@'localhost';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'edwin'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `status`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobsdb`;
INSERT INTO `status` (`id`, `status_name`) VALUES (1, 'applied');
INSERT INTO `status` (`id`, `status_name`) VALUES (2, 'rejected');
INSERT INTO `status` (`id`, `status_name`) VALUES (3, 'accepted');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobsdb`;
INSERT INTO `user` (`id`, `username`, `password`) VALUES (1, 'admin', 'admin');
INSERT INTO `user` (`id`, `username`, `password`) VALUES (2, 'edwin', 'edwin');
INSERT INTO `user` (`id`, `username`, `password`) VALUES (3, 'joe', 'joe');

COMMIT;


-- -----------------------------------------------------
-- Data for table `job_application`
-- -----------------------------------------------------
START TRANSACTION;
USE `jobsdb`;
INSERT INTO `job_application` (`id`, `company_name`, `notes`, `date_applied`, `job_title`, `job_description`, `salary`, `user_id`, `status_id`) VALUES (1, 'Google', 'Submitted application online on LinkedIn', '2023-05-06', 'Software Engineer', 'We are seeking a Full Stack Developer to join our team! You will be responsible for developing and implementing software solutions to meet the needs of our customers.', 125000, 1, 1);
INSERT INTO `job_application` (`id`, `company_name`, `notes`, `date_applied`, `job_title`, `job_description`, `salary`, `user_id`, `status_id`) VALUES (2, 'Amazon', 'Submitted application online on Indeed', '2023-05-05', 'Software Engineer', 'Looking for an experienced software engineer to join our team. The ideal candidate will have a strong background in Java and experience working with large-scale distributed systems.', 100000, 2, 2);
INSERT INTO `job_application` (`id`, `company_name`, `notes`, `date_applied`, `job_title`, `job_description`, `salary`, `user_id`, `status_id`) VALUES (3, 'Netflix', 'Submitted application online on Company Website', '2023-03-05', 'Software Engineer', 'Design, develop, and maintain software applications and systems for Netflix\'s products and services.', 120000, 3, 3);

COMMIT;


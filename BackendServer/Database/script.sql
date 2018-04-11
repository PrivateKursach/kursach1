CREATE SCHEMA `training_portal` ;

CREATE TABLE `training_portal`.`tp_training` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `description` MEDIUMTEXT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `training_portal`.`tp_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NULL,
  `last_name` VARCHAR(100) NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `role` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `training_portal`.`tp_training_type` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `training_portal`.`tp_training_training_type` (
  `training_id` BIGINT(20) NOT NULL,
  `training_type_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`training_id`, `training_type_id`),
  INDEX `tp_training_training_type_fk2_idx` (`training_type_id` ASC),
  CONSTRAINT `tp_training_training_type_fk1`
  FOREIGN KEY (`training_id`)
  REFERENCES `training_portal`.`tp_training` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `tp_training_training_type_fk2`
  FOREIGN KEY (`training_type_id`)
  REFERENCES `training_portal`.`tp_training_type` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

ALTER TABLE `training_portal`.`tp_training`
  ADD COLUMN `trainer_name` VARCHAR(100) NULL AFTER `end_date`,
  ADD COLUMN `location` VARCHAR(150) NULL AFTER `trainer_name`;

CREATE TABLE `training_portal`.`tp_request` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) NOT NULL,
  `training_id` BIGINT(20) NOT NULL,
  `status` INT NOT NULL,
  `rating` INT NULL,
  `date_created` DATE NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `training_portal`.`tp_request`
  ADD INDEX `tp_request_fk1_idx` (`training_id` ASC);
ALTER TABLE `training_portal`.`tp_request`
  ADD CONSTRAINT `tp_request_fk1`
FOREIGN KEY (`training_id`)
REFERENCES `training_portal`.`tp_training` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `training_portal`.`tp_request`
  ADD INDEX `tp_request_fk2_idx` (`user_id` ASC);
ALTER TABLE `training_portal`.`tp_request`
  ADD CONSTRAINT `tp_request_fk2`
FOREIGN KEY (`user_id`)
REFERENCES `training_portal`.`tp_user` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
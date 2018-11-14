-- create db
DROP DATABASE IF EXISTS `admissionsboard`;

CREATE DATABASE
IF NOT EXISTS `admissionsBoard`
DEFAULT CHARACTER SET utf8
COLLATE utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `enrolee` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL,
  `lastName` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL,
  `login` VARCHAR(30) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL,
  `password` VARCHAR(25) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL,
  `email` VARCHAR(120) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL,
  `additional` TEXT(500) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL,
  `registrationDate` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `enrolleeEmailIndex` (`email` ASC)
)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `subject` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `description` TEXT(500) CHARACTER SET `utf8` COLLATE `utf8_unicode_ci` NOT NULL,
  `popularity` FLOAT(3,2) NULL,
  `anyDate` DATE NULL,
  `subjectTypeId` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY(`id`),
  INDEX `subjectNameIndex` (`name` ASC)
)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `faculty` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL,
  `totalCount` SMALLINT UNSIGNED NOT NULL,
  `budgetCount` SMALLINT UNSIGNED NOT NULL,
  `creationDate` DATE NOT NULL,
  `popularity` FLOAT(3,2) NULL,
  `description` TEXT(500) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `facultyNameIndex`(`facultyName` ASC)
)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `statement` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `popularity` FLOAT(3,2) NULL,
  `description` TEXT(500) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `someName` VARCHAR(50) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `date` (`date` ASC)
)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `city` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NOT NULL,
  `area` FLOAT(10,2) NOT NULL,
  `description` TEXT(500) NOT NULL,
  `creationDate` DATE NOT NULL,
  PRIMARY KEY `id`(`id`)
)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `subjecttype` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_unicode_ci' NULL,
  PRIMARY KEY (`id`)
)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `request` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `enrolleeId` INT UNSIGNED NOT NULL,
  `facultyId` INT UNSIGNED NOT NULL,
  `averageScore` FLOAT(4,2) NOT NULL
  PRIMARY KEY (`id`, `enrolleeId`, `facultyId`),
  INDEX `requestEnrolleeIndex`(`enrolleeId` ASC),
  INDEX `requestFacultyIndex`(`facultyId` ASC)
)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `statementRequest` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `requestId` INT UNSIGNED NOT NULL,
  `statementId` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `requestId`, `statementId`),
  INDEX `statementRequestIndex` (`requestId` ASC)
)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `enrolleeSubject` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `enrolleeId` INT UNSIGNED NOT NULL,
  `subjectId` INT UNSIGNED NOT NULL,
  `point` FLOAT(4,2) NOT NULL,
  PRIMARY KEY (`id`, `enrolleeId`, `subjectId`),
  INDEX `enrolleeSubjectIndex`(`enrolleeId` ASC),
)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `facultySubject` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `coefficient` FLOAT NOT NULL,
  `facultyId` INT UNSIGNED NOT NULL,
  `subjectId` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
  INDEX `facultySubjectFacultyIdIndex` (`facultyId` ASC)
)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

LOAD DATA INFILE 'first.txt' INTO TABLE enrolee
FIELDS TERMINATED BY ','
(firstName, lastName, login, password, email, additional);

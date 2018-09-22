-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.28


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema iedtt
--

CREATE DATABASE IF NOT EXISTS iedtt;
USE iedtt;

--
-- Definition of table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `email_id` varchar(100) NOT NULL,
  `city` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `door_number` varchar(45) NOT NULL,
  `locality` varchar(100) NOT NULL,
  `pincode` varchar(6) NOT NULL,
  `state` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `town` varchar(45) NOT NULL,
  PRIMARY KEY (`email_id`),
  CONSTRAINT `user_address` FOREIGN KEY (`email_id`) REFERENCES `user` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


--
-- Definition of table `defect_comments`
--

DROP TABLE IF EXISTS `defect_comments`;
CREATE TABLE `defect_comments` (
  `defect_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `commentor` varchar(100) NOT NULL,
  `comment` text NOT NULL,
  `date_time` datetime NOT NULL,
  KEY `FK_defect_id` (`defect_id`),
  KEY `FK_defect_user` (`commentor`),
  CONSTRAINT `FK_defect_id` FOREIGN KEY (`defect_id`) REFERENCES `defects` (`id`),
  CONSTRAINT `FK_defect_user` FOREIGN KEY (`commentor`) REFERENCES `user` (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `defect_comments`
--

/*!40000 ALTER TABLE `defect_comments` DISABLE KEYS */;
INSERT INTO `defect_comments` (`defect_id`,`commentor`,`comment`,`date_time`) VALUES 
 (17,'sap.koduri@gmail.com','defect opened','2018-09-15 20:37:37'),
 (17,'sap.koduri@gmail.com','issue fixed','2018-09-15 21:22:57'),
 (17,'sap.koduri@gmail.com','adsfasdfasd','2018-09-16 14:53:44'),
 (17,'sap.koduri@gmail.com','asdfasdfasd','2018-09-16 14:53:47'),
 (17,'sap.koduri@gmail.com','adsfasdfasdf','2018-09-16 14:54:25'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 14:55:29'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 14:55:50'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 14:56:13'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 14:56:28'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 14:57:17'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 14:57:41'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 14:58:19'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 15:00:05'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 15:02:29'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 15:05:12'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 15:06:04'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 15:06:23'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 15:06:40'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 15:06:50'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 15:07:20'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 15:07:36'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 15:08:11'),
 (17,'sap.koduri@gmail.com','ASDAdsASDasd','2018-09-16 15:08:29'),
 (17,'sap.koduri@gmail.com','difect not fixed properly, re opened','2018-09-16 16:25:58'),
 (19,'sap.koduri2@gmail.com','new defect','2018-09-19 20:52:13'),
 (19,'sap.koduri2@gmail.com','new defect','2018-09-19 20:53:22'),
 (19,'sap.koduri2@gmail.com','new defect','2018-09-19 20:53:36'),
 (19,'sap.koduri2@gmail.com','new defect','2018-09-19 21:01:50'),
 (20,'sap.koduri2@gmail.com','defect opened and started investigation on issue','2018-09-22 17:20:15'),
 (17,'sap.koduri@gmail.com','The quick brown fox jumps over the lazy dog\r\nThe quick brown fox jumps over the lazy dog\r\nThe quick brown fox jumps over the lazy dog\r\nThe quick brown fox jumps over the lazy dog\r\nThe quick brown fox jumps over the lazy dog\r\nThe quick brown fox jumps over the lazy dog\r\nThe quick brown fox jumps over the lazy dog\r\nThe quick brown fox jumps over the lazy dog','2018-09-22 17:41:18'),
 (17,'sap.koduri@gmail.com','dfasdfasdfasdfasdf','2018-09-22 17:50:39');
/*!40000 ALTER TABLE `defect_comments` ENABLE KEYS */;


--
-- Definition of table `defects`
--

DROP TABLE IF EXISTS `defects`;
CREATE TABLE `defects` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `status` varchar(50) NOT NULL,
  `identified_by` varchar(100) NOT NULL,
  `assigned_to` varchar(100) NOT NULL,
  `eta` date DEFAULT NULL,
  `defect_date` date NOT NULL,
  `rca` text,
  `project_name` varchar(100) NOT NULL,
  `module_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `defects`
--

/*!40000 ALTER TABLE `defects` DISABLE KEYS */;
INSERT INTO `defects` (`id`,`description`,`status`,`identified_by`,`assigned_to`,`eta`,`defect_date`,`rca`,`project_name`,`module_name`) VALUES 
 (17,'new defect','Closed','sap.koduri@gmail.com','sap.koduri@yahoo.com','2018-09-20','2018-09-11','null pointer not handled','IEDTT','login'),
 (18,'new project iedtt','Fixed','sap.koduri2@gmail.com','Reddysoumya563@gmail.com','2018-09-21','2018-09-18','','IEDTT','login'),
 (19,'WEQEWR','ReTest','sap.koduri2@gmail.com','Reddysoumya563@gmail.com','2018-09-24','2018-09-18','','IEDTT','login'),
 (20,'Registration issue','Fixed','sap.koduri2@gmail.com','sap.koduri@gmail.com','2018-09-26','2018-09-22','Validation error','ALM','Registration');
/*!40000 ALTER TABLE `defects` ENABLE KEYS */;


--
-- Definition of table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_name` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `module_name` varchar(100) NOT NULL,
  PRIMARY KEY (`module_name`,`project_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` (`project_name`,`description`,`module_name`) VALUES 
 ('IEDTT','internal and external defect tracking system','Defect Creation'),
 ('IEDTT','new project iedtt','login'),
 ('ALM','Internal defect tracking tool','Registration'),
 ('IEDTT','internal and external defect tracking system','Registration'),
 ('ALM','Internal defect tracking tool','Reports');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;


--
-- Definition of table `teams`
--

DROP TABLE IF EXISTS `teams`;
CREATE TABLE `teams` (
  `team_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `team_name` varchar(100) NOT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teams`
--

/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `email_id` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `date_of_registration` datetime NOT NULL,
  `last_login` datetime NOT NULL,
  `is_user_active` tinyint(1) NOT NULL,
  `role` varchar(45) NOT NULL,
  `team` int(10) unsigned NOT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`email_id`,`password`,`date_of_registration`,`last_login`,`is_user_active`,`role`,`team`) VALUES 
 ('emai@gmail.com','password','2018-08-19 15:29:33','2018-08-19 15:29:33',1,'',0),
 ('Reddysoumya563@gmail.com','password','2018-09-18 01:32:56','2018-09-18 01:32:56',1,'new',0),
 ('sap.koduri2@gmail.com','password','2018-09-18 01:32:02','2018-09-18 01:32:02',1,'manager',0),
 ('sap.koduri@gmail.com','password','2018-08-19 19:27:03','2018-08-19 19:27:03',1,'dev',0),
 ('sap.koduri@yahoo.com','password','2018-08-28 22:36:17','2018-08-28 22:36:17',1,'new',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
CREATE TABLE `user_profile` (
  `email_id` varchar(100) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `security_question_1` text NOT NULL,
  `security_answer_1` text NOT NULL,
  `security_question_2` text NOT NULL,
  `sucrity_answer_2` text NOT NULL,
  `is_user_profile_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`email_id`),
  CONSTRAINT `user_profile` FOREIGN KEY (`email_id`) REFERENCES `user` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_profile`
--

/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` (`email_id`,`first_name`,`last_name`,`gender`,`mobile`,`security_question_1`,`security_answer_1`,`security_question_2`,`sucrity_answer_2`,`is_user_profile_active`) VALUES 
 ('emai@gmail.com','first name','last name','Female','1234567890','Where Your Born','india','Favourite colour','blue',1),
 ('Reddysoumya563@gmail.com','sowmya','Reddy','Female','1234512345','First Mobile Number','1234567890','Mother Middle Name','Reddy',1),
 ('sap.koduri2@gmail.com','sap','k','Male','1231231231','First Mobile Number','1234567890','Mother Middle Name','ss',1),
 ('sap.koduri@gmail.com','fn','ln','Female','9876543210','First School Name','shankar','Favourite colour','blue',1),
 ('sap.koduri@yahoo.com','ss','ss','Male','1324567890','First Mobile Number','1234567890','Best Friend Name','ss',1);
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

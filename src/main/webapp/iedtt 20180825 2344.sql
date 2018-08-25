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
-- Definition of table `defects`
--

DROP TABLE IF EXISTS `defects`;
CREATE TABLE `defects` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `status` varchar(50) NOT NULL,
  `identified_by` varchar(100) NOT NULL,
  `assigned_to` varchar(100) NOT NULL,
  `eta` datetime NOT NULL,
  `defect_date` datetime NOT NULL,
  `rca` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `defects`
--

/*!40000 ALTER TABLE `defects` DISABLE KEYS */;
INSERT INTO `defects` (`id`,`description`,`status`,`identified_by`,`assigned_to`,`eta`,`defect_date`,`rca`) VALUES 
 (1,'new','0','sap.koduri@gmail.com','emai@gmail.com','2018-01-25 00:08:00','2018-01-25 00:08:00','ads'),
 (2,'new','1','sap.koduri@gmail.com','emai@gmail.com','2018-01-25 00:05:00','2018-01-25 00:08:00','ads'),
 (3,'new','1','sap.koduri@gmail.com','emai@gmail.com','2018-01-25 00:05:00','2018-01-25 00:08:00','ads');
/*!40000 ALTER TABLE `defects` ENABLE KEYS */;


--
-- Definition of table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_id` varchar(50) NOT NULL,
  `name` text NOT NULL,
  `module` int(10) unsigned NOT NULL,
  PRIMARY KEY (`project_id`,`module`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;


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
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`email_id`,`password`,`date_of_registration`,`last_login`,`is_user_active`) VALUES 
 ('emai@gmail.com','password','2018-08-19 15:29:33','2018-08-19 15:29:33',1),
 ('sap.koduri@gmail.com','password','2018-08-19 19:27:03','2018-08-19 19:27:03',1);
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
 ('sap.koduri@gmail.com','fn','ln','Female','9876543210','First School Name','shankar','Favourite colour','blue',1);
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

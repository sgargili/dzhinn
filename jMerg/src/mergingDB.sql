-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.37-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema mergingdb
--

CREATE DATABASE IF NOT EXISTS mergingdb;
USE mergingdb;

--
-- Definition of table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_name` varchar(256) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`article_id`),
  KEY `FK_article_1` (`bank_id`),
  CONSTRAINT `FK_article_1` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `article`
--

/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`article_id`,`article_name`,`bank_id`) VALUES 
 (1,'NixArticle1',1),
 (2,'NixArticle2',1),
 (3,'NixArticle3',1),
 (4,'NixArticle4',1),
 (5,'F-CenterArticle1',2),
 (6,'F-CenterArticle2',2),
 (7,'F-CenterArticle3',2),
 (8,'F-CenterArticle4',2);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;


--
-- Definition of table `attribute`
--

DROP TABLE IF EXISTS `attribute`;
CREATE TABLE `attribute` (
  `attribute_id` int(11) NOT NULL AUTO_INCREMENT,
  `attribute_name` varchar(256) DEFAULT NULL,
  `attribute_type_id` int(11) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`attribute_id`),
  KEY `FK_attribute_1` (`bank_id`),
  KEY `FK_attribute_2` (`attribute_type_id`),
  CONSTRAINT `FK_attribute_2` FOREIGN KEY (`attribute_type_id`) REFERENCES `attribute_type` (`attribute_type_id`),
  CONSTRAINT `FK_attribute_1` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `attribute`
--

/*!40000 ALTER TABLE `attribute` DISABLE KEYS */;
INSERT INTO `attribute` (`attribute_id`,`attribute_name`,`attribute_type_id`,`bank_id`) VALUES 
 (1,'Размер экрана',1,1),
 (2,'Технология экрана',1,1),
 (3,'Время отклика',1,1);
/*!40000 ALTER TABLE `attribute` ENABLE KEYS */;


--
-- Definition of table `attribute_rule`
--

DROP TABLE IF EXISTS `attribute_rule`;
CREATE TABLE `attribute_rule` (
  `attribute_rule_id` int(11) NOT NULL AUTO_INCREMENT,
  `attribute_id_from` int(11) DEFAULT NULL,
  `attribute_id_to` int(11) DEFAULT NULL,
  `rule_type_id` int(11) DEFAULT NULL,
  `regexp_id` int(11) DEFAULT NULL,
  `unit_id` int(11) DEFAULT NULL,
  `rule_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`attribute_rule_id`),
  KEY `FK_attribute_rule_1` (`attribute_id_from`),
  KEY `FK_attribute_rule_2` (`attribute_id_to`),
  KEY `FK_attribute_rule_3` (`rule_type_id`),
  KEY `FK_attribute_rule_4` (`regexp_id`),
  KEY `FK_attribute_rule_5` (`unit_id`),
  KEY `FK_attribute_rule_6` (`rule_id`),
  CONSTRAINT `FK_attribute_rule_1` FOREIGN KEY (`attribute_id_from`) REFERENCES `attribute` (`attribute_id`),
  CONSTRAINT `FK_attribute_rule_2` FOREIGN KEY (`attribute_id_to`) REFERENCES `attribute` (`attribute_id`),
  CONSTRAINT `FK_attribute_rule_3` FOREIGN KEY (`rule_type_id`) REFERENCES `rule_type` (`rule_type_id`),
  CONSTRAINT `FK_attribute_rule_4` FOREIGN KEY (`regexp_id`) REFERENCES `regexp` (`regexp_id`),
  CONSTRAINT `FK_attribute_rule_5` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`unit_id`),
  CONSTRAINT `FK_attribute_rule_6` FOREIGN KEY (`rule_id`) REFERENCES `rule` (`rule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `attribute_rule`
--

/*!40000 ALTER TABLE `attribute_rule` DISABLE KEYS */;
INSERT INTO `attribute_rule` (`attribute_rule_id`,`attribute_id_from`,`attribute_id_to`,`rule_type_id`,`regexp_id`,`unit_id`,`rule_id`) VALUES 
 (1,1,1,1,1,1,1);
/*!40000 ALTER TABLE `attribute_rule` ENABLE KEYS */;


--
-- Definition of table `attribute_to_groupe`
--

DROP TABLE IF EXISTS `attribute_to_groupe`;
CREATE TABLE `attribute_to_groupe` (
  `attribute_to_groupe_id` int(11) NOT NULL AUTO_INCREMENT,
  `attribute_id` int(11) DEFAULT NULL,
  `groupe_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`attribute_to_groupe_id`),
  KEY `FK_attribute_to_groupe_1` (`attribute_id`),
  KEY `FK_attribute_to_groupe_2` (`groupe_id`),
  CONSTRAINT `FK_attribute_to_groupe_1` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`attribute_id`),
  CONSTRAINT `FK_attribute_to_groupe_2` FOREIGN KEY (`groupe_id`) REFERENCES `groupe` (`groupe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `attribute_to_groupe`
--

/*!40000 ALTER TABLE `attribute_to_groupe` DISABLE KEYS */;
INSERT INTO `attribute_to_groupe` (`attribute_to_groupe_id`,`attribute_id`,`groupe_id`) VALUES 
 (1,1,1),
 (2,2,1),
 (3,3,1);
/*!40000 ALTER TABLE `attribute_to_groupe` ENABLE KEYS */;


--
-- Definition of table `attribute_type`
--

DROP TABLE IF EXISTS `attribute_type`;
CREATE TABLE `attribute_type` (
  `attribute_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `attribute_type_name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`attribute_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `attribute_type`
--

/*!40000 ALTER TABLE `attribute_type` DISABLE KEYS */;
INSERT INTO `attribute_type` (`attribute_type_id`,`attribute_type_name`) VALUES 
 (1,'Text'),
 (2,'Single'),
 (3,'Multi');
/*!40000 ALTER TABLE `attribute_type` ENABLE KEYS */;


--
-- Definition of table `attribute_value`
--

DROP TABLE IF EXISTS `attribute_value`;
CREATE TABLE `attribute_value` (
  `attribute_id` int(11) DEFAULT NULL,
  `attribute_value` varchar(1024) DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `attribute_value_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`attribute_value_id`) USING BTREE,
  KEY `FK_attribute_value_1` (`attribute_id`),
  KEY `FK_attribute_value_2` (`article_id`),
  CONSTRAINT `FK_attribute_value_1` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`attribute_id`),
  CONSTRAINT `FK_attribute_value_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `attribute_value`
--

/*!40000 ALTER TABLE `attribute_value` DISABLE KEYS */;
INSERT INTO `attribute_value` (`attribute_id`,`attribute_value`,`article_id`,`attribute_value_id`) VALUES 
 (1,'20\"',1,1),
 (2,'TFT',1,2),
 (3,'2 мс',1,3);
/*!40000 ALTER TABLE `attribute_value` ENABLE KEYS */;


--
-- Definition of table `bank`
--

DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `bank_id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bank`
--

/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` (`bank_id`,`bank_name`) VALUES 
 (1,'Nix'),
 (2,'F-Center'),
 (3,'Value4IT');
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;


--
-- Definition of table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE `groupe` (
  `groupe_id` int(11) NOT NULL AUTO_INCREMENT,
  `groupe_name` varchar(256) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`groupe_id`),
  KEY `FK_groupe_1` (`bank_id`),
  CONSTRAINT `FK_groupe_1` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groupe`
--

/*!40000 ALTER TABLE `groupe` DISABLE KEYS */;
INSERT INTO `groupe` (`groupe_id`,`groupe_name`,`bank_id`) VALUES 
 (1,'Экран',1);
/*!40000 ALTER TABLE `groupe` ENABLE KEYS */;


--
-- Definition of table `groupe_to_model`
--

DROP TABLE IF EXISTS `groupe_to_model`;
CREATE TABLE `groupe_to_model` (
  `groupe_to_model_id` int(11) NOT NULL AUTO_INCREMENT,
  `groupe_id` int(11) DEFAULT NULL,
  `model_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`groupe_to_model_id`),
  KEY `FK_groupe_to_model_1` (`groupe_id`),
  KEY `FK_groupe_to_model_2` (`model_id`),
  CONSTRAINT `FK_groupe_to_model_1` FOREIGN KEY (`groupe_id`) REFERENCES `groupe` (`groupe_id`),
  CONSTRAINT `FK_groupe_to_model_2` FOREIGN KEY (`model_id`) REFERENCES `model` (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groupe_to_model`
--

/*!40000 ALTER TABLE `groupe_to_model` DISABLE KEYS */;
INSERT INTO `groupe_to_model` (`groupe_to_model_id`,`groupe_id`,`model_id`) VALUES 
 (2,1,1);
/*!40000 ALTER TABLE `groupe_to_model` ENABLE KEYS */;


--
-- Definition of table `matching`
--

DROP TABLE IF EXISTS `matching`;
CREATE TABLE `matching` (
  `matching_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id_from` int(11) DEFAULT NULL,
  `article_id_to` int(11) DEFAULT NULL,
  `bank_id_from` int(11) DEFAULT NULL,
  `bank_id_to` int(11) DEFAULT NULL,
  PRIMARY KEY (`matching_id`),
  KEY `FK_matching_1` (`article_id_from`),
  KEY `FK_matching_2` (`article_id_to`),
  KEY `FK_matching_3` (`bank_id_from`),
  KEY `FK_matching_4` (`bank_id_to`),
  CONSTRAINT `FK_matching_1` FOREIGN KEY (`article_id_from`) REFERENCES `article` (`article_id`),
  CONSTRAINT `FK_matching_2` FOREIGN KEY (`article_id_to`) REFERENCES `article` (`article_id`),
  CONSTRAINT `FK_matching_3` FOREIGN KEY (`bank_id_from`) REFERENCES `bank` (`bank_id`),
  CONSTRAINT `FK_matching_4` FOREIGN KEY (`bank_id_to`) REFERENCES `bank` (`bank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `matching`
--

/*!40000 ALTER TABLE `matching` DISABLE KEYS */;
/*!40000 ALTER TABLE `matching` ENABLE KEYS */;


--
-- Definition of table `model`
--

DROP TABLE IF EXISTS `model`;
CREATE TABLE `model` (
  `model_id` int(11) NOT NULL AUTO_INCREMENT,
  `model_name` varchar(256) DEFAULT NULL,
  `bank_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`model_id`),
  KEY `FK_model_1` (`bank_id`),
  CONSTRAINT `FK_model_1` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`bank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `model`
--

/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` (`model_id`,`model_name`,`bank_id`) VALUES 
 (1,'LCD Мониторы',1);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;


--
-- Definition of table `regexp`
--

DROP TABLE IF EXISTS `regexp`;
CREATE TABLE `regexp` (
  `regexp_id` int(11) NOT NULL AUTO_INCREMENT,
  `regexp_value` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`regexp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `regexp`
--

/*!40000 ALTER TABLE `regexp` DISABLE KEYS */;
INSERT INTO `regexp` (`regexp_id`,`regexp_value`) VALUES 
 (1,'.*');
/*!40000 ALTER TABLE `regexp` ENABLE KEYS */;


--
-- Definition of table `rule`
--

DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule` (
  `rule_id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_name` varchar(256) DEFAULT NULL,
  `model_id_from` int(11) DEFAULT NULL,
  `model_id_to` int(11) DEFAULT NULL,
  PRIMARY KEY (`rule_id`),
  KEY `FK_rule_1` (`model_id_from`),
  KEY `FK_rule_2` (`model_id_to`),
  CONSTRAINT `FK_rule_1` FOREIGN KEY (`model_id_from`) REFERENCES `model` (`model_id`),
  CONSTRAINT `FK_rule_2` FOREIGN KEY (`model_id_to`) REFERENCES `model` (`model_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rule`
--

/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` (`rule_id`,`rule_name`,`model_id_from`,`model_id_to`) VALUES 
 (1,'Monitor LCD',1,1);
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;


--
-- Definition of table `rule_type`
--

DROP TABLE IF EXISTS `rule_type`;
CREATE TABLE `rule_type` (
  `rule_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `rule_type_name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`rule_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rule_type`
--

/*!40000 ALTER TABLE `rule_type` DISABLE KEYS */;
INSERT INTO `rule_type` (`rule_type_id`,`rule_type_name`) VALUES 
 (1,'One to One'),
 (2,'One to Many'),
 (3,'Many to One');
/*!40000 ALTER TABLE `rule_type` ENABLE KEYS */;


--
-- Definition of table `unit`
--

DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
  `unit_id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_value` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `unit`
--

/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` (`unit_id`,`unit_value`) VALUES 
 (1,'мс');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

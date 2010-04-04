-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.0-m2-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema spring
--

CREATE DATABASE IF NOT EXISTS spring;
USE spring;

--
-- Definition of table `attribute`
--

DROP TABLE IF EXISTS `attribute`;
CREATE TABLE `attribute` (
  `attribute_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `attribute_name` varchar(256) NOT NULL,
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `attribute`
--

/*!40000 ALTER TABLE `attribute` DISABLE KEYS */;
INSERT INTO `attribute` (`attribute_id`,`attribute_name`) VALUES 
 (1,'Размер экрана'),
 (2,'Время отклика'),
 (3,'Контраст'),
 (4,'DVI'),
 (5,'VGA');
/*!40000 ALTER TABLE `attribute` ENABLE KEYS */;


--
-- Definition of table `gr2attr`
--

DROP TABLE IF EXISTS `gr2attr`;
CREATE TABLE `gr2attr` (
  `groupe_id` int(10) unsigned NOT NULL,
  `attribute_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`groupe_id`,`attribute_id`),
  KEY `FK_gr2attr_2` (`attribute_id`),
  CONSTRAINT `FK_gr2attr_1` FOREIGN KEY (`groupe_id`) REFERENCES `groupe` (`groupe_id`),
  CONSTRAINT `FK_gr2attr_2` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`attribute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `gr2attr`
--

/*!40000 ALTER TABLE `gr2attr` DISABLE KEYS */;
INSERT INTO `gr2attr` (`groupe_id`,`attribute_id`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (2,4),
 (2,5);
/*!40000 ALTER TABLE `gr2attr` ENABLE KEYS */;


--
-- Definition of table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE `groupe` (
  `groupe_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `groupe_name` varchar(256) NOT NULL,
  PRIMARY KEY (`groupe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groupe`
--

/*!40000 ALTER TABLE `groupe` DISABLE KEYS */;
INSERT INTO `groupe` (`groupe_id`,`groupe_name`) VALUES 
 (1,'Экран'),
 (2,'Интерфейсы');
/*!40000 ALTER TABLE `groupe` ENABLE KEYS */;


--
-- Definition of table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `product_type_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_type_name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`product_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_type`
--

/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` (`product_type_id`,`product_type_name`) VALUES 
 (1,'Мониторы');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;


--
-- Definition of table `pt2gr`
--

DROP TABLE IF EXISTS `pt2gr`;
CREATE TABLE `pt2gr` (
  `product_type_id` int(10) unsigned NOT NULL,
  `groupe_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`product_type_id`,`groupe_id`),
  KEY `FK_pt2gr_2` (`groupe_id`),
  CONSTRAINT `FK_pt2gr_1` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`product_type_id`),
  CONSTRAINT `FK_pt2gr_2` FOREIGN KEY (`groupe_id`) REFERENCES `groupe` (`groupe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pt2gr`
--

/*!40000 ALTER TABLE `pt2gr` DISABLE KEYS */;
INSERT INTO `pt2gr` (`product_type_id`,`groupe_id`) VALUES 
 (1,1),
 (1,2);
/*!40000 ALTER TABLE `pt2gr` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

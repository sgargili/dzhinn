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
-- Create schema keydb
--

CREATE DATABASE IF NOT EXISTS keydb;
USE keydb;

--
-- Definition of table `keydata`
--

DROP TABLE IF EXISTS `keydata`;
CREATE TABLE `keydata` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Full_Name` text,
  `Manufacturer` varchar(255) DEFAULT NULL,
  `Article` varchar(255) DEFAULT NULL,
  `Product_Type` varchar(255) DEFAULT NULL,
  `Picture_URL` text,
  `Groupe` varchar(255) DEFAULT NULL,
  `Attribute` varchar(255) DEFAULT NULL,
  `Attribute_Value` text,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `keydata`
--

/*!40000 ALTER TABLE `keydata` DISABLE KEYS */;
/*!40000 ALTER TABLE `keydata` ENABLE KEYS */;


--
-- Definition of table `keymarketing`
--

DROP TABLE IF EXISTS `keymarketing`;
CREATE TABLE `keymarketing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyarticle` varchar(512) DEFAULT NULL,
  `keymarketing` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `keymarketing`
--

/*!40000 ALTER TABLE `keymarketing` DISABLE KEYS */;
/*!40000 ALTER TABLE `keymarketing` ENABLE KEYS */;


--
-- Definition of table `keyprice`
--

DROP TABLE IF EXISTS `keyprice`;
CREATE TABLE `keyprice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyarticle` varchar(512) DEFAULT NULL,
  `keyprice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `keyprice`
--

/*!40000 ALTER TABLE `keyprice` DISABLE KEYS */;
/*!40000 ALTER TABLE `keyprice` ENABLE KEYS */;


--
-- Definition of table `matching`
--

DROP TABLE IF EXISTS `matching`;
CREATE TABLE `matching` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyarticle` varchar(512) DEFAULT NULL,
  `vendorarticle` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `matching`
--

/*!40000 ALTER TABLE `matching` DISABLE KEYS */;
INSERT INTO `matching` (`id`,`keyarticle`,`vendorarticle`) VALUES 
 (1,'12548','BX80602E5540');
/*!40000 ALTER TABLE `matching` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

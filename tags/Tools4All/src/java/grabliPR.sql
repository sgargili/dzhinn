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
-- Create schema grabli
--

CREATE DATABASE IF NOT EXISTS grabli;
USE grabli;

--
-- Definition of table `parent_relate_element`
--

DROP TABLE IF EXISTS `parent_relate_element`;
CREATE TABLE `parent_relate_element` (
  `parent_relate_element_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `parent_relate_element_name` varchar(50) DEFAULT NULL,
  `parent_relate_element_type` tinyint(4) unsigned DEFAULT NULL,
  PRIMARY KEY (`parent_relate_element_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `parent_relate_element`
--

/*!40000 ALTER TABLE `parent_relate_element` DISABLE KEYS */;
INSERT INTO `parent_relate_element` (`parent_relate_element_id`,`parent_relate_element_name`,`parent_relate_element_type`) VALUES 
 (1,'tbody',0),
 (2,'table',0),
 (3,'div',0),
 (4,'span',0),
 (5,'td',1),
 (7,'div',1),
 (8,'span',1);
/*!40000 ALTER TABLE `parent_relate_element` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

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
-- Create schema value4it
--

CREATE DATABASE IF NOT EXISTS value4it;
USE value4it;

--
-- Definition of table `articles`
--

DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles` (
  `article_id` bigint(20) NOT NULL,
  `article` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `articles`
--

/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;


--
-- Definition of table `chat_logs`
--

DROP TABLE IF EXISTS `chat_logs`;
CREATE TABLE `chat_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(15) DEFAULT NULL,
  `nick` varchar(512) DEFAULT NULL,
  `message` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chat_logs`
--

/*!40000 ALTER TABLE `chat_logs` DISABLE KEYS */;
INSERT INTO `chat_logs` (`id`,`ip`,`nick`,`message`) VALUES 
 (3,'127.0.0.1','Я','Дарова '),
 (4,'127.0.0.1','Я','Как дела?');
/*!40000 ALTER TABLE `chat_logs` ENABLE KEYS */;


--
-- Definition of table `cookies`
--

DROP TABLE IF EXISTS `cookies`;
CREATE TABLE `cookies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cookie` varchar(512) DEFAULT NULL,
  `time` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cookies`
--

/*!40000 ALTER TABLE `cookies` DISABLE KEYS */;
INSERT INTO `cookies` (`id`,`cookie`,`time`) VALUES 
 (1,'JSESSIONID=0000YLtxOg6kYhSbmn7p-UfkM6i',1264777933937);
/*!40000 ALTER TABLE `cookies` ENABLE KEYS */;


--
-- Definition of table `logs`
--

DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(15) DEFAULT NULL,
  `log_type` varchar(256) DEFAULT NULL,
  `log_message` text,
  `log_time` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `logs`
--

/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` (`id`,`ip`,`log_type`,`log_message`,`log_time`) VALUES 
 (5,'127.0.0.1','Login. Create new Session.','JSESSIONID=0000YLtxOg6kYhSbmn7p-UfkM6i:-1','29/0/2010 5:7:18'),
 (6,'127.0.0.1','Export by Products.','Size: 8 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=100/LANGS=/LANG=en/LANG=ru/ID_71129130756771332=71129130756771332/','29/0/2010 5:7:18'),
 (7,'127.0.0.1','Export by Products.','Size: 8 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_71129130756771332=71129130756771332/','29/0/2010 5:9:46'),
 (8,'127.0.0.1','Export by Products.','Size: 8 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_71129130756771332=71129130756771332/','29/0/2010 5:10:25'),
 (9,'127.0.0.1','Export by Products.','Size: 10 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_81127071803258848=81127071803258848/ID_71129130756771332=71129130756771332/ID_90410071830262136=90410071830262136/','29/0/2010 5:12:12');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

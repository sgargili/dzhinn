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
-- Create schema nixdb
--

CREATE DATABASE IF NOT EXISTS nixdb;
USE nixdb;

--
-- Definition of table `nix_data`
--

DROP TABLE IF EXISTS `nix_data`;
CREATE TABLE `nix_data` (
  `id` bigint(20) NOT NULL,
  `full_name` text,
  `manufacturer` varchar(255) DEFAULT NULL,
  `article` varchar(255) DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `pic_url` text,
  `groupe` varchar(255) DEFAULT NULL,
  `attribute` varchar(255) DEFAULT NULL,
  `attribute_value` text,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nix_data`
--

/*!40000 ALTER TABLE `nix_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `nix_data` ENABLE KEYS */;


--
-- Definition of table `nix_links`
--

DROP TABLE IF EXISTS `nix_links`;
CREATE TABLE `nix_links` (
  `id` bigint(20) NOT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  `product_url` text,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nix_links`
--

/*!40000 ALTER TABLE `nix_links` DISABLE KEYS */;
/*!40000 ALTER TABLE `nix_links` ENABLE KEYS */;


--
-- Definition of table `processes`
--

DROP TABLE IF EXISTS `processes`;
CREATE TABLE `processes` (
  `id` bigint(20) NOT NULL,
  `process_name` varchar(255) DEFAULT NULL,
  `process_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `processes`
--

/*!40000 ALTER TABLE `processes` DISABLE KEYS */;
/*!40000 ALTER TABLE `processes` ENABLE KEYS */;


--
-- Definition of table `pt`
--

DROP TABLE IF EXISTS `pt`;
CREATE TABLE `pt` (
  `id` int(11) NOT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pt`
--

/*!40000 ALTER TABLE `pt` DISABLE KEYS */;
/*!40000 ALTER TABLE `pt` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

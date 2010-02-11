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
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chat_logs`
--

/*!40000 ALTER TABLE `chat_logs` DISABLE KEYS */;
INSERT INTO `chat_logs` (`id`,`ip`,`nick`,`message`) VALUES 
 (1,'127.0.0.1','sdfg','вапывап'),
 (2,'127.0.0.1','sdfg','d'),
 (3,'127.0.0.1','sdfg','fg'),
 (4,'127.0.0.1','sdfg','sdgsdfg'),
 (5,'127.0.0.1','sdfg','sdgsdfg'),
 (6,'127.0.0.1','sdfg','sdfg'),
 (7,'127.0.0.1','sdfg','sdfg'),
 (8,'127.0.0.1','sdfg','sdfg'),
 (9,'127.0.0.1','sdfg','sdfg'),
 (10,'127.0.0.1','sdfg','s'),
 (11,'127.0.0.1','sdfg','вап'),
 (12,'127.0.0.1','sdfg','уке'),
 (13,'127.0.0.1','sdfg','g'),
 (14,'127.0.0.1','sdfg','sdfgsdfgsdfg'),
 (15,'127.0.0.1','sdfg','sdfg'),
 (16,'127.0.0.1','sdfg','sdg'),
 (17,'127.0.0.1','sdfg','sdg'),
 (18,'127.0.0.1','sdfg','sdfg'),
 (19,'127.0.0.1','sdfg','sdf'),
 (20,'127.0.0.1','sdfg','g'),
 (21,'127.0.0.1','sdfg','sdg'),
 (22,'127.0.0.1','sdfg','выап'),
 (23,'127.0.0.1','sdfg','sd'),
 (24,'127.0.0.1','sdfg','sdfg'),
 (25,'127.0.0.1','sdfg','s'),
 (26,'127.0.0.1','sdfg','g'),
 (27,'127.0.0.1','sdfg','dfg'),
 (28,'127.0.0.1','sdfg','g'),
 (29,'127.0.0.1','sdfg','sdfg'),
 (30,'127.0.0.1','sdfg','sdfg'),
 (31,'127.0.0.1','sdfg','sdfg'),
 (32,'127.0.0.1','sdfg','sdfg'),
 (33,'127.0.0.1','sdfg','sdgsdgsdfg'),
 (34,'127.0.0.1','sdfg','sdfg'),
 (35,'127.0.0.1','sdfg','sdfg'),
 (36,'127.0.0.1','sdfg','sdfgsdfg'),
 (37,'127.0.0.1','sdg','sgsdfg'),
 (38,'127.0.0.1','sdg','sdg'),
 (39,'127.0.0.1','sdg','sdfg'),
 (40,'127.0.0.1','sdg','sdfg'),
 (41,'127.0.0.1','sdg','sdg'),
 (42,'127.0.0.1','sdg','sdg'),
 (43,'127.0.0.1','sdg','sdfg'),
 (44,'127.0.0.1','sdg','sdfg'),
 (45,'127.0.0.1','sgd','выапывап'),
 (46,'127.0.0.1','sgd','sdg'),
 (47,'127.0.0.1','sgd','sdfg'),
 (48,'127.0.0.1','sgd','sdfg'),
 (49,'127.0.0.1','sgd','sdfg'),
 (50,'127.0.0.1','sgd','sdfgfghdgf'),
 (51,'127.0.0.1','sgd','sdfg'),
 (52,'127.0.0.1','sgd','sdfg'),
 (53,'127.0.0.1','sgd','sg'),
 (54,'127.0.0.1','sdg','sdg'),
 (55,'127.0.0.1','sdg','sdg'),
 (56,'127.0.0.1','sdg','sdfg'),
 (57,'127.0.0.1','sdg','sdgsdfg'),
 (58,'127.0.0.1','sdg','sdgsdfgsdg'),
 (59,'127.0.0.1','PAV','Привет!'),
 (60,'127.0.0.1','PAV','Как дела?'),
 (61,'127.0.0.1','PAV','Привет!'),
 (62,'127.0.0.1','ПАВ','Дарова!'),
 (63,'127.0.0.1','sadfasdf','dsfasfd'),
 (64,'127.0.0.1','sadfasdf','sadfasdf'),
 (65,'127.0.0.1','PAV','asdfasdfdf'),
 (66,'127.0.0.1','PAV','Привет!'),
 (67,'127.0.0.1','PAV','Как дела?'),
 (68,'127.0.0.1','PAV','Что нового?'),
 (69,'127.0.0.1','PAV','Я вот нифига не делаю'),
 (70,'127.0.0.1','PAV','а ты?'),
 (71,'127.0.0.1','Андрей Попов','Привет всем!'),
 (72,'127.0.0.1','PAV','Это я');
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
 (1,'JSESSIONID=00002HPmhAl0TOBbTuyzRPds-ti',1265113583140);
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
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `logs`
--

/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` (`id`,`ip`,`log_type`,`log_message`,`log_time`) VALUES 
 (1,'127.0.0.1','Login. Create new Session.','JSESSIONID=0000za_GMYfExMSOscrvftb41qk:-1','2/1/2010 10:8:41'),
 (2,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_71129130756771332=71129130756771332/','2/1/2010 10:8:41'),
 (3,'127.0.0.1','Login. Create new Session.','JSESSIONID=0000Xk0HIGniWnzblitd08LtdHW:-1','2/1/2010 10:49:22'),
 (4,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_71129130756771332=71129130756771332/','2/1/2010 10:49:22'),
 (5,'127.0.0.1','Export by Products.','Size: 10 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_90421085456484286=90421085456484286/ID_90421085500693874=90421085500693874/ID_80922065929754842=80922065929754842/ID_90415130416514605=90415130416514605/ID_90421085459859309=90421085459859309/ID_90415130354944705=90415130354944705/ID_90415130353068679=90415130353068679/ID_90409113754190906=90409113754190906/ID_90723131949549478=90723131949549478/ID_81125084408889552=81125084408889552/','2/1/2010 10:52:17'),
 (6,'127.0.0.1','Export by Products.','Size: 10 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_90421085457322181=90421085457322181/ID_90421085458177440=90421085458177440/ID_80924060059504293=80924060059504293/ID_90421085501709567=90421085501709567/ID_90723131951436041=90723131951436041/ID_90723131950478103=90723131950478103/ID_90421085459000697=90421085459000697/ID_80116122239700906=80116122239700906/ID_90415130354017320=90415130354017320/ID_90415130352215980=90415130352215980/','2/1/2010 10:52:17'),
 (7,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_90415130440480523=90415130440480523/','2/1/2010 10:52:17'),
 (8,'127.0.0.1','Export Marketing.','Size: 10 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90421085456484286=90421085456484286/TARGET_90421085456484286=90421085456484286/ID_90421085500693874=90421085500693874/TARGET_90421085500693874=90421085500693874/ID_80922065929754842=80922065929754842/TARGET_80922065929754842=80922065929754842/ID_90415130416514605=90415130416514605/TARGET_90415130416514605=90415130416514605/ID_90421085459859309=90421085459859309/TARGET_90421085459859309=90421085459859309/ID_90415130354944705=90415130354944705/TARGET_90415130354944705=90415130354944705/ID_90415130353068679=90415130353068679/TARGET_90415130353068679=90415130353068679/ID_90409113754190906=90409113754190906/TARGET_90409113754190906=90409113754190906/ID_90723131949549478=90723131949549478/TARGET_90723131949549478=90723131949549478/ID_81125084408889552=81125084408889552/TARGET_81125084408889552=81125084408889552/','2/1/2010 10:53:19'),
 (9,'127.0.0.1','Export Marketing.','Size: 10 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90421085457322181=90421085457322181/TARGET_90421085457322181=90421085457322181/ID_90421085458177440=90421085458177440/TARGET_90421085458177440=90421085458177440/ID_80924060059504293=80924060059504293/TARGET_80924060059504293=80924060059504293/ID_90421085501709567=90421085501709567/TARGET_90421085501709567=90421085501709567/ID_90723131951436041=90723131951436041/TARGET_90723131951436041=90723131951436041/ID_90723131950478103=90723131950478103/TARGET_90723131950478103=90723131950478103/ID_90421085459000697=90421085459000697/TARGET_90421085459000697=90421085459000697/ID_80116122239700906=80116122239700906/TARGET_80116122239700906=80116122239700906/ID_90415130354017320=90415130354017320/TARGET_90415130354017320=90415130354017320/ID_90415130352215980=90415130352215980/TARGET_90415130352215980=90415130352215980/','2/1/2010 10:53:19'),
 (10,'127.0.0.1','Export Marketing.','Size: 10 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90421085456484286=90421085456484286/TARGET_90421085456484286=90421085456484286/ID_90421085500693874=90421085500693874/TARGET_90421085500693874=90421085500693874/ID_80922065929754842=80922065929754842/TARGET_80922065929754842=80922065929754842/ID_90415130416514605=90415130416514605/TARGET_90415130416514605=90415130416514605/ID_90421085459859309=90421085459859309/TARGET_90421085459859309=90421085459859309/ID_90415130354944705=90415130354944705/TARGET_90415130354944705=90415130354944705/ID_90415130353068679=90415130353068679/TARGET_90415130353068679=90415130353068679/ID_90409113754190906=90409113754190906/TARGET_90409113754190906=90409113754190906/ID_90723131949549478=90723131949549478/TARGET_90723131949549478=90723131949549478/ID_81125084408889552=81125084408889552/TARGET_81125084408889552=81125084408889552/','2/1/2010 10:56:48'),
 (11,'127.0.0.1','Export Marketing.','Size: 10 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90421085457322181=90421085457322181/TARGET_90421085457322181=90421085457322181/ID_90421085458177440=90421085458177440/TARGET_90421085458177440=90421085458177440/ID_80924060059504293=80924060059504293/TARGET_80924060059504293=80924060059504293/ID_90421085501709567=90421085501709567/TARGET_90421085501709567=90421085501709567/ID_90723131951436041=90723131951436041/TARGET_90723131951436041=90723131951436041/ID_90723131950478103=90723131950478103/TARGET_90723131950478103=90723131950478103/ID_90421085459000697=90421085459000697/TARGET_90421085459000697=90421085459000697/ID_80116122239700906=80116122239700906/TARGET_80116122239700906=80116122239700906/ID_90415130354017320=90415130354017320/TARGET_90415130354017320=90415130354017320/ID_90415130352215980=90415130352215980/TARGET_90415130352215980=90415130352215980/','2/1/2010 10:56:48'),
 (12,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90415130440480523=90415130440480523/TARGET_90415130440480523=90415130440480523/','2/1/2010 10:56:48'),
 (13,'127.0.0.1','Change Owner.','Size: 10 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_90421085456484286=90421085456484286/TARGET_90421085456484286=90421085456484286/ID_90421085500693874=90421085500693874/TARGET_90421085500693874=90421085500693874/ID_80922065929754842=80922065929754842/TARGET_80922065929754842=80922065929754842/ID_90415130416514605=90415130416514605/TARGET_90415130416514605=90415130416514605/ID_90421085459859309=90421085459859309/TARGET_90421085459859309=90421085459859309/ID_90415130354944705=90415130354944705/TARGET_90415130354944705=90415130354944705/ID_90415130353068679=90415130353068679/TARGET_90415130353068679=90415130353068679/ID_90409113754190906=90409113754190906/TARGET_90409113754190906=90409113754190906/ID_90723131949549478=90723131949549478/TARGET_90723131949549478=90723131949549478/ID_81125084408889552=81125084408889552/TARGET_81125084408889552=81125084408889552/','2/1/2010 10:59:33'),
 (14,'127.0.0.1','Change Owner.','Size: 10 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_90421085457322181=90421085457322181/TARGET_90421085457322181=90421085457322181/ID_90421085458177440=90421085458177440/TARGET_90421085458177440=90421085458177440/ID_80924060059504293=80924060059504293/TARGET_80924060059504293=80924060059504293/ID_90421085501709567=90421085501709567/TARGET_90421085501709567=90421085501709567/ID_90723131951436041=90723131951436041/TARGET_90723131951436041=90723131951436041/ID_90723131950478103=90723131950478103/TARGET_90723131950478103=90723131950478103/ID_90421085459000697=90421085459000697/TARGET_90421085459000697=90421085459000697/ID_80116122239700906=80116122239700906/TARGET_80116122239700906=80116122239700906/ID_90415130354017320=90415130354017320/TARGET_90415130354017320=90415130354017320/ID_90415130352215980=90415130352215980/TARGET_90415130352215980=90415130352215980/','2/1/2010 10:59:33'),
 (15,'127.0.0.1','Change Owner.','Size: 2 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_90415130440480523=90415130440480523/TARGET_90415130440480523=90415130440480523/ID_Empty=Empty/TARGET_Empty=Empty/','2/1/2010 10:59:33'),
 (16,'127.0.0.1','Change Owner.','Size: 10 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=80321141718635082/ID_90421085456484286=90421085456484286/TARGET_90421085456484286=90421085456484286/ID_90421085500693874=90421085500693874/TARGET_90421085500693874=90421085500693874/ID_80922065929754842=80922065929754842/TARGET_80922065929754842=80922065929754842/ID_90415130416514605=90415130416514605/TARGET_90415130416514605=90415130416514605/ID_90421085459859309=90421085459859309/TARGET_90421085459859309=90421085459859309/ID_90415130354944705=90415130354944705/TARGET_90415130354944705=90415130354944705/ID_90415130353068679=90415130353068679/TARGET_90415130353068679=90415130353068679/ID_90409113754190906=90409113754190906/TARGET_90409113754190906=90409113754190906/ID_90723131949549478=90723131949549478/TARGET_90723131949549478=90723131949549478/ID_81125084408889552=81125084408889552/TARGET_81125084408889552=81125084408889552/','2/1/2010 11:1:36'),
 (17,'127.0.0.1','Change Owner.','Size: 10 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=80321141718635082/ID_90421085457322181=90421085457322181/TARGET_90421085457322181=90421085457322181/ID_90421085458177440=90421085458177440/TARGET_90421085458177440=90421085458177440/ID_80924060059504293=80924060059504293/TARGET_80924060059504293=80924060059504293/ID_90421085501709567=90421085501709567/TARGET_90421085501709567=90421085501709567/ID_90723131951436041=90723131951436041/TARGET_90723131951436041=90723131951436041/ID_90723131950478103=90723131950478103/TARGET_90723131950478103=90723131950478103/ID_90421085459000697=90421085459000697/TARGET_90421085459000697=90421085459000697/ID_80116122239700906=80116122239700906/TARGET_80116122239700906=80116122239700906/ID_90415130354017320=90415130354017320/TARGET_90415130354017320=90415130354017320/ID_90415130352215980=90415130352215980/TARGET_90415130352215980=90415130352215980/','2/1/2010 11:1:36'),
 (18,'127.0.0.1','Change Owner.','Size: 2 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=80321141718635082/ID_90415130440480523=90415130440480523/TARGET_90415130440480523=90415130440480523/ID_Empty=Empty/TARGET_Empty=Empty/','2/1/2010 11:1:36'),
 (19,'127.0.0.1','Change Status.','Size: 10 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=4/NEW_OWNER_ID=70919085040801266/ID_90421085456484286=90421085456484286/TARGET_90421085456484286=90421085456484286/ID_90421085500693874=90421085500693874/TARGET_90421085500693874=90421085500693874/ID_80922065929754842=80922065929754842/TARGET_80922065929754842=80922065929754842/ID_90415130416514605=90415130416514605/TARGET_90415130416514605=90415130416514605/ID_90421085459859309=90421085459859309/TARGET_90421085459859309=90421085459859309/ID_90415130354944705=90415130354944705/TARGET_90415130354944705=90415130354944705/ID_90415130353068679=90415130353068679/TARGET_90415130353068679=90415130353068679/ID_90409113754190906=90409113754190906/TARGET_90409113754190906=90409113754190906/ID_90723131949549478=90723131949549478/TARGET_90723131949549478=90723131949549478/ID_81125084408889552=81125084408889552/TARGET_81125084408889552=81125084408889552/','2/1/2010 11:1:55'),
 (20,'127.0.0.1','Change Status.','Size: 10 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=4/NEW_OWNER_ID=70919085040801266/ID_90421085457322181=90421085457322181/TARGET_90421085457322181=90421085457322181/ID_90421085458177440=90421085458177440/TARGET_90421085458177440=90421085458177440/ID_80924060059504293=80924060059504293/TARGET_80924060059504293=80924060059504293/ID_90421085501709567=90421085501709567/TARGET_90421085501709567=90421085501709567/ID_90723131951436041=90723131951436041/TARGET_90723131951436041=90723131951436041/ID_90723131950478103=90723131950478103/TARGET_90723131950478103=90723131950478103/ID_90421085459000697=90421085459000697/TARGET_90421085459000697=90421085459000697/ID_80116122239700906=80116122239700906/TARGET_80116122239700906=80116122239700906/ID_90415130354017320=90415130354017320/TARGET_90415130354017320=90415130354017320/ID_90415130352215980=90415130352215980/TARGET_90415130352215980=90415130352215980/','2/1/2010 11:1:55'),
 (21,'127.0.0.1','Change Status.','Size: 2 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=4/NEW_OWNER_ID=70919085040801266/ID_90415130440480523=90415130440480523/TARGET_90415130440480523=90415130440480523/ID_Empty=Empty/TARGET_Empty=Empty/','2/1/2010 11:1:55'),
 (22,'127.0.0.1','Change Status.','Size: 10 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=4/NEW_OWNER_ID=70919085040801266/ID_90421085456484286=90421085456484286/TARGET_90421085456484286=90421085456484286/ID_90421085500693874=90421085500693874/TARGET_90421085500693874=90421085500693874/ID_80922065929754842=80922065929754842/TARGET_80922065929754842=80922065929754842/ID_90415130416514605=90415130416514605/TARGET_90415130416514605=90415130416514605/ID_90421085459859309=90421085459859309/TARGET_90421085459859309=90421085459859309/ID_90415130354944705=90415130354944705/TARGET_90415130354944705=90415130354944705/ID_90415130353068679=90415130353068679/TARGET_90415130353068679=90415130353068679/ID_90409113754190906=90409113754190906/TARGET_90409113754190906=90409113754190906/ID_90723131949549478=90723131949549478/TARGET_90723131949549478=90723131949549478/ID_81125084408889552=81125084408889552/TARGET_81125084408889552=81125084408889552/','2/1/2010 11:7:15'),
 (23,'127.0.0.1','Change Status.','Size: 10 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=4/NEW_OWNER_ID=70919085040801266/ID_90421085457322181=90421085457322181/TARGET_90421085457322181=90421085457322181/ID_90421085458177440=90421085458177440/TARGET_90421085458177440=90421085458177440/ID_80924060059504293=80924060059504293/TARGET_80924060059504293=80924060059504293/ID_90421085501709567=90421085501709567/TARGET_90421085501709567=90421085501709567/ID_90723131951436041=90723131951436041/TARGET_90723131951436041=90723131951436041/ID_90723131950478103=90723131950478103/TARGET_90723131950478103=90723131950478103/ID_90421085459000697=90421085459000697/TARGET_90421085459000697=90421085459000697/ID_80116122239700906=80116122239700906/TARGET_80116122239700906=80116122239700906/ID_90415130354017320=90415130354017320/TARGET_90415130354017320=90415130354017320/ID_90415130352215980=90415130352215980/TARGET_90415130352215980=90415130352215980/','2/1/2010 11:7:15'),
 (24,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=4/NEW_OWNER_ID=70919085040801266/ID_90415130440480523=90415130440480523/TARGET_90415130440480523=90415130440480523/','2/1/2010 11:7:15'),
 (25,'127.0.0.1','Change Status.','Size: 10 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=4/NEW_OWNER_ID=70919085040801266/ID_90421085456484286=90421085456484286/TARGET_90421085456484286=90421085456484286/ID_90421085500693874=90421085500693874/TARGET_90421085500693874=90421085500693874/ID_80922065929754842=80922065929754842/TARGET_80922065929754842=80922065929754842/ID_90415130416514605=90415130416514605/TARGET_90415130416514605=90415130416514605/ID_90421085459859309=90421085459859309/TARGET_90421085459859309=90421085459859309/ID_90415130354944705=90415130354944705/TARGET_90415130354944705=90415130354944705/ID_90415130353068679=90415130353068679/TARGET_90415130353068679=90415130353068679/ID_90409113754190906=90409113754190906/TARGET_90409113754190906=90409113754190906/ID_90723131949549478=90723131949549478/TARGET_90723131949549478=90723131949549478/ID_81125084408889552=81125084408889552/TARGET_81125084408889552=81125084408889552/','2/1/2010 11:15:47'),
 (26,'127.0.0.1','Change Status.','Size: 10 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=4/NEW_OWNER_ID=70919085040801266/ID_90421085457322181=90421085457322181/TARGET_90421085457322181=90421085457322181/ID_90421085458177440=90421085458177440/TARGET_90421085458177440=90421085458177440/ID_80924060059504293=80924060059504293/TARGET_80924060059504293=80924060059504293/ID_90421085501709567=90421085501709567/TARGET_90421085501709567=90421085501709567/ID_90723131951436041=90723131951436041/TARGET_90723131951436041=90723131951436041/ID_90723131950478103=90723131950478103/TARGET_90723131950478103=90723131950478103/ID_90421085459000697=90421085459000697/TARGET_90421085459000697=90421085459000697/ID_80116122239700906=80116122239700906/TARGET_80116122239700906=80116122239700906/ID_90415130354017320=90415130354017320/TARGET_90415130354017320=90415130354017320/ID_90415130352215980=90415130352215980/TARGET_90415130352215980=90415130352215980/','2/1/2010 11:15:47'),
 (27,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=4/NEW_OWNER_ID=70919085040801266/ID_90415130440480523=90415130440480523/TARGET_90415130440480523=90415130440480523/','2/1/2010 11:15:47'),
 (28,'127.0.0.1','Export Marketing.','Size: 10 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90421085456484286=90421085456484286/TARGET_90421085456484286=90421085456484286/ID_90421085500693874=90421085500693874/TARGET_90421085500693874=90421085500693874/ID_80922065929754842=80922065929754842/TARGET_80922065929754842=80922065929754842/ID_90415130416514605=90415130416514605/TARGET_90415130416514605=90415130416514605/ID_90421085459859309=90421085459859309/TARGET_90421085459859309=90421085459859309/ID_90415130354944705=90415130354944705/TARGET_90415130354944705=90415130354944705/ID_90415130353068679=90415130353068679/TARGET_90415130353068679=90415130353068679/ID_90409113754190906=90409113754190906/TARGET_90409113754190906=90409113754190906/ID_90723131949549478=90723131949549478/TARGET_90723131949549478=90723131949549478/ID_81125084408889552=81125084408889552/TARGET_81125084408889552=81125084408889552/','2/1/2010 11:16:35'),
 (29,'127.0.0.1','Export Marketing.','Size: 10 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90421085457322181=90421085457322181/TARGET_90421085457322181=90421085457322181/ID_90421085458177440=90421085458177440/TARGET_90421085458177440=90421085458177440/ID_80924060059504293=80924060059504293/TARGET_80924060059504293=80924060059504293/ID_90421085501709567=90421085501709567/TARGET_90421085501709567=90421085501709567/ID_90723131951436041=90723131951436041/TARGET_90723131951436041=90723131951436041/ID_90723131950478103=90723131950478103/TARGET_90723131950478103=90723131950478103/ID_90421085459000697=90421085459000697/TARGET_90421085459000697=90421085459000697/ID_80116122239700906=80116122239700906/TARGET_80116122239700906=80116122239700906/ID_90415130354017320=90415130354017320/TARGET_90415130354017320=90415130354017320/ID_90415130352215980=90415130352215980/TARGET_90415130352215980=90415130352215980/','2/1/2010 11:16:35'),
 (30,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90415130440480523=90415130440480523/TARGET_90415130440480523=90415130440480523/','2/1/2010 11:16:35'),
 (31,'127.0.0.1','Export Marketing.','Size: 10 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90421085456484286=90421085456484286/TARGET_90421085456484286=90421085456484286/ID_90421085500693874=90421085500693874/TARGET_90421085500693874=90421085500693874/ID_80922065929754842=80922065929754842/TARGET_80922065929754842=80922065929754842/ID_90415130416514605=90415130416514605/TARGET_90415130416514605=90415130416514605/ID_90421085459859309=90421085459859309/TARGET_90421085459859309=90421085459859309/ID_90415130354944705=90415130354944705/TARGET_90415130354944705=90415130354944705/ID_90415130353068679=90415130353068679/TARGET_90415130353068679=90415130353068679/ID_90409113754190906=90409113754190906/TARGET_90409113754190906=90409113754190906/ID_90723131949549478=90723131949549478/TARGET_90723131949549478=90723131949549478/ID_81125084408889552=81125084408889552/TARGET_81125084408889552=81125084408889552/','2/1/2010 11:21:55'),
 (32,'127.0.0.1','Export Marketing.','Size: 10 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90421085457322181=90421085457322181/TARGET_90421085457322181=90421085457322181/ID_90421085458177440=90421085458177440/TARGET_90421085458177440=90421085458177440/ID_80924060059504293=80924060059504293/TARGET_80924060059504293=80924060059504293/ID_90421085501709567=90421085501709567/TARGET_90421085501709567=90421085501709567/ID_90723131951436041=90723131951436041/TARGET_90723131951436041=90723131951436041/ID_90723131950478103=90723131950478103/TARGET_90723131950478103=90723131950478103/ID_90421085459000697=90421085459000697/TARGET_90421085459000697=90421085459000697/ID_80116122239700906=80116122239700906/TARGET_80116122239700906=80116122239700906/ID_90415130354017320=90415130354017320/TARGET_90415130354017320=90415130354017320/ID_90415130352215980=90415130352215980/TARGET_90415130352215980=90415130352215980/','2/1/2010 11:21:55'),
 (33,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90415130440480523=90415130440480523/TARGET_90415130440480523=90415130440480523/','2/1/2010 11:21:55'),
 (34,'127.0.0.1','Login. Create new Session.','JSESSIONID=00002HPmhAl0TOBbTuyzRPds-ti:-1','2/1/2010 3:23:39'),
 (35,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_90415130404006638=90415130404006638/','2/1/2010 3:23:39'),
 (36,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_80924055846235225=80924055846235225/','2/1/2010 3:23:39'),
 (37,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_80604121812378067=80604121812378067/','2/1/2010 3:23:39'),
 (38,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_90415130439645977=90415130439645977/','2/1/2010 3:23:39'),
 (39,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_90415130407288608=90415130407288608/','2/1/2010 3:23:39'),
 (40,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_90826074447225487=90826074447225487/','2/1/2010 3:23:39'),
 (41,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_80825082828550680=80825082828550680/','2/1/2010 3:23:39'),
 (42,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_90415130403091141=90415130403091141/','2/1/2010 3:23:39'),
 (43,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_80214131345393587=80214131345393587/','2/1/2010 3:23:39'),
 (44,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_90826074448124824=90826074448124824/','2/1/2010 3:23:39'),
 (45,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_80924055844287377=80924055844287377/','2/1/2010 3:23:39'),
 (46,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_90630103657272592=90630103657272592/','2/1/2010 3:23:39'),
 (47,'127.0.0.1','Export by Products.','Size: 1 Body: referer=/FACTORY_ID=137/ACTION=EXPORT/PN_RPP=0/LANGS=/LANG=en/LANG=ru/ID_90415130414533367=90415130414533367/','2/1/2010 3:23:39'),
 (48,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90415130404006638=90415130404006638/TARGET_90415130404006638=90415130404006638/','2/1/2010 3:24:59'),
 (49,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_80924055846235225=80924055846235225/TARGET_80924055846235225=80924055846235225/','2/1/2010 3:24:59'),
 (50,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_80604121812378067=80604121812378067/TARGET_80604121812378067=80604121812378067/','2/1/2010 3:24:59'),
 (51,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90415130439645977=90415130439645977/TARGET_90415130439645977=90415130439645977/','2/1/2010 3:24:59'),
 (52,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90415130407288608=90415130407288608/TARGET_90415130407288608=90415130407288608/','2/1/2010 3:24:59'),
 (53,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90826074447225487=90826074447225487/TARGET_90826074447225487=90826074447225487/','2/1/2010 3:24:59'),
 (54,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_80825082828550680=80825082828550680/TARGET_80825082828550680=80825082828550680/','2/1/2010 3:24:59'),
 (55,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90415130403091141=90415130403091141/TARGET_90415130403091141=90415130403091141/','2/1/2010 3:24:59'),
 (56,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_80214131345393587=80214131345393587/TARGET_80214131345393587=80214131345393587/','2/1/2010 3:24:59'),
 (57,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90826074448124824=90826074448124824/TARGET_90826074448124824=90826074448124824/','2/1/2010 3:24:59'),
 (58,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_80924055844287377=80924055844287377/TARGET_80924055844287377=80924055844287377/','2/1/2010 3:24:59'),
 (59,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90630103657272592=90630103657272592/TARGET_90630103657272592=90630103657272592/','2/1/2010 3:24:59'),
 (60,'127.0.0.1','Export Marketing.','Size: 1 Body: POST_ACTION=updateMarketing/SOURCE=/NEW_OWNER_ID=70919085040801266/ID_90415130414533367=90415130414533367/TARGET_90415130414533367=90415130414533367/','2/1/2010 3:24:59'),
 (61,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_90415130404006638=90415130404006638/TARGET_90415130404006638=90415130404006638/','2/1/2010 3:25:37'),
 (62,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_80924055846235225=80924055846235225/TARGET_80924055846235225=80924055846235225/','2/1/2010 3:25:37'),
 (63,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_80604121812378067=80604121812378067/TARGET_80604121812378067=80604121812378067/','2/1/2010 3:25:37'),
 (64,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_90415130439645977=90415130439645977/TARGET_90415130439645977=90415130439645977/','2/1/2010 3:25:37'),
 (65,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_90415130407288608=90415130407288608/TARGET_90415130407288608=90415130407288608/','2/1/2010 3:25:37'),
 (66,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_90826074447225487=90826074447225487/TARGET_90826074447225487=90826074447225487/','2/1/2010 3:25:37'),
 (67,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_80825082828550680=80825082828550680/TARGET_80825082828550680=80825082828550680/','2/1/2010 3:25:37'),
 (68,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_90415130403091141=90415130403091141/TARGET_90415130403091141=90415130403091141/','2/1/2010 3:25:37'),
 (69,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_80214131345393587=80214131345393587/TARGET_80214131345393587=80214131345393587/','2/1/2010 3:25:37'),
 (70,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_90826074448124824=90826074448124824/TARGET_90826074448124824=90826074448124824/','2/1/2010 3:25:37'),
 (71,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_80924055844287377=80924055844287377/TARGET_80924055844287377=80924055844287377/','2/1/2010 3:25:37'),
 (72,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_90630103657272592=90630103657272592/TARGET_90630103657272592=90630103657272592/','2/1/2010 3:25:37'),
 (73,'127.0.0.1','Change Owner.','Size: 1 Body: POST_ACTION=change_owner/SOURCE=/NEW_OWNER_ID=60511120540229999/ID_90415130414533367=90415130414533367/TARGET_90415130414533367=90415130414533367/','2/1/2010 3:25:37'),
 (74,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_90415130404006638=90415130404006638/TARGET_90415130404006638=90415130404006638/','2/1/2010 3:26:18'),
 (75,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_80924055846235225=80924055846235225/TARGET_80924055846235225=80924055846235225/','2/1/2010 3:26:18'),
 (76,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_80604121812378067=80604121812378067/TARGET_80604121812378067=80604121812378067/','2/1/2010 3:26:18'),
 (77,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_90415130439645977=90415130439645977/TARGET_90415130439645977=90415130439645977/','2/1/2010 3:26:18'),
 (78,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_90415130407288608=90415130407288608/TARGET_90415130407288608=90415130407288608/','2/1/2010 3:26:18'),
 (79,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_90826074447225487=90826074447225487/TARGET_90826074447225487=90826074447225487/','2/1/2010 3:26:18'),
 (80,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_80825082828550680=80825082828550680/TARGET_80825082828550680=80825082828550680/','2/1/2010 3:26:18'),
 (81,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_90415130403091141=90415130403091141/TARGET_90415130403091141=90415130403091141/','2/1/2010 3:26:18'),
 (82,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_80214131345393587=80214131345393587/TARGET_80214131345393587=80214131345393587/','2/1/2010 3:26:18'),
 (83,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_90826074448124824=90826074448124824/TARGET_90826074448124824=90826074448124824/','2/1/2010 3:26:18'),
 (84,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_80924055844287377=80924055844287377/TARGET_80924055844287377=80924055844287377/','2/1/2010 3:26:18'),
 (85,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_90630103657272592=90630103657272592/TARGET_90630103657272592=90630103657272592/','2/1/2010 3:26:18'),
 (86,'127.0.0.1','Change Status.','Size: 1 Body: POST_ACTION=change_status/SOURCE=/NEW_STATUS=6/NEW_OWNER_ID=70919085040801266/ID_90415130414533367=90415130414533367/TARGET_90415130414533367=90415130414533367/','2/1/2010 3:26:18');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user` varchar(512) DEFAULT NULL,
  `nick` varchar(512) DEFAULT NULL,
  `login` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`user`,`nick`,`login`,`password`,`ip`) VALUES 
 (1,'Андрей Попов','PAV',NULL,NULL,'127.0.0.1'),
 (2,'Николай Соловьев','КАлян',NULL,NULL,'192.168.1.61'),
 (3,'Павел Ушаков',NULL,NULL,NULL,'192.168.1.42'),
 (4,'Сергей Кобызев','SK',NULL,NULL,'192.168.1.19'),
 (5,'Cергей Серов','Серега',NULL,NULL,'192.168.1.88');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
-- MySQL dump 10.16  Distrib 10.1.12-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: bis14_banking
-- ------------------------------------------------------
-- Server version	10.1.12-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `bis14_banking`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bis14_banking` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bis14_banking`;

--
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Account` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `bankfk` varchar(255) NOT NULL,
  PRIMARY KEY (`username`,`bankfk`),
  KEY `FKf6fnvpq8gqpsuceyuxoddfui1` (`bankfk`),
  CONSTRAINT `FKf6fnvpq8gqpsuceyuxoddfui1` FOREIGN KEY (`bankfk`) REFERENCES `Bank` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` VALUES ('buchs','','UBS');
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Bank`
--

DROP TABLE IF EXISTS `Bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bank` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bank`
--

LOCK TABLES `Bank` WRITE;
/*!40000 ALTER TABLE `Bank` DISABLE KEYS */;
INSERT INTO `Bank` VALUES ('UBS');
/*!40000 ALTER TABLE `Bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Buchung`
--

DROP TABLE IF EXISTS `Buchung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Buchung` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `art` int(11) DEFAULT NULL,
  `betrag` float DEFAULT NULL,
  `datum` date DEFAULT NULL,
  `ausgangfk` varchar(255) DEFAULT NULL,
  `eingangfk` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3jbqhs9dqmt7tlp56kupap1yv` (`ausgangfk`),
  KEY `FKcoexr7k4pmg4cisbi26otsq0c` (`eingangfk`),
  CONSTRAINT `FK3jbqhs9dqmt7tlp56kupap1yv` FOREIGN KEY (`ausgangfk`) REFERENCES `Konto` (`nr`),
  CONSTRAINT `FKcoexr7k4pmg4cisbi26otsq0c` FOREIGN KEY (`eingangfk`) REFERENCES `Konto` (`nr`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Buchung`
--

LOCK TABLES `Buchung` WRITE;
/*!40000 ALTER TABLE `Buchung` DISABLE KEYS */;
INSERT INTO `Buchung` VALUES (1,0,333,'2016-03-03',NULL,'111.111');
/*!40000 ALTER TABLE `Buchung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Karte`
--

DROP TABLE IF EXISTS `Karte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Karte` (
  `nummer` varchar(255) NOT NULL,
  `pin` varchar(255) NOT NULL,
  `kontofk` varchar(255) DEFAULT NULL,
  `kundefk` int(11) DEFAULT NULL,
  PRIMARY KEY (`nummer`),
  KEY `FKj0dx0rjbth6q554pwnu6usd71` (`kontofk`),
  KEY `FK1gttfqenmh4tw0xqibtgjc2st` (`kundefk`),
  CONSTRAINT `FK1gttfqenmh4tw0xqibtgjc2st` FOREIGN KEY (`kundefk`) REFERENCES `Kunde` (`id`),
  CONSTRAINT `FKj0dx0rjbth6q554pwnu6usd71` FOREIGN KEY (`kontofk`) REFERENCES `Konto` (`nr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Karte`
--

LOCK TABLES `Karte` WRITE;
/*!40000 ALTER TABLE `Karte` DISABLE KEYS */;
INSERT INTO `Karte` VALUES ('111-111','1111','111.111',1);
/*!40000 ALTER TABLE `Karte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Konto`
--

DROP TABLE IF EXISTS `Konto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Konto` (
  `nr` varchar(255) NOT NULL,
  `kontostand` float DEFAULT NULL,
  `bankfk` varchar(255) DEFAULT NULL,
  `kundefk` int(11) DEFAULT NULL,
  PRIMARY KEY (`nr`),
  KEY `FKdr28dx5wfw92o392e3y4hr6t7` (`bankfk`),
  KEY `FKp4ayshkgtjeg0jxyrkcpq2ijd` (`kundefk`),
  CONSTRAINT `FKdr28dx5wfw92o392e3y4hr6t7` FOREIGN KEY (`bankfk`) REFERENCES `Bank` (`name`),
  CONSTRAINT `FKp4ayshkgtjeg0jxyrkcpq2ijd` FOREIGN KEY (`kundefk`) REFERENCES `Kunde` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Konto`
--

LOCK TABLES `Konto` WRITE;
/*!40000 ALTER TABLE `Konto` DISABLE KEYS */;
INSERT INTO `Konto` VALUES ('111.111',3443,'UBS',1);
/*!40000 ALTER TABLE `Konto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Kunde`
--

DROP TABLE IF EXISTS `Kunde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Kunde` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `vorname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Kunde`
--

LOCK TABLES `Kunde` WRITE;
/*!40000 ALTER TABLE `Kunde` DISABLE KEYS */;
INSERT INTO `Kunde` VALUES (1,'Buchs','Enrico');
/*!40000 ALTER TABLE `Kunde` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-03 14:58:07

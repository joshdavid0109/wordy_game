-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: wordy_schema
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game` (
  `gameID` int NOT NULL,
  `gameWinner` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`gameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,NULL),(2,NULL),(3,NULL),(4,NULL),(5,NULL),(6,NULL),(7,NULL),(8,NULL),(9,NULL),(10,NULL),(11,NULL),(12,NULL),(13,NULL),(14,NULL),(15,NULL),(16,NULL),(17,NULL),(18,NULL),(19,NULL),(20,NULL),(21,NULL),(22,NULL),(23,NULL),(24,NULL),(25,NULL),(26,NULL),(27,NULL),(28,NULL),(29,NULL),(30,NULL),(31,NULL),(32,NULL),(33,NULL),(34,NULL),(35,NULL),(36,NULL),(37,NULL),(38,NULL),(39,NULL),(40,NULL),(41,NULL),(42,NULL),(43,NULL),(44,NULL),(45,NULL),(46,NULL),(47,NULL),(48,NULL),(49,NULL),(50,NULL),(51,NULL),(52,NULL),(53,NULL),(54,NULL),(55,NULL),(56,NULL),(57,NULL),(58,NULL),(59,NULL),(60,NULL),(61,NULL),(62,NULL),(63,NULL),(64,NULL),(65,NULL),(66,NULL),(67,NULL),(68,NULL),(69,NULL),(70,NULL),(71,NULL),(72,NULL),(73,NULL),(74,NULL),(75,NULL),(76,NULL),(77,NULL),(78,NULL),(79,NULL),(80,NULL),(81,NULL),(82,NULL),(83,NULL),(84,NULL),(85,NULL),(86,NULL),(87,NULL),(88,NULL),(89,NULL),(90,NULL),(91,NULL),(92,NULL),(93,NULL),(94,NULL),(95,NULL),(96,NULL),(97,NULL),(98,NULL),(99,NULL),(100,NULL),(101,NULL),(102,NULL),(103,NULL),(104,NULL),(105,NULL),(106,NULL),(107,NULL),(108,NULL),(109,NULL),(110,NULL),(111,NULL),(112,NULL),(113,NULL),(114,NULL),(115,NULL),(116,NULL),(117,NULL),(118,NULL),(119,NULL),(120,NULL),(121,NULL),(122,NULL),(123,NULL),(124,NULL),(125,NULL),(126,NULL),(127,NULL),(128,NULL),(129,NULL),(130,NULL),(131,NULL),(132,NULL),(133,NULL),(134,NULL),(135,NULL),(136,NULL),(137,NULL),(138,NULL),(139,NULL),(140,NULL),(141,NULL),(142,NULL),(143,NULL),(144,NULL),(145,NULL),(146,NULL),(147,NULL),(148,NULL),(149,NULL),(150,NULL),(151,NULL),(152,NULL),(153,NULL),(154,NULL),(155,NULL),(156,NULL),(157,NULL),(158,NULL),(159,NULL),(160,NULL),(161,NULL),(162,NULL),(163,NULL),(164,NULL),(165,NULL),(166,NULL),(167,NULL),(168,NULL),(169,NULL),(170,NULL),(171,NULL),(172,NULL),(173,NULL),(174,NULL),(175,NULL),(176,NULL),(177,NULL),(178,NULL),(179,NULL),(180,NULL),(181,NULL),(182,NULL),(183,NULL),(184,NULL),(185,NULL),(186,NULL),(187,NULL),(188,NULL),(189,NULL),(190,NULL),(191,NULL),(192,NULL),(193,NULL),(194,NULL),(195,NULL),(196,NULL),(197,NULL),(198,NULL),(199,NULL),(200,NULL),(201,NULL),(202,NULL),(203,NULL),(204,NULL),(205,NULL),(206,NULL),(207,NULL),(208,NULL),(209,NULL),(210,NULL),(211,NULL),(212,NULL),(213,NULL),(214,NULL),(215,NULL),(216,NULL),(217,NULL),(218,NULL),(219,NULL),(220,NULL),(221,NULL),(222,NULL),(223,NULL),(224,NULL),(225,NULL),(226,NULL),(227,NULL),(228,NULL),(229,NULL),(230,NULL),(231,NULL),(232,NULL),(233,NULL),(234,NULL),(235,NULL),(236,NULL),(237,NULL),(238,NULL),(239,NULL),(240,NULL),(241,NULL),(242,NULL),(243,NULL),(244,NULL),(245,NULL),(246,NULL),(247,NULL),(248,NULL),(249,NULL),(250,NULL),(251,NULL),(252,NULL),(253,NULL),(254,NULL),(255,NULL),(256,NULL),(257,NULL),(258,NULL),(259,NULL),(260,NULL),(261,NULL),(262,NULL),(263,NULL),(264,NULL),(265,NULL),(266,NULL),(267,NULL),(268,NULL),(269,NULL),(270,NULL),(271,NULL),(272,NULL),(273,NULL),(274,NULL),(275,NULL),(276,NULL),(277,NULL),(278,NULL),(279,NULL),(280,NULL),(281,NULL),(282,NULL),(283,NULL),(284,'david');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `round`
--

DROP TABLE IF EXISTS `round`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `round` (
  `gameID` int NOT NULL,
  `roundNum` int NOT NULL,
  `roundWin` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `longestWord` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `round`
--

LOCK TABLES `round` WRITE;
/*!40000 ALTER TABLE `round` DISABLE KEYS */;
INSERT INTO `round` VALUES (116,1,'65565','analyzed'),(116,2,'0','adorn'),(116,2,'0','aloud'),(116,3,'0','aborts'),(116,3,'0','absurd'),(116,4,'0','other'),(116,4,'0','razor'),(117,1,'4213','agate'),(117,1,'4213','agape'),(123,1,'1234','batik'),(123,2,'0','arrow'),(123,2,'0','arrow'),(123,3,'4213','adorn'),(123,3,'4213','adorn'),(123,3,'4213','adorn'),(123,3,'4213','adorn'),(123,3,'4213','adore'),(123,3,'4213','adore'),(124,1,'0','abhor'),(124,1,'0','abhor'),(124,2,'412','abler'),(124,2,'412','abler'),(125,1,'5123','abide'),(125,1,'5123','abide'),(126,1,'0','coped'),(126,4,'5123','choose'),(126,5,'555','admin'),(126,6,'5123','chink'),(126,7,'0','aorta'),(126,8,'0','cacao'),(127,1,'5123','ivory'),(127,3,'555','finely'),(131,1,'555','envoy'),(131,3,'555','ability'),(132,1,'5555','advising'),(134,2,'4123','teletext'),(134,3,'4123','apotheosis'),(136,1,'3','adapters'),(136,2,'3','abandoned'),(136,3,'3','banding'),(137,1,'774','amaze'),(137,2,'774','bijou'),(137,3,'774','aimless'),(138,1,'443','apace'),(139,1,'82','acacia'),(140,1,'337','avoid'),(140,2,'337','acting'),(140,4,'337','cheek'),(141,1,'387','cabin'),(141,2,'387','agony'),(141,3,'387','acted'),(142,1,'766','cereal'),(142,2,'766','appetizer'),(142,3,'766','adjoins'),(144,1,'241','adore'),(144,2,'241','armour'),(144,3,'241','awful'),(145,1,'241','abdomen'),(146,1,'413','brooms'),(146,2,'413','badge'),(146,3,'413','alters'),(147,1,'264','coined'),(147,2,'264','begot'),(147,4,'264','ablaze'),(148,1,'264','cluing'),(149,1,'390','aloud'),(149,2,'390','archduke'),(149,3,'390','calved'),(150,1,'390','abbots'),(150,2,'390','albums'),(150,3,'390','acquirer'),(152,2,'191','bookie'),(152,3,'191','bumper'),(153,1,'545','appal'),(153,2,'545','barks'),(153,3,'545','bruit'),(154,1,'545','ached'),(154,2,'545','admits'),(154,3,'545','barker'),(155,1,'545','abler'),(156,1,'705','airflow'),(156,2,'705','gliding'),(156,3,'705','aviation'),(158,1,'771','bedroom'),(158,2,'771','anagrams'),(158,3,'771','fixity'),(159,2,'771','anyways'),(159,3,'771','almost'),(159,4,'771','beefs'),(161,1,'387','bewitch'),(161,2,'387','batch'),(161,3,'387','coins'),(163,1,'680','cagoule'),(163,2,'680','affix'),(163,3,'680','airbag'),(164,1,'680','headman'),(164,2,'680','enemas'),(164,3,'680','account'),(165,1,'3','bedsit'),(166,1,'3','fibrous'),(167,1,'3','accord'),(169,4,'1','earwig'),(173,3,'3','macaw'),(174,3,'5','aeration'),(176,1,'1','affix'),(186,1,'2','disrupt'),(186,2,'2','droopier'),(186,3,'4','billed'),(185,1,'3','awoken'),(186,5,'2','demon'),(185,4,'3','guava'),(185,5,'3','abductors'),(281,1,'3','ached'),(283,1,'2','airway'),(284,1,'4','afoot'),(283,3,'2','abases'),(284,2,'4','firmly'),(284,3,'3','below'),(284,4,'4','arbor');
/*!40000 ALTER TABLE `round` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `isOnline` bit(1) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','pass',_binary '\0'),(2,'zeph','zeph',_binary '\0'),(3,'darren','darren',_binary '\0'),(4,'david','joshua',_binary ''),(5,'ariel','12345',_binary '\0'),(6,'456','55555',_binary '\0');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `word`
--

DROP TABLE IF EXISTS `word`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `word` (
  `gameID` int NOT NULL,
  `roundNo` int NOT NULL,
  `userID` int NOT NULL,
  `words` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  KEY `userID_idx` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `word`
--

LOCK TABLES `word` WRITE;
/*!40000 ALTER TABLE `word` DISABLE KEYS */;
INSERT INTO `word` VALUES (5,1,412,'avidly'),(6,1,4321,'fantasia'),(6,4,4321,'backhoe'),(7,1,4321,'groovy'),(7,2,4321,'drifted'),(7,3,4321,'cutely'),(15,1,123,'abalones'),(16,1,112,'equip'),(16,2,112,'beaten'),(16,3,112,'fugue'),(17,1,123,'glottis'),(17,1,123,'glottis'),(17,2,123,'immunizes'),(17,3,523,'fairies'),(17,4,123,'loops'),(17,5,523,'blouse'),(17,5,123,'boles'),(19,1,5324,'abound'),(20,1,123,'adult'),(20,2,123,'augured'),(20,3,123,'backbone'),(21,1,234,'civil'),(21,1,532,'fuzzily'),(21,2,234,'queues'),(21,3,532,'asexual'),(24,1,213,'absolved'),(25,1,423,'muzak'),(30,2,4123,'acrylics'),(31,1,5123,'alley'),(32,1,5123,'dryly'),(35,1,45123,'acquire'),(35,2,45123,'admirer'),(35,3,45123,'abuses'),(36,1,412,'dowdy'),(37,1,4123,'boiled'),(37,2,4123,'jojoba'),(37,3,4123,'family'),(42,1,4213,'adamant'),(43,1,123,'actions'),(60,2,4124,'accent'),(60,3,4124,'agile'),(60,4,4124,'admin'),(61,1,55,'acorn'),(63,1,4213,'headset'),(64,2,123,'abbey'),(64,3,123,'alfresco'),(69,1,21,'motion'),(70,1,4123,'buttock'),(78,1,4213,'admit'),(80,1,123,'jumpy'),(80,1,5123,'jumpy'),(81,1,321,'adios'),(82,1,4213,'abort'),(82,2,4213,'exist'),(82,3,4213,'amazon'),(83,1,123,'damped'),(83,2,123,'abalone'),(85,1,4123,'emulate'),(86,1,342,'carpool'),(87,1,1234,'apron'),(90,1,412,'alveolars'),(91,2,55,'either'),(91,3,55,'cloudier'),(91,4,55,'bedbug'),(95,1,123,'cervix'),(96,1,423,'femur'),(97,1,123,'abusive'),(98,1,412,'bench'),(99,1,21,'basque'),(100,1,5421,'bedevils'),(100,2,5421,'acetone'),(100,3,5421,'agonise'),(101,1,4123,'exams'),(101,2,4123,'favourite'),(101,3,4123,'baited'),(102,2,4213,'advent'),(102,3,4213,'aches'),(102,4,4213,'anorak'),(103,2,4123,'allot'),(103,3,4123,'anoints'),(103,4,4123,'abbess'),(104,1,55,'abbots'),(104,2,55,'boughs'),(104,4,4213,'allege'),(104,5,55,'devout'),(105,1,4213,'climax'),(105,1,4213,'climax'),(105,1,4213,'climax'),(106,1,4123,'admiring'),(106,1,4123,'admiring'),(106,1,4123,'admiring'),(107,2,5123,'dildo'),(107,2,5123,'dildo'),(107,2,5123,'dildo'),(108,1,554213,'allot'),(108,1,554213,'allot'),(108,1,554213,'allot'),(108,2,554213,'compile'),(108,2,554213,'compile'),(108,2,554213,'compile'),(109,1,555,'civic'),(109,1,555,'civic'),(109,1,555,'civic'),(110,1,5123,'candy'),(110,1,5123,'candy'),(110,1,5123,'candy'),(111,1,512312,'abolish'),(112,1,8567,'aloes'),(112,1,8567,'aloes'),(112,1,8567,'aloes'),(0,1,2342,'asdc'),(0,1,2342,'asdc'),(113,1,412312,'canny'),(113,1,412312,'canny'),(113,1,412312,'canny'),(113,2,412312,'equip'),(114,1,65554,'cumin'),(114,1,65554,'cumin'),(114,1,65554,'cumin'),(115,1,8567,'check'),(115,1,8567,'check'),(115,1,8567,'check'),(116,1,65565,'analyzed'),(116,1,65565,'analyzed'),(116,1,65565,'analyzed'),(116,2,2222551,'adorn'),(116,2,2222551,'aloud'),(116,3,65565,'aborts'),(116,3,4123213,'absurd'),(116,4,4123213,'other'),(116,4,4123213,'razor'),(117,1,4213,'agate'),(117,1,4213,'agape'),(119,1,42132,'above'),(119,1,42132,'above'),(119,1,42132,'above'),(120,1,5324,'evoked'),(120,1,5324,'evoked'),(120,1,5324,'evoked'),(121,1,1234,'felony'),(121,1,1234,'felony'),(121,1,1234,'felony'),(122,1,22,'beery'),(122,1,22,'beery'),(122,1,22,'beery'),(123,1,1234,'batik'),(123,1,1234,'batik'),(123,1,1234,'batik'),(123,2,1234,'arrow'),(123,2,4213,'arrow'),(123,3,4213,'adorn'),(123,3,4213,'adore'),(124,1,412,'abhor'),(124,1,42332,'abode'),(124,2,412,'abler'),(124,2,412,'abode'),(125,1,5123,'abide'),(125,1,5123,'afire'),(126,1,555,'coped'),(126,1,5123,'count'),(126,4,5123,'choose'),(126,4,5123,'choose'),(126,4,5123,'choose'),(126,5,555,'admin'),(126,5,555,'aging'),(126,6,5123,'chink'),(126,6,5123,'chive'),(126,7,555,'aorta'),(126,7,5123,'apart'),(126,8,555,'cacao'),(126,8,5123,'cocoa'),(127,1,5123,'ivory'),(127,1,5123,'razor'),(127,3,555,'finely'),(131,1,555,'envoy'),(131,1,555,'felon'),(131,3,555,'ability'),(132,1,5555,'advising'),(134,2,4123,'teletext'),(134,3,4123,'apotheosis'),(136,1,3,'adapters'),(136,2,3,'abandoned'),(136,3,3,'banding'),(137,1,774,'amaze'),(137,2,774,'bijou'),(137,3,774,'aimless'),(138,1,443,'apace'),(139,1,82,'acacia'),(140,1,337,'avoid'),(140,2,337,'acting'),(140,4,337,'cheek'),(141,1,387,'cabin'),(141,2,387,'agony'),(141,3,387,'acted'),(142,1,766,'cereal'),(142,2,766,'appetizer'),(142,3,766,'adjoins'),(144,1,241,'adore'),(144,2,241,'armour'),(144,3,241,'awful'),(145,1,241,'abdomen'),(146,1,413,'brooms'),(146,2,413,'badge'),(146,3,413,'alters'),(147,1,264,'coined'),(147,2,264,'begot'),(147,4,264,'ablaze'),(148,1,264,'cluing'),(149,1,390,'aloud'),(149,2,390,'archduke'),(149,3,390,'calved'),(150,1,390,'abbots'),(150,2,390,'albums'),(150,3,390,'acquirer'),(152,2,191,'bookie'),(152,3,191,'bumper'),(152,4,191,'chewing'),(153,1,545,'appal'),(153,2,545,'barks'),(153,3,545,'bruit'),(154,1,545,'ached'),(154,2,545,'admits'),(154,3,545,'barker'),(155,1,545,'abler'),(156,1,705,'airflow'),(156,2,705,'gliding'),(156,3,705,'aviation'),(158,1,771,'bedroom'),(158,2,771,'anagrams'),(158,3,771,'fixity'),(159,2,771,'anyways'),(159,3,771,'almost'),(159,4,771,'beefs'),(161,1,387,'bewitch'),(161,2,387,'batch'),(161,3,387,'coins'),(163,1,680,'cagoule'),(163,2,680,'affix'),(163,3,680,'airbag'),(164,1,680,'headman'),(164,2,680,'enemas'),(164,2,680,'enemas'),(164,3,680,'account'),(165,1,3,'bedsit'),(166,1,3,'fibrous'),(167,1,3,'accord'),(169,4,1,'earwig'),(173,3,3,'macaw'),(174,3,5,'aeration'),(176,1,1,'affix'),(186,1,2,'disrupt'),(186,2,2,'droopier'),(186,3,4,'billed'),(185,1,3,'awoken'),(186,5,2,'demon'),(185,4,3,'guava'),(185,5,3,'abductors'),(281,1,3,'ached'),(283,1,2,'airway'),(284,1,4,'afoot'),(283,3,2,'abases'),(284,2,4,'firmly'),(284,3,3,'below'),(284,4,4,'arbor');
/*!40000 ALTER TABLE `word` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-28  8:33:15

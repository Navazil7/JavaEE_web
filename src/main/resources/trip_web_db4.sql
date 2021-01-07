-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: trip_web_db
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tp_admin`
--

DROP TABLE IF EXISTS `tp_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_admin` (
  `tp_aid` int NOT NULL AUTO_INCREMENT,
  `tp_aname` varchar(100) DEFAULT NULL,
  `tp_aemail` varchar(100) DEFAULT NULL,
  `tp_apwd` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tp_aid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_admin`
--

LOCK TABLES `tp_admin` WRITE;
/*!40000 ALTER TABLE `tp_admin` DISABLE KEYS */;
INSERT INTO `tp_admin` VALUES (1,'root','root@root.com','root'),(2,'yyy','yyy','yyy'),(3,'yyy@zjut.cn','yyy','yyy'),(4,'yyy','yyy@zjut.cn','yyy');
/*!40000 ALTER TABLE `tp_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tp_city`
--

DROP TABLE IF EXISTS `tp_city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_city` (
  `tp_cid` int NOT NULL AUTO_INCREMENT,
  `tp_cname` varchar(45) DEFAULT NULL,
  `tp_cprovince` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tp_cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_city`
--

LOCK TABLES `tp_city` WRITE;
/*!40000 ALTER TABLE `tp_city` DISABLE KEYS */;
/*!40000 ALTER TABLE `tp_city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tp_forum`
--

DROP TABLE IF EXISTS `tp_forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_forum` (
  `tp_fid` int NOT NULL AUTO_INCREMENT,
  `tp_author_id` varchar(100) DEFAULT NULL,
  `tp_author` varchar(100) DEFAULT NULL,
  `tp_title` varchar(100) DEFAULT NULL,
  `tp_sub_title` varchar(100) DEFAULT NULL,
  `tp_issue_time` varchar(100) DEFAULT NULL,
  `tp_tag` varchar(100) DEFAULT NULL,
  `tp_tcontent` text,
  PRIMARY KEY (`tp_fid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_forum`
--

LOCK TABLES `tp_forum` WRITE;
/*!40000 ALTER TABLE `tp_forum` DISABLE KEYS */;
INSERT INTO `tp_forum` VALUES (2,'2','123','test','tset',NULL,'set','<p><img src=\"/static/upload/forumFile/6cc44591-1bba-46ce-8b2a-6ca5d0193db8.jpg\" style=\"max-width:100%;\"><br></p>'),(3,'2','123','从前有座山，山里有座庙','嘻嘻哈哈',NULL,'','<p>1322222222222222222222222222</p><table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></tbody></table><p><font color=\"#f9963b\">2132</font>13123<span style=\"background-color: rgb(249, 150, 59);\">12312312</span>3地方<u>的</u></p>');
/*!40000 ALTER TABLE `tp_forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tp_hotel`
--

DROP TABLE IF EXISTS `tp_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_hotel` (
  `hid` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `local` varchar(100) DEFAULT NULL,
  `house_type` varchar(100) DEFAULT NULL,
  `bed_type` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `people_num` varchar(100) DEFAULT NULL,
  `zip` varchar(100) DEFAULT NULL,
  `house_size` varchar(100) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL,
  `img_url` varchar(100) DEFAULT NULL,
  `content` text,
  `longitude` varchar(45) DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_hotel`
--

LOCK TABLES `tp_hotel` WRITE;
/*!40000 ALTER TABLE `tp_hotel` DISABLE KEYS */;
INSERT INTO `tp_hotel` VALUES (1,'123','123','21','123','12312','','123','123','123','91e337fa-ed5a-42b9-ba35-c06258231c3e.jpg','<p>1233333333333333333</p>',NULL,NULL,NULL),(2,'wqewqeqw','q231123','qwe','qweqw','eqwe',NULL,'qwe','qwe','123','046cc263-64d7-4d0c-8426-dbbcf273ab99.jpg','<p>qweqwewqeqw</p>',NULL,NULL,NULL);
/*!40000 ALTER TABLE `tp_hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tp_reply`
--

DROP TABLE IF EXISTS `tp_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_reply` (
  `tp_rid` int NOT NULL AUTO_INCREMENT,
  `tp_rname` varchar(100) DEFAULT NULL,
  `tp_rdate` varchar(100) DEFAULT NULL,
  `tp_rcontent` varchar(100) DEFAULT NULL,
  `tp_r_for_name` varchar(100) DEFAULT NULL,
  `tp_r_for_words` varchar(100) DEFAULT NULL,
  `tp_r_for_reply` varchar(100) DEFAULT NULL,
  `tp_r_viewpointId` varchar(100) DEFAULT NULL,
  `tp_r_forumId` varchar(100) DEFAULT NULL,
  `tp_r_hotelId` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tp_rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_reply`
--

LOCK TABLES `tp_reply` WRITE;
/*!40000 ALTER TABLE `tp_reply` DISABLE KEYS */;
INSERT INTO `tp_reply` VALUES (1,'123','2020-12-28 05:29:50','123123','123','3','','1',NULL,NULL),(2,'','2021-01-03 05:48:31','gay gun','','7','',NULL,'3',NULL);
/*!40000 ALTER TABLE `tp_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tp_station`
--

DROP TABLE IF EXISTS `tp_station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_station` (
  `tp_sid` int NOT NULL AUTO_INCREMENT,
  `tp_sname` varchar(100) DEFAULT NULL,
  `tp_stype` varchar(45) DEFAULT NULL,
  `tp_slocal` varchar(100) DEFAULT NULL,
  `tp_slongitude` varchar(45) DEFAULT NULL,
  `tp_slatitude` varchar(45) DEFAULT NULL,
  `tp_scity` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tp_sid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_station`
--

LOCK TABLES `tp_station` WRITE;
/*!40000 ALTER TABLE `tp_station` DISABLE KEYS */;
INSERT INTO `tp_station` VALUES (1,'杭州东站','火车','浙江省, 杭州市, 江干区, 新风里, 16号','120.22056773373247','30.292413207713437','杭州');
/*!40000 ALTER TABLE `tp_station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tp_traffic`
--

DROP TABLE IF EXISTS `tp_traffic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_traffic` (
  `tp_Tid` int NOT NULL AUTO_INCREMENT,
  `tp_type` varchar(100) DEFAULT NULL,
  `tp_current` varchar(100) DEFAULT NULL,
  `tp_destination` varchar(100) DEFAULT NULL,
  `tp_current_time` varchar(100) DEFAULT NULL,
  `tp_arrive_time` varchar(100) DEFAULT NULL,
  `tp_tprice` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tp_Tid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_traffic`
--

LOCK TABLES `tp_traffic` WRITE;
/*!40000 ALTER TABLE `tp_traffic` DISABLE KEYS */;
INSERT INTO `tp_traffic` VALUES (1,'火车','北京市','绵阳市','2019-05-18 13:05:20','2019-05-17 14:50:42','356.0');
/*!40000 ALTER TABLE `tp_traffic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tp_user`
--

DROP TABLE IF EXISTS `tp_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_user` (
  `tp_uid` int NOT NULL AUTO_INCREMENT,
  `tp_uname` varchar(100) DEFAULT NULL,
  `tp_uemail` varchar(100) DEFAULT NULL,
  `tp_upwd` varchar(100) DEFAULT NULL,
  `tp_age` varchar(100) DEFAULT NULL,
  `tp_gender` varchar(100) DEFAULT NULL,
  `tp_upic` varchar(100) DEFAULT NULL,
  `tp_phone` varchar(100) DEFAULT NULL,
  `tp_regdate` timestamp NULL DEFAULT NULL,
  `tp_update_time` timestamp NULL DEFAULT NULL,
  `tp_like` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tp_uid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_user`
--

LOCK TABLES `tp_user` WRITE;
/*!40000 ALTER TABLE `tp_user` DISABLE KEYS */;
INSERT INTO `tp_user` VALUES (1,'ziming','ziming@163.com','ziming','19',NULL,NULL,NULL,NULL,NULL,NULL),(2,'123','123@zjut.cn','123','12','nan',NULL,'110','2020-12-26 23:58:25','2020-12-26 23:58:25',NULL),(5,'ttt','ttt@zjut.cn','ttt',NULL,NULL,'default.jpg',NULL,'2020-12-30 01:03:41','2020-12-30 01:03:41',NULL),(6,'wwww','wwww@zjut.cn','wwww',NULL,NULL,'default.jpg',NULL,'2020-12-30 07:32:03','2020-12-30 07:32:04',NULL);
/*!40000 ALTER TABLE `tp_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tp_viewpoint`
--

DROP TABLE IF EXISTS `tp_viewpoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_viewpoint` (
  `tp_vid` int NOT NULL AUTO_INCREMENT,
  `tp_title` varchar(100) DEFAULT NULL,
  `tp_vname` varchar(100) DEFAULT NULL,
  `tp_vtype` varchar(100) DEFAULT NULL,
  `tp_vpic` varchar(100) DEFAULT NULL,
  `tp_vphone` varchar(100) DEFAULT NULL,
  `tp_level` varchar(100) DEFAULT NULL,
  `tp_price` varchar(100) DEFAULT NULL,
  `tp_location` varchar(100) DEFAULT NULL,
  `tp_zip` varchar(100) DEFAULT NULL,
  `tp_opentime` varchar(100) DEFAULT NULL,
  `tp_creatTime` timestamp NULL DEFAULT NULL,
  `tp_vcontent` text,
  `tp_vlongitude` varchar(45) DEFAULT NULL,
  `tp_vlatitude` varchar(45) DEFAULT NULL,
  `tp_vcity` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tp_vid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_viewpoint`
--

LOCK TABLES `tp_viewpoint` WRITE;
/*!40000 ALTER TABLE `tp_viewpoint` DISABLE KEYS */;
INSERT INTO `tp_viewpoint` VALUES (1,'123','123','3','28eafde4-ca48-4e3e-a537-85cb9ec585c5.jpg','12312','3123','31','213','123','123',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tp_viewpoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tp_words`
--

DROP TABLE IF EXISTS `tp_words`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_words` (
  `tp_wid` int NOT NULL AUTO_INCREMENT,
  `tp_wname` varchar(100) DEFAULT NULL,
  `tp_wdate` varchar(100) DEFAULT NULL,
  `tp_wcontent` varchar(100) DEFAULT NULL,
  `tp_w_for_name` varchar(100) DEFAULT NULL,
  `tp_w_viewpointId` varchar(100) DEFAULT NULL,
  `tp_w_forumId` varchar(100) DEFAULT NULL,
  `tp_w_hotelId` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tp_wid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_words`
--

LOCK TABLES `tp_words` WRITE;
/*!40000 ALTER TABLE `tp_words` DISABLE KEYS */;
INSERT INTO `tp_words` VALUES (1,'123','2020-12-27 03:55:32','你在干什么',NULL,NULL,'2',NULL),(2,'123','2020-12-28 05:29:44','',NULL,'1',NULL,NULL),(3,'123','2020-12-28 05:29:45','???????????????????',NULL,'1',NULL,NULL),(4,'','2020-12-29 07:23:53','',NULL,NULL,NULL,'2'),(5,'','2020-12-29 07:23:55','123123123',NULL,NULL,NULL,'2'),(6,'','2021-01-03 04:34:25','nihaoxiangbutaidong',NULL,NULL,'3',NULL),(7,'','2021-01-03 05:48:20','兄弟抱一下',NULL,NULL,'3',NULL);
/*!40000 ALTER TABLE `tp_words` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-03 18:53:03

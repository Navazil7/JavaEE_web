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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_city`
--

LOCK TABLES `tp_city` WRITE;
/*!40000 ALTER TABLE `tp_city` DISABLE KEYS */;
INSERT INTO `tp_city` VALUES (1,'杭州','浙江'),(2,'重庆',NULL),(3,'北京',NULL),(4,'成都','四川'),(5,'西安','陕西'),(6,'南京','江苏'),(7,'上海',NULL),(8,'长沙','湖南'),(9,'天津',NULL),(10,'深圳',NULL),(11,'广州','广东'),(12,'福州','福建'),(13,'上海',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_forum`
--

LOCK TABLES `tp_forum` WRITE;
/*!40000 ALTER TABLE `tp_forum` DISABLE KEYS */;
INSERT INTO `tp_forum` VALUES (4,'2','小王','迪士尼','攻略',NULL,'上海','<div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上海迪士尼乐园占地1.16平方公里，位于<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%8A%E6%B5%B7%E8%BF%AA%E5%A3%AB%E5%B0%BC%E5%BA%A6%E5%81%87%E5%8C%BA/3337842\">上海迪士尼度假区</a>的核心位置，以奇幻童话城堡为中心，四周分布着七个主题园区，分别为米奇大街、奇想花园、探险岛、宝藏湾、明日世界、梦幻世界、迪士尼·皮克斯玩具总动员。主入口正对着一片中心湖，两旁是商业娱乐设施和酒店。<sup>&nbsp;</sup></div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;迪士尼创意团队为上海迪士尼乐园设计了“米奇大街”作为迎宾入口，由此取代了迪士尼近60年的以美国小镇为主题的设计传统。不只是迎宾大道，在上海迪士尼的各个景点设计中，处处可见中国元素。标志性的景点“奇幻童话城堡”高处尖顶缀有传统中国祥云、牡丹、莲花及上海市花白玉兰等元素；中式餐厅漫月轩更是继承了传统中式建筑风格，向游历中国大地、充满艺术创作情怀的文人墨客致敬，选择了高山、海洋、沙漠、森林和河流五大元素为主题；而在“奇想花园”，迪士尼标志性的旋转木马全由中国手工艺匠精心打造，72种绚烂颜色美妙地交织。<sup>&nbsp;</sup></div>'),(5,'2','小张','马鞍山','游记',NULL,'湖南','<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;马鞍山介于新化县城和天龙山之间，以前有个马鞍山煤矿的，不过这几年破产了，那些职工住房区在建廉租房，应该也会用马鞍山命名吧。附近有座海拔较高的山——金子山，具体多高暂时无法写实。金子山脚下是工农小学，小学旁边是金马水泥厂，洪大村的各个村民小组零散的分布在它们之间，洪大村第十组和十一组之间有两个水库，均命名为马鞍山水库，其中一个水库上正在建桥和亭子，共同属于建设中的马鞍山风景区。</p><p><br></p>');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_hotel`
--

LOCK TABLES `tp_hotel` WRITE;
/*!40000 ALTER TABLE `tp_hotel` DISABLE KEYS */;
INSERT INTO `tp_hotel` VALUES (1,'杭州柏悦酒店（天际下午茶，网红餐厅酒吧）','杭州市黄龙体育中心商圈','','','123456',NULL,NULL,'','1588','eb03c941-c698-43c5-be56-b887cc4e59b3.webp','<p><br></p>','120.22151','30.25991','杭州'),(2,'杭州马可波罗滨湖酒店','杭州市上城区解放路251号杭州解百城市奥莱F1','','','123456','',NULL,'','571','d8bc93ed-f39a-4a16-9b1c-c55b4298e560.webp','<p><br></p>','120.172642','30.255124','杭州'),(3,'浙江西湖山庄','浙江省杭州市西湖区北山路84号(近葛岭路口)','','','123456',NULL,NULL,'','600','965c89c3-f147-4e8f-8bfe-f868c106b198.webp','<p><br></p>','120.147015','30.262029','杭州'),(4,'全季酒店(西湖湖滨店)','杭州市上城区开元路66号','','','123456',NULL,NULL,'','400','fa829485-f0f6-43fc-b52e-e1d515c77afc.webp','<p><br></p>','120.173505','30.25335','杭州'),(5,'Here艺术酒店','浙江省杭州市西湖区西湖风景名胜区杭州Here艺术酒店','','','123456',NULL,NULL,'','399','daeff116-d20d-48af-8d27-f9450704337c.webp','<p><br></p>','120.131375','30.225055','杭州'),(6,'杭州黄龙饭店','浙江省杭州市西湖区曙光路120号','','','123456',NULL,NULL,'','895','22beb42a-a4c4-4f7e-bddd-bf0bf580313b.webp','<p><br></p>','120.149368','30.273372','杭州'),(7,'千岛湖梅地亚君澜度假酒店','浙江省杭州市淳安县千岛湖镇梦姑路488号','','','123456',NULL,NULL,'','1000','23d59094-00ea-4e78-8e9b-110163797612.jpeg','<p><br></p>','119.014653','29.599737','杭州'),(8,'漫心上海徐家汇酒店','上海市裕德路45号','','','123456',NULL,NULL,'','158','3f675b1c-7ffd-4b1b-971e-67ba9857935b.jpeg','<p><br></p>','121.44196','31.191364','上海'),(9,'上海静安香格里拉大酒店','上海市浦东新区富城路33号浦东香格里拉大酒店','','','123456',NULL,NULL,'','1599','2ceab2fe-0f09-4209-8fb4-803be4d839ef.jpeg','<p><br></p>','121.505943','31.241192','上海'),(10,'上海西郊宾馆','上海市长宁区虹桥路1921号','','','123456',NULL,NULL,'','1209','4e5cd02e-6bcd-4e90-a638-2e68bf6fb3ca.jpeg','<p><br></p>','121.385368','31.20726','上海'),(11,'金奥诺阁雅酒店(上海打浦桥店)','上海市徐汇区合宝路58号','','','123456',NULL,NULL,'','399','18931689-2d4f-4225-bad9-935e6de3c613.jpeg','<p><br></p>','121.471356','31.206574','上海'),(12,'桔子水晶上海外滩金陵东路酒店','上海市黄浦区金陵东路511号','','','123456',NULL,NULL,'','850','3a3dd065-ac94-4fb7-a007-4f25b40de515.jpeg','<p><br></p>','121.488424','31.233394','上海'),(13,'上海凯世精品酒店','上海市静安区南京西路931号','','','123456',NULL,NULL,'','665','157d3bc0-a065-4411-990d-2097a9d91d0a.jpeg','<p><br></p>','121.465579','31.235815','上海'),(14,'白玉兰酒店(上海磁悬浮总站店)','上海市浦东新区白杨路260号','','','123456',NULL,NULL,'','299','c229ce99-b1fd-4d49-b208-c742e10843d0.jpeg','<p><br></p>','121.561504','31.213576','上海');
/*!40000 ALTER TABLE `tp_hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tp_order`
--

DROP TABLE IF EXISTS `tp_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tp_order` (
  `tp_oid` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tp_uid` int NOT NULL,
  `tp_oinfo` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tp_status` varchar(3) NOT NULL,
  PRIMARY KEY (`tp_oid`),
  KEY `fk_order_user_idx` (`tp_uid`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`tp_uid`) REFERENCES `tp_user` (`tp_uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_order`
--

LOCK TABLES `tp_order` WRITE;
/*!40000 ALTER TABLE `tp_order` DISABLE KEYS */;
INSERT INTO `tp_order` VALUES ('A202101101856026516',10,'南宋御街#杭州市上城区中山中路106号#576373039@qq.com#13878596516#25#2021-01-10#18:56:02#2021年1月10日#32#2','未使用');
/*!40000 ALTER TABLE `tp_order` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_station`
--

LOCK TABLES `tp_station` WRITE;
/*!40000 ALTER TABLE `tp_station` DISABLE KEYS */;
INSERT INTO `tp_station` VALUES (1,'杭州东站','火车','浙江省, 杭州市, 江干区, 新风里, 16号','120.22056773373247','30.292413207713437','杭州'),(3,'杭州萧山机场','飞机','浙江省, 杭州市, 萧山区, 空港大道,','120.43580173392318','30.236640648428416','杭州'),(5,'北京站','火车','北京市, 北京市, 东城区, 毛家湾胡同, 甲13号','116.43331170366541','39.90945370692867','北京'),(6,'北京首都机场','飞机','北京市, 北京市, 朝阳区, 航管南路,','116.59759381533019','40.08428540653673','北京'),(7,'上海南站','火车','上海市, 上海市, 徐汇区, 石龙路, 980弄-1-37号','121.43421440993308','31.154688862448452','上海'),(8,'上海浦东机场','飞机','上海市, 上海市, 浦东新区, S32(申嘉湖高速),','121.81710815050609','31.146777280463382','上海');
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_traffic`
--

LOCK TABLES `tp_traffic` WRITE;
/*!40000 ALTER TABLE `tp_traffic` DISABLE KEYS */;
INSERT INTO `tp_traffic` VALUES (1,'火车','北京站','杭州东站','2021-01-12 20:45:47','2021-01-13 02:45:47','540'),(2,'火车','北京站','杭州东站','2021-01-12 08:20:47','2021-01-12 14:20:47','553'),(3,'火车','北京站','杭州东站','2021-01-12 12:00:47','2021-01-12 18:00:47','909'),(4,'火车','北京站','杭州东站','2020-01-08 17:00:47','2020-01-08 23:00:47','566'),(5,'飞机','北京首都机场','杭州萧山机场','2020-01-08 07:00:47','2020-01-08 09:40:47','1190'),(6,'飞机','北京首都机场','杭州萧山机场','2021-01-12 07:45:47','2021-01-12 10:20:47','660'),(7,'飞机','北京首都机场','杭州萧山机场','2021-01-12 11:30:47','2021-01-12 14:10:47','1076'),(8,'飞机','北京首都机场','杭州萧山机场','2021-01-12 20:00:47','2021-01-12 22:45:47','483'),(9,'火车','北京站','上海南站','2020-01-08 03:00:47','2020-01-08 05:00:47','553'),(10,'火车','北京站','上海南站','2021-01-12 07:20:47','2021-01-12 12:20:47','576'),(11,'火车','北京站','上海南站','2021-01-12 12:30:47','2021-01-12 17:30:47','598'),(12,'火车','北京站','上海南站','2021-01-12 22:00:47','2021-01-12 03:00:47','526'),(13,'飞机','北京首都机场','上海浦东机场','2020-01-08 13:00:47','2020-01-08 15:00:47','1236'),(14,'飞机','北京首都机场','上海浦东机场','2021-01-12 06:45:47','2021-01-12 08:45:47','500'),(15,'飞机','北京首都机场','上海浦东机场','2021-01-12 12:20:47','2021-01-12 14:10:47','225'),(16,'飞机','北京首都机场','上海浦东机场','2021-01-12 21:45:47','2021-01-12 23:45:47','483');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_user`
--

LOCK TABLES `tp_user` WRITE;
/*!40000 ALTER TABLE `tp_user` DISABLE KEYS */;
INSERT INTO `tp_user` VALUES (10,'碱性肥皂','576373039@qq.com','yyy',NULL,NULL,'default.jpg','13878596516','2021-01-10 02:55:59','2021-01-10 02:55:59','游玩度假区:2#');
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_viewpoint`
--

LOCK TABLES `tp_viewpoint` WRITE;
/*!40000 ALTER TABLE `tp_viewpoint` DISABLE KEYS */;
INSERT INTO `tp_viewpoint` VALUES (1,'外滩','外滩','游玩度假区','af3f24f0-4bb3-4f9d-8e97-8fa674f5efbe.jpg','123456','5A','23','上海市黄浦区中山东一路（临黄浦江','',NULL,NULL,'','121.497204','31.243453','上海'),(2,'东方明珠','东方明珠','人文景观类','c07f0cea-c568-41ee-943d-a93a94219a26.jpg','123456','5A','199','上海市浦东新区陆家嘴世纪大道1号',NULL,'',NULL,'','121.506379','31.245414','上海'),(3,'上海迪士尼度假区','上海迪士尼度假区','游玩度假区','3bb59341-f979-4863-92d9-6b09aefdb096.jpg','(021)31580000','5A','369','上海市浦东新区川沙镇黄赵路310号',NULL,'',NULL,'','121.671964','31.148267','上海'),(6,'南京路步行街','南京路步行街','休闲购物类','2b18831a-1bc6-4ae0-b5b9-055f40c7cfd7.jpg','123456','4A','80','上海市黄浦区河南中路33号',NULL,'',NULL,NULL,'121.491127','31.243487','上海'),(14,'静安寺','静安寺','文化古迹类','7b1d7c4d-38a5-4c51-b55d-5e365c47e496.jpg','(021)62566366','5A','50','上海市静安区南京西路1686号',NULL,'',NULL,NULL,'121.451592','31.229924','上海'),(15,'西湖','西湖','游玩度假区','ae6e4fac-8b49-4150-bcee-d4bbfcc1ec44.jpg','123456','5A','44','杭州市西湖区龙井路1号',NULL,'',NULL,NULL,'120.12792','30.228932','杭州'),(16,'灵隐寺','灵隐寺','文化古迹类','270318c5-83f9-43eb-8f4b-b3f6b1813547.jpg','(0571)87968665','5A','75','杭州市西湖区灵隐路法云弄1号',NULL,'',NULL,NULL,'120.107833','30.246914','杭州'),(17,'西溪国家湿地公园','西溪国家湿地公园','游玩度假区','e04def05-6341-4c07-b510-a75edee3f403.jpg','(0571)88106696','5A','70','杭州市西湖区天目山路518号',NULL,'',NULL,NULL,'120.071528','30.27289','杭州'),(18,'杭州宋城','杭州宋城','文化古迹类','0eca01c6-c8a2-4ad4-8dad-647f97eaa77e.jpg','(0571)87313101','4A','300','杭州市西湖区之江路148号',NULL,'',NULL,NULL,'120.105381','30.175794','杭州'),(19,'严子陵钓台','严子陵钓台','人文景观类','4e0a76ea-d9f5-44f8-977e-9cb9d853f77d.jpg','123456','4A','112','杭州市桐庐县富春江镇七里泷段',NULL,'',NULL,NULL,'119.665807','29.703618','杭州'),(32,'南宋御街','南宋御街','休闲购物类','a2ec0a22-63cc-4516-b7ac-2ecaa5d8418e.jpeg','123456','4A','25','杭州市上城区中山中路106号',NULL,'',NULL,NULL,'120.177601','30.247498','杭州');
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

-- Dump completed on 2021-01-10 19:31:21

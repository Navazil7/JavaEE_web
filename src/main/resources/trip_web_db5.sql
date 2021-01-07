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
INSERT INTO `tp_forum` VALUES (2,'2','123','test','tset',NULL,'set','<p><img src=\"/static/upload/forumFile/6cc44591-1bba-46ce-8b2a-6ca5d0193db8.jpg\" style=\"max-width:100%;\"><br></p>'),(3,'2','123','从前有座山，山里有座庙','嘻嘻哈哈',NULL,'','<p>1322222222222222222222222222</p><table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th><th>&nbsp;</th></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr><tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></tbody></table><p><font color=\"#f9963b\">2132</font>13123<span style=\"background-color: rgb(249, 150, 59);\">12312312</span>3地方<u>的</u></p>'),(4,'2','小王','迪士尼','攻略',NULL,'上海','<div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上海迪士尼乐园占地1.16平方公里，位于<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%8A%E6%B5%B7%E8%BF%AA%E5%A3%AB%E5%B0%BC%E5%BA%A6%E5%81%87%E5%8C%BA/3337842\">上海迪士尼度假区</a>的核心位置，以奇幻童话城堡为中心，四周分布着七个主题园区，分别为米奇大街、奇想花园、探险岛、宝藏湾、明日世界、梦幻世界、迪士尼·皮克斯玩具总动员。主入口正对着一片中心湖，两旁是商业娱乐设施和酒店。<sup>&nbsp;</sup></div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;迪士尼创意团队为上海迪士尼乐园设计了“米奇大街”作为迎宾入口，由此取代了迪士尼近60年的以美国小镇为主题的设计传统。不只是迎宾大道，在上海迪士尼的各个景点设计中，处处可见中国元素。标志性的景点“奇幻童话城堡”高处尖顶缀有传统中国祥云、牡丹、莲花及上海市花白玉兰等元素；中式餐厅漫月轩更是继承了传统中式建筑风格，向游历中国大地、充满艺术创作情怀的文人墨客致敬，选择了高山、海洋、沙漠、森林和河流五大元素为主题；而在“奇想花园”，迪士尼标志性的旋转木马全由中国手工艺匠精心打造，72种绚烂颜色美妙地交织。<sup>&nbsp;</sup></div>'),(5,'2','小张','马鞍山','游记',NULL,'湖南','<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;马鞍山介于新化县城和天龙山之间，以前有个马鞍山煤矿的，不过这几年破产了，那些职工住房区在建廉租房，应该也会用马鞍山命名吧。附近有座海拔较高的山——金子山，具体多高暂时无法写实。金子山脚下是工农小学，小学旁边是金马水泥厂，洪大村的各个村民小组零散的分布在它们之间，洪大村第十组和十一组之间有两个水库，均命名为马鞍山水库，其中一个水库上正在建桥和亭子，共同属于建设中的马鞍山风景区。</p><p><br></p>');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_hotel`
--

LOCK TABLES `tp_hotel` WRITE;
/*!40000 ALTER TABLE `tp_hotel` DISABLE KEYS */;
INSERT INTO `tp_hotel` VALUES (1,'上海婧玲公寓','上海,上海市, 上海市, 浦东新区, 周浦建设路,','单间/双间','大床房/双床房','0938-12312','2+',NULL,'15㎡起','78起','af78f3d5-9c72-490b-a5cb-1c2a93d9e8dd.jpg','<h2>酒店信息</h2><div><dl><dt>酒店介绍</dt><dd><ul><li><h3>基本信息：</h3><div><p><em>酒店电话：021-26137886,4220126</em>&nbsp;<em>艺龙服务热线：95711</em></p><p><em>开业时间：2019年03月</em>&nbsp;<em>客房数：1间</em></p></div></li><li><h3>酒店简介：</h3><div><p>这里是我精心准备的家。有缘来住下的朋友，希望它能为你带来一段温馨难忘的旅途体验。</p></div></li></ul></dd></dl><dl><dt>温馨提示</dt><dd><ul><li><h3>预订须知：</h3><divmargin: 0px;=\"\" padding:=\"\" 0px;\"=\"\"><p>为贯彻落实《上海市生活垃圾管理条例》相关规定，推进生活垃圾源头减量，上海市文化和旅游局特制定《关于本市旅游住宿业不主动提供客房一次性日用品的实施意见》，2019年7月1日起，上海市旅游住宿业将不再主动提供牙刷、梳子、浴擦、剃须刀、指甲锉、鞋擦这些一次性日用品。若需要可咨询酒店。</p></divmargin:></li></ul></dd></dl></div><li><h3>温馨提示：</h3><div><em title=\"酒店仅接待大陆客人\">酒店仅接待大陆客人</em></div></li><li><h3>入离时间：</h3><divmargin: 0px;=\"\" padding:=\"\" 0px;\"=\"\"><p><em>入住时间:14点以后</em>&nbsp;<em>离店时间:12点以前</em></p></divmargin:></li><dl><dt>酒店设施</dt><dd><ul><li><h3>通用设施：</h3><div><div><span title=\"有电梯\">有电梯</span></div></div></li></ul></dd></dl><dl><dt>证照信息</dt><dd>&nbsp;&nbsp;<a method=\"showSupplierLicense\">查看供应商信息</a></dd></dl><dl><dt>价格说明</dt><dd><ul><li>划线价格指商品或服务的门市价、服务提供商的指导价、零售价或该商品或服务曾经展示过的销售价等，并非原价；产品信息实时更新、市场价格波动等原因都可能导致价格与您预订时展示的价格不一致，该价格仅供您参考。<br>未划线价格指商品或服务的实时标价。</li></ul></dd></dl><p><br></p>','121.65828773634199','31.135155940193286',NULL),(2,'富恒精品酒店','杭州,浙江省, 杭州市, 上城区, 佑圣观路, 187号','单间/双间','大床房/双床房','0938-666666','2+',NULL,'15㎡起','78起','bf1d1b1a-d3b5-432f-9978-a122a7583c03.jpg','<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;富恒精品酒店地处繁华的商业和文化中心，紧邻杭州城站火车站，西湖大道及南宋御街，附近有多处著名自然和人文景观，距延安路商业街、武林路女装街、南山路酒吧一条街、清河坊街、高银街小吃一条街、湖滨国际步行街、中国美术学院、四季青服装市场5至10分钟车程，交通十分便利。 酒店设有温馨、舒适的商务套房、标准房、大床房等，24小时供应热水、独立空调、有限上网等，地理位置优越、是商务、旅行、购物观光的理想居所。 此酒店二楼为餐厅，三楼为足浴，四楼五楼为客房 ，上下有电梯方便出行。</p><p><br></p>','120.18165313904022','30.253425689930257',NULL),(3,'随缘居','重庆,重庆市, 重庆市, 九龙坡区, 华龙大道, 8号-43','单间/双间','大床房/双床房','0938-666666','2+',NULL,'15㎡起','78起','797d2b7d-6cd4-4806-a400-526551195c13.jpg','<h2>酒店信息</h2><div><dl><dt>酒店介绍</dt><dd><ul><li><h3>基本信息：</h3><div><p><em>酒店电话：021-26137886,4220126</em>&nbsp;<em>艺龙服务热线：95711</em></p><p><em>开业时间：2019年03月</em>&nbsp;<em>客房数：1间</em></p></div></li><li><h3>酒店简介：</h3><div><p>这里是我精心准备的家。有缘来住下的朋友，希望它能为你带来一段温馨难忘的旅途体验。</p></div></li></ul></dd></dl><dl><dt>温馨提示</dt><dd><ul><li><h3>预订须知：</h3><divmargin: 0px;=\"\" padding:=\"\" 0px;\"=\"\"><p>为贯彻落实《xx市生活垃圾管理条例》相关规定，推进生活垃圾源头减量，xx市文化和旅游局特制定《关于本市旅游住宿业不主动提供客房一次性日用品的实施意见》，2019年7月1日起，xx市旅游住宿业将不再主动提供牙刷、梳子、浴擦、剃须刀、指甲锉、鞋擦这些一次性日用品。若需要可咨询酒店。</p></divmargin:></li></ul></dd></dl></div><li><h3>温馨提示：</h3><div><em title=\"酒店仅接待大陆客人\">酒店仅接待大陆客人</em></div></li><li><h3>入离时间：</h3><divmargin: 0px;=\"\" padding:=\"\" 0px;\"=\"\"><p><em>入住时间:14点以后</em>&nbsp;<em>离店时间:12点以前</em></p></divmargin:></li><dl><dt>酒店设施</dt><dd><ul><li><h3>通用设施：</h3><div><div><span title=\"有电梯\">有电梯</span></div></div></li></ul></dd></dl><dl><dt>证照信息</dt><dd>&nbsp;&nbsp;<a method=\"showSupplierLicense\">查看供应商信息</a></dd></dl><dl><dt>价格说明</dt><dd><ul><li>划线价格指商品或服务的门市价、服务提供商的指导价、零售价或该商品或服务曾经展示过的销售价等，并非原价；产品信息实时更新、市场价格波动等原因都可能导致价格与您预订时展示的价格不一致，该价格仅供您参考。<br>未划线价格指商品或服务的实时标价，为在划</li></ul></dd></dl><p><br></p>','106.45748527422418','29.4990493882304',NULL),(4,'杏花居','池州,安徽省, 池州市, 贵池区, 建设西路,','单间/双间','大床房/双床房','0938-888888','2+',NULL,'15㎡起','78起','4b35889a-9336-4a49-b55c-b5cafc499e28.jpg','<h2>酒店信息</h2><div><dl><dt>酒店介绍</dt><dd><ul><li><h3>基本信息：</h3><div><p><em>酒店电话：021-26137886,4220126</em>&nbsp;<em>艺龙服务热线：95711</em></p><p><em>开业时间：2019年03月</em>&nbsp;<em>客房数：1间</em></p></div></li><li><h3>酒店简介：</h3><div><p>这里是我精心准备的家。有缘来住下的朋友，希望它能为你带来一段温馨难忘的旅途体验。</p></div></li></ul></dd></dl><dl><dt>温馨提示</dt><dd><ul><li><h3>预订须知：</h3><divmargin: 0px;=\"\" padding:=\"\" 0px;\"=\"\"><p>为贯彻落实《xx市生活垃圾管理条例》相关规定，推进生活垃圾源头减量，xx市文化和旅游局特制定《关于本市旅游住宿业不主动提供客房一次性日用品的实施意见》，2019年7月1日起，xx市旅游住宿业将不再主动提供牙刷、梳子、浴擦、剃须刀、指甲锉、鞋擦这些一次性日用品。若需要可咨询酒店。</p></divmargin:></li></ul></dd></dl></div><li><h3>温馨提示：</h3><div><em title=\"酒店仅接待大陆客人\">酒店仅接待大陆客人</em></div></li><li><h3>入离时间：</h3><divmargin: 0px;=\"\" padding:=\"\" 0px;\"=\"\"><p><em>入住时间:14点以后</em>&nbsp;<em>离店时间:12点以前</em></p></divmargin:></li><dl><dt>酒店设施</dt><dd><ul><li><h3>通用设施：</h3><div><div><span title=\"有电梯\">有电梯</span></div></div></li></ul></dd></dl><dl><dt>证照信息</dt><dd>&nbsp;&nbsp;<a method=\"showSupplierLicense\">查看供应商信息</a></dd></dl><dl><dt>价格说明</dt><dd><ul><li>划线价格指商品或服务的门市价、服务提供商的指导价、零售价或该商品或服务曾经展示过的销售价等，并非原价；产品信息实时更新、市场价格波动等原因都可能导致价格与您预订时展示的价格不一致，该价格仅供您参考。<br>未划线价格指商品或服务的实时标价，为在划</li></ul></dd></dl><p><br></p>','117.47793321510858','30.664404463168463',NULL),(5,'马鞍山旅舍','衡阳,湖南省, 衡阳市, 衡山县, ,','单间/双间','大床房/双床房','0966-888888','2+',NULL,'15㎡起','78','eda44b4f-c577-44c2-8b80-655dfe7d08c1.jpg','<h2>酒店信息</h2><div><dl><dt>酒店介绍</dt><dd><ul><li><h3>基本信息：</h3><div><p><em>酒店电话：021-26137886,4220126</em>&nbsp;<em>艺龙服务热线：95711</em></p><p><em>开业时间：2019年03月</em>&nbsp;<em>客房数：1间</em></p></div></li><li><h3>酒店简介：</h3><div><p>这里是我精心准备的家。有缘来住下的朋友，希望它能为你带来一段温馨难忘的旅途体验。</p></div></li></ul></dd></dl><dl><dt>温馨提示</dt><dd><ul><li><h3>预订须知：</h3><divmargin: 0px;=\"\" padding:=\"\" 0px;\"=\"\"><p>为贯彻落实《xx市生活垃圾管理条例》相关规定，推进生活垃圾源头减量，xx市文化和旅游局特制定《关于本市旅游住宿业不主动提供客房一次性日用品的实施意见》，2019年7月1日起，xx市旅游住宿业将不再主动提供牙刷、梳子、浴擦、剃须刀、指甲锉、鞋擦这些一次性日用品。若需要可咨询酒店。</p></divmargin:></li></ul></dd></dl></div><li><h3>温馨提示：</h3><div><em title=\"酒店仅接待大陆客人\">酒店仅接待大陆客人</em></div></li><li><h3>入离时间：</h3><divmargin: 0px;=\"\" padding:=\"\" 0px;\"=\"\"><p><em>入住时间:14点以后</em>&nbsp;<em>离店时间:12点以前</em></p></divmargin:></li><dl><dt>酒店设施</dt><dd><ul><li><h3>通用设施：</h3><div><div><span title=\"有电梯\">有电梯</span></div></div></li></ul></dd></dl><dl><dt>证照信息</dt><dd>&nbsp;&nbsp;<a method=\"showSupplierLicense\">查看供应商信息</a></dd></dl><dl><dt>价格说明</dt><dd><ul><li>划线价格指商品或服务的门市价、服务提供商的指导价、零售价或该商品或服务曾经展示过的销售价等，并非原价；产品信息实时更新、市场价格波动等原因都可能导致价格与您预订时展示的价格不一致，该价格仅供您参考。<br>未划线价格指商品或服务的实时标价，为在划</li></ul></dd></dl><p><br></p>','112.75550520259918','27.35949068975729',NULL);
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
  PRIMARY KEY (`tp_oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_order`
--

LOCK TABLES `tp_order` WRITE;
/*!40000 ALTER TABLE `tp_order` DISABLE KEYS */;
INSERT INTO `tp_order` VALUES ('A202101021651251427',2,'西湖#浙江省杭州市#123@zjut.cn#15306591427#150#2021-1-2#16:51#2021-1-7'),('A202101031651251427',2,'西湖#浙江省杭州市#123@zjut.cn#15306591427#150#2021-1-3#16:51:25#2021-1-7'),('H202101021655011427',2,'西湖酒店#浙江杭州#123@zjut.cn#15306591427#200#2021-1-2#16:55#2021-1-7'),('H202101071244401427',2,'国际大酒店#浙江省, 杭州市, 萧山区, 湘湖路,#123@zjut.cn#15306591427#5000#2021-01-07#12:44:40#2021-01-06#3'),('T202101021751221427',2,'高铁#123@zjut.cn#15306591427#浙江省宁波市#浙江省杭州市#2021-1-5#10:15#2021-1-5#11:15#80#2021-1-2#17:51');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_user`
--

LOCK TABLES `tp_user` WRITE;
/*!40000 ALTER TABLE `tp_user` DISABLE KEYS */;
INSERT INTO `tp_user` VALUES (1,'ziming','ziming@163.com','ziming','19',NULL,NULL,NULL,NULL,NULL,NULL),(2,'123','123@zjut.cn','123','12','男','c09b3933-ecea-435d-b627-7f3ea44d3703.jpg','15306591427','2021-01-07 04:59:58','2021-01-07 04:59:58',NULL),(5,'ttt','ttt@zjut.cn','ttt',NULL,NULL,'default.jpg',NULL,'2020-12-30 01:03:41','2020-12-30 01:03:41','广州:1#福州:1#上海:1#'),(6,'wwww','wwww@zjut.cn','wwww',NULL,NULL,'default.jpg',NULL,'2020-12-30 07:32:03','2020-12-30 07:32:04','杭州:5#重庆:2#北京:3#成都:4#上海:2#西安:1#'),(7,'wsnd','qqq@zjut.cn','yyy','12','男','default.jpg','13878596516','2021-01-06 23:52:10','2021-01-06 23:52:10','杭州:1#重庆:1#北京:1#成都:1#西安:1#南京:1#'),(8,'碱性肥皂','576373039@qq.com','123456',NULL,NULL,'default.jpg',NULL,'2021-01-07 04:15:51','2021-01-07 04:15:52','西安:1#上海:1#长沙:1#广州:1#');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tp_viewpoint`
--

LOCK TABLES `tp_viewpoint` WRITE;
/*!40000 ALTER TABLE `tp_viewpoint` DISABLE KEYS */;
INSERT INTO `tp_viewpoint` VALUES (1,'大尖山','大尖山','自然景观类','66850780-1940-462c-b2f3-cfe7f55cf64d.jpg','0939-666','AAAA','99','浙江省, 绍兴市, 柯桥区, , placeholder=',NULL,'123',NULL,'<p>大尖山乃为五分山群的姜子寮山列之一，其山腰向来以寺庙多而著称，其中又以慈航堂最为著名，因当年慈航法师在此讲经说法、化坐；登山的途中还可顺道游览秀峰瀑布，亦是爬山、郊游者们的最好去处。&nbsp;</p><p><span style=\"color: inherit; font-family: &quot;Source Sans Pro&quot;, sans-serif; font-size: 24px;\">大尖山</span></p><p><img src=\"/static/upload/contentFile/aff6794c-9697-43cd-9654-0e23e91449d1.jpg\" style=\"max-width: 100%;\"></p><div label-module=\"para\"><div><b><a nslog-type=\"9317\" href=\"https://baike.baidu.com/pic/%E5%A4%A7%E5%B0%96%E5%B1%B1/8254559/0/cefc1e178a82b9018110cea8738da9773812efe8?fr=lemma&amp;ct=single\" target=\"_blank\" title=\"大尖山慈航堂\"><imghttps: bkimg.cdn.bcebos.com=\"\" pic=\"\" cefc1e178a82b9018110cea8738da9773812efe8?x-bce-process=\"image/resize,m_lfit,w_220,limit_1&quot;\" alt=\"大尖山慈航堂\"></imghttps:></a>大尖山慈航堂</b></div><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A4%A7%E5%B0%96%E5%B1%B1%E9%A3%8E%E6%99%AF%E5%8C%BA/6680629\">大尖山风景区</a>属于<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%BA%94%E5%88%86%E5%B1%B1/15407463\">五分山</a>群的姜子寮山列，山腰素以慈航堂最著名。登山途中可顺道游览秀峰瀑布，是登山、郊游者最常造访之地。大尖山风景区经汐止市公所整顿后，筑起了登山阶梯，广植花木，并从国外引进草皮，造就了山坡上成片平整的草毯，加上风味特殊的休憩亭和石桌椅，大尖山风景区一时之间即变成了汐止的后花园。</div><div label-module=\"para\">登大尖山可从<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B1%90%E6%AD%A2%E5%8C%BA\">汐止区</a>街寻秀峰路、勤进路前行抵天秀宫，登山<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%AD%A5%E9%81%93\">步道</a>即由此开始，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A4%A7%E5%B0%96%E5%B1%B1%E9%A3%8E%E6%99%AF%E5%8C%BA/6680629\">大尖山风景区</a>全长4.2公里，一路前进可抵龙船洞、秀峰瀑布。再继续前行可登山顶，放眼望去，汐止区与周遭的群山风貌全进眼底。由此可续沿着山棱线纵走四分仔尾山，在循公路下山回到汐止。</div><div label-module=\"para\">另外，由天秀宫沿勤进路行至天道清修院，亦有步道上大尖山，由此登顶全长不到1公里。</div><div label-module=\"para\">大尖山是新北东侧的热门郊山，小小460公尺高的山头，春天里樱花、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%9D%9C%E9%B9%83\">杜鹃</a>盛放，漫野花海；规划良好的山道与步径两旁，名刹、瀑布散落幽处，而山坡间绿毯般草皮与朴拙石桌椅则构出诗般画面。大尖山，在<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B1%90%E6%AD%A2/4400682\">汐止</a>区公所的营造下，已成为一座引人入胜的大公园。</div><p><br></p><div label-module=\"para\"><div><b><a nslog-type=\"9317\" href=\"https://baike.baidu.com/pic/%E5%A4%A7%E5%B0%96%E5%B1%B1/8254559/0/1e71f72463ea853c4c088d96?fr=lemma&amp;ct=single\" target=\"_blank\" title=\"大尖山樱夜景\"><imghttps: bkimg.cdn.bcebos.com=\"\" pic=\"\" 4b90f603738da977e2619f26b051f8198618e375?x-bce-process=\"image/resize,m_lfit,w_220,limit_1&quot;\" alt=\"大尖山樱夜景\"></imghttps:></a>大尖山樱夜景</b></div><div><img src=\"/static/upload/contentFile/42cc4a0b-3e95-445a-be1c-8480677e9dc6.jpg\" style=\"max-width: 100%;\"></div>大尖山因山顶散布着许多大岩块而得名，其登山健行步道的发迹，源于山脚慈航堂<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%85%88%E8%88%AA%E6%B3%95%E5%B8%88/4799892\">慈航法师</a>的传奇，他修成正果圆寂后<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%82%89%E8%BA%AB%E4%B8%8D%E5%9D%8F/105387\">肉身不坏</a>，被信徒供为<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%85%88%E8%88%AA%E8%8F%A9%E8%90%A8\">慈航菩萨</a>，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%85%88%E8%88%AA%E5%AF%BA/5615251\">慈航寺</a>的名气不胫而走，也吸引许多人朝圣之余开始攀登大尖山。经<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B1%90%E6%AD%A2/4400682\">汐止</a>镇公所大刀阔斧整顿，筑起长长的登山石阶，广植花木，并从国外引进短草皮，造就了山坡上成片平整如茵的草毯，加上错落山间、风味特殊的石桌椅和休憩亭，大尖山一变而成汐止的后花园。攀登大尖山，可从<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B1%90%E6%AD%A2%E5%B8%82/2434931\">汐止市</a>街循秀峰路、勤进路前行抵天秀宫，登山步道即由此展开。</div><p><br></p>','120.36429661532894','30.09963156921508','绍兴'),(2,'黄鹤楼','黄鹤楼','自然景观类','84f6b752-2b0d-4220-b133-448f3e25e817.jpg','0939-888','AAAAA','139','安徽省, 宣城市, 宁国市, , placeholder=',NULL,'全年开放',NULL,'<p><span style=\"color: inherit; font-family: &quot;Source Sans Pro&quot;, sans-serif; font-size: 36px;\">黄鹤楼（“江南三大名楼”之一）</span><br></p><div label-module=\"lemmaSummary\"><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;黄鹤楼位于湖北省武汉市长江南岸的武昌<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%9B%87%E5%B1%B1/32580\">蛇山</a>之巅，濒临万里长江，是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9B%BD%E5%AE%B65A%E7%BA%A7%E6%97%85%E6%B8%B8%E6%99%AF%E5%8C%BA\">国家5A级旅游景区</a>，“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B1%9F%E5%8D%97%E4%B8%89%E5%A4%A7%E5%90%8D%E6%A5%BC/1212495\">江南三大名楼</a>”之一，自古享有“天下江山第一楼“和“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A4%A9%E4%B8%8B%E7%BB%9D%E6%99%AF/15761977\">天下绝景</a>”之称。黄鹤楼是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%AD%A6%E6%B1%89%E5%B8%82/195165\">武汉市</a>标志性建筑，与<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%99%B4%E5%B7%9D%E9%98%81/565396\">晴川阁</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%8F%A4%E7%90%B4%E5%8F%B0/415630\">古琴台</a>并称“武汉三大名胜”。<sup>&nbsp;[1-2]</sup><a name=\"ref_[1-2]_11187512\">&nbsp;</a></div><div label-module=\"para\">黄鹤楼始建于三国时代吴<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%BB%84%E6%AD%A6/3317213\">黄武</a>二年（公元223年），三国时期该楼只是<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%A4%8F%E5%8F%A3%E5%9F%8E/8935167\">夏口城</a>一角瞭望守戍的“军事楼”，晋灭东吴以后，三国归于一统，该楼在失去其军事价值的同时，随着江夏城地发展，逐步演变成为官商行旅“游必于是”、“宴必于是”的观赏楼。唐代诗人<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B4%94%E9%A2%A2/831831\">崔颢</a>在此题下<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E3%80%8A%E9%BB%84%E9%B9%A4%E6%A5%BC%E3%80%8B/10268660\">《黄鹤楼》</a>一诗，李白在此写下《<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%BB%84%E9%B9%A4%E6%A5%BC%E9%80%81%E5%AD%9F%E6%B5%A9%E7%84%B6%E4%B9%8B%E5%B9%BF%E9%99%B5/2804672\">黄鹤楼送孟浩然之广陵</a>》，历代文人墨客在此留下了许多千古绝唱，使得黄鹤楼自古以来闻名遐迩。</div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;黄鹤楼坐落在海拔61.7米的蛇山顶，以清代“同治楼”为原型设计，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%BA%AC%E5%B9%BF%E9%93%81%E8%B7%AF/630228\">京广铁路</a>的列车从楼下呼啸而过。楼高5层，总高度51.4米，建筑面积3219平方米。黄鹤楼内部由72根圆柱支撑，外部有60个翘角向外伸展，屋面用10多万块黄色琉璃瓦覆盖构建而成。<sup>&nbsp;</sup></div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;黄鹤楼楼外铸铜<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%BB%84%E9%B9%A4/3374542\">黄鹤</a>造型、胜像宝塔、牌坊、轩廊、亭阁等一批辅助建筑，将主楼烘托得更加壮丽。主楼周围还建有白云阁、象宝塔、碑廊、山门等建筑。整个建筑具有独特的民族风格，散发出中国传统文化的精神、气质、神韵。它与<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%9B%87%E5%B1%B1/32580\">蛇山</a>脚下的<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%AD%A6%E6%B1%89%E9%95%BF%E6%B1%9F%E5%A4%A7%E6%A1%A5/320899\">武汉长江大桥</a>交相辉映；登楼远眺，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%AD%A6%E6%B1%89%E4%B8%89%E9%95%87/3758321\">武汉三镇</a>的风光尽收眼底。</div><div label-module=\"para\"><br></div></div><p><br></p>','119.0537766729323','30.538244517834254','宁国'),(3,'城头山古文化遗址','城头山古文化遗址','古文化遗址','4b0b6354-bf8d-48f8-864d-feac6a71a638.jpg','0939-888','AAA','79','湖南省, 常德市, 澧县, placeholder=','NULL','春节不开放',NULL,'<dl><dd><h1>城头山古文化遗址（湖南省澧县遗址）</h1></dd></dl><div label-module=\"lemmaSummary\"><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;城头山古文化遗址，位于<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B9%96%E5%8D%97%E7%9C%81/293174\">湖南省</a><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%B8%B8%E5%BE%B7%E5%B8%82/2292265\">常德市</a><a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%BE%A7%E5%8E%BF/141215\">澧县</a>，是中国南方史前大溪文化至<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%9F%B3%E5%AE%B6%E6%B2%B3%E6%96%87%E5%8C%96/8583482\">石家河文化</a>时期的遗址，也是迄今中国唯一发现时代最早、文物最丰富、保护最完整的古城遗址，被誉为“中国最早的城市”。<sup>&nbsp;</sup><a name=\"ref_[1-2]_12099857\">&nbsp;</a></div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1979年<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B9%96%E5%8D%97%E7%9C%81/293174\">湖南省</a>文物普查时，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%BE%A7%E5%8E%BF/141215\">澧县</a>考古工作者首次发现城头山遗址。1991年至2011年，由湖南省考古所主持，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%BE%A7%E5%8E%BF/141215\">澧县</a>进行了13次考古发掘，发掘面积近9000平方米，先后出土有古城遗址、氏族墓葬、大型祭坛、灌溉设施完备的水稻田等大批珍贵文物。城头山古文化遗址代表了长江流域新石器时代古文明的发展高度，对研究人类文明的起源、早期城池的建立以及阶级、国家的产生具有重要意义。</div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1996年，城头山古文化遗址被批准为<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%85%A8%E5%9B%BD%E9%87%8D%E7%82%B9%E6%96%87%E7%89%A9%E4%BF%9D%E6%8A%A4%E5%8D%95%E4%BD%8D/2960685\">全国重点文物保护单位</a>；2001年，被评为“中国20世纪100项考古大发现”之一，镌刻到“<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%AD%E5%8D%8E%E4%B8%96%E7%BA%AA%E5%9D%9B/435060\">中华世纪坛</a>”的青铜甬道上。</div></div><p><br></p>','111.71296776028355','29.68983825333861','常德'),(4,'上海迪士尼度假区','上海迪士尼','游玩度假区','e7ff5636-0d1e-48c5-b0db-b3eb96880395.jpg','0939-888','AAAA','199+','上海 placeholder=','上海市, 上海市, 浦东新区, ,','全年开放',NULL,'<div label-module=\"lemmaSummary\"><div label-module=\"para\"><dl><dd><h1>上海迪士尼度假区</h1></dd></dl><div label-module=\"lemmaSummary\"><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上海迪士尼度假区（Shanghai Disney Resort），位于上海市浦东新区申迪北路753号，是中国大陆第一座<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%BF%AA%E5%A3%AB%E5%B0%BC%E5%BA%A6%E5%81%87%E5%8C%BA/15723266\">迪士尼度假区</a>，也是继加州迪士尼乐园度假区、奥兰多华特迪士尼世界度假区、东京迪士尼度假区、巴黎迪士尼乐园度假区和香港迪士尼乐园度假区之后，全球第六个迪士尼度假区。<sup>&nbsp;[1]</sup><a name=\"ref_[1]_2317134\">&nbsp;</a></div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上海迪士尼度假区占地3.9平方公里，包括<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E4%B8%8A%E6%B5%B7%E8%BF%AA%E5%A3%AB%E5%B0%BC%E4%B9%90%E5%9B%AD/3246958\">上海迪士尼乐园</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E8%BF%AA%E5%A3%AB%E5%B0%BC%E5%B0%8F%E9%95%87/18010381\">迪士尼小镇</a>和2家带有主题风格的酒店，于2011年4月8日正式在上海市<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%B5%A6%E4%B8%9C%E6%96%B0%E5%8C%BA\">浦东新区</a>川沙破土动工，2016年6月16日正式开园。</div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2014年，上海迪士尼度假区获得<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%BE%8E%E5%9B%BD%E5%BB%BA%E7%AD%91%E5%B8%88%E5%8D%8F%E4%BC%9A/10457583\">美国建筑师协会</a>（AIA）颁发的“建筑实践技术大奖（TAP）”。2017年11月，上海迪士尼度假区获得2016-2017年度中国建设工程<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%B2%81%E7%8F%AD%E5%A5%96/2323200\">鲁班奖</a>。<sup>&nbsp;[2]</sup><a name=\"ref_[2]_2317134\">&nbsp;</a></div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2019年4月18日，获得“第八届中国食品健康七星奖”。</div></div></div></div><div><dl><br></dl></div><div></div><div></div><p><br></p>','121.67682876206793','31.119246377843055','上海'),(5,'磁器口古镇','磁器口古镇','游玩度假区','233b0a22-2859-48ae-887e-92a68b737eb9.jpg','0939-888','AAAA','99','重庆市, 重庆市, 沙坪坝区, 磁器口市街, 14号-3 placeholder=',NULL,'全年开放',NULL,'<dl><dd><h1>磁器口古镇</h1></dd></dl><div label-module=\"lemmaSummary\"><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;磁器口古镇，原名龙隐镇<sup>&nbsp;</sup>&nbsp;，国家AAAA级景区，中国历史文化名街，重庆市重点保护传统街，重庆“新巴渝十二景”，巴渝民俗文化旅游圈。磁器口古镇位于重庆市沙坪坝区嘉陵江畔，始建于宋代，拥有“一江两溪三山四街”的独特地貌，形成天然良港，是嘉陵江边重要的水陆码头。</div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;磁器口古镇，曾经“白日里千人拱手，入夜后万盏明灯”繁盛一时。巴渝文化、宗教文化、沙磁文化、红岩文化和民间文化，各具特色。一条石板路，千年磁器口，是重庆古城的缩影和象征，被赞誉为“小重庆”，磁器口古镇开发有榨油、抽丝、制糖、捏面人、川戏等传统表演项目和各种传统小吃、茶馆等，每年春节举办的磁器口庙会是最具特色的传统活动，吸引数万市民前往参与。</div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2020年11月18日，当选“成渝十大文旅产业地标”。</div></div><p><br></p>','106.45680256203681','29.584611841474445','重庆');
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

-- Dump completed on 2021-01-07 21:37:04

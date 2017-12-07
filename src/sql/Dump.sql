CREATE DATABASE  IF NOT EXISTS `hotelbook` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hotelbook`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: hotelbook
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `authinfo`
--

DROP TABLE IF EXISTS `authinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authinfo` (
  `authId` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `authItem` varchar(45) DEFAULT NULL COMMENT '权限项',
  `isRead` varchar(45) DEFAULT NULL COMMENT '可读',
  `isWrite` varchar(45) DEFAULT NULL COMMENT '可写',
  `isChange` varchar(45) DEFAULT NULL COMMENT '可改',
  `isDelete` varchar(45) DEFAULT NULL COMMENT '可删',
  PRIMARY KEY (`authId`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authinfo`
--

LOCK TABLES `authinfo` WRITE;
/*!40000 ALTER TABLE `authinfo` DISABLE KEYS */;
INSERT INTO `authinfo` VALUES (1,'测试0','1','1','0','0'),(2,'测试1','1','1','1','0'),(3,'测试2','1','1','2','0'),(4,'测试3','1','1','3','0'),(5,'测试4','1','1','4','0'),(6,'测试5','1','1','5','0'),(7,'测试6','1','1','6','0'),(8,'测试7','1','1','7','0'),(9,'测试8','1','1','8','0'),(10,'测试9','1','1','9','0'),(11,'测试10','1','1','10','0'),(12,'测试11','1','1','11','0'),(13,'测试12','1','1','12','0'),(14,'测试13','1','1','13','0'),(15,'测试14','1','1','14','0'),(16,'测试15','1','1','15','0'),(17,'测试16','1','1','16','0'),(18,'测试17','1','1','17','0'),(19,'测试18','1','1','18','0'),(20,'测试19','1','1','19','0'),(21,'测试20','1','1','20','0'),(22,'测试21','1','1','21','0'),(23,'测试22','1','1','22','0'),(24,'测试23','1','1','23','0'),(25,'测试24','1','1','24','0'),(26,'测试25','1','1','25','0'),(27,'测试26','1','1','26','0'),(28,'测试27','1','1','27','0'),(29,'测试28','1','1','28','0'),(30,'测试29','1','1','29','0'),(31,'测试30','1','1','30','0'),(32,'测试31','1','1','31','0'),(33,'测试32','1','1','32','0'),(34,'测试33','1','1','33','0'),(35,'测试34','1','1','34','0'),(36,'测试35','1','1','35','0'),(37,'测试36','1','1','36','0'),(38,'测试37','1','1','37','0'),(39,'测试38','1','1','38','0'),(40,'测试39','1','1','39','0'),(41,'测试40','1','1','40','0'),(42,'测试41','1','1','41','0'),(43,'测试42','1','1','42','0'),(44,'测试43','1','1','43','0'),(45,'测试44','1','1','44','0'),(46,'测试45','1','1','45','0'),(47,'测试46','1','1','46','0'),(48,'测试47','1','1','47','0'),(49,'测试48','1','1','48','0'),(50,'测试49','1','1','49','0'),(51,'测试50','1','1','50','0'),(52,'测试51','1','1','51','0'),(53,'测试52','1','1','52','0'),(54,'测试53','1','1','53','0'),(55,'测试54','1','1','54','0'),(56,'测试55','1','1','55','0'),(57,'测试56','1','1','56','0'),(58,'测试57','1','1','57','0'),(59,'测试58','1','1','58','0'),(60,'测试59','1','1','59','0'),(61,'测试60','1','1','60','0'),(62,'测试61','1','1','61','0'),(63,'测试62','1','1','62','0'),(64,'测试63','1','1','63','0'),(65,'测试64','1','1','64','0'),(66,'测试65','1','1','65','0'),(67,'测试66','1','1','66','0'),(68,'测试67','1','1','67','0'),(69,'测试68','1','1','68','0'),(70,'测试69','1','1','69','0'),(71,'测试70','1','1','70','0'),(72,'测试71','1','1','71','0'),(73,'测试72','1','1','72','0'),(74,'测试73','1','1','73','0'),(75,'测试74','1','1','74','0'),(76,'测试75','1','1','75','0'),(77,'测试76','1','1','76','0'),(78,'测试77','1','1','77','0'),(79,'测试78','1','1','78','0'),(80,'测试79','1','1','79','0'),(81,'测试80','1','1','80','0'),(82,'测试81','1','1','81','0'),(83,'测试82','1','1','82','0'),(84,'测试83','1','1','83','0'),(85,'测试84','1','1','84','0'),(86,'测试85','1','1','85','0'),(87,'测试86','1','1','86','0'),(88,'测试87','1','1','87','0'),(89,'测试88','1','1','88','0'),(90,'测试89','1','1','89','0'),(91,'测试90','1','1','90','0'),(92,'测试91','1','1','91','0'),(93,'测试92','1','1','92','0'),(94,'测试93','1','1','93','0'),(95,'测试94','1','1','94','0'),(96,'测试95','1','1','95','0'),(97,'测试96','1','1','96','0'),(98,'测试97','1','1','97','0'),(99,'测试98','1','1','98','0'),(100,'测试99','1','1','99','0');
/*!40000 ALTER TABLE `authinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billinfo`
--

DROP TABLE IF EXISTS `billinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billinfo` (
  `billId` int(11) NOT NULL COMMENT '账单编号',
  `checkId` varchar(45) NOT NULL COMMENT '入住单号',
  `costMoney` varchar(20) DEFAULT NULL COMMENT '消费金额',
  `costDate` varchar(45) DEFAULT NULL COMMENT '消费时间',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`billId`),
  KEY `fk_billInfo_1_idx` (`checkId`),
  CONSTRAINT `fk_billInfo_1` FOREIGN KEY (`checkId`) REFERENCES `checkininfo` (`checkId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billinfo`
--

LOCK TABLES `billinfo` WRITE;
/*!40000 ALTER TABLE `billinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `billinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkininfo`
--

DROP TABLE IF EXISTS `checkininfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `checkininfo` (
  `checkId` varchar(45) NOT NULL COMMENT '入住单号',
  `orderId` varchar(45) DEFAULT NULL COMMENT '预定单号',
  `checkName` varchar(45) DEFAULT NULL COMMENT '入住人',
  `checkPhone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `checkIDcard` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `typeId` varchar(45) NOT NULL COMMENT '客房类型',
  `arrireTime` varchar(45) DEFAULT NULL COMMENT '抵店时间',
  `leaveTime` varchar(45) DEFAULT NULL COMMENT '离店时间',
  `checkState` varchar(20) DEFAULT NULL COMMENT '单据状态',
  `checkNum` int(11) DEFAULT NULL COMMENT '入住人数',
  `roomId` varchar(45) NOT NULL COMMENT '客房编号',
  `price` varchar(20) DEFAULT NULL COMMENT '客房价格',
  `checkPrice` varchar(20) DEFAULT NULL COMMENT '入住价格',
  `discount` int(11) DEFAULT NULL COMMENT '折扣',
  `discountReason` varchar(60) DEFAULT NULL COMMENT '折扣原因',
  `addBed` varchar(10) DEFAULT NULL COMMENT '是否加床',
  `addBedPrice` varchar(20) DEFAULT NULL COMMENT '加床价格',
  `orderMoney` varchar(20) DEFAULT NULL COMMENT '预收款',
  `money` varchar(20) DEFAULT NULL COMMENT '应收账款',
  `isCheck` varchar(10) DEFAULT NULL COMMENT '是否结账',
  `checkMoney` varchar(20) DEFAULT NULL COMMENT '结账金额',
  `checkDate` varchar(45) DEFAULT NULL COMMENT '结账日期',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `operatorId` varchar(45) DEFAULT NULL COMMENT '操作员',
  PRIMARY KEY (`checkId`),
  KEY `fk_checkInfo_1_idx` (`typeId`),
  KEY `fk_checkInfo_2_idx` (`roomId`),
  CONSTRAINT `fk_checkInfo_1` FOREIGN KEY (`typeId`) REFERENCES `roomtype` (`typeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_checkInfo_2` FOREIGN KEY (`roomId`) REFERENCES `roominfo` (`roomId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkininfo`
--

LOCK TABLES `checkininfo` WRITE;
/*!40000 ALTER TABLE `checkininfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `checkininfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `floorinfo`
--

DROP TABLE IF EXISTS `floorinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `floorinfo` (
  `floorId` int(11) NOT NULL AUTO_INCREMENT COMMENT '楼层编号',
  `floorName` varchar(45) DEFAULT NULL COMMENT '楼层名称',
  PRIMARY KEY (`floorId`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `floorinfo`
--

LOCK TABLES `floorinfo` WRITE;
/*!40000 ALTER TABLE `floorinfo` DISABLE KEYS */;
INSERT INTO `floorinfo` VALUES (108,'一楼大厅'),(109,'二楼客房'),(110,'三楼三楼'),(111,'四楼四楼'),(112,'五楼五楼'),(113,'测试编辑 编辑编辑'),(114,'测试重复'),(115,'测试重复1'),(116,'测试删除'),(118,'测试分页1'),(119,'测试分页2');
/*!40000 ALTER TABLE `floorinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `loginId` int(11) NOT NULL AUTO_INCREMENT COMMENT '登录内部标示，主键、自动增长。',
  `loginName` varchar(45) NOT NULL COMMENT '登录用户名，前台唯一性的标识。不能重复。',
  `loginPwd` varchar(45) NOT NULL COMMENT '登录用户的密码，不能为空。',
  `loginNickName` varchar(45) DEFAULT NULL COMMENT '登录用户的昵称',
  `loginAdmin` int(11) DEFAULT NULL COMMENT '权限，默认最高权限是0',
  PRIMARY KEY (`loginId`),
  UNIQUE KEY `loginName_UNIQUE` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'root','toor','管理员',0);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderinfo`
--

DROP TABLE IF EXISTS `orderinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderinfo` (
  `orderId` varchar(45) NOT NULL COMMENT '预定单号',
  `orderName` varchar(45) DEFAULT NULL COMMENT '预定人',
  `orderPhone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `orderIDcard` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `typeId` varchar(45) NOT NULL COMMENT '客房类型',
  `arrireDate` varchar(45) DEFAULT NULL COMMENT '抵店时间',
  `leaveDate` varchar(45) DEFAULT NULL COMMENT '离店时间',
  `orderState` varchar(20) DEFAULT NULL COMMENT '单据状态',
  `checkNum` varchar(45) DEFAULT NULL COMMENT '入住人数',
  `roomId` varchar(45) DEFAULT NULL COMMENT '客房编号',
  `price` varchar(20) DEFAULT NULL COMMENT '客房价格',
  `checkPrice` varchar(20) DEFAULT NULL COMMENT '入住价格',
  `discount` int(11) DEFAULT NULL COMMENT '折扣',
  `discountReason` varchar(60) DEFAULT NULL COMMENT '折扣原因',
  `addBed` varchar(10) DEFAULT NULL COMMENT '是否加床',
  `addBedPrice` varchar(20) DEFAULT NULL COMMENT '加床价格',
  `orderMoney` varchar(20) DEFAULT NULL COMMENT '预收款',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `operatorId` varchar(45) DEFAULT NULL COMMENT '操作员',
  PRIMARY KEY (`orderId`),
  KEY `fk_orderInfo_1_idx` (`typeId`),
  CONSTRAINT `fk_orderInfo_1` FOREIGN KEY (`typeId`) REFERENCES `roomtype` (`typeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderinfo`
--

LOCK TABLES `orderinfo` WRITE;
/*!40000 ALTER TABLE `orderinfo` DISABLE KEYS */;
INSERT INTO `orderinfo` VALUES ('OD1512315000354','测试修改','12312342345','111222121212121212','RT171203233825','2017-12-21 00:00:00','2018-01-11 00:00:00','结算','4','','240','100',0,'测试修改','true','50','44','测试修改测试修改测试修改测试修改测试修改测试修改测试修改','root'),('OD1512354780333','预定人','18212345678','123321111122223333','RT171203233828','2017-12-04 00:00:00','2017-12-06 00:00:00','入住','3','','380','10',5,'任性','true','1','500','预定人','root'),('OD1512554246864','测试新增','12345678900','123456789123456789','RT171203233828','2017-12-14 00:00:00','2018-01-18 00:00:00','延期','3','','380','300',0,'没哟偶呀','true','50','500','测试新增测试新增测试新增测试新增测试新增测试新增','root'),('OD1512615956848','测试新增2','12011112563','123444111122223333','RT171203233121','2017-12-12 04:03:04','2017-12-15 00:00:07','预定','','','300','',0,'','false','','1','','root'),('OD1512616046371','测试删除','','567890123698740258','RT171205210707','2017-12-27 00:00:00','2018-01-10 00:00:00','结算','','','1','',0,'','true','1','0','','root');
/*!40000 ALTER TABLE `orderinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roominfo`
--

DROP TABLE IF EXISTS `roominfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roominfo` (
  `roomId` varchar(45) NOT NULL COMMENT '客房编号',
  `typeId` varchar(45) NOT NULL COMMENT '类型编号',
  `floorId` int(11) NOT NULL COMMENT '楼层编号',
  `ratedNum` int(11) DEFAULT NULL COMMENT '额定人数',
  `bedNum` int(11) DEFAULT NULL COMMENT '床数',
  `roomDescription` varchar(45) DEFAULT NULL COMMENT '客房描述',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `status` varchar(10) DEFAULT NULL COMMENT '状态',
  `isSplice` varchar(10) DEFAULT NULL COMMENT '是否可拼房',
  PRIMARY KEY (`roomId`),
  KEY `fk_roomInfo_1_idx` (`typeId`),
  KEY `fk_roomInfo_2_idx` (`floorId`),
  CONSTRAINT `fk_roomInfo_1` FOREIGN KEY (`typeId`) REFERENCES `roomtype` (`typeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_roomInfo_2` FOREIGN KEY (`floorId`) REFERENCES `floorinfo` (`floorId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roominfo`
--

LOCK TABLES `roominfo` WRITE;
/*!40000 ALTER TABLE `roominfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `roominfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomtype`
--

DROP TABLE IF EXISTS `roomtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roomtype` (
  `typeId` varchar(45) NOT NULL COMMENT '类型编号',
  `typeName` varchar(45) DEFAULT NULL COMMENT '类型名称',
  `price` varchar(20) DEFAULT NULL COMMENT '价格',
  `splicPrice` varchar(20) DEFAULT NULL COMMENT '拼房价格',
  `exceedance` int(11) DEFAULT NULL COMMENT '可超预定数',
  `isSplice` varchar(10) DEFAULT NULL COMMENT '是否可拼房',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomtype`
--

LOCK TABLES `roomtype` WRITE;
/*!40000 ALTER TABLE `roomtype` DISABLE KEYS */;
INSERT INTO `roomtype` VALUES ('RT171130160554','普通单人间','200','160',4,'Y'),('RT171203233121','豪华单人间','300','0',2,'N'),('RT171203233825','普通双人间','240','180',3,'Y'),('RT171203233828','豪华双人间','380','300',3,'Y'),('RT171205210442','家庭套间','300','0',4,'N'),('RT171205210528','小时房','100','80',6,'Y'),('RT171205210606','122','1','1',1,'Y'),('RT171205210608','1221','1','1',1,'Y'),('RT171205210611','12212','1','1',1,'Y'),('RT171205210614','122124','1','1',1,'Y'),('RT171205210616','1221245','1','1',1,'Y'),('RT171205210702','测试外键关联1','1','1',1,'Y'),('RT171205210707','测试外键关联2','1','1',1,'Y'),('RT171207110107','最终测试数据1','999','999',999,'Y'),('RT171207110112','最终测试数据2 改','998','998',999,'N');
/*!40000 ALTER TABLE `roomtype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-07 11:11:44

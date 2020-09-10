/*
Navicat MySQL Data Transfer

Source Server         : linkTest
Source Server Version : 50645
Source Host           : localhost:3306
Source Database       : studentsdormitory

Target Server Type    : MYSQL
Target Server Version : 50645
File Encoding         : 65001

Date: 2020-09-10 00:09:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `announcement`
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `tid` int(7) NOT NULL,
  `title` varchar(50) NOT NULL,
  `mid` int(7) NOT NULL,
  `content` longtext NOT NULL,
  `date` date NOT NULL COMMENT 'date',
  PRIMARY KEY (`tid`),
  KEY `idx_a_mid` (`mid`) USING BTREE,
  CONSTRAINT `c3` FOREIGN KEY (`mid`) REFERENCES `manager` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('10001', '电量示警名单', '2017001', '27139   剩余电量35.5度 ，请尽快充值，不要再拖了好吗朋友们', '2020-07-05');
INSERT INTO `announcement` VALUES ('10003', '公告三', '2017001', '333333333333333333333', '2020-07-07');
INSERT INTO `announcement` VALUES ('10004', '公告四', '2017001', '44444444444444', '2020-07-09');
INSERT INTO `announcement` VALUES ('10005', '公告五', '2017001', '27139   剩余电量35.5度 ，请尽快充值，不要再拖了好吗朋友们', '2020-07-10');

-- ----------------------------
-- Table structure for `dormitory`
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory` (
  `did` int(5) NOT NULL,
  `bid` int(4) NOT NULL,
  `dname` varchar(20) NOT NULL,
  `beds` int(2) NOT NULL,
  PRIMARY KEY (`did`,`bid`),
  KEY `bid` (`bid`),
  KEY `did` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES ('23121', '2003', '南校区天和苑三号楼', '6');
INSERT INTO `dormitory` VALUES ('27119', '2007', '南校区天和苑七号楼', '6');
INSERT INTO `dormitory` VALUES ('27139', '2007', '南校区天和苑七号楼', '6');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `mid` int(7) NOT NULL,
  `bid` int(4) NOT NULL,
  `mname` varchar(5) DEFAULT NULL,
  `tel` bigint(20) NOT NULL,
  `password` int(10) NOT NULL,
  PRIMARY KEY (`mid`),
  KEY `idx_m_bid` (`bid`) USING BTREE,
  CONSTRAINT `c2` FOREIGN KEY (`bid`) REFERENCES `dormitory` (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('2017001', '2003', '阿姨一号', '15858270121', '123456');
INSERT INTO `manager` VALUES ('2017002', '2007', '阿姨二号', '11234578922', '123456');

-- ----------------------------
-- Table structure for `repairs`
-- ----------------------------
DROP TABLE IF EXISTS `repairs`;
CREATE TABLE `repairs` (
  `did` int(5) NOT NULL,
  `rid` int(7) NOT NULL,
  `info` text NOT NULL COMMENT '宿舍需要修理',
  `state` varchar(50) NOT NULL DEFAULT '未修理',
  `date` date DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `c4` (`did`),
  CONSTRAINT `c4` FOREIGN KEY (`did`) REFERENCES `dormitory` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repairs
-- ----------------------------
INSERT INTO `repairs` VALUES ('27139', '1001', '139宿舍阳台门把手坏了，需要维修', '已修理', '2020-07-06');
INSERT INTO `repairs` VALUES ('23121', '1003', '121卫生间还在漏水，请速修谢谢师傅', '已修理', '2020-07-09');
INSERT INTO `repairs` VALUES ('27119', '1021', '新增维修信息', '已修理', '2020-07-09');
INSERT INTO `repairs` VALUES ('27119', '2001', '没啥事，随便写写', '未修理', '2020-07-10');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(15) NOT NULL DEFAULT '0',
  `name` varchar(4) NOT NULL,
  `gender` varchar(2) NOT NULL,
  `did` int(5) NOT NULL,
  `password` varchar(10) NOT NULL DEFAULT '123456',
  PRIMARY KEY (`sid`),
  KEY `c1` (`did`),
  CONSTRAINT `c1` FOREIGN KEY (`did`) REFERENCES `dormitory` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('70031003', '郭靖', '男', '27119', '123456');
INSERT INTO `student` VALUES ('70031004', '黄蓉', '女', '23121', '123456');
INSERT INTO `student` VALUES ('70031006', '苏星河', '男', '27119', '123456');
INSERT INTO `student` VALUES ('70031007', '郭芙', '女', '23121', '123456');
INSERT INTO `student` VALUES ('70031008', '啊啊啊', '男', '27119', '123456');
INSERT INTO `student` VALUES ('70031211', '木婉清', '女', '23121', '123456');
INSERT INTO `student` VALUES ('70031212', '钟灵', '女', '23121', '123456');
INSERT INTO `student` VALUES ('70031213', '王语嫣', '女', '23121', '123456');

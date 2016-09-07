/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : onlinechatinfo

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2016-09-07 13:34:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `ID` int(11) NOT NULL auto_increment,
  `NAME` varchar(255) default NULL,
  `EMAIL` varchar(255) default NULL,
  `PASSWORD` varchar(255) default NULL,
  `STATE` int(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '周华波', '251611427@qq.com', 'zhou', '1');

/*
 Navicat MySQL Data Transfer

 Source Server         : 2.55
 Source Server Version : 50713
 Source Host           : localhost
 Source Database       : chapter12

 Target Server Version : 50713
 File Encoding         : utf-8

 Date: 03/06/2020 19:23:05 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `isDelete` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1711 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `addUserCase`
-- ----------------------------
DROP TABLE IF EXISTS `addUserCase`;
CREATE TABLE `addUserCase` (
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `isDelete` varchar(255) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL
)ENGINE=InnoDB AUTO_INCREMENT=1711 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


-- ----------------------------
--  Table structure for `GetUserInfoCase`
-- ----------------------------

DROP TABLE IF EXISTS `getUserInfoCase`;
CREATE TABLE `getUserInfoCase` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
)ENGINE=InnoDB AUTO_INCREMENT=1711 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `getUserListCase`
-- ----------------------------

DROP TABLE IF EXISTS `getUserListCase`;
CREATE TABLE `getUserListCase` (
  `userName` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL
)ENGINE=InnoDB AUTO_INCREMENT=1711 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


-- ----------------------------
--  Table structure for `loginCase`
-- ----------------------------

DROP TABLE IF EXISTS `loginCase`;
CREATE TABLE `loginCase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1711 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
--  Table structure for `updateUserInfoCase`
-- ----------------------------

DROP TABLE IF EXISTS `updateUserInfoCase`;
CREATE TABLE `updateUserInfoCase` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `isDelete` varchar(255) DEFAULT NULL,
  `expected` varchar(255) DEFAULT NULL
)ENGINE=InnoDB AUTO_INCREMENT=1711 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

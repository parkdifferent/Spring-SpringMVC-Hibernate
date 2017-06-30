/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : ssh

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-06-30 11:13:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_test
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(32) DEFAULT NULL,
  `second_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES ('1', 'firstName2', 'secondName3');
INSERT INTO `t_test` VALUES ('3', 't1', '32');
INSERT INTO `t_test` VALUES ('4', 't2', 'qw');
INSERT INTO `t_test` VALUES ('5', 't3', 'rq');
INSERT INTO `t_test` VALUES ('6', 't4', 'rq');
INSERT INTO `t_test` VALUES ('7', 't5', 'dfs');
INSERT INTO `t_test` VALUES ('8', 't6', 'sfd');
INSERT INTO `t_test` VALUES ('9', 't7', 'fs');
INSERT INTO `t_test` VALUES ('10', 't8', 'fw');
INSERT INTO `t_test` VALUES ('11', 't9', 'gf');
INSERT INTO `t_test` VALUES ('12', 't10', 'er');
INSERT INTO `t_test` VALUES ('13', 't11', 'r3');
INSERT INTO `t_test` VALUES ('14', 't12', 'e');

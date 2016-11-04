/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : casserver

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-11-04 14:35:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` varchar(40) COLLATE utf8_bin NOT NULL,
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `systemcode` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `salt` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `postid` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `locked` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', '1', '47ec2dd791e31e2ef2076caf64ed9b3d', '1', 'test', '1', '1');
INSERT INTO `sys_users` VALUES ('297eb23e559fbebb01559fd4eaf8000c', 'pickettest', '47ec2dd791e31e2ef2076caf64ed9b3d', '2', 'test', '', '1');
INSERT INTO `sys_users` VALUES ('297eb23e55fb72260155fb7d3b610001', 'carHome', '47ec2dd791e31e2ef2076caf64ed9b3d', '2', 'test', '', '1');
INSERT INTO `sys_users` VALUES ('297eb23e5818b439015818b8a2ce0004', 'yhadmin', '47ec2dd791e31e2ef2076caf64ed9b3d', '2', 'test', '', '1');
INSERT INTO `sys_users` VALUES ('402881e4461f9c6401461fa2e6f50002', 'tingfeng', '47ec2dd791e31e2ef2076caf64ed9b3d', '2', 'test', '', '1');
INSERT INTO `sys_users` VALUES ('402881e44648134a014648174a45000c', 'ceshi', '47ec2dd791e31e2ef2076caf64ed9b3d', '2', 'test', '', '1');
INSERT INTO `sys_users` VALUES ('4028d881436d514601436d5215ac0043', 'admin', 'd94354ac9cf3024f57409bd74eec6b4c', '1', 'admin', '0', '1');
INSERT INTO `sys_users` VALUES ('4028d881436d514601436d5215b20044', 'scott', '47ec2dd791e31e2ef2076caf64ed9b3d', '2', 'test', '', '1');
INSERT INTO `sys_users` VALUES ('4028d881436d514601436d5215b80045', 'cgy', '47ec2dd791e31e2ef2076caf64ed9b3d', '2', 'test', '', '1');
INSERT INTO `sys_users` VALUES ('4028d881436d514601436d5215bc0046', 'cgspy', '47ec2dd791e31e2ef2076caf64ed9b3d', '2', 'test', '', '1');
INSERT INTO `sys_users` VALUES ('69878c250932449390391d7655371fd3', 'test', '47ec2dd791e31e2ef2076caf64ed9b3d', '1', 'test', '1', '1');
INSERT INTO `sys_users` VALUES ('b0b5c6eda45747eaaebfac30dee14a3e', 'hta001', '10ac255d9adadbc2c5d1b14261e66174', '1', 'hta', 'eee1e847ef0349c69399d7069bbac65a', '1');

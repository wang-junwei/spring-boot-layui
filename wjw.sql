/*
 Navicat Premium Data Transfer

 Source Server         : wjw
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : wjw

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 14/08/2021 17:21:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `mname` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名',
  `label` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名，用于权限展示',
  `url` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单地址',
  `pid` int(11) NOT NULL COMMENT '菜单父id',
  `icon` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `checked` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否选中',
  `disabled` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否禁用',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '权限管理', '权限管理', NULL, 0, 'bk-icon icon-panel-permission', NULL, NULL, 1);
INSERT INTO `menu` VALUES (2, '角色管理', '角色管理', '/role/roleManager', 1, NULL, NULL, NULL, 2);
INSERT INTO `menu` VALUES (3, '用户管理', '用户管理', '/user/userManager', 1, NULL, NULL, NULL, 3);
INSERT INTO `menu` VALUES (4, '文件管理', '文件管理', NULL, 0, 'bk-icon icon-file', NULL, NULL, 4);
INSERT INTO `menu` VALUES (5, '文件上传', '文件上传', '/file/upload', 4, NULL, NULL, NULL, 5);
INSERT INTO `menu` VALUES (6, '文件下载', '文件下载', '/file/download', 4, NULL, NULL, NULL, 6);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(155) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (-1, '未知');
INSERT INTO `role` VALUES (1, '管理员');
INSERT INTO `role` VALUES (2, '运维人员');
INSERT INTO `role` VALUES (3, '安全人员');
INSERT INTO `role` VALUES (4, '普通职员');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (25, 1, 1, 1);
INSERT INTO `role_menu` VALUES (26, 1, 2, 2);
INSERT INTO `role_menu` VALUES (27, 1, 3, 3);
INSERT INTO `role_menu` VALUES (28, 1, 4, 4);
INSERT INTO `role_menu` VALUES (29, 1, 5, 5);
INSERT INTO `role_menu` VALUES (30, 1, 6, 6);
INSERT INTO `role_menu` VALUES (31, 3, 4, 4);
INSERT INTO `role_menu` VALUES (32, 3, 5, 5);
INSERT INTO `role_menu` VALUES (33, 2, 4, 4);
INSERT INTO `role_menu` VALUES (34, 2, 5, 5);
INSERT INTO `role_menu` VALUES (37, 4, 1, 1);
INSERT INTO `role_menu` VALUES (38, 4, 2, 2);
INSERT INTO `role_menu` VALUES (39, 4, 3, 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真是姓名',
  `gender` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `phone` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系方式',
  `birth` date NOT NULL COMMENT '出生年月',
  `role_id` int(11) NOT NULL COMMENT '用户角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wangjunwei', '01f281729677d27d8109592bd66550f4ee0b292b97046111', '王君伟', '男', '15081064435', '1993-03-04', 1);

SET FOREIGN_KEY_CHECKS = 1;

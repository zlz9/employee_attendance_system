/*
 Navicat Premium Data Transfer

 Source Server         : first_db
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : staff_management_system

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 27/05/2022 00:19:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dapartment
-- ----------------------------
DROP TABLE IF EXISTS `dapartment`;
CREATE TABLE `dapartment`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dapartment
-- ----------------------------
INSERT INTO `dapartment` VALUES (1, '财务');
INSERT INTO `dapartment` VALUES (2, '物管');
INSERT INTO `dapartment` VALUES (3, 'HR');
INSERT INTO `dapartment` VALUES (4, '客服');
INSERT INTO `dapartment` VALUES (5, '市场');
INSERT INTO `dapartment` VALUES (6, '培训部');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `emp_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '员工姓名',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工住址',
  `induction_time` bigint(20) NULL DEFAULT NULL COMMENT '入职时间',
  `phone` int(11) NULL DEFAULT NULL COMMENT '手机号',
  `department_id` bigint(20) NULL DEFAULT NULL COMMENT '员工所属部门',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id`(`department_id`) USING BTREE,
  CONSTRAINT `id` FOREIGN KEY (`department_id`) REFERENCES `dapartment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '小花', 12, '郫都', 20220526000000, 1111111111, 1);
INSERT INTO `employee` VALUES (18, 'xiaoh', 0, '郫都', 20220526000000, 12313131, 1);
INSERT INTO `employee` VALUES (19, 'xiaoh', 0, '郫都', 1653549269159, 12313131, 1);
INSERT INTO `employee` VALUES (20, '小明', 16, '郫都区', 1653552668036, 1999999, 2);
INSERT INTO `employee` VALUES (21, '小明', 16, '郫都', 1653569786449, 2113131, 2);
INSERT INTO `employee` VALUES (22, 'zlz', 16, '郫都', 1653569809921, 21313, 4);
INSERT INTO `employee` VALUES (23, 'yt', 16, '郫都', 1653569827074, 1999999, 2);
INSERT INTO `employee` VALUES (24, '哈哈哈哈', 16, '郫都', 1653569833133, 1999999, 2);
INSERT INTO `employee` VALUES (25, '西西', 16, '郫都', 1653569838437, 1999999, 2);
INSERT INTO `employee` VALUES (29, '吱吱吱吱', 16, '郫都区', 1653576397766, 21313, 5);

-- ----------------------------
-- Table structure for employee_record
-- ----------------------------
DROP TABLE IF EXISTS `employee_record`;
CREATE TABLE `employee_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `department_id` bigint(20) NULL DEFAULT NULL COMMENT '所属部门',
  `starTime` bigint(20) NULL DEFAULT NULL COMMENT '工作时间',
  `endTime` bigint(20) NULL DEFAULT NULL COMMENT '下班时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `department_id`(`department_id`) USING BTREE,
  CONSTRAINT `department_id` FOREIGN KEY (`department_id`) REFERENCES `dapartment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_record
-- ----------------------------
INSERT INTO `employee_record` VALUES (1, '小明', 3, 1653556286915, 1653556286915);
INSERT INTO `employee_record` VALUES (3, '小明', 5, 1653556286915, 1653556286915);
INSERT INTO `employee_record` VALUES (4, '小花', 1, 1653547711478, 1653547727103);
INSERT INTO `employee_record` VALUES (5, '小花', 1, 1653547742540, 1653547752621);
INSERT INTO `employee_record` VALUES (6, '小花', 1, 1653555278735, 1653555289071);
INSERT INTO `employee_record` VALUES (7, '小明', 2, 1653555324325, 1653555335899);
INSERT INTO `employee_record` VALUES (8, '小明', 2, 1653556286915, 1653572984333);
INSERT INTO `employee_record` VALUES (9, '小明', 2, 1653556286915, 1653556286915);
INSERT INTO `employee_record` VALUES (10, '小明', 3, 1653556286915, 1653556286915);
INSERT INTO `employee_record` VALUES (67, '小明', 3, 1653556286915, 1653556286915);
INSERT INTO `employee_record` VALUES (68, NULL, NULL, NULL, NULL);
INSERT INTO `employee_record` VALUES (69, '小花', 1, 1653573199439, 1653573206565);
INSERT INTO `employee_record` VALUES (70, '哈哈哈哈哈哈哈', 1, 1653578324311, NULL);
INSERT INTO `employee_record` VALUES (71, '哈哈哈哈哈哈哈', 1, 1653578339208, NULL);
INSERT INTO `employee_record` VALUES (72, '哈哈哈哈哈哈哈', 1, 1653578530509, 1653578735903);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(100) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `username` varchar(50) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `chinese_name` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '123456', 'admin', NULL);
INSERT INTO `user` VALUES (13, '123456', 'emp_one', NULL);
INSERT INTO `user` VALUES (22, '2131', '321313', NULL);
INSERT INTO `user` VALUES (23, '1234444', 'hh', NULL);
INSERT INTO `user` VALUES (24, 'admin123', 'zlz', NULL);
INSERT INTO `user` VALUES (25, '123456', 'chl', NULL);
INSERT INTO `user` VALUES (26, 'admin123', 'yt', NULL);

SET FOREIGN_KEY_CHECKS = 1;

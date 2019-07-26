/*
 Navicat Premium Data Transfer

 Source Server         : seckill
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 20/07/2019 16:46:51
*/

/*注意：导入SQL语句之后，在orderinfo表中的buyCount购买数量字段要改为int数值型字段*/

create database gxamybatis;
use gxamybatis; 

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `receiverName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人姓名',
  `receiverAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人地址',
  `receiverPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人手机号码',
  `postNo` varchar(11) DEFAULT NULL COMMENT '邮编',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`addressId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`categoryId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodsId` int(11) NOT NULL,
  `goodsName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `goodsTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品标题',
  `goodsPrice` decimal(10, 2) DEFAULT NULL COMMENT '商品价格',
  `goodsImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片',
  `goodsDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品描述',
  `goodsStock` int(10) DEFAULT NULL COMMENT '商品库存，-1表示没有限制',
  `categoryId` int(11) DEFAULT NULL COMMENT '分类id',
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for miaoshagoods
-- ----------------------------
DROP TABLE IF EXISTS `miaoshagoods`;
CREATE TABLE `miaoshagoods`  (
  `miaoshagoodsId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` int(10) DEFAULT NULL COMMENT '对应的商品编号',
  `miaoshaStock` int(10) DEFAULT NULL COMMENT '秒杀商品库存',
  `miaoshaPrice` decimal(10, 0) DEFAULT NULL COMMENT '秒杀价格',
  `beginTime` datetime(0) DEFAULT NULL COMMENT '开始时间',
  `endTime` datetime(0) DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`miaoshagoodsId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for miaoshaorder
-- ----------------------------
DROP TABLE IF EXISTS `miaoshaorder`;
CREATE TABLE `miaoshaorder`  (
  `miaoshaOrderId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `orderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`miaoshaOrderId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `orderNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单号',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `goodsId` int(11) DEFAULT NULL COMMENT '商品id',
  `addressId` int(11) DEFAULT NULL COMMENT '收货地址id',
  `buyCount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '购买的数量',
  `orderStatus` int(10) DEFAULT NULL COMMENT '订单状态',
  `payPrice` decimal(10, 2) DEFAULT NULL COMMENT '商品价格',
  `createTime` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `payTime` datetime(0) DEFAULT NULL COMMENT '支付时间',
  `alipayNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '支付宝交易号',
  PRIMARY KEY (`orderId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `userPwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `userEmail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户邮箱',
  `userPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `lastLoginTime` datetime(0) DEFAULT NULL COMMENT '上次登陆时间',
  `registTime` datetime(0) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

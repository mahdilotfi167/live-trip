/*
 Source Server         : nano
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : live_trip
 
 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001
 
 Date: 14/09/2021 01:47:03
 */
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for driver_info
-- ----------------------------
DROP TABLE IF EXISTS `driver_info`;
CREATE TABLE `driver_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `car_model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `car_tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKe7tbi665slxdwj1t0oo8dyoex`(`user_id`) USING BTREE,
  CONSTRAINT `FKe7tbi665slxdwj1t0oo8dyoex` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lat` double NULL DEFAULT NULL,
  `lng` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Table structure for rider_info
-- ----------------------------
DROP TABLE IF EXISTS `rider_info`;
CREATE TABLE `rider_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKfwrecmqyexv40jyvana3kyof0`(`user_id`) USING BTREE,
  CONSTRAINT `FKfwrecmqyexv40jyvana3kyof0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Table structure for trip
-- ----------------------------
DROP TABLE IF EXISTS `trip`;
CREATE TABLE `trip` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pay_ment` int NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `driver_id` int NULL DEFAULT NULL,
  `end_location_id` int NULL DEFAULT NULL,
  `rider_id` int NULL DEFAULT NULL,
  `start_location_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKr24c951t3pqp09u49lxentd45`(`driver_id`) USING BTREE,
  INDEX `FKsk6kcvu7ghs8y9fct2obokp8q`(`end_location_id`) USING BTREE,
  INDEX `FKhualmn1fgip0dsresdttm1hky`(`rider_id`) USING BTREE,
  INDEX `FK5prb1v56d7o09bf5w1p1ro73o`(`start_location_id`) USING BTREE,
  CONSTRAINT `FK5prb1v56d7o09bf5w1p1ro73o` FOREIGN KEY (`start_location_id`) REFERENCES `location` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKhualmn1fgip0dsresdttm1hky` FOREIGN KEY (`rider_id`) REFERENCES `rider_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKr24c951t3pqp09u49lxentd45` FOREIGN KEY (`driver_id`) REFERENCES `driver_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKsk6kcvu7ghs8y9fct2obokp8q` FOREIGN KEY (`end_location_id`) REFERENCES `location` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `credit` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `user_id` int NOT NULL,
  `roles` int NULL DEFAULT NULL,
  INDEX `FK55itppkw3i07do3h7qoclqd4k`(`user_id`) USING BTREE,
  CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
SET FOREIGN_KEY_CHECKS = 1;
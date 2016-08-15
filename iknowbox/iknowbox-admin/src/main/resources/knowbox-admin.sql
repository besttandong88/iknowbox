/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 60004
Source Host           : localhost:3306
Source Database       : knowbox-admin

Target Server Type    : MYSQL
Target Server Version : 60004
File Encoding         : 65001

Date: 2016-08-15 22:36:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `fund_channel`
-- ----------------------------
DROP TABLE IF EXISTS `fund_channel`;
CREATE TABLE `fund_channel` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_code` varchar(255) DEFAULT NULL,
  `channel_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fund_channel
-- ----------------------------
INSERT INTO `fund_channel` VALUES ('1', '00001', '广发银行');
INSERT INTO `fund_channel` VALUES ('2', '00002', '浦发银行');
INSERT INTO `fund_channel` VALUES ('3', '00003', '富友支付');

-- ----------------------------
-- Table structure for `order_purchase`
-- ----------------------------
DROP TABLE IF EXISTS `order_purchase`;
CREATE TABLE `order_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bus_pur_orderno` varchar(40) DEFAULT NULL COMMENT '申购申请订单号',
  `mer_no` varchar(30) DEFAULT NULL COMMENT '商户编号',
  `pur_amount` decimal(16,4) DEFAULT NULL COMMENT '申购金额',
  `mem_no` varchar(20) DEFAULT NULL COMMENT '微支付会员号',
  `cust_no` varchar(20) DEFAULT NULL COMMENT '微支付客户号',
  `bank_prod_code` varchar(20) DEFAULT NULL COMMENT '银行产品代码',
  `fund_code` varchar(20) DEFAULT NULL COMMENT '银行基金代码',
  `channel_code` varchar(20) DEFAULT NULL COMMENT '基金渠道编码',
  `purch_type` tinyint(4) DEFAULT NULL COMMENT '申购类型',
  `pur_status` tinyint(4) DEFAULT NULL COMMENT '申购状态',
  `is_pay_grant` tinyint(4) DEFAULT NULL COMMENT '是否需要微支付完成扣款并利益发放',
  `begin_profit_date` date DEFAULT NULL COMMENT '预计开始计算收益日期',
  `confirm_share` int(11) DEFAULT NULL COMMENT '申购确认份额',
  `confirm_date` date DEFAULT NULL COMMENT '申购确认日期',
  `res_code` varchar(20) DEFAULT NULL COMMENT '返回码',
  `res_msg` varchar(50) DEFAULT NULL COMMENT '返回描述',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `apply_date` date DEFAULT NULL COMMENT '申购申请日期',
  `apply_time` datetime DEFAULT NULL COMMENT '申购申请时间',
  `apply_uptime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '申购申请最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_purchase
-- ----------------------------
INSERT INTO `order_purchase` VALUES ('1', 'P20160804000001', 'C000001', '100.0000', 'C000001001', null, '', 'CHANNEL_002', '00001', '0', '0', null, null, null, null, null, null, 'hahhahahhahah', null, null, '2016-08-12 11:28:39');
INSERT INTO `order_purchase` VALUES ('2', 'P20160804000002', 'MER_0001', '1000.0000', 'MEM_0001', '430703', '111', 'CHANNEL_001', '00001', '1', '0', '1', '2016-08-04', '1', '2016-08-04', '1', '1', '111', '2016-08-04', '2016-08-04 17:18:20', '2016-08-10 16:37:28');
INSERT INTO `order_purchase` VALUES ('3', 'P20160804000003', 'c000001', '100.0000', 'c000001001', '430703', '111', 'CHANNEL_001', '00001', '1', '0', '1', '2016-08-03', '1', '2016-08-03', '1', '1', '111', '2016-08-03', '2016-08-03 14:07:08', '2016-08-10 16:37:29');
INSERT INTO `order_purchase` VALUES ('5', 'P20160804000003', 'c000001', '100.0000', 'c000001001', '430703', '111', 'CHANNEL_001', '00001', '1', '0', '1', '2016-08-03', '1', '2016-08-03', '1', '1', '111', '2016-08-03', '2016-08-03 14:07:08', '2016-08-10 16:37:31');
INSERT INTO `order_purchase` VALUES ('6', 'P20160804000004', 'MER_0001', '1000.0000', 'MEM_0001', '430703', '111', 'CHANNEL_001', '00002', '1', '0', '1', '2016-08-04', '1', '2016-08-04', '1', '1', '111', '2016-08-04', '2016-08-04 17:18:20', '2016-08-10 16:37:35');
INSERT INTO `order_purchase` VALUES ('7', 'P20160804000003', 'c000001', '100.0000', 'c000001001', '430703', '111', 'CHANNEL_001', '00002', '1', '0', '1', '2016-08-03', '1', '2016-08-03', '1', '1', '111', '2016-08-03', '2016-08-03 14:07:08', '2016-08-10 16:37:36');
INSERT INTO `order_purchase` VALUES ('8', 'P20160804000004', 'MER_0001', '1000.0000', 'MEM_0001', '430703', '111', 'CHANNEL_001', '00002', '1', '0', '1', '2016-08-04', '1', '2016-08-04', '1', '1', '111', '2016-08-04', '2016-08-04 17:18:20', '2016-08-10 16:37:36');
INSERT INTO `order_purchase` VALUES ('9', 'P20160804000003', 'c000001', '100.0000', 'c000001001', '430703', '111', 'CHANNEL_001', '00002', '1', '0', '1', '2016-08-03', '1', '2016-08-03', '1', '1', '111', '2016-08-03', '2016-08-03 14:07:08', '2016-08-10 16:37:37');
INSERT INTO `order_purchase` VALUES ('10', 'P20160804000004', 'MER_0001', '1000.0000', 'MEM_0001', '430703', '111', 'CHANNEL_001', '00002', '1', '0', '1', '2016-08-04', '1', '2016-08-04', '1', '1', '111', '2016-08-04', '2016-08-04 17:18:20', '2016-08-10 16:37:38');
INSERT INTO `order_purchase` VALUES ('11', 'P20160804000003', 'c000001', '100.0000', 'c000001001', '430703', '111', 'CHANNEL_001', '00002', '1', '0', '1', '2016-08-03', '1', '2016-08-03', '1', '1', '111', '2016-08-03', '2016-08-03 14:07:08', '2016-08-10 16:37:40');
INSERT INTO `order_purchase` VALUES ('12', 'P20160804000004', 'MER_0001', '1000.0000', 'MEM_0001', '430703', '111', 'CHANNEL_001', '00002', '1', '0', '1', '2016-08-04', '1', '2016-08-04', '1', '1', '111', '2016-08-04', '2016-08-04 17:18:20', '2016-08-10 16:37:42');
INSERT INTO `order_purchase` VALUES ('13', 'P20160804000003', 'c000001', '100.0000', 'c000001001', '430703', '111', 'CHANNEL_001', '00002', '1', '0', '1', '2016-08-03', '1', '2016-08-03', '1', '1', '111', '2016-08-03', '2016-08-03 14:07:08', '2016-08-10 16:37:43');
INSERT INTO `order_purchase` VALUES ('14', 'P20160804000004', 'MER_0001', '1000.0000', 'MEM_0001', '430703', '111', 'CHANNEL_001', '00003', '1', '0', '1', '2016-08-04', '1', '2016-08-04', '1', '1', '111', '2016-08-04', '2016-08-04 17:18:20', '2016-08-10 16:37:45');
INSERT INTO `order_purchase` VALUES ('15', 'fdsfdsf', 'sdfsdfds', '222.0000', 'dsfsf', null, null, 'dsfdsf', '00001', null, null, null, null, null, null, null, null, 'dsfdsfdsf', null, null, '2016-08-12 11:35:18');
INSERT INTO `order_purchase` VALUES ('16', 'fdsfdsf', 'sdfsdfds', '222.0000', 'dsfsf', null, null, 'dsfdsf', '00001', null, null, null, null, null, null, null, null, 'dsfdsfdsf', null, null, '2016-08-12 11:35:55');
INSERT INTO `order_purchase` VALUES ('17', 'dsfdsfd', 'sdf', '900.0000', 'sfds', null, null, 'sdfdsf', '00002', null, null, null, null, null, null, null, null, 'sdfdsfdsf', null, null, '2016-08-12 11:36:48');
INSERT INTO `order_purchase` VALUES ('18', 'fdsfdsf', 'dsfds', '900.0000', 'dsfdsf', null, null, 'dsfdsf', '00003', null, null, null, null, null, null, null, null, 'dsfdsfdsfdsf', null, null, '2016-08-12 11:37:20');

-- ----------------------------
-- Table structure for `sys_dict_item`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_code` varchar(20) DEFAULT NULL,
  `type_code` varchar(20) DEFAULT NULL,
  `item_name` varchar(20) DEFAULT NULL,
  `sort_index` int(4) DEFAULT NULL,
  `class_name` varchar(50) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES ('1', '00', 'ORDER_STATUS', '申请中', '1', null, null);
INSERT INTO `sys_dict_item` VALUES ('2', '01', 'ORDER_STATUS', '申请成功', '2', null, null);
INSERT INTO `sys_dict_item` VALUES ('3', '02', 'ORDER_STATUS', '申购中', '3', null, null);

-- ----------------------------
-- Table structure for `sys_dict_type`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_code` varchar(20) DEFAULT NULL,
  `type_name` varchar(20) DEFAULT NULL,
  `type_kind` int(1) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('50', 'ORDER_STATUS', '订单状态', '1', '');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) DEFAULT NULL,
  `menu_url` varchar(200) DEFAULT NULL,
  `menu_state` varchar(1) DEFAULT NULL,
  `menu_index` varchar(2) DEFAULT NULL,
  `menu_leaf` varchar(1) DEFAULT NULL,
  `menu_icon` varchar(200) DEFAULT NULL,
  `parent` bigint(20) DEFAULT NULL,
  `insert_time` varchar(20) DEFAULT NULL,
  `last_update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', null, '1', '1', '0', null, '0', null, null);
INSERT INTO `sys_menu` VALUES ('2', '系统用户', 'page/sysmgr/sysUser.html', '1', '1', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('3', '角色岗位', 'page/sysmgr/sysRole.html', '1', '1', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('4', '功能菜单', 'page/sysmgr/sysMenu.html', '1', '1', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('5', '数据字典', 'page/sysmgr/dict.html', '1', '1', '1', null, '1', null, null);
INSERT INTO `sys_menu` VALUES ('11', '组织机构', '', '1', '2', '0', '', '0', null, null);
INSERT INTO `sys_menu` VALUES ('12', '机构管理', 'page/orgmgr/org.html', '1', '1', '1', '', '11', null, null);
INSERT INTO `sys_menu` VALUES ('13', '人员管理', 'page/orgmgr/employee.html', '1', '2', '1', '', '11', null, null);

-- ----------------------------
-- Table structure for `sys_org`
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(100) DEFAULT NULL,
  `org_mail` varchar(100) DEFAULT NULL,
  `org_manager` varchar(100) DEFAULT NULL,
  `org_phone` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `hasChild` varchar(1) DEFAULT NULL,
  `parent` bigint(20) DEFAULT NULL,
  `insert_time` varchar(20) DEFAULT NULL,
  `last_update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('1', '北京宇信易诚科技有限公司', 'all@yuchengtech.com', '洪卫东', '010-57689098', '北京市朝阳区酒仙桥东路南口电子城研发中心A2号楼5、6层', '1', '0', null, null);
INSERT INTO `sys_org` VALUES ('2', '网络金融产品部', null, '梁强', '010-57689099', '北京市朝阳区酒仙桥东路南口电子城研发中心A2号楼5、6层', '1', '1', null, null);
INSERT INTO `sys_org` VALUES ('3', '北部交付中心', null, '蓝颖', '010-57689097', '北京市朝阳区酒仙桥东路南口电子城研发中心A2号楼5、6层', '0', '2', null, null);
INSERT INTO `sys_org` VALUES ('4', '南部交付中心', null, '王军', '020-56789090', '广州市天河区软件园', '0', '2', null, null);
INSERT INTO `sys_org` VALUES ('5', '东部交付中心', null, '张三', '021-54567878', '上海市浦东新区东方明珠塔楼A', '0', '2', null, null);
INSERT INTO `sys_org` VALUES ('6', '数据产品部', null, '郑春', '010-57689097', '北京市朝阳区酒仙桥东路南口电子城研发中心A2号楼5、6层', '1', '1', null, null);
INSERT INTO `sys_org` VALUES ('7', '运营管理部', null, '王五', '010-57689097', '北京市朝阳区酒仙桥东路南口电子城研发中心A2号楼5、6层', '0', '1', null, null);
INSERT INTO `sys_org` VALUES ('8', '大数据研发中心', null, 'mark', '18511290886', '北京市朝阳区酒仙桥东路电子城研发中心A2', '0', '6', null, null);
INSERT INTO `sys_org` VALUES ('9', '测试部', null, 'cv', 'cvcv', '北京市朝阳区酒仙桥东路电子城研发中心A2', '1', '1', null, null);

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  `insert_time` varchar(20) DEFAULT NULL,
  `last_update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '拥有所有权限', null, null);
INSERT INTO `sys_role` VALUES ('2', '业务管理员', '拥有除系统管理之外的所有权限', null, null);

-- ----------------------------
-- Table structure for `sys_role_menu_rel`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu_rel`;
CREATE TABLE `sys_role_menu_rel` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu_rel
-- ----------------------------
INSERT INTO `sys_role_menu_rel` VALUES ('18', '2', '2');
INSERT INTO `sys_role_menu_rel` VALUES ('25', '1', '0');
INSERT INTO `sys_role_menu_rel` VALUES ('26', '1', '1');
INSERT INTO `sys_role_menu_rel` VALUES ('27', '1', '2');
INSERT INTO `sys_role_menu_rel` VALUES ('28', '1', '3');
INSERT INTO `sys_role_menu_rel` VALUES ('29', '1', '4');
INSERT INTO `sys_role_menu_rel` VALUES ('30', '1', '5');
INSERT INTO `sys_role_menu_rel` VALUES ('31', '1', '6');
INSERT INTO `sys_role_menu_rel` VALUES ('34', '1', '11');
INSERT INTO `sys_role_menu_rel` VALUES ('35', '1', '12');
INSERT INTO `sys_role_menu_rel` VALUES ('36', '1', '13');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) DEFAULT NULL,
  `login_pwd` varchar(100) DEFAULT NULL,
  `true_name` varchar(100) DEFAULT NULL,
  `idno` varchar(30) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `user_mail` varchar(255) DEFAULT NULL,
  `owner_org` bigint(20) DEFAULT NULL,
  `user_state` varchar(1) DEFAULT NULL,
  `last_login_time` varchar(20) DEFAULT NULL,
  `insert_time` varchar(20) DEFAULT NULL,
  `last_update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '111111', '张三', '430703198511209830', '18511290886', '北京市朝阳区', 'zhangsan@yuchengtech.com', null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('4', 'tandong', null, '谈冬aaa', '430703198511209830', '18511290886', '北京市朝阳区', 'tandong1@yuchengtech.com', null, '1', null, null, null);

-- ----------------------------
-- Table structure for `sys_user_role_rel`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_rel`;
CREATE TABLE `sys_user_role_rel` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role_rel
-- ----------------------------
INSERT INTO `sys_user_role_rel` VALUES ('30', '1', '1');
INSERT INTO `sys_user_role_rel` VALUES ('31', '1', '2');
INSERT INTO `sys_user_role_rel` VALUES ('42', '4', '1');
INSERT INTO `sys_user_role_rel` VALUES ('43', '4', '2');

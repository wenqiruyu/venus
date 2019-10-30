DROP TABLE IF EXISTS `venus_user`;
CREATE TABLE `venus_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(16) DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `username` varchar(255) DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userface` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否有效',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者，记录创建者信息',
  `last_update_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '修改者，记录修改者信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT '启明星用户表';

DROP TABLE IF EXISTS `venus_user_role`;
CREATE TABLE `venus_user_role` (
  `user_id` int(11) DEFAULT NULL COMMENT '用户表id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色表id'
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT '启明星用户角色表';

DROP TABLE IF EXISTS `venus_role`;
CREATE TABLE `venus_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name_en` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `role_name_zh` varchar(64) DEFAULT NULL COMMENT '角色名称 中文',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否有效',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者，记录创建者信息',
  `last_update_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '修改者，记录修改者信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8 COMMENT '启明星用户角色表';

DROP TABLE IF EXISTS `venus_menu`;
CREATE TABLE `venus_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `iconCls` varchar(64) DEFAULT NULL,
  `keepAlive` tinyint(1) DEFAULT NULL,
  `requireAuth` tinyint(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for tb_wx_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_wx_student`;
CREATE TABLE `tb_wx_student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(10) unsigned UNIQUE KEY NOT NULL DEFAULT '0' COMMENT '会员ID',
  `student_id` bigint(25) COLLATE utf8mb4_bin NOT NULL COMMENT '学号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='学号与微信会员中间表';
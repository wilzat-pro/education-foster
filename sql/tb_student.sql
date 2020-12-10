-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `tb_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `student_id` bigint(25) COLLATE utf8mb4_bin UNIQUE KEY NOT NULL COMMENT '学号',
  `source_in` varchar(10) COLLATE utf8mb4_bin DEFAULT '' COMMENT '生源类别',
  `province` varchar(20) COLLATE utf8mb4_bin DEFAULT '' COMMENT '省',
  `city` varchar(20) COLLATE utf8mb4_bin DEFAULT '' COMMENT '市',
  `county` varchar(30) COLLATE utf8mb4_bin DEFAULT '' COMMENT '县',
  `student_name` varchar(20) COLLATE utf8mb4_bin DEFAULT '' COMMENT '姓名',
  `stu_sex` int(1) DEFAULT '1' COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `student_in_date` datetime DEFAULT NULL COMMENT '入学时间',
  `politic_face` int(4) DEFAULT '0' COMMENT '政治面貌',
  `race` int(4) DEFAULT '0' COMMENT '民族',
  `mid_school` varchar(50) COLLATE utf8mb4_bin DEFAULT '' COMMENT '中学',
  `licence_id` bigint(25) DEFAULT '0' COMMENT '身份证',
  `family_addr` varchar(200) COLLATE utf8mb4_bin DEFAULT '' COMMENT '家庭地址',
  `post` int(8) DEFAULT '0' COMMENT '邮编',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `telephone` bigint(15) DEFAULT '0' COMMENT '联系电话',
  `subject_type` varchar(10) COLLATE utf8mb4_bin DEFAULT '' COMMENT '科类',
  `score` FLOAT(4,2) DEFAULT '0' COMMENT '成绩',
  `domain_in` varchar(20) COLLATE utf8mb4_bin DEFAULT '' COMMENT '专业',
  `dept_id` bigint(20) DEFAULT '0' COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `dept_name` varchar(30) COLLATE utf8mb4_bin DEFAULT '' COMMENT '所在学院',
  `class_in` varchar(20) COLLATE utf8mb4_bin DEFAULT '' COMMENT '班级',
  `status` int(1) DEFAULT '0' COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `password` varchar(200) COLLATE utf8mb4_bin DEFAULT '' COMMENT '密码',
  PRIMARY KEY (`tb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1063 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='学生基础信息表';



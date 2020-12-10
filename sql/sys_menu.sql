-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) COLLATE utf8mb4_bin DEFAULT '#' COMMENT '请求地址',
  `target` varchar(20) COLLATE utf8mb4_bin DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
  `menu_type` char(1) COLLATE utf8mb4_bin DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) COLLATE utf8mb4_bin DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) COLLATE utf8mb4_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8mb4_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8mb4_bin DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1063 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (4, '学生管理', 0, 1, '#', '', 'M', '0', '', 'fa fa-gear', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '学生管理目录');
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 2, '#', '', 'M', '1', '', 'fa fa-gear', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 3, '#', '', 'M', '0', '', 'fa fa-video-camera', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 4, '#', '', 'M', '0', '', 'fa fa-bars', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '系统工具目录');
INSERT INTO `sys_menu` VALUES (400, '学生列表', 4, 1, '/system/user', '', 'C', '0', 'system:user:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '学生管理菜单');
INSERT INTO `sys_menu` VALUES (401, '组织设置', 4, 1, '/system/dept', '', 'C', '0', 'system:dept:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '组织管理菜单');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, '/system/user', '', 'C', '0', 'system:user:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, '/system/role', '', 'C', '0', 'system:role:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, '/system/menu', '', 'C', '0', 'system:menu:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, '/system/dept', '', 'C', '0', 'system:dept:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, '/system/post', '', 'C', '0', 'system:post:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, '/system/dict', '', 'C', '0', 'system:dict:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, '/system/config', '', 'C', '0', 'system:config:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, '/system/notice', '', 'C', '0', 'system:notice:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, '#', '', 'M', '0', '', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, '/monitor/online', '', 'C', '0', 'monitor:online:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, '/monitor/job', '', 'C', '0', 'monitor:job:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `sys_menu` VALUES (112, '服务监控', 2, 3, '/monitor/server', '', 'C', '0', 'monitor:server:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '服务监控菜单');
INSERT INTO `sys_menu` VALUES (113, '表单构建', 3, 1, '/tool/build', '', 'C', '0', 'tool:build:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '表单构建菜单');
INSERT INTO `sys_menu` VALUES (114, '代码生成', 3, 2, '/tool/gen', '', 'C', '0', 'tool:gen:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '代码生成菜单');
INSERT INTO `sys_menu` VALUES (115, '系统接口', 3, 3, '/tool/swagger', '', 'C', '0', 'tool:swagger:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '系统接口菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, '/monitor/operlog', '', 'C', '0', 'monitor:operlog:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, '/monitor/logininfor', '', 'C', '0', 'monitor:logininfor:view', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1000, '用户查询', 100, 1, '#', '', 'F', '0', 'system:user:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1001, '用户新增', 100, 2, '#', '', 'F', '0', 'system:user:add', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1002, '用户修改', 100, 3, '#', '', 'F', '0', 'system:user:edit', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1003, '用户删除', 100, 4, '#', '', 'F', '0', 'system:user:remove', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1004, '用户导出', 100, 5, '#', '', 'F', '0', 'system:user:export', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1005, '用户导入', 100, 6, '#', '', 'F', '0', 'system:user:import', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1006, '重置密码', 100, 7, '#', '', 'F', '0', 'system:user:resetPwd', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1007, '角色查询', 101, 1, '#', '', 'F', '0', 'system:role:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1008, '角色新增', 101, 2, '#', '', 'F', '0', 'system:role:add', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1009, '角色修改', 101, 3, '#', '', 'F', '0', 'system:role:edit', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1010, '角色删除', 101, 4, '#', '', 'F', '0', 'system:role:remove', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1011, '角色导出', 101, 5, '#', '', 'F', '0', 'system:role:export', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1012, '菜单查询', 102, 1, '#', '', 'F', '0', 'system:menu:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1013, '菜单新增', 102, 2, '#', '', 'F', '0', 'system:menu:add', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1014, '菜单修改', 102, 3, '#', '', 'F', '0', 'system:menu:edit', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1015, '菜单删除', 102, 4, '#', '', 'F', '0', 'system:menu:remove', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1016, '部门查询', 103, 1, '#', '', 'F', '0', 'system:dept:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1017, '部门新增', 103, 2, '#', '', 'F', '0', 'system:dept:add', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1018, '部门修改', 103, 3, '#', '', 'F', '0', 'system:dept:edit', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1019, '部门删除', 103, 4, '#', '', 'F', '0', 'system:dept:remove', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1020, '岗位查询', 104, 1, '#', '', 'F', '0', 'system:post:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1021, '岗位新增', 104, 2, '#', '', 'F', '0', 'system:post:add', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1022, '岗位修改', 104, 3, '#', '', 'F', '0', 'system:post:edit', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1023, '岗位删除', 104, 4, '#', '', 'F', '0', 'system:post:remove', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1024, '岗位导出', 104, 5, '#', '', 'F', '0', 'system:post:export', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1025, '字典查询', 105, 1, '#', '', 'F', '0', 'system:dict:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1026, '字典新增', 105, 2, '#', '', 'F', '0', 'system:dict:add', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1027, '字典修改', 105, 3, '#', '', 'F', '0', 'system:dict:edit', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1028, '字典删除', 105, 4, '#', '', 'F', '0', 'system:dict:remove', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1029, '字典导出', 105, 5, '#', '', 'F', '0', 'system:dict:export', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1030, '参数查询', 106, 1, '#', '', 'F', '0', 'system:config:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1031, '参数新增', 106, 2, '#', '', 'F', '0', 'system:config:add', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1032, '参数修改', 106, 3, '#', '', 'F', '0', 'system:config:edit', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1033, '参数删除', 106, 4, '#', '', 'F', '0', 'system:config:remove', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1034, '参数导出', 106, 5, '#', '', 'F', '0', 'system:config:export', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1035, '公告查询', 107, 1, '#', '', 'F', '0', 'system:notice:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1036, '公告新增', 107, 2, '#', '', 'F', '0', 'system:notice:add', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1037, '公告修改', 107, 3, '#', '', 'F', '0', 'system:notice:edit', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1038, '公告删除', 107, 4, '#', '', 'F', '0', 'system:notice:remove', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1039, '操作查询', 500, 1, '#', '', 'F', '0', 'monitor:operlog:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1040, '操作删除', 500, 2, '#', '', 'F', '0', 'monitor:operlog:remove', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1041, '详细信息', 500, 3, '#', '', 'F', '0', 'monitor:operlog:detail', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', 'F', '0', 'monitor:operlog:export', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', 'F', '0', 'monitor:logininfor:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', 'F', '0', 'monitor:logininfor:remove', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', 'F', '0', 'monitor:logininfor:export', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', 'F', '0', 'monitor:online:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', 'F', '0', 'monitor:online:batchForceLogout', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', 'F', '0', 'monitor:online:forceLogout', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, 1, '#', '', 'F', '0', 'monitor:job:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, 2, '#', '', 'F', '0', 'monitor:job:add', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, 3, '#', '', 'F', '0', 'monitor:job:edit', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, 4, '#', '', 'F', '0', 'monitor:job:remove', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, 5, '#', '', 'F', '0', 'monitor:job:changeStatus', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1054, '任务详细', 110, 6, '#', '', 'F', '0', 'monitor:job:detail', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1055, '任务导出', 110, 7, '#', '', 'F', '0', 'monitor:job:export', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1056, '生成查询', 114, 1, '#', '', 'F', '0', 'tool:gen:list', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1057, '生成代码', 114, 2, '#', '', 'F', '0', 'tool:gen:code', '#', 'crown', '2018-03-16 11:33:00', 'crown', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu` VALUES (1058, '即时日志', 2, 4, '/monitor/consolelog', 'menuItem', 'C', '0', 'monitor:consolelog:view', '', 'crown', '2019-07-25 01:59:15', NULL, '2019-07-25 09:52:52', '');
INSERT INTO `sys_menu` VALUES (1059, '异常日志', 2, 1, '/monitor/exceLog', 'menuItem', 'C', '0', 'monitor:exceLog:view', '#', 'crown', '2018-06-28 00:00:00', NULL, '2019-07-27 14:48:54', '异常日志菜单');
INSERT INTO `sys_menu` VALUES (1060, '异常日志查询', 1059, 1, '#', 'menuItem', 'F', '0', 'monitor:exceLog:list', '#', 'crown', '2018-06-28 00:00:00', NULL, '2019-07-27 14:49:10', '');
INSERT INTO `sys_menu` VALUES (1061, '异常日志删除', 1059, 4, '#', 'menuItem', 'F', '0', 'monitor:exceLog:remove', '#', 'crown', '2018-06-28 00:00:00', NULL, '2019-07-27 14:49:22', '');
INSERT INTO `sys_menu` VALUES (1062, '异常日志详情', 1059, 3, '', 'menuItem', 'F', '0', 'monitor:exceLog:detail', '', 'crown', '2019-07-27 16:48:20', NULL, '2019-07-27 16:48:48', '');
COMMIT;
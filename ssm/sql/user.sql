CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '����',
  `user_name` varchar(100) DEFAULT NULL COMMENT '�û���',
  `user_account` varchar(100) DEFAULT NULL,
  `super_admin` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `mobile_phone` varchar(20) DEFAULT NULL,
  `company` varchar(200) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL COMMENT '����',
  `create_date` datetime DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL COMMENT '�Ƿ����',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
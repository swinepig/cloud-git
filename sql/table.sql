CREATE TABLE `t_user_roles` (
  `d_user_role_id` int(10) NOT NULL,
  `d_username` varchar(50) DEFAULT NULL,
  `d_role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`d_user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_users` (
  `d_username` varchar(50) NOT NULL,
  `d_password` varchar(60) DEFAULT NULL,
  `d_enabled` int(1) DEFAULT NULL,
  `d_accountnonexpired` int(1) DEFAULT NULL,
  `d_accountnonlocked` int(1) DEFAULT '1',
  `d_credentialsnonexpired` int(1) DEFAULT NULL,
  PRIMARY KEY (`d_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE `t_user_attempts2` (
`d_id`  int(10) NOT NULL AUTO_INCREMENT ,
`d_username`  varchar(20) NULL ,
`d_attempts`  int(4) NULL DEFAULT '登陆次数' ,
`d_lastmodified`  date NULL ,
PRIMARY KEY (`d_id`)
)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;



insert into T_USERS (D_USERNAME, D_PASSWORD, D_ENABLED)
values ('YJMYZZ', '123456', 1);

insert into T_USERS (D_USERNAME, D_PASSWORD, D_ENABLED)
values ('MIKE', 'MIKE123', 1); 

insert into T_USER_ROLES (D_USER_ROLE_ID, D_USERNAME, D_ROLE)
values (1, 'MIKE', 'POWER');

insert into T_USER_ROLES (D_USER_ROLE_ID, D_USERNAME, D_ROLE)
values (2, 'YJMYZZ', 'ADMIN');

insert into T_USER_ROLES (D_USER_ROLE_ID, D_USERNAME, D_ROLE)
values (3, 'YJMYZZ', 'POWER');

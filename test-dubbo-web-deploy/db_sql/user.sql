
-- 测试的用户表
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT  CHARSET=utf8;
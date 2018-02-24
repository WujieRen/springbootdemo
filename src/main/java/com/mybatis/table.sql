DROP TABLE IF EXISTS `mybatis_user`;
CREATE TABLE `mybatis_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(50) DEFAULT NULL,
  `userAge` INT(11) DEFAULT NULL,
  `userAddress` VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `mybatis_user` VALUES ('1', 'summer', '30', 'shanghai');
INSERT INTO `mybatis_user` VALUES ('2', 'test2', '22', 'suzhou');
INSERT INTO `mybatis_user` VALUES ('3', 'test1', '29', 'some place');
INSERT INTO `mybatis_user` VALUES ('4', 'lu', '28', 'some place');
INSERT INTO `mybatis_user` VALUES ('5', 'xiaoxun', '27', 'nanjing');
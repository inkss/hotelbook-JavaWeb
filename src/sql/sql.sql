-- 建立hotelbook数据库 
# CREATE SCHEMA `hotelbook` DEFAULT CHARACTER SET utf8 ;

-- 建立登录表
# CREATE TABLE `hotelbook`.`login` (
#   `loginId` INT NOT NULL AUTO_INCREMENT COMMENT '登录内部标示，主键、自动增长。',
#   `loginName` VARCHAR(45) NOT NULL COMMENT '登录用户名，前台唯一性的标识。不能重复。',
#   `loginPwd` VARCHAR(45) NOT NULL COMMENT '登录用户的密码，不能为空。',
#   `loginAdmin` INT NULL COMMENT '权限，默认最高权限是0',
#   PRIMARY KEY (`loginId`),
#   UNIQUE INDEX `loginName_UNIQUE` (`loginName` ASC));
 
 -- 为login表插入默认的管理员用户
# INSERT INTO `hotelbook`.`login` (`loginName`,`loginPwd`,`loginAdmin`) VALUE ("root","toor",0);
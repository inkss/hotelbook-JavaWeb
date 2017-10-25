-- 建立hotelbook数据库
 CREATE SCHEMA `hotelbook` DEFAULT CHARACTER SET utf8 ;

-- 建立登录表
 CREATE TABLE `hotelbook`.`login` (
   `loginId` INT NOT NULL AUTO_INCREMENT COMMENT '登录内部标示，主键、自动增长。',
   `loginName` VARCHAR(45) NOT NULL COMMENT '登录用户名，前台唯一性的标识。不能重复。',
   `loginPwd` VARCHAR(45) NOT NULL COMMENT '登录用户的密码，不能为空。',
   `loginAdmin` INT NULL COMMENT '权限，默认最高权限是0',
   PRIMARY KEY (`loginId`),
   UNIQUE INDEX `loginName_UNIQUE` (`loginName` ASC));

-- 为login表插入默认的管理员用户
 INSERT INTO `hotelbook`.`login` (`loginName`,`loginPwd`,`loginAdmin`) VALUE ("root","toor",0);


-- 创建数据表

CREATE TABLE `hotelbook`.`客户类型` (
  `类型编号` INT NOT NULL,
  `类型名称` VARCHAR(45) NULL,
  PRIMARY KEY (`类型编号`));

CREATE TABLE `hotelbook`.`楼层信息` (
  `楼层编号` INT NOT NULL,
  `楼层名称` VARCHAR(45) NULL,
  PRIMARY KEY (`楼层编号`));

CREATE TABLE `hotelbook`.`客房类型` (
  `类型编号` VARCHAR(45) NOT NULL,
  `类型名称` VARCHAR(45) NULL,
  `价格` VARCHAR(10) NULL,
  `拼房价格` VARCHAR(10) NULL,
  `可超预定数` INT NULL,
  `是否可拼房` VARCHAR(10) NULL,
  PRIMARY KEY (`类型编号`));

CREATE TABLE `hotelbook`.`客房信息` (
  `客房编号` VARCHAR(12) NOT NULL,
  `类型编号` VARCHAR(10) NOT NULL,
  `楼层编号` INT NOT NULL,
  `额定人数` INT NULL,
  `床数` INT NULL,
  `客房描述` VARCHAR(45) NULL,
  `备注` VARCHAR(100) NULL,
  `状态` VARCHAR(10) NULL,
  `是否可拼房` VARCHAR(10) NULL,
  PRIMARY KEY (`客房编号`),
  INDEX `fk_客房信息_1_idx` (`类型编号` ASC),
  INDEX `fk_客房信息_2_idx` (`楼层编号` ASC),
  CONSTRAINT `fk_客房信息_1`
    FOREIGN KEY (`类型编号`)
    REFERENCES `hotelbook`.`客房类型` (`类型编号`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_客房信息_2`
    FOREIGN KEY (`楼层编号`)
    REFERENCES `hotelbook`.`楼层信息` (`楼层编号`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `hotelbook`.`预订单` (
  `预定单号` VARCHAR(36) NOT NULL,
  `预定人` VARCHAR(20) NULL,
  `联系电话` VARCHAR(45) NULL,
  `身份证号` VARCHAR(18) NULL,
  `客房类型` VARCHAR(10) NOT NULL,
  `抵店时间` VARCHAR(45) NULL,
  `离店时间` VARCHAR(45) NULL,
  `单据状态` VARCHAR(20) NULL,
  `入住人数` VARCHAR(45) NULL,
  `客房编号` VARCHAR(12) NULL,
  `客房价格` VARCHAR(10) NULL,
  `入住价格` VARCHAR(10) NULL,
  `折扣` INT NULL,
  `折扣原因` VARCHAR(60) NULL,
  `是否加床` VARCHAR(10) NULL,
  `加床价格` VARCHAR(10) NULL,
  `预收款` VARCHAR(10) NULL,
  `备注` VARCHAR(500) NULL,
  `操作员` VARCHAR(20) NULL,
  PRIMARY KEY (`预定单号`),
  INDEX `fk_预订单_1_idx` (`客房类型` ASC),
  CONSTRAINT `fk_预订单_1`
    FOREIGN KEY (`客房类型`)
    REFERENCES `hotelbook`.`客房类型` (`类型编号`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `hotelbook`.`入住单` (
  `入住单号` VARCHAR(36) NOT NULL,
  `预定单号` VARCHAR(36) NULL,
  `入住人` VARCHAR(20) NULL,
  `联系电话` VARCHAR(20) NULL,
  `身份证号` VARCHAR(18) NULL,
  `客房类型` VARCHAR(10) NOT NULL,
  `抵店时间` VARCHAR(45) NULL,
  `离店时间` VARCHAR(45) NULL,
  `单据状态` VARCHAR(20) NULL,
  `入住人数` INT NULL,
  `客房编号` VARCHAR(12) NOT NULL,
  `客房价格` VARCHAR(10) NULL,
  `入住价格` VARCHAR(10) NULL,
  `折扣` INT NULL,
  `折扣原因` VARCHAR(60) NULL,
  `是否加床` VARCHAR(10) NULL,
  `加床价格` VARCHAR(10) NULL,
  `预收款` VARCHAR(10) NULL,
  `应收账款` VARCHAR(10) NULL,
  `是否结账` VARCHAR(10) NULL,
  `结账金额` VARCHAR(10) NULL,
  `结账日期` VARCHAR(45) NULL,
  `备注` VARCHAR(500) NULL,
  `操作员` VARCHAR(20) NULL,
  PRIMARY KEY (`入住单号`),
  INDEX `fk_入住单_1_idx` (`客房类型` ASC),
  INDEX `fk_入住单_2_idx` (`客房编号` ASC),
  CONSTRAINT `fk_入住单_1`
    FOREIGN KEY (`客房类型`)
    REFERENCES `hotelbook`.`客房类型` (`类型编号`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_入住单_2`
    FOREIGN KEY (`客房编号`)
    REFERENCES `hotelbook`.`客房信息` (`客房编号`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `hotelbook`.`账单明细` (
  `账单编号` INT NOT NULL,
  `入住单号` VARCHAR(36) NOT NULL,
  `消费金额` VARCHAR(10) NULL,
  `消费时间` VARCHAR(45) NULL,
  `备注` VARCHAR(100) NULL,
  PRIMARY KEY (`账单编号`),
  INDEX `fk_账单明细_1_idx` (`入住单号` ASC),
  CONSTRAINT `fk_账单明细_1`
    FOREIGN KEY (`入住单号`)
    REFERENCES `hotelbook`.`入住单` (`入住单号`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

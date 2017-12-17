-- 建立hotelbook数据库
CREATE SCHEMA `hotelbook` DEFAULT CHARACTER SET utf8 ;

-- 建立登录表
CREATE TABLE `hotelbook`.`login` (
   `loginId` INT NOT NULL AUTO_INCREMENT COMMENT '登录内部标示，主键、自动增长。',
   `loginName` VARCHAR(45) NOT NULL COMMENT '登录用户名，前台唯一性的标识。不能重复。',
   `loginPwd` VARCHAR(45) NOT NULL COMMENT '登录用户的密码，不能为空。',
   `loginNickName` VARCHAR(45) NULL COMMENT '登录用户的昵称' ,
   `loginAdmin` INT NULL COMMENT '权限，默认最高权限是0',
   PRIMARY KEY (`loginId`),
   UNIQUE INDEX `loginName_UNIQUE` (`loginName` ASC));

-- 为login表插入默认的管理员用户
INSERT INTO `hotelbook`.`login` (`loginName`,`loginPwd`,`loginNickName`,`loginAdmin`) VALUE ("root","eySvyLyA5UjWbE5/9yFxxQ==","管理员",0);

-- 建立日志表
CREATE TABLE `hotelbook`.`logInfo` (
   `logId` INT NOT NULL AUTO_INCREMENT COMMENT '日志，主键、自动增长。',
   `logName` VARCHAR(45) NOT NULL COMMENT '日志项目',
   `loginId` INT NOT NULL COMMENT '用户 外键 login表字段值',
   `loginName` VARCHAR(45)  NULL COMMENT '用户名称',
   `logDate` VARCHAR(45) NULL COMMENT '日志时间' ,
   PRIMARY KEY (`logId`),
   CONSTRAINT `fk_logInfo_1`
    FOREIGN KEY (`loginId`)
    REFERENCES `hotelbook`.`login` (`loginId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- 创建主体数据表
-- 核心数据库内容
-- 将不使用存储过程，仅仅用到外键/外联
-- 数据维护主要依靠后端维护

-- 楼层信息
CREATE TABLE `hotelbook`.`floorInfo` (
  `floorId` INT NOT NULL AUTO_INCREMENT COMMENT '楼层编号',
  `floorName` VARCHAR(45) NULL COMMENT '楼层名称',
  PRIMARY KEY (`floorId`));

-- 客房类型
CREATE TABLE `hotelbook`.`roomType` (
  `typeId` VARCHAR(45) NOT NULL COMMENT '类型编号',
  `typeName` VARCHAR(45) NULL COMMENT '类型名称',
  `price` VARCHAR(20) NULL COMMENT '价格',
  `splicPrice` VARCHAR(20) NULL COMMENT '拼房价格',
  `exceedance` INT NULL COMMENT '可超预定数',
  `isSplice` VARCHAR(10) NULL COMMENT '是否可拼房',
  PRIMARY KEY (`typeId`));

-- 客房信息
CREATE TABLE `hotelbook`.`roomInfo` (
  `roomId` VARCHAR(45) NOT NULL COMMENT '客房编号',
  `typeId` VARCHAR(45) NOT NULL COMMENT '类型编号',
  `floorId` INT NOT NULL COMMENT '楼层编号',
  `ratedNum` INT NULL COMMENT '额定人数',
  `bedNum` INT NULL COMMENT '床数',
  `roomDescription` VARCHAR(45) NULL COMMENT '客房描述',
  `remark` VARCHAR(100) NULL COMMENT '备注',
  `status` VARCHAR(10) NULL COMMENT '状态',
  `isSplice` VARCHAR(10) NULL COMMENT '是否可拼房',
  PRIMARY KEY (`roomId`),
  INDEX `fk_roomInfo_1_idx` (`typeId` ASC),
  INDEX `fk_roomInfo_2_idx` (`floorId` ASC),
  CONSTRAINT `fk_roomInfo_1`
    FOREIGN KEY (`typeId`)
    REFERENCES `hotelbook`.`roomType` (`typeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roomInfo_2`
    FOREIGN KEY (`floorId`)
    REFERENCES `hotelbook`.`floorInfo` (`floorId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- 预订单
CREATE TABLE `hotelbook`.`orderInfo` (
  `orderId` VARCHAR(45) NOT NULL COMMENT '预定单号',
  `orderName` VARCHAR(45) NULL COMMENT '预定人',
  `orderPhone` VARCHAR(45) NULL COMMENT '联系电话',
  `orderIDcard` VARCHAR(18) NULL COMMENT '身份证号',
  `typeId` VARCHAR(45) NOT NULL COMMENT '客房类型',
  `arrireDate` VARCHAR(45) NULL COMMENT '抵店时间',
  `leaveDate` VARCHAR(45) NULL COMMENT '离店时间',
  `orderState` VARCHAR(20) NULL COMMENT '单据状态',
  `checkNum` VARCHAR(45) NULL COMMENT '入住人数',
  `roomId` VARCHAR(45) NULL COMMENT '客房编号',
  `price` VARCHAR(20) NULL COMMENT '客房价格',
  `checkPrice` VARCHAR(20) NULL COMMENT '入住价格',
  `discount` INT NULL COMMENT '折扣',
  `discountReason` VARCHAR(60) NULL COMMENT '折扣原因',
  `addBed` VARCHAR(10) NULL COMMENT '是否加床',
  `addBedPrice` VARCHAR(20) NULL COMMENT '加床价格',
  `orderMoney` VARCHAR(20) NULL COMMENT '预收款',
  `remark` VARCHAR(500) NULL COMMENT '备注',
  `operatorId` VARCHAR(45) NULL COMMENT '操作员',
  PRIMARY KEY (`orderId`),
  INDEX `fk_orderInfo_1_idx` (`typeId` ASC),
  CONSTRAINT `fk_orderInfo_1`
    FOREIGN KEY (`typeId`)
    REFERENCES `hotelbook`.`roomType` (`typeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- 入住单
CREATE TABLE `hotelbook`.`checkInInfo` (
  `checkId` VARCHAR(45) NOT NULL COMMENT '入住单号',
  `orderId` VARCHAR(45) NULL COMMENT '预定单号',
  `checkName` VARCHAR(45) NULL COMMENT '入住人',
  `checkPhone` VARCHAR(45) NULL COMMENT '联系电话',
  `checkIDcard` VARCHAR(18) NULL COMMENT '身份证号',
  `typeId` VARCHAR(45) NOT NULL COMMENT '客房类型',
  `arrireTime` VARCHAR(45) NULL COMMENT '抵店时间',
  `leaveTime` VARCHAR(45) NULL COMMENT '离店时间',
  `checkState` VARCHAR(20) NULL COMMENT '单据状态',
  `checkNum` INT NULL COMMENT '入住人数',
  `roomId` VARCHAR(45) NOT NULL COMMENT '客房编号',
  `price` VARCHAR(20) NULL COMMENT '客房价格',
  `checkPrice` VARCHAR(20) NULL COMMENT '入住价格',
  `discount` INT NULL COMMENT '折扣',
  `discountReason` VARCHAR(60) NULL COMMENT '折扣原因',
  `addBed` VARCHAR(10) NULL COMMENT '是否加床',
  `addBedPrice` VARCHAR(20) NULL COMMENT '加床价格',
  `orderMoney` VARCHAR(20) NULL COMMENT '预收款',
  `money` VARCHAR(20) NULL COMMENT '应收账款',
  `isCheck` VARCHAR(10) NULL COMMENT '是否结账',
  `checkMoney` VARCHAR(20) NULL COMMENT '结账金额',
  `checkDate` VARCHAR(45) NULL COMMENT '结账日期',
  `remark` VARCHAR(500) NULL COMMENT '备注',
  `operatorId` VARCHAR(45) NULL COMMENT '操作员',
  PRIMARY KEY (`checkId`),
  INDEX `fk_checkInfo_1_idx` (`typeId` ASC),
  INDEX `fk_checkInfo_2_idx` (`roomId` ASC),
  CONSTRAINT `fk_checkInfo_1`
    FOREIGN KEY (`typeId`)
    REFERENCES `hotelbook`.`roomType` (`typeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_checkInfo_2`
    FOREIGN KEY (`roomId`)
    REFERENCES `hotelbook`.`roomInfo` (`roomId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- 账单明细
CREATE TABLE `hotelbook`.`billInfo` (
  `billId` INT NOT NULL COMMENT '账单编号',
  `checkId` VARCHAR(45) NOT NULL COMMENT '入住单号',
  `costMoney` VARCHAR(20) NULL COMMENT '消费金额',
  `costDate` VARCHAR(45) NULL COMMENT '消费时间',
  `remark` VARCHAR(100) NULL COMMENT '备注',
  PRIMARY KEY (`billId`),
  INDEX `fk_billInfo_1_idx` (`checkId` ASC),
  CONSTRAINT `fk_billInfo_1`
    FOREIGN KEY (`checkId`)
    REFERENCES `hotelbook`.`checkInInfo` (`checkId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- 权限管理
CREATE TABLE `hotelbook`.`authInfo` (
  `authId` INT NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `authItem` VARCHAR(45) NULL COMMENT '权限项',
  `isRead` VARCHAR(45) NULL COMMENT '可读',
  `isWrite` VARCHAR(45) NULL COMMENT '可写',
  `isChange` VARCHAR(45) NULL COMMENT '可改',
  `isDelete` VARCHAR(45) NULL COMMENT '可删',
  PRIMARY KEY (`authId`));


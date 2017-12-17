# 酒店管理系统

## 一、概述

酒店管理系统，类Maven项目结构。项目配置项为：

* 服务器：apache-tomcat-9.0.0.M26

* 数据库：Mysql 5.7.18-1

* 编辑器：IntelliJ IDEA

## 二、介绍

JavaWeb作业，即简单的酒店管理系统。

后端Java部分采用MVC形式，前端网页主要借鉴[layui](http://www.layui.com)与[win10-ui](http://win10ui.yuri2.cn)。

目前完成：登录；楼层，房间类型，预订单的增删改查。网页前端功能反倒是全部划分完成。

整体写的七七八八，用了不少第三方的jar包，虽然采用了类似Maven的结构，但是本身只是普通的JavaWeb项目。

数据库脚本位于`~/src/sql`目录中，导入mysql后，用IDEA打开重新配置一下JDK与Tomcat不出意外是可以直接使用的。

附1：*Tomcat的Deployment中Application context值为/hb*

附2：数据库默认登录账号root toor

重要：本项目最初是在ubuntu上写的，中间才迁移到Windows上，所以数据库上踩了一个坑，Windows对大小写不敏感，也就是**Windows不区分大小写**，数据库建表时表名称含有大写值，对应的就是DAO层操控数据库时表名也全是大写，但是在Windows下导出的表结构中表名**全是小写**，这里务必注意务必注意务必注意。从某种意义上来说这是数据库设计上遗留的问题emmm

## 三、####

> 寒假将至，如有可能，将继续完善，待更新..
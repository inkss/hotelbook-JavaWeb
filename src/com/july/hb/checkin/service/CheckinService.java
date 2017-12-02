package com.july.hb.checkin.service;

import com.july.hb.checkin.pojo.CheckinInfo;

import java.util.ArrayList;

/**
 * 数据异常在本层解决
 * 但凡出现SQL方面异常均返回-1
 */
public interface CheckinService {

    //增添
    int insertCheckinInfo(CheckinInfo checkinInfo);

    //删除
    int deleteCheckinInfo(String checkId);

    //更新
    int updateCheckinInfo(CheckinInfo checkinInfo);

    //查询单条
    CheckinInfo query(String checkId);

    //查询多条
    ArrayList query(int page, int limit);

    //查询长度
    int queryCheckinNum();


    int queryRepeat(String checkName);
}

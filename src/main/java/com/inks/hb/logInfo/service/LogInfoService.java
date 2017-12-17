package com.inks.hb.logInfo.service;

import com.inks.hb.logInfo.pojo.LogInfo;

import java.util.ArrayList;

public interface LogInfoService {

    int insertLogInfo(LogInfo logInfo);

    int deleteLogInfo(int logId);

    ArrayList query(int page, int limit);

    int queryLogInfoNum();

    int deleteByName(int loginId);

}

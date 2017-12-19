package com.inks.hb.logInfo.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogInfo {

    private int logId;

    private String logName;

    private int loginId;

    private String loginName;

    private String logDate;

    private Date date;

    private SimpleDateFormat dateFormat;

    public LogInfo() {
        super();
    }

    /**
     * 此构造器呀
     */
    public LogInfo(String logName, int loginId, String loginName) {
        this.logName = logName;
        this.loginId = loginId;
        this.loginName = loginName;
        date = new Date();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logDate = dateFormat.format(date);
    }

    public LogInfo(int logId, String logName, int loginId, String loginName, String logDate) {
        this.logId = logId;
        this.logName = logName;
        this.loginId = loginId;
        this.loginName = loginName;
        this.logDate = logDate;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "logId=" + logId +
                ", logName='" + logName + '\'' +
                ", loginId=" + loginId +
                ", loginName='" + loginName + '\'' +
                ", logDate='" + logDate + '\'' +
                '}';
    }
}

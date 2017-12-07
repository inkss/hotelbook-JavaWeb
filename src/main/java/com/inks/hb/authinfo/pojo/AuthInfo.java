package com.inks.hb.authinfo.pojo;


/**
 * AuthInfo对象对应数据库中的authInfo表,主键为authID。
 */
public class AuthInfo {

    private int authId;         //权限ID

    private String authItem;    //权限名称

    private String isRead;      //可读

    private String isWrite;     //可写

    private String isChange;    //可改

    private String isDelete;    //可删

    public AuthInfo() {
        super();
    }

    public AuthInfo(int authId, String authItem, String isRead, String isWrite, String isChange, String isDelete) {
        this.authId = authId;
        this.authItem = authItem;
        this.isRead = isRead;
        this.isWrite = isWrite;
        this.isChange = isChange;
        this.isDelete = isDelete;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public String getAuthItem() {
        return authItem;
    }

    public void setAuthItem(String authItem) {
        this.authItem = authItem;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getIsWrite() {
        return isWrite;
    }

    public void setIsWrite(String isWrite) {
        this.isWrite = isWrite;
    }

    public String getIsChange() {
        return isChange;
    }

    public void setIsChange(String isChange) {
        this.isChange = isChange;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String idDelete) {
        this.isDelete = idDelete;
    }

    @Override
    public String toString() {
        return "\n--->AuthInfo对象信息输出：" +
                "\n authId = " + authId +
                "\n authItem = '" + authItem + '\'' +
                "\n isRead = '" + isRead + '\'' +
                "\n isWrite = '" + isWrite + '\'' +
                "\n isChange = " + isChange +
                "\n idDelete = " + isDelete +
                "\n--->AuthInfo信息输出结束\n";

    }
}

package com.inks.hb.authInfo.pojo;


/**
 * AuthInfo对象对应数据库中的authInfo表,主键为authID。
 * -------------
 * 提供了3个构造器，分别为：
 * 1. 无参构造器
 * 2. 不含权限ID的构造器
 * 3. 全构造器
 * -------------
 * 提供正常的get、set方法；
 * -------------
 * 提供重载后的toString()方法；
 */
public class AuthInfo {

    private int authId;         //权限ID

    private String authItem;    //权限名称

    private String isRead;      //可读

    private String isWrite;     //可写

    private String isChange;    //可改

    private String isDelete;    //可删

    /**
     * 无参构造器
     *
     */
    public AuthInfo() {
        super();
    }

    /**
     * 不含ID的构造器
     *
     * @param authItem 权限名称
     * @param isRead 可读
     * @param isWrite 可写
     * @param isChange 可改
     * @param isDelete 可删
     */
    public AuthInfo(String authItem, String isRead, String isWrite, String isChange, String isDelete) {
        this.authItem = authItem;
        this.isRead = isRead;
        this.isWrite = isWrite;
        this.isChange = isChange;
        this.isDelete = isDelete;
    }

    /**
     * 全构造器
     * @param authId 权限ID
     * @param authItem 权限名称
     * @param isRead 可读
     * @param isWrite 可写
     * @param isChange 可改
     * @param isDelete 可删
     */
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

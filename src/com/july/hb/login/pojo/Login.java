package com.july.hb.login.pojo;

/**
 * Login对象对应数据库中的login表，主键为authId，设置为自动增加。
 * -------------
 * 提供了5个构造器，分别为：
 * 1. 无参构造器
 * 2. 用户登录名、用户密码
 * 3. 用户登录名、用户密码、用户权限
 * 4. 用户登录名、用户密码、用户昵称、用户权限
 * 5. 全构造器
 * 注意：对于无参构造器，其用户权限loginAdmin置为-1
 * -------------
 * 提供正常的get、set方法；
 * -------------
 * 提供重载后的toString()方法；
 */
public class Login {

    private int loginId;            //用户ID

    private String loginName;       //用户登录名

    private String loginPwd;        //用户密码

    private String loginNickName;   //用户昵称

    private int loginAdmin;         //用户权限

    public Login() {
        super();
        loginAdmin = -1;
    }

    public Login(String loginName, String loginPwd) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
    }

    public Login(String loginName, String loginPwd, int loginAdmin) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.loginAdmin = loginAdmin;
    }

    public Login(String loginName, String loginPwd, String loginNickName, int loginAdmin) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.loginNickName = loginNickName;
        this.loginAdmin = loginAdmin;
    }

    public Login(int loginId, String loginName, String loginPwd, String loginNickName, int loginAdmin) {
        this.loginId = loginId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.loginNickName = loginNickName;
        this.loginAdmin = loginAdmin;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getLoginNickName() {
        return loginNickName;
    }

    public void setLoginNickName(String loginNickName) {
        this.loginNickName = loginNickName;
    }

    public int getLoginAdmin() {
        return loginAdmin;
    }

    public void setLoginAdmin(int loginAdmin) {
        this.loginAdmin = loginAdmin;
    }

    @Override
    public String toString() {
        return "\n--->Login对象信息输出：" +
                "\n loginId = " + loginId +
                "\n loginName = '" + loginName + '\'' +
                "\n loginPwd = '" + loginPwd + '\'' +
                "\n loginNickName = '" + loginNickName + '\'' +
                "\n loginAdmin = " + loginAdmin +
                "\n--->Login信息输出结束\n";
    }
}

package com.inks.hb.login.pojo;

public class Login {

    private int loginId;        //登录编号 主键 自动增长

    private String loginName;   //登录用户名

    private String loginPwd;    //登录用户密码

    private String loginNickName;   //昵称

    private int loginAdmin;     //权限，默认最高权限是0

    //无参构造器
    public Login() {
        super();
        loginAdmin = -1;
        //关于权限标志
        //默认生成的空对象统一置-1
        //最高权限为0
        //权限0 1 2 3 等等
        //分级再说
    }

    //用户名、用户密码
    public Login(String loginName, String loginPwd) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
    }

    //用户名、用户密码、权限
    public Login(String loginName, String loginPwd, int loginAdmin) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.loginAdmin = loginAdmin;
    }

    //用户名、用户密码、用户昵称、权限     -- 最常用的应该是这个
    public Login(String loginName, String loginPwd, String loginNickName, int loginAdmin) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.loginNickName = loginNickName;
        this.loginAdmin = loginAdmin;
    }

    //全构造器
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

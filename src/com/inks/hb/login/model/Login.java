package inks.hb.login.model;

public class Login {

    private int loginId;        //登录编号 主键 自动增长

    private String loginName;   //登录用户名

    private String loginPwd;    //登录用户密码

    private int loginAdmin;     //权限，默认最高权限是0

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

    public Login(int loginId, String loginName, String loginPwd, int loginAdmin) {
        this.loginId = loginId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
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
                "\n loginAdmin = " + loginAdmin +
                "\n--->Login信息输出结束\n";
    }
}

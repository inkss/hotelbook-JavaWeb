package hb.authInfo.dao;

import com.inks.hb.authInfo.dao.AuthInfoDao;
import com.inks.hb.authInfo.dao.AuthInfoDaoImpl;
import com.inks.hb.authInfo.pojo.AuthInfo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AuthInfoDaoImplTest {

    private AuthInfo authInfo;

    private AuthInfoDao dao = new AuthInfoDaoImpl();

    @Test
    public void insertAuthInfo() throws Exception {

        /**
         * 测试通过
         *
         * 插入一百条数据
         */
        for (int i = 1; i < 100; i++) {
            authInfo = new AuthInfo(i, "测试数据" + i, "1", "1", "1", "1");
            dao.insertAuthInfo(authInfo);
        }
    }

    @Test
    public void queryAuthInfoNum() throws SQLException {

        System.out.println("表长度：" + dao.queryAuthInfoNum());

    }

    @Test
    public void query() throws SQLException {

        ArrayList<AuthInfo> list = dao.query(0,2);

        for(AuthInfo authInfo : list)
            System.out.println(authInfo.toString());
    }

}
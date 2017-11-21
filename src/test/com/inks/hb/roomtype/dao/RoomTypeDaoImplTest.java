package com.inks.hb.roomtype.dao;

import com.inks.hb.common.CommonDao;
import com.inks.hb.roomtype.pojo.RoomType;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTypeDaoImplTest {

    private CommonDao dao = new RoomTypeDaoImpl();
    @Test
    public void insertData() throws Exception {

        RoomType roomType = new RoomType("测试","测试"
                ,"测试","测试",5,"测试");
        dao.insertData(roomType);
    }

    @Test
    public void deleteData() throws Exception {
        RoomType roomType = new RoomType();
        System.out.println(roomType.toString());
    }

    @Test
    public void updateData() throws Exception {
    }

    @Test
    public void queryDataNum() throws Exception {
    }

    @Test
    public void query() throws Exception {
    }

    @Test
    public void query1() throws Exception {
    }

}
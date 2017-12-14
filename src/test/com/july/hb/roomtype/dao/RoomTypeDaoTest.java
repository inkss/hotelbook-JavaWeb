package com.july.hb.roomtype.dao;

import com.july.hb.roomtype.pojo.RoomType;
import org.junit.Test;

import java.util.ArrayList;

public class RoomTypeDaoTest {
    private RoomTypeDao dao = new RoomTypeDao();
    private RoomType roomType;

    @Test
    public void insertData() throws Exception {
        roomType = new RoomType("测试3","10000","222","333",4,"555");
        dao.insertData(roomType);
    }

    @Test
    public void deleteData() throws Exception {
        roomType = new RoomType();
        roomType.setTypeId("测试");
        dao.deleteData(roomType);
    }

    @Test
    public void updateData() throws Exception {
        roomType = new RoomType();
        roomType.setTypeId("测试");
        roomType.setTypeName("垃圾");
        dao.updateData(roomType);
    }

    @Test
    public void queryDataNum() throws Exception {
        System.out.println(dao.queryDataNum());
    }

    /**
     * 测试查询所有数据
     */
    @Test
    public void query() throws Exception {
        ArrayList<RoomType> list =  dao.query(1,50);
        for (RoomType i : list)
            System.out.println(i.toString());
    }

    @Test
    public void query1() throws Exception {
        roomType = new RoomType();
        roomType.setTypeId("测试3");
        RoomType roomType1 = (RoomType) dao.query(roomType);
        System.out.println(roomType1.toString());
        /**
         * 也就是空对象
         typeId = null
         typeName = 'null'
         price = 'null'
         splicPrice = 'null'
         exceedance = 0
         isSplice = null
         */
    }

}
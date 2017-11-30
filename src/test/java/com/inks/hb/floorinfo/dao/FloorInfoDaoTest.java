package com.inks.hb.floorinfo.dao;

import com.inks.hb.floorinfo.pojo.FloorInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class FloorInfoDaoTest {
    @Test
    public void insertData() throws Exception {
        FloorInfoDao dao = new FloorInfoDao();
        FloorInfo floorInfo;
        for (int i = 0; i < 100; i++) {
            floorInfo = new FloorInfo(i, "123546");
            dao.insertData(floorInfo);

        }
    }

}
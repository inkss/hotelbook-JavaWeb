package com.inks.hb.floorInfo.service;

import com.inks.hb.floorInfo.pojo.FloorInfo;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class FloorInfoServiceImplTest {

    FloorInfoService service = new FloorInfoServiceImpl();

    @Test
    public void insertFloorInfo() throws Exception {

        String a = "测试Ａ";
        System.out.println(service.insertFloorInfo(a));
    }

    @Test
    public void updateFloorInfo() throws SQLException {
        String a = "哔哩哔哩";
        int id = 21;

        FloorInfo floorInfo = new FloorInfo(id,a);
        service.updateFloorInfo(floorInfo);
    }

}
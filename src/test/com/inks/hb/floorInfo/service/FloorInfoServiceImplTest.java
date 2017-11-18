package com.inks.hb.floorInfo.service;

import com.inks.hb.floorInfo.pojo.FloorInfo;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class FloorInfoServiceImplTest {

    FloorInfoService service = new FloorInfoServiceImpl();

    @Test
    public void insertFloorInfo() {

        String a = "测试Ａ";
        try {
            System.out.println(service.insertFloorInfo(a));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateFloorInfo()  {
        String a = "哔哩哔哩";
        int id = 21;

        FloorInfo floorInfo = new FloorInfo(id,a);
        try {
            service.updateFloorInfo(floorInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
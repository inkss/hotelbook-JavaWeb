package com.inks.hb.floorInfo.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class FloorInfoServiceImplTest {

    FloorInfoService service = new FloorInfoServiceImpl();

    @Test
    public void insertFloorInfo() throws Exception {

        String a = "测试Ａ";
        System.out.println(service.insertFloorInfo(a));
    }

}
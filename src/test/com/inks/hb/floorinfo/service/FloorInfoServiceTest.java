package com.inks.hb.floorinfo.service;

import com.inks.hb.floorinfo.pojo.FloorInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class FloorInfoServiceTest {

    FloorInfoService service = new FloorInfoServiceImpl();

    @Test
    public void query() throws Exception {
        FloorInfo floorInfo = new FloorInfo();
        System.out.println(floorInfo);

        floorInfo = service.query("");
        System.out.println(floorInfo);
    }


}
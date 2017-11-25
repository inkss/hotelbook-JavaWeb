package com.july.hb.floorinfo.service;

import com.july.hb.floorinfo.pojo.FloorInfo;
import org.junit.Test;

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
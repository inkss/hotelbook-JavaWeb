package com.inks.hb.floorinfo.service;

import com.inks.hb.floorinfo.pojo.FloorInfo;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class FloorInfoServiceTest {

    FloorInfoService service = new FloorInfoServiceImpl();

    @Test
    public void query() throws Exception {
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        System.out.println(df.format(day));
    }


}
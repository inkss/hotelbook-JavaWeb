package com.inks.hb.common;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class ExportExcelTest {

    @Test
    public void readXlsx() {
        try {
            ArrayList list = ExportExcel.readXlsx("D:\\用户信息.xlsx");
            for (Object i : list)
                System.out.println(i.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
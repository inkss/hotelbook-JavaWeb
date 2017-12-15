package com.july.hb.checkin.dao;

import com.july.hb.checkin.pojo.CheckinInfo;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class CheckinDaoTest {

    private CheckinDao dao = new CheckinDao();

    @Test
    public void insertData() {
    }

    @Test
    public void deleteData() {
    }

    @Test
    public void updateData() {
    }

    @Test
    public void queryDataNum() {
        try {
            System.out.println(dao.queryDataNum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void query() {
        CheckinInfo checkinInfo;
        try {
            for (Object info : dao.query(1,50)){
                checkinInfo = (CheckinInfo) info;
                System.out.println(checkinInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryName() {
    }
}
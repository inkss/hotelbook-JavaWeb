package com.july.hb.checkin.service;

import com.july.hb.checkin.dao.CheckinDao;
import com.july.hb.checkin.pojo.CheckinInfo;
import com.july.hb.roomInfo.pojo.RoomInfo;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CheckinServiceImpl implements CheckinService {

    private CheckinDao dao = new CheckinDao();

    @Override
    public int insertCheckinInfo(CheckinInfo checkinInfo) {
        try {
            if (queryRepeat(checkinInfo.getCheckId()) == 1) {
                RoomInfo roomInfo = new RoomInfo(checkinInfo.getRoomId()
                        , checkinInfo.getTypeId(), checkinInfo.getFloorId());
                roomInfo.insertRoomInfo();
                checkinInfo.setIsCheck(checkinInfo.getIsCheck());
                checkinInfo.setCheckoutDate(checkinInfo.getCheckoutDate());
                dao.insertData(checkinInfo);
            } else
                return 0; //存在id
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            e.printStackTrace();
            return -1;
        }
        return 1;
    }

    @Override
    public int deleteCheckinInfo(String checkId) {
        CheckinInfo checkinInfo = new CheckinInfo();
        checkinInfo.setCheckId(checkId);

        try {
            dao.deleteData(checkinInfo);
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateCheckinInfo(CheckinInfo checkinInfo) {
        try {
            dao.updateData(checkinInfo);
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public CheckinInfo query(String checkId) {
        CheckinInfo checkinInfo = new CheckinInfo();
        checkinInfo.setCheckId(checkId);
        try {
            CheckinInfo checkinInfo1 = (CheckinInfo) dao.query(checkinInfo);
            return checkinInfo1;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList query(int page, int limit) {

        int start = (page * limit) - limit + 1; //每一页的起始位置

        if (start < 1)  //小于1的话会触发一个错误
            start = 1;  //但是理论上page和limit是由table表格生成的参数

        try {
            return dao.query(start, limit);
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList billInfo(int page, int limit) {
        int start = (page * limit) - limit + 1; //每一页的起始位置

        if (start < 1)  //小于1的话会触发一个错误
            start = 1;  //但是理论上page和limit是由table表格生成的参数

        try {
            CheckinInfo checkinInfo; //中间变量
            ArrayList list1; //一个是查到的，一个用来转换
            ArrayList<CheckinInfo> list2 = new ArrayList<>();
            Date begin, end;
            double between, day, price, discount, orderMoney, money;
            list1 = dao.query(start, limit);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            for (Object i : list1) {
                checkinInfo = (CheckinInfo) i;
                price = Long.parseLong(checkinInfo.getPrice());
                discount = Long.parseLong(checkinInfo.getDiscount());
                orderMoney = Long.parseLong(checkinInfo.getOrderMoney());
                begin = df.parse(checkinInfo.getArriveTime());
                end = df.parse(checkinInfo.getLeaveTime());
                between = (end.getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
                day = between / (24 * 3600);
                price = price * discount * 0.1;
                money = price * day - orderMoney;
                checkinInfo.setMoney(String.valueOf(money));
                checkinInfo.setRemark(String.valueOf(day));
                if (!checkinInfo.getCheckState().equals("结算"))
                    list2.add(checkinInfo);
            }
            return list2;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int queryCheckinNum() {
        try {
            return dao.queryDataNum();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + e.getMessage());
            return -1;
        }
    }

    @Override
    public int queryRepeat(String checkName) {
        CheckinInfo checkinInfo;

        try {
            checkinInfo = dao.queryName(checkName);
            if (!checkinInfo.isNull()) //表示存在同名项
                return 0;
            else
                return 1;
        } catch (SQLException e) {
            return -1;
        }
    }
}

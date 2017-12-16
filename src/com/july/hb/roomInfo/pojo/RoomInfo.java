package com.july.hb.roomInfo.pojo;

import com.july.hb.common.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//一个简单的房间信息对象
public class RoomInfo {
    private String roomId;

    private String typeId;

    private String floorId;

    public RoomInfo(String roomId, String typeId, String floorId) {
        this.roomId = roomId;
        this.typeId = typeId;
        this.floorId = floorId;
    }

    //一个贼不要脸的插入函数
    public void insertRoomInfo() {
        try {
            Connection conn = DBUtil.getConnection();
            String sql = "INSERT INTO roominfo (roomId,typeId,floorId) VALUE (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,roomId);
            pstmt.setString(2,typeId);
            pstmt.setInt(3,Integer.parseInt(floorId));
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



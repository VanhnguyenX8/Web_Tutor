package com.example.dashboardweb.DAO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class HocSinhDAO {
    ConnectDB conn = new ConnectDB();
    Connection con = conn.getConnect();
    public int countHocSinh() {
        int soLuongHocSinh = 0;
        Statement stmt =null;
        try {
            stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("select count(*) as CountHocSinh from hocsinh");
            rs.next();
            soLuongHocSinh = rs.getInt("CountHocSinh");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return soLuongHocSinh;
    }

    public JSONArray getListHocSinh(){
        Statement stmt =null;
        JSONArray listHocSinh= new JSONArray();
        try {
            stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("select * from hocsinh");
            while (rs.next()){
                JSONObject obj = new JSONObject();
                obj.put("accountBalance",rs.getInt("so_du_tai_khoan"));
                obj.put("bankNumber",rs.getString("so_tai_khoan"));
                obj.put("address",rs.getString("dia_chi"));
                obj.put("email",rs.getString("email"));
                obj.put("phone",rs.getString("sdt"));
                obj.put("gender",rs.getString("gioi_tinh"));
                obj.put("dateOfBirth",rs.getString("nam_sinh"));
                obj.put("name",rs.getString("ten_hoc_sinh"));
                obj.put("username",rs.getString("username"));
                listHocSinh.put(obj);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listHocSinh;
    }


    public void deleteHocSinh(String username){
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM hocsinh WHERE username = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

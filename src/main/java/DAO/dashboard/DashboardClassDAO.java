package DAO.dashboard;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DashboardClassDAO {
    DashboardConnectDB conn = new DashboardConnectDB();
    Connection con = conn.getConnect();

    public int countLopHoc() {
        int soLuongLopHoc = 0;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) as CountLopHoc from lophoc");
            rs.next();
            soLuongLopHoc = rs.getInt("CountLopHoc");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return soLuongLopHoc;
    }

    public JSONArray getListLopHoc(){
        Statement stmt =null;
        JSONArray listLopHoc = new JSONArray();
        try {
            stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("select * from lophoc");
            while (rs.next()){
                JSONObject obj = new JSONObject();
                obj.put("id",rs.getString("id"));
                obj.put("usernameStudent",rs.getString("username_hoc_sinh"));
                obj.put("usernameTutor",rs.getString("username_gia_su"));
                obj.put("className",rs.getString("ten_lop_hoc"));
                obj.put("classSchedule",rs.getString("gio_hoc"));
                obj.put("classDay",rs.getString("ngay_hoc"));
                obj.put("tuition",rs.getInt("hoc_phi"));
                obj.put("tutorFee",rs.getInt("phi_gia_su"));
                obj.put("description",rs.getString("mo_ta"));
                obj.put("image",rs.getString("hinh_anh"));
                obj.put("accept",rs.getInt("accept"));
                listLopHoc.put(obj);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listLopHoc;
    }

    public void updateLopHoc(String id){
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE lophoc " +
                    "SET accept = 1 " +
                    "WHERE id::text = ?");
            stmt.setString(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLopHoc(String id){
        try {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM lophoc WHERE id::text = ?");
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Map<Integer, Integer>> soLopMoTheoNgay(String ngayBatDau, String ngayKetThuc) {
        Map<String, Map<Integer, Integer>> dangKiLopHoc = new HashMap<>();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) as solopmo ,count(username_hoc_sinh) as hocsinhdangki, ngay_hoc FROM  " +
                    "lophoc where ngay_hoc >= " +"'"+ ngayBatDau+"'" + " and ngay_hoc <= " +"'"+ ngayKetThuc+"'"+
                    " " +
                    "group" +
                    " by " +
                    "ngay_hoc");
            while (rs.next()) {
                Map<Integer, Integer> map = new HashMap<>();
                
                map.put(rs.getInt("solopmo"), Integer.valueOf(rs.getString("hocsinhdangki")));
                dangKiLopHoc.put(rs.getString("ngay_hoc"), map);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dangKiLopHoc;
    }
}

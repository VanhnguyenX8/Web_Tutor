package DAO.dashboard;

import org.json.JSONArray;
import Model.LopHoc;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
                LopHoc lopHoc = new LopHoc(rs.getString("id"),rs.getString("username_hoc_sinh"),rs.getString("username_gia_su"),rs.getString("ten_lop_hoc"),
                		rs.getInt("gio_hoc"),rs.getDate("ngay_hoc"),rs.getInt("hoc_phi"),rs.getInt("phi_gia_su"),rs.getString("mo_ta")
                		,rs.getString("hinh_anh"),rs.getInt("accept"),rs.getInt("khoi"));
                obj.put("id",lopHoc.getId());
                obj.put("usernameStudent",lopHoc.getUsernameHocSinh());
                obj.put("usernameTutor",lopHoc.getUsernameGiaSu());
                obj.put("className",lopHoc.getTenLopHoc());
                obj.put("classSchedule",lopHoc.getGioHoc());
                obj.put("classDay",lopHoc.getNgayHoc());
                obj.put("tuition",lopHoc.getHocPhi());
                obj.put("tutorFee",lopHoc.getPhiGiaSu());
                obj.put("description",lopHoc.getMoTa());
                obj.put("image",lopHoc.getHinhAnh());
                obj.put("accept",lopHoc.getAccept());
                obj.put("level", lopHoc.getLever());
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

    public List soLopMoTheoNgay(String ngayBatDau, String ngayKetThuc) {
        List dangKiLopHoc = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) as solopmo ,count(username_hoc_sinh) as hocsinhdangki, ngay_hoc FROM  " +
                    "lophoc where ngay_hoc >= " +"'"+ ngayBatDau+"'" + " and ngay_hoc <= " +"'"+ ngayKetThuc+"'"+
                    " " +
                    "group" +
                    " by " +
                    "ngay_hoc ORDER BY ngay_hoc ASC");
            while (rs.next()) {
                Map<Integer, Integer> map = new HashMap<>();
                JSONObject obj =new JSONObject();
                map.put(rs.getInt("solopmo"), Integer.valueOf(rs.getString("hocsinhdangki")));
                obj.put(rs.getString("ngay_hoc"), map);
                dangKiLopHoc.add(obj);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dangKiLopHoc;
    }
}

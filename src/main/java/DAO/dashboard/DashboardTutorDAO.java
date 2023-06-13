package DAO.dashboard;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class DashboardTutorDAO {
    DashboardConnectDB conn = new DashboardConnectDB();
    Connection con = conn.getConnect();
    public int countGiaSu() {
        int soLuongGiaSu = 0;
        Statement stmt =null;
        try {
            stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("select count(*) as CountGiaSu from giasu");
            rs.next();
            soLuongGiaSu = rs.getInt("CountGiaSu");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return soLuongGiaSu;
    }
    public JSONArray getListGiaSu(){
        Statement stmt =null;
        JSONArray listGiaSu = new JSONArray();
        try {
            stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("select * from giasu");
            while (rs.next()){
                JSONObject obj = new JSONObject();
                obj.put("accountBalance",rs.getInt("so_du_tai_khoan"));
                obj.put("paymentAmount",rs.getInt("chua_thanh_toan"));
                obj.put("bankNumber",rs.getString("so_tai_khoan"));
                obj.put("address",rs.getString("dia_chi"));
                obj.put("email",rs.getString("email"));
                obj.put("phone",rs.getString("sdt"));
                obj.put("gender",rs.getString("gioi_tinh"));
                obj.put("dateOfBirth",rs.getString("nam_sinh"));
                obj.put("name",rs.getString("ten_gia_su"));
                obj.put("username",rs.getString("username"));
                listGiaSu.put(obj);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listGiaSu;
    }

    public String updateGiaSu(String username){
        PreparedStatement pstmt = null;
        String sql = "UPDATE giasu " +
                "SET so_du_tai_khoan = chua_thanh_toan + so_du_tai_khoan, " +
                "   chua_thanh_toan = 0 " +
                "WHERE username = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Thanh toán thành công cho gia sư";
    }

    public void deleteGiaSu(String username){
        PreparedStatement pstmt = null;
        String sql = "DELETE FROM giasu WHERE username = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

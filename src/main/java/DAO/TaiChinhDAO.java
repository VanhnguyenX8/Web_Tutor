package com.example.dashboardweb.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class TaiChinhDAO {
    ConnectDB conn = new ConnectDB();
    Connection con = conn.getConnect();

    public Map<String, Map<Integer, Integer>> tinhLoiNhuanTheoNam() {
        Statement stmt = null;
        Map<String, Map<Integer, Integer>> year = new HashMap<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT (hoc_phi-phi_gia_su) as loinhuan,YEAR(ngay_hoc) as year,month" +
                    "(ngay_hoc) as month FROM lophoc ORDER BY year asc,month ASC");
            while (rs.next()) {
                int loinhuan = rs.getInt("loinhuan");
                String yearStr = rs.getString("year");
                int month = rs.getInt("month");

                if (year.containsKey(yearStr)) {
                    Map<Integer, Integer> monthMap = year.get(yearStr);
                    monthMap.put(month, loinhuan);
                } else {
                    Map<Integer, Integer> monthMap = new HashMap<>();
                    monthMap.put(month, loinhuan);
                    year.put(yearStr, monthMap);
                }

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return year;
    }

    public Map<String, Double> tinhPhanTramChiTraChoGiaSu() {
        Statement stmt = null;
        Map<String, Double> phanTram = new HashMap<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT avg((phi_gia_su/hoc_phi)*100)  AS percent FROM webgiasu.lophoc");

            rs.next();
            phanTram.put("phanTram", rs.getDouble("percent"));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return phanTram;
    }

    public String getTongDoanhThu() {
        Statement stmt = null;
        long doanhThu = 0;
        String tongDoanhThu = "";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT sum(hoc_phi) as tongdoanhthu FROM lophoc;");

            rs.next();
            doanhThu = rs.getLong("tongdoanhthu");
            tongDoanhThu = formatNumber(doanhThu);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tongDoanhThu;
    }

    public String formatNumber(long input) {
        String[] suffixes = {"", "K", "M", "B", "T"};
        int suffixNum = 0;
        double number = Double.valueOf(input);
        while (number >= 1000) {
            number /= 1000;
            suffixNum++;
        }

        return String.format("%.1f %s", (double) number, suffixes[suffixNum]);
    }
}

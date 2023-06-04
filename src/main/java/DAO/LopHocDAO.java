package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import Model.LopHoc;
import Model.TaiKhoan;

public class LopHocDAO extends DBconnect{
	public ArrayList<LopHoc> getLopHoc(int index) {
		String sql;
		if(index == 0) {
			sql = "SELECT id, tenlophoc, khoi, tengiasu, hocphi FROM lophoc WHERE khoi <= 5 ORDER BY khoi;";
		}
		else if(index == 1) {
			sql = "SELECT id, tenlophoc, khoi, tengiasu, hocphi FROM lophoc WHERE khoi > 5 AND khoi <= 9 ORDER BY khoi;";
		}
		else {
			sql = "SELECT id, tenlophoc, khoi, tengiasu, hocphi FROM lophoc WHERE khoi > 9 ORDER BY khoi;";
		}
		ArrayList<LopHoc> ans = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LopHoc tmp = new LopHoc(rs.getInt("id"), rs.getString("tenlophoc"), rs.getInt("khoi"), rs.getString("tengiasu"), rs.getInt("hocphi"));
				ans.add(tmp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return ans;
	}
}

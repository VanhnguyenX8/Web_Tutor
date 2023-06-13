package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.UserHS;

public class HocSinhDAO{
	public DBconnect db = new DBconnect();
	Connection con = db.DBconnect();
	
	public UserHS getHocSinhFromDatabase(String username) {
		String sql = "SELECT * FROM hocsinh WHERE username = ?";
		UserHS tmp = new UserHS();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				tmp.setTen_hoc_sinh(rs.getString("ten_hoc_sinh"));
				tmp.setNam_sinh(rs.getDate("nam_sinh"));
				tmp.setSdt(rs.getString("sdt"));
				tmp.setEmail(rs.getString("email"));
				tmp.setSo_du_tai_khoan(rs.getInt("so_du_tai_khoan"));
				tmp.setUsername(rs.getString("username"));
				tmp.setGioi_tinh(rs.getString("gioi_tinh"));
				tmp.setDia_chi(rs.getString("dia_chi"));
				tmp.setSo_tai_khoan(rs.getString("so_tai_khoan"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
	}
	
	public boolean setSoDu(String username, int so_du_moi) {
		String sql = "UPDATE hocsinh SET so_du_tai_khoan = ? WHERE username = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, so_du_moi);
			ps.setString(2, username);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

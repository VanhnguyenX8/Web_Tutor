package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import Model.UserGS;
import Model.LopHoc;


public class LopHocDKDAO{
	public DBconnect db = new DBconnect();
	Connection con = db.DBconnect();
	
	public ArrayList<LopHoc> getLopHoc(int index) {
		String sql;
		if(index == 0) {
			sql = "SELECT lophoc.id, username_hoc_sinh, ten_lop_hoc, gio_hoc, ngay_hoc, hoc_phi, khoi, ten_gia_su, sdt FROM lophoc, giasu WHERE lophoc.username_gia_su = giasu.username and khoi <= 5 and ngay_hoc >= CURRENT_DATE and accept = 1 ORDER BY khoi;";
		}
		else if(index == 1) {
			sql = "SELECT lophoc.id, username_hoc_sinh, ten_lop_hoc, gio_hoc, ngay_hoc, hoc_phi, khoi, ten_gia_su, sdt FROM lophoc, giasu WHERE lophoc.username_gia_su = giasu.username and khoi > 5 and khoi <= 9 and ngay_hoc >= CURRENT_DATE and accept = 1 ORDER BY khoi;";
		}
		else {
			sql = "SELECT lophoc.id, username_hoc_sinh, ten_lop_hoc, gio_hoc, ngay_hoc, hoc_phi, khoi, ten_gia_su, sdt FROM lophoc, giasu WHERE lophoc.username_gia_su = giasu.username and khoi > 9 and ngay_hoc >= CURRENT_DATE and accept = 1 ORDER BY khoi;";
		}
		ArrayList<LopHoc> ans = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LopHoc tmp = new LopHoc();
				tmp.setId(rs.getString(1));
				tmp.setUsernameHocSinh(rs.getString("username_hoc_sinh"));
				tmp.setGiasu(new UserGS(rs.getString("ten_gia_su"), rs.getString("sdt")));
				tmp.setTenLopHoc(rs.getString("ten_lop_hoc"));
				tmp.setGioHoc(rs.getInt("gio_hoc"));
				tmp.setNgayHoc(rs.getDate("ngay_hoc"));
				tmp.setHocPhi(rs.getInt("hoc_phi"));
				tmp.setKhoi(rs.getInt("khoi"));
//				System.out.println(tmp.toString());
				ans.add(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}
	
	public ArrayList<LopHoc> getLopHoc(String username_hoc_sinh) {
		
		String sql = "SELECT lophoc.id, username_hoc_sinh, ten_lop_hoc, gio_hoc, ngay_hoc, hoc_phi, khoi, ten_gia_su, sdt FROM lophoc, giasu WHERE username_hoc_sinh = ? and lophoc.username_gia_su = giasu.username and ngay_hoc >= CURRENT_DATE and accept = 1 ORDER BY ngay_hoc DESC, gio_hoc ASC";
		ArrayList<LopHoc> ans = new ArrayList<>();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username_hoc_sinh);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LopHoc tmp = new LopHoc();
				tmp.setId(rs.getString(1));
				tmp.setUsernameHocSinh(rs.getString("username_hoc_sinh"));
				tmp.setGiasu(new UserGS(rs.getString("ten_gia_su"), rs.getString("sdt")));
				tmp.setTenLopHoc(rs.getString("ten_lop_hoc"));
				tmp.setGioHoc(rs.getInt("gio_hoc"));
				tmp.setNgayHoc(rs.getDate("ngay_hoc"));
				tmp.setHocPhi(rs.getInt("hoc_phi"));
				tmp.setKhoi(rs.getInt("khoi"));
//				System.out.println(tmp.toString());
				ans.add(tmp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return ans;
	}
	
	public boolean setLopHoc(String username_hoc_sinh, String id_lop_hoc) {
		String sql = "UPDATE lophoc SET username_hoc_sinh = ? WHERE id::text = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username_hoc_sinh);
			ps.setString(2, id_lop_hoc);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

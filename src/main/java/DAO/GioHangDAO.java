package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import Model.GioHang;

public class GioHangDAO{
	public DBconnect db = new DBconnect();
	Connection con = db.DBconnect();
	
	public ArrayList<GioHang> getGioHang(String username_hoc_sinh) {
		String sql = "SELECT * FROM giohang WHERE username_hoc_sinh = ?";
		ArrayList<GioHang> ans = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username_hoc_sinh);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				GioHang tmp = new GioHang();
				tmp.setId(rs.getInt("id"));
				tmp.setUsername_hoc_sinh(rs.getString("username_hoc_sinh"));
				tmp.setId_lop_hoc(rs.getString("id_lop_hoc"));
				ans.add(tmp);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}
	
	public void editGioHang(String username_hoc_sinh, String id_lop_hoc, int c) {
		String sql = "SELECT * FROM giohang WHERE username_hoc_sinh = ? and id_lop_hoc::text = ?";
		GioHang ans = new GioHang();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username_hoc_sinh);
			ps.setString(2, id_lop_hoc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			    ans.setId(rs.getInt("id"));
			    ans.setUsername_hoc_sinh(rs.getString("username_hoc_sinh"));
			    ans.setId_lop_hoc(rs.getString("id_lop_hoc"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		int check = ans.getId();
		if(check == 0 && c == 0) {
			addGioHang(username_hoc_sinh, id_lop_hoc);
		}
		if(check != 0 && c == 1) {
			deleteGioHang(ans.getId());
		}
	}
	
	private void deleteGioHang(int id) {
		String sql = "DELETE FROM giohang WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			System.out.println("Xóa thành công");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addGioHang(String username_hoc_sinh, String id_lop_hoc) {
		String sql = "INSERT INTO giohang(id, username_hoc_sinh, id_lop_hoc) VALUES (?, ?, ?)";
		int id = getIdGioHang();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, username_hoc_sinh);
			ps.setObject(3, UUID.fromString(id_lop_hoc));
			ps.execute();
			System.out.println("Thêm thành công");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int getIdGioHang() {
		String sql = "SELECT MAX(id) FROM giohang;";
		int ans = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ans = rs.getInt(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ans + 1;
	}
	
	public void confirmGioHang(String username_hoc_sinh, int so_du_moi, String bac_hoc) throws SQLException {
		con.setAutoCommit(false);
		String sql;
		String sql2;
		if(bac_hoc.equals("Tieu hoc")) {
			sql = "SELECT * FROM giohang WHERE username_hoc_sinh = ? and id_lop_hoc IN (SELECT id FROM lophoc WHERE khoi <= 5)";
			sql2 = "DELETE FROM giohang WHERE username_hoc_sinh = ? and id_lop_hoc IN (SELECT id FROM lophoc WHERE khoi <= 5)";
		}
		else if(bac_hoc.equals("THCS")) {
			sql = "SELECT * FROM giohang WHERE username_hoc_sinh = ? and id_lop_hoc IN (SELECT id FROM lophoc WHERE khoi > 5 and khoi <= 9)";
			sql2 = "DELETE FROM giohang WHERE username_hoc_sinh = ? and id_lop_hoc IN (SELECT id FROM lophoc WHERE khoi > 5 and khoi <= 9)";
		}
		else {
			sql = "SELECT * FROM giohang WHERE username_hoc_sinh = ? and id_lop_hoc IN (SELECT id FROM lophoc WHERE khoi > 9)";
			sql2 = "DELETE FROM giohang WHERE username_hoc_sinh = ? and id_lop_hoc IN (SELECT id FROM lophoc WHERE khoi > 9)";
		}
		//Thêm username_hoc_sinh vào lớp học
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username_hoc_sinh);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				boolean tmp = new LopHocDKDAO().setLopHoc(username_hoc_sinh, rs.getString("id_lop_hoc"));
				if(!tmp) {
					con.rollback();
					return;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			return;
		}
		//Xóa giỏ hàng tương ứng
		try {
			PreparedStatement ps = con.prepareStatement(sql2);
			ps.setString(1, username_hoc_sinh);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			return;
		}
		//Đặt lại số dư
		boolean tmp2 = new HocSinhDAO().setSoDu(username_hoc_sinh, so_du_moi);
		if(!tmp2) {
			con.rollback();
			return;
		}
		con.commit();
		con.setAutoCommit(true);
	}
}

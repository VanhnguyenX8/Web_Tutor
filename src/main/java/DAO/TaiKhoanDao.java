package DAO;

import java.security.AlgorithmParametersSpi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.TaiKhoan;

public class TaiKhoanDao extends DBconnect {
	// trad ve acount hoac null
	public TaiKhoan checklogin(String user, String pass) {
		try {

			String query = "select * from accout where username =? and password=?";

//		 System.out.print(user);
//		 System.out.print(pass);
			PreparedStatement ps = con.prepareStatement(query);
			// nem query vao trong sql server
			ps.setString(1, user);
			// truyen cac user va pass vao cau truy van
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TaiKhoan a = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBytes(4));
				System.out.print(a);
				return a;
			}

			// nhan ket qua tra ve
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public byte[] getSaltFromDB(String username) throws SQLException {
		try {
			byte[] salt = null;
			String query = "select salt from accout where username = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				salt = rs.getBytes("salt");
			}
			return salt;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}
	public String getPositionFromDB(String username) throws SQLException{
		try {
			String position = null;
			String query = "select position from accout where username = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				position = rs.getString("position");
			}
			return position;
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	public String getPasswordFromDB(String username) throws SQLException{
		try {
			String password = null;
			String query = "select password from accout where username = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				password = rs.getString("password");
			}
			return password;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}
}

package DAO;

import java.security.AlgorithmParametersSpi;

import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.TaiKhoan;

public class TaiKhoanDao{
	public DBconnect db = new DBconnect();
	Connection con = db.DBconnect();
	// trad ve acount hoac null
	public TaiKhoan checklogin(String user, String pass) {
		try {
			String query = "select * from account where username =? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			// nem query vao trong sql server
			ps.setString(1, user);
			// truyen cac user va pass vao cau truy van
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // Chuyển đổi chuỗi UUID thành UUID
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            String position = rs.getString("role");
	            byte[] encode = rs.getBytes("encode");
	            
	            TaiKhoan taiKhoan = new TaiKhoan(username, password, position, encode);
	            System.out.println(taiKhoan);
	            return taiKhoan;
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
			byte[] encode = null;
			String query = "select encode from account where username = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				encode = rs.getBytes("encode");
			}
			return encode;
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}
	public String getPositionFromDB(String username) throws SQLException{
		try {
			String position = null;
			String query = "select role from account where username = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				position = rs.getString("role");
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
			String query = "select password from account where username = ?";
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
	
	public TaiKhoan getByUsername(String username) throws SQLException {
		try {
			String query = "SELECT * FROM account WHERE username = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
//				UUID id = UUID.fromString(resultSet.getString(1));
				String password = resultSet.getString("password");
				String position = resultSet.getString("role");
				byte[] salt = resultSet.getBytes("encode");
				return new TaiKhoan(username, password, position, salt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public void updatePassword(String username, String password) {
		try {
			String query = "UPDATE account set password = ? where username = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, password);
			statement.setString(2, username);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
package DAO;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import Model.TaiKhoan;

public class SignUpDao {
	public DBconnect db = new DBconnect();
	Connection con = db.DBconnect();
	public TaiKhoan checkAccount(String user) {
		String query = "select username, password, role, encode from account where username = ? ";
		try {
			if(con!=null) {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, user);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
	//				UUID id = UUID.fromString(rs.getString(1)); // Chuyển đổi chuỗi UUID thành UUID
		            String username = rs.getString("username");
		            String password = rs.getString("password");
		            String position = rs.getString("role");
		            byte[] encode = rs.getBytes("encode");
		            
		            TaiKhoan taiKhoan = new TaiKhoan(username, password, position, encode);
		            System.out.println(taiKhoan);
		            return taiKhoan;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return null;
	}

	public void NewAccount(String user, String pass, String position, byte[] encode) {
		String query = "insert into account(username, password, role, encode) values (?,?,?,?);";
		try {
			if(con!=null) {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, user);
				ps.setString(2, pass);
				ps.setString(3, position);
				ps.setBytes(4, encode);
				ps.executeUpdate();
				// k can dung result vi khi usertao tai khoan se k co du lieu tra ve
				// can dung [executeUpdate()] de update lai du lieu
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void NewInfoGS(String user) {
		String query = "insert into giasu (username) values (?);";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void NewInfoHS(String user) {
		String query = "insert into hocsinh(username) values (?);";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
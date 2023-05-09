package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
				TaiKhoan a = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3));
				System.out.println(a);
				return a;
			}

			// nhan ket qua tra ve
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}

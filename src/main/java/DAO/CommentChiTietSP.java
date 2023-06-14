package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Model.BinhLuan;
public class CommentChiTietSP{
	public DBconnect db = new DBconnect();
	Connection con = db.DBconnect();
	public List<BinhLuan> getallcmt(String idsanpham) {
		List<BinhLuan> list = new ArrayList<>();
		String sql = "SELECT * FROM binhluan where idlophoc::text = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,idsanpham);
			ResultSet rs =st.executeQuery();
			while(rs.next()) {
				BinhLuan c = new BinhLuan(rs.getString("id"), rs.getString("idlophoc"), rs.getString("usernamebl"), rs.getString("chat"));
				list.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	public void ThemCMT(String cid, String cmt) throws ParseException {
		String query = "insert into BinhLuan(idlophoc,usernamebl,chat) values (?,?,?);";
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setObject(1, UUID.fromString(cid));
			ps.setString(2, "vanhnguyenx8");
			ps.setString(3, cmt);
			ps.executeUpdate();
			// k can dung result vi khi usertao tai khoan se k co du lieu tra ve
			// can dung [executeUpdate()] de update lai du lieu
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
